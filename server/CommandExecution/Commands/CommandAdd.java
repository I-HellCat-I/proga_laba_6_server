package CommandExecution.Commands;

import Classes.Context;
import Classes.Flat;
import CommandExecution.Command;
import Network.CommandMessage;


public class CommandAdd extends Command {
    public CommandAdd(Context context) {
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
