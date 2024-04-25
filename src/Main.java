import Classes.Context;
import Classes.Logger;
import Network.ClientHandler;
import Network.CommandMessage;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws IOException {
        Context context = new Context();
        ExecutorService executors = Executors.newVirtualThreadPerTaskExecutor();
        try (ServerSocket serverSocket = new ServerSocket(3214)) {
            while (true) {
                Socket client = serverSocket.accept();
                executors.execute(new ClientHandler(client, context));
                Logger.log("Main", "New connection");
            }
        }
    }
}