package CommandExecution;

import CommandExecution.LocalCommands.LocalCommandSave;
import ServerClasses.Context;
import CommandExecution.NetworkCommands.*;
import ServerNetwork.CommandMessage;
import ServerNetwork.ServerCommunicationsArray;
import lombok.Getter;
import lombok.SneakyThrows;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Класс, отвечающий за обработку команд
 */
public class CommandManager {

    @Getter
    private HashMap<String, Class<? extends NetworkCommand>> commands = new HashMap<>(); // Хранит в себе команды
    private HashMap<String, Class<? extends LocalCommand>> notNetworkCommands = new HashMap<>();
    private Context context;

    /*
      Блок, задающий базовые команды
      */
    public CommandManager(Context context) {
        this.context = context;
        addCommand("CommandExecution.Commands.CommandInfo", NetworkCommandInfo.class);
        addCommand("CommandExecution.Commands.CommandShow", NetworkCommandShow.class);
        addCommand("CommandExecution.Commands.CommandAdd", NetworkCommandAdd.class);
        addCommand("CommandExecution.Commands.CommandSort", NetworkCommandSort.class);
        addCommand("CommandExecution.Commands.CommandUpdate", NetworkCommandUpdate.class);
        addCommand("CommandExecution.Commands.CommandRemoveById", NetworkCommandRemoveById.class);
        addCommand("CommandExecution.Commands.CommandClear", NetworkCommandClear.class);
        addCommand("CommandExecution.Commands.CommandRemoveAt", NetworkCommandRemoveAt.class);
        addCommand("CommandExecution.Commands.CommandRemoveLast", NetworkCommandRemoveLast.class);
        addCommand("CommandExecution.Commands.CommandCountLTFurnish", NetworkCommandCountLTFurnish.class);
        addCommand("CommandExecution.Commands.CommandRemoveById", NetworkCommandRemoveById.class);
        addCommand("CommandExecution.Commands.CommandExecuteScript", NetworkCommandExecuteScript.class);
        addCommand("CommandExecution.Commands.CommandSumOfNumberOfRooms", NetworkCommandSumOfNumberOfRooms.class);
        addCommand("CommandExecution.Commands.CommandPrintUniqueHouse", NetworkCommandPrintUniqueHouse.class);
        addCommand("CommandExecution.Commands.CommandCheckIfExists", NetworkCommandCheckIfExists.class);
        addCommand("CommandExecution.Commands.CommandHandShake", NetworkCommandHandShake.class);
        addNotNetoworkCommand("save", LocalCommandSave.class);
    }

    @SneakyThrows
    public String serverExec(String word, String[] args) {
        if (notNetworkCommands.containsKey(word)){
            return notNetworkCommands.get(word).getConstructor(String[].class, Context.class)
                    .newInstance(args, context).execute();
        } return ("Такой команды нет");
    }

    public void addCommand(String s, Class<? extends NetworkCommand> f) {
        commands.put(s, f);
    }

    public void addNotNetoworkCommand(String s, Class<? extends LocalCommand> f) {
        notNetworkCommands.put(s, f);
    }

    public <T> void exec(CommandMessage message, ServerCommunicationsArray communicationsArray) {
        try {
            if (!commands.containsKey(message.commandClass())){
                communicationsArray.sendMessage("No such command");
                Logger.getAnonymousLogger().log(Level.WARNING, "Server got wrong command");
                System.out.println(message);
                return;
            }
            communicationsArray.sendMessage(
                    commands.get(message.commandClass()).getConstructor(Context.class)
                            .newInstance(context).execute(message)
            );
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException |
                 IOException e) {
            Logger.getAnonymousLogger().log(Level.WARNING, "CommandManager.exec", e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
