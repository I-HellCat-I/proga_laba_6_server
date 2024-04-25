package CommandExecution.Commands;

import Classes.Context;
import Classes.House;
import CommandExecution.Command;
import Network.CommandMessage;

import java.io.IOException;
import java.util.ArrayList;

public class CommandPrintUniqueHouse extends Command {
    public CommandPrintUniqueHouse(Context context) {
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
