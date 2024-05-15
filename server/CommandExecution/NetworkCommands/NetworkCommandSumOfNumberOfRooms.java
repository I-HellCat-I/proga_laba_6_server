package CommandExecution.NetworkCommands;

import ServerClasses.Context;
import CommandExecution.NetworkCommand;
import ServerNetwork.CommandMessage;

public class NetworkCommandSumOfNumberOfRooms extends NetworkCommand {
    public NetworkCommandSumOfNumberOfRooms(Context context) {
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
