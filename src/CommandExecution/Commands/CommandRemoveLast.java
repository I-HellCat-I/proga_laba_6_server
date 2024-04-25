package CommandExecution.Commands;

import Classes.Context;
import CommandExecution.Command;
import Network.CommandMessage;

import java.io.IOException;
import java.util.EmptyStackException;

public class CommandRemoveLast extends Command {

    public CommandRemoveLast(Context context) {
        super(context);
    }

    @Override
    public String execute(CommandMessage message) {
        try {
            context.getStructureStorage().removeLastFlat();
        } catch (EmptyStackException e){
            return "Стэк пуст, ничего не удалено";
        }
        return "Ok";
    }

    @Override
    public String toString() {
        return "remove_last : удалить последний элемент из коллекции";
    }
}
