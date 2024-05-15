package CommandExecution.NetworkCommands;

import ServerClasses.Context;
import CommandExecution.NetworkCommand;
import ServerNetwork.CommandMessage;

public class NetworkCommandSort extends NetworkCommand {
    public NetworkCommandSort(Context context) {
        super(context);
    }

    @Override
    public String execute(CommandMessage message) {
        context.getStructureStorage().sort();
        return "Ok";
    }

    @Override
    public String toString() {
        return "sort : отсортировать коллекцию в естественном порядке";
    }
}
