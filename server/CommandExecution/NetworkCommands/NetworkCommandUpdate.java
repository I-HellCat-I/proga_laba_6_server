package CommandExecution.NetworkCommands;

import ServerClasses.Context;
import CommandExecution.NetworkCommand;
import ServerNetwork.CommandMessage;

public class NetworkCommandUpdate extends NetworkCommand {
    public NetworkCommandUpdate(Context context) {
        super(context);
    }

    @Override
    public String execute(CommandMessage message) {
        if (!context.getStructureStorage().updateFlatByRecord(message.sendedFlatUpdateRecord())) {
            return ("Квартиры с таким Id не найдено, ничего обновляться не будет");
        }
        return "Ok";
    }

    @Override
    public String toString() {
        return "update id {element} : обновить значение элемента коллекции, id которого равен заданному";
    }
}
