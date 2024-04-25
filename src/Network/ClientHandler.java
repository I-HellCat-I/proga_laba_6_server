package Network;

import Classes.Context;
import Classes.Logger;
import com.fasterxml.jackson.databind.json.JsonMapper;

import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler implements Runnable{
    private static Socket client;
    private Context context;
    private CommunicationsArray communicationsArray;
    public ClientHandler(Socket client, Context context) throws IOException {
        ClientHandler.client = client;
        this.communicationsArray = new CommunicationsArray(client);
        this.context = context;
        Logger.log("New ClientHandler", "New client : " + client.getInetAddress());
    }
    @Override
    public void run() {
        while (client.isConnected()){
            try {
                CommandMessage message = null;
                message = communicationsArray.getCommandMessage();
                Logger.log("ClientHandler", "command type: " + message.commandClass());
                context.getCommandManager().exec(message, communicationsArray);

            } catch (IOException e) {
                Logger.log("ClientHandler", e.getMessage());
            }
        }
        try {
            communicationsArray.kill();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
