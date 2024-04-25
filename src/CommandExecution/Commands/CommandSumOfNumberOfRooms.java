package CommandExecution.Commands;

import Classes.Context;
import CommandExecution.Command;
import Network.CommandMessage;

import java.io.IOException;

public class CommandSumOfNumberOfRooms extends Command {
    public CommandSumOfNumberOfRooms(Context context) {
        super(context);
    }

    @Override
    public String execute(CommandMessage message) {
        return String.valueOf(context.getStructureStorage().getNumberOfRoomsSum());
    }

    @Override
    public String toString() {
        return "sum_of_number_of_rooms : вывести сумму значений поля numberOfRooms для всех элементов коллекции";
    }
}
