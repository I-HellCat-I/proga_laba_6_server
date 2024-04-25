package CommandExecution.Commands;

import Classes.Context;
import CommandExecution.Command;
import Network.CommandMessage;

public class CommandCountLTFurnish extends Command {
    public CommandCountLTFurnish(Context context) {
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
