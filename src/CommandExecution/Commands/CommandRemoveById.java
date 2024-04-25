package CommandExecution.Commands;

import Classes.Context;
import CommandExecution.Command;
import Network.CommandMessage;

import java.io.IOException;

public class CommandRemoveById extends Command {
    public CommandRemoveById(Context context) {
        super(context);
    }

    @Override
    public String execute(CommandMessage message) {
        if (!context.getStructureStorage().removeFlatById(message.numericArgument()))
            return ("Квартиры с таким Id не найдено, ничего не удалено");
        return "Ok";
    }

    @Override
    public String toString() {
        return "remove_by_id id : удалить элемент из коллекции по его id";
    }
}
