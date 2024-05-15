package CommandExecution.NetworkCommands;

import ServerClasses.Context;
import CommandExecution.NetworkCommand;
import ServerNetwork.CommandMessage;

public class NetworkCommandRemoveAt extends NetworkCommand {
    public NetworkCommandRemoveAt(Context context) {
        super(context);
    }

    @Override
    public String execute(CommandMessage message) {
        context.getStructureStorage().removeFlatAt(message.numericArgument());
        return "Ok";
    }

    @Override
    public String toString() {
        return "remove_at index : удалить элемент, находящийся в заданной позиции коллекции (index)";
    }
}
