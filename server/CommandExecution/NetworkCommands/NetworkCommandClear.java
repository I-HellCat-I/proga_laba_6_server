package CommandExecution.NetworkCommands;

import ServerClasses.Context;
import CommandExecution.NetworkCommand;
import ServerNetwork.CommandMessage;

public class NetworkCommandClear extends NetworkCommand {
    public NetworkCommandClear(Context context) {
        super(context);
    }


    @Override
    public String execute(CommandMessage message) {
        context.getStructureStorage().clearCollection();
        return "Ok";
    }

    @Override
    public String toString() {
        return "clear : очистить коллекцию";
    }
}
