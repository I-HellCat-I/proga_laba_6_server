package CommandExecution.NetworkCommands;

import ServerClasses.Context;
import CommandExecution.NetworkCommand;
import ServerNetwork.CommandMessage;

public class NetworkCommandCountLTFurnish extends NetworkCommand {
    public NetworkCommandCountLTFurnish(Context context) {
        super(context);
    }

    @Override
    public String execute(CommandMessage message) {
        return String.valueOf(context.getStructureStorage().countLTFurnish(message.numericArgument()));
    }

    @Override
    public String toString() {
        return "count_less_than_furnish furnish : вывести количество элементов, значение поля furnish которых меньше заданного";
    }
}
