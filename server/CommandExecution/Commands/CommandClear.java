package CommandExecution.Commands;

import Classes.Context;
import CommandExecution.Command;
import Network.CommandMessage;

public class CommandClear extends Command {
    public CommandClear( Context context) {
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
