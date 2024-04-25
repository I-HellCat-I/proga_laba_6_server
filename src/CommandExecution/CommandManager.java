package CommandExecution;

import Classes.Context;
import CommandExecution.Commands.*;
import Network.CommandMessage;
import lombok.Getter;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

/**
 * Класс, отвечающий за обработку команд
 */
public class CommandManager {

    @Getter
    private HashMap<String, Class<? extends Command>> commands = new HashMap<>(); // Хранит в себе команды
    private Context context;

    /*
      Блок, задающий базовые команды
      */
    public CommandManager(Context context) {
        this.context = context;
        addCommand("CommandExecution.Commands.CommandInfo", CommandInfo.class);
        addCommand("CommandExecution.Commands.CommandShow", CommandShow.class);
        addCommand("CommandExecution.Commands.CommandAdd", CommandAdd.class);
        addCommand("CommandExecution.Commands.CommandSort", CommandSort.class);
        addCommand("CommandExecution.Commands.CommandUpdate", CommandUpdate.class);
        addCommand("CommandExecution.Commands.CommandRemoveById", CommandRemoveById.class);
        addCommand("CommandExecution.Commands.CommandClear", CommandClear.class);
        addCommand("CommandExecution.Commands.CommandRemoveAt", CommandRemoveAt.class);
        addCommand("CommandExecution.Commands.CommandRemoveLast", CommandRemoveLast.class);
        addCommand("CommandExecution.Commands.CommandCountLTFurnish", CommandCountLTFurnish.class);
        addCommand("CommandExecution.Commands.CommandRemoveById", CommandRemoveById.class);
        addCommand("CommandExecution.Commands.CommandExecuteScript", CommandExecuteScript.class);
        addCommand("CommandExecution.Commands.CommandSumOfNumberOfRooms", CommandSumOfNumberOfRooms.class);
        addCommand("CommandExecution.Commands.CommandPrintUniqueHouse", CommandPrintUniqueHouse.class);
    }

    public void addCommand(String s, Class<? extends Command> f) {
        commands.put(s, f);
    }

    public <T> void exec(CommandMessage message) {
        try {
            context.getCommunicationsArray().sendMessage(
                    commands.get(message.commandClass()).getConstructor(Context.class)
                            .newInstance(context).execute(message)
            );
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException |
                 IOException e) {
            throw new RuntimeException(e);
        }
    }
}
