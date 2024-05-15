package CommandExecution.NetworkCommands;

import ServerClasses.Context;
import CommandExecution.NetworkCommand;
import ServerNetwork.CommandMessage;

import java.io.IOException;

public class NetworkCommandCheckIfExists extends NetworkCommand {
    public NetworkCommandCheckIfExists(Context context) {
        super(context);
    }

    @Override
    public String execute(CommandMessage message) throws IOException {
        boolean fl = false;
        if (context.getStructureStorage().getFlatById(message.numericArgument()) != null) {
            return "true";
        }
        return "false";
    }

    @Override
    public String toString() {
        return null;
    }
}
