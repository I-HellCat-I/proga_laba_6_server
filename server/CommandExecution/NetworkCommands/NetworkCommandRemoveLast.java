package CommandExecution.NetworkCommands;

import ServerClasses.Context;
import CommandExecution.NetworkCommand;
import ServerNetwork.CommandMessage;

import java.util.EmptyStackException;

public class NetworkCommandRemoveLast extends NetworkCommand {

    public NetworkCommandRemoveLast(Context context) {
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
