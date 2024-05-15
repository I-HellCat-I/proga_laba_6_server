package CommandExecution.NetworkCommands;

import ServerClasses.Context;
import CommandExecution.NetworkCommand;
import ServerNetwork.CommandMessage;

public class NetworkCommandRemoveById extends NetworkCommand {
    public NetworkCommandRemoveById(Context context) {
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
