package Network;

import Classes.Context;

import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientHandler implements Runnable{
    private static Socket client;
    private Context context;
    private ServerCommunicationsArray communicationsArray;
    public ClientHandler(Socket client, Context context) throws IOException {
        ClientHandler.client = client;
        this.communicationsArray = new ServerCommunicationsArray();
        this.context = context;
        Logger.getAnonymousLogger().log(Level.INFO,"New ClientHandler, New client : " + client.getInetAddress());
    }
    @Override
    public void run() {
        Logger.getAnonymousLogger().log(Level.INFO, "ClientHandler started");
        while (!client.isClosed()){
            try {
                CommandMessage message = null;
                message = communicationsArray.getCommandMessage();
                Logger.getAnonymousLogger().log(Level.INFO, "ClientHandler, command type: " + message.commandClass());
                context.getCommandManager().exec(message, communicationsArray);

            } catch (IOException e) {
                Logger.getAnonymousLogger().log(Level.WARNING,"ClientHandler " + e.getMessage());
            }
        }
        try {
            communicationsArray.kill();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
