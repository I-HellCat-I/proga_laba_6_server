package Network;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.json.JsonMapper;

import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.util.Arrays;
import java.util.Optional;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ServerCommunicationsArray {
    protected DatagramChannel datagramChannel;
    protected JsonMapper mapper;
    protected SocketAddress lastClient;

    public ServerCommunicationsArray() throws IOException {
        mapper = JsonMapper.builder().findAndAddModules().build();
        datagramChannel = DatagramChannelBuilder.bindChannel(new InetSocketAddress(InetAddress.getLocalHost(), 3123));
        Logger.getAnonymousLogger().log(Level.INFO, "Started");
    }

    public CommandMessage getCommandMessage() throws IOException {
        ByteBuffer byteBuffer = ByteBuffer.allocate(100000);
        lastClient = datagramChannel.receive(byteBuffer);
        Logger.getAnonymousLogger().log(Level.INFO, "received message");
        Message message = mapper.readValue(byteBuffer.array(), new TypeReference<Message>() {});
        System.out.println(message);
        return message.commandMessage();
    }


    public void sendMessage(Object toSend) throws IOException {
        Stack<Integer> stack = new Stack<>();
        ByteBuffer byteBuffer = ByteBuffer.wrap(mapper.writeValueAsBytes(toSend));
        stack.add(byteBuffer.array().length);
        ByteBuffer lenBuffer = ByteBuffer.wrap(mapper.writeValueAsBytes(stack));
        Logger.getAnonymousLogger().log(Level.INFO, lastClient + " message sent");
        datagramChannel.send(lenBuffer, lastClient);
        datagramChannel.send(byteBuffer, lastClient);
    }

    public void kill() throws IOException {
        datagramChannel.close();
    }
}
