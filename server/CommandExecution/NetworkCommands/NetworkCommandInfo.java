package CommandExecution.NetworkCommands;

import ServerClasses.Context;
import CommandExecution.NetworkCommand;
import ServerNetwork.CommandMessage;

public class NetworkCommandInfo extends NetworkCommand {
    public NetworkCommandInfo(Context context) {
        super(context);
    }

    @Override
    public String execute(CommandMessage message) {
        return (context.getStructureStorage().getClass() + " " + context.getInitDate() + " " + context.getStructureStorage().getSize());
    }

    @Override
    public String toString() {
        return "info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)";
    }
}
