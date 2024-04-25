package CommandExecution.Commands;

import Classes.Context;
import CommandExecution.Command;
import Network.CommandMessage;

import java.io.IOException;

public class CommandSort extends Command {
    public CommandSort(Context context) {
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
