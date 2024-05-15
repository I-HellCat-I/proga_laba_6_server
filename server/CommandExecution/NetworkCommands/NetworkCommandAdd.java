package CommandExecution.NetworkCommands;

import ServerClasses.Context;
import ServerClasses.Flat;
import CommandExecution.NetworkCommand;
import ServerNetwork.CommandMessage;


public class NetworkCommandAdd extends NetworkCommand {
    public NetworkCommandAdd(Context context) {
        super(context);
    }

    @Override
    public String execute(CommandMessage message) {
        context.getStructureStorage().addFlat(new Flat(message.sendedFlatUpdateRecord().flatUpdateRecord()));
        return "Ok";
    }

    @Override
    public String toString() {
        return "add {element} : добавить новый элемент в коллекцию";
    }
}
