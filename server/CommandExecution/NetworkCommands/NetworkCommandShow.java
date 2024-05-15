package CommandExecution.NetworkCommands;

import ServerClasses.Context;
import CommandExecution.NetworkCommand;
import ServerNetwork.CommandMessage;

public class NetworkCommandShow extends NetworkCommand {
    public NetworkCommandShow(Context context) {
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
