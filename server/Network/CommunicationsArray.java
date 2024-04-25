package Network;

import Classes.Context;
import Classes.Flat;
import Classes.Logger;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.json.JsonMapper;

import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;
import java.util.Arrays;


public class CommunicationsArray {
    protected DatagramSocket datagramSocket;
    protected JsonMapper mapper;
    protected Socket client;
    protected DataOutputStream clientOutputStream;

    public CommunicationsArray(Socket client) throws IOException {
        this.client = client;
        mapper = JsonMapper.builder().findAndAddModules().build();
        datagramSocket = new DatagramSocket(3213, client.getInetAddress());
        clientOutputStream = new DataOutputStream(client.getOutputStream());
    }

    public CommandMessage getCommandMessage() throws IOException {
        byte[] bytes = new byte[100000];
        DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length);
        datagramSocket.receive(datagramPacket);
        Logger.log("Communications array, " + client.getInetAddress(), "received message");
        return mapper.readValue(datagramPacket.getData(), new TypeReference<CommandMessage>() {});
    }


    public void sendMessage(Object toSend) throws IOException {
        Logger.log("CommuncationsArray " + client.getInetAddress(), "message sent");
        System.out.println(toSend);
        mapper.writeValue((DataOutput) clientOutputStream, toSend);
    }

    public boolean isConnected() {
        return client.isBound();
    }
    public void kill() throws IOException {
        clientOutputStream.close();
        datagramSocket.close();
        client.close();
    }
}
