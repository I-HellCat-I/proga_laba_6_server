package CommandExecution.NetworkCommands;

import ServerClasses.Context;
import ServerClasses.House;
import CommandExecution.NetworkCommand;
import ServerNetwork.CommandMessage;

import java.util.ArrayList;

public class NetworkCommandPrintUniqueHouse extends NetworkCommand {
    public NetworkCommandPrintUniqueHouse(Context context) {
        super(context);
    }

    @Override
    public String execute(CommandMessage message) {
        ArrayList<House> uniques = context.getStructureStorage().getUniqueHouse();
        return String.valueOf(uniques);
    }

    @Override
    public String toString() {
        return "print_unique_house : вывести уникальные значения поля house всех элементов в коллекции";
    }
}
