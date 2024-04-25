import Classes.Context;
import Network.CommandMessage;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Context context = new Context();
        try {
            context.getCommunicationsArray().accept();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Connected with");

        while (true){
            try {
                CommandMessage message = context.getCommunicationsArray().getCommandMessage();
                System.out.println(message.commandClass());
                context.getCommandManager().exec(message);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if (!context.getCommunicationsArray().isConnected()){
                context.getCommunicationsArray().accept();
            }
        }
    }
}