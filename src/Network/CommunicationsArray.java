package Network;

import Classes.Context;
import Classes.Flat;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.json.JsonMapper;

import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;
import java.util.Arrays;


public class CommunicationsArray {
    private Context context;
    protected DatagramSocket datagramSocket;
    protected ServerSocket serverSocket;
    protected JsonMapper mapper;
    protected Socket client;
    protected DataOutputStream clientOutputStream;

    public CommunicationsArray(Context context) throws IOException {
        this.context = context;
        this.datagramSocket = new DatagramSocket(3123);
        this.serverSocket = new ServerSocket(3124);
        System.out.println(serverSocket.getInetAddress());
        mapper = JsonMapper.builder().findAndAddModules().build();
    }
    public void accept() throws IOException {
        this.client = this.serverSocket.accept();
        clientOutputStream = new DataOutputStream(client.getOutputStream());
    }

    public CommandMessage getCommandMessage() throws IOException {
        byte[] bytes = new byte[100000];
        DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length);
        datagramSocket.receive(datagramPacket);
        return mapper.readValue(datagramPacket.getData(), new TypeReference<CommandMessage>() {});
    }


    public void sendMessage(Object toSend) throws IOException {
        mapper.writeValue((DataOutput) clientOutputStream, toSend);
    }

    public boolean isConnected() {
        return serverSocket.isBound();
    }
}
