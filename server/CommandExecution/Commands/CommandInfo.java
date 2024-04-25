package CommandExecution.Commands;

import Classes.Context;
import CommandExecution.Command;
import Network.CommandMessage;

import java.io.IOException;

public class CommandInfo extends Command {
    public CommandInfo(Context context) {
        super(context);
    }

    @Override
    public String execute(CommandMessage message) {
        return (context.getStructureStorage().getClass() + " " + context.getInitDate() + " " + context.getStructureStorage().getSize());
    }

    @Override
    public String toString() {
        return "info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)";
    }
}
