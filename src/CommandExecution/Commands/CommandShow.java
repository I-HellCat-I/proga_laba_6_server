package CommandExecution.Commands;

import Classes.Context;
import CommandExecution.Command;
import Network.CommandMessage;

import java.io.IOException;

public class CommandShow extends Command {
    public CommandShow(Context context) {
        super(context);
    }

    @Override
    public String execute(CommandMessage message) {
        StringBuilder ans = new StringBuilder();
        context.getStructureStorage().getCollection().forEach(ans::append);
        if (ans.isEmpty()){
            ans.append("Пусто");
        }
        return ans.toString();
    }

    @Override
    public String toString() {
        return "show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении";
    }
}
