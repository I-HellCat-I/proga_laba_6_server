package CommandExecution.Commands;

import Classes.Context;
import CommandExecution.Command;
import Network.CommandMessage;

import java.io.IOException;

public class CommandRemoveAt extends Command {
    public CommandRemoveAt(Context context) {
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
