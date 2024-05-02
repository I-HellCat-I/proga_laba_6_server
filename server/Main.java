import Classes.Context;
import Network.ClientHandler;
import Network.CommandMessage;

import java.io.IOException;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) throws IOException {
        Context context = new Context();
        while (true) {
            context.getCommandManager().exec(context.getServerCommunicationsArray().getCommandMessage(), context.getServerCommunicationsArray());
        }
    }
}