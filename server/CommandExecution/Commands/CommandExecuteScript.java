package CommandExecution.Commands;

import Classes.Context;
import CommandExecution.Command;
import Network.CommandMessage;

public class CommandExecuteScript extends Command {
    public CommandExecuteScript(Context context) {
        super(context);
    }

//    @Override
//    public String execute() {
//        return context.getInteractor().executeScript(args[0]);
//    }

    @Override
    public String execute(CommandMessage message) {
        return null;
    }

    @Override
    public String toString() {
        return "execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.";
    }
}
