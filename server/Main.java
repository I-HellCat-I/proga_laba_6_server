import CommandExecution.Interactor;
import ServerClasses.Context;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Context context = new Context();
        Thread serverCommandsExecutor = new Thread(){
            @Override
            public void run() {
                Interactor interactor = new Interactor(context);
                Scanner scanner = new Scanner(System.in);
                while (true){
                    interactor.masterProcessInput(scanner.nextLine());
                }
            }
        };
        serverCommandsExecutor.start();
        while (true) {
            context.getCommandManager().exec(context.getServerCommunicationsArray().getCommandMessage(), context.getServerCommunicationsArray());
        }
    }
}