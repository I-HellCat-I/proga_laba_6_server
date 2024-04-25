package CommandExecution.Commands;

import Classes.Context;
import Classes.SendedFlatUpdateRecord;
import CommandExecution.Command;
import Network.CommandMessage;

import java.io.IOException;

public class CommandUpdate extends Command {
    public CommandUpdate(Context context) {
        super(context);
    }

    @Override
    public String execute(CommandMessage message) {
        if (context.getStructureStorage().updateFlatByRecord(message.sendedFlatUpdateRecord())) {
            return ("Квартиры с таким Id не найдено, ничего обновляться не будет");
        }
        return "Ok";
    }

    @Override
    public String toString() {
        return "update id {element} : обновить значение элемента коллекции, id которого равен заданному";
    }
}
