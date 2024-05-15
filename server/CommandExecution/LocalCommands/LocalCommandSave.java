package CommandExecution.LocalCommands;

import CommandExecution.LocalCommand;
import ServerClasses.Context;
import CommandExecution.NetworkCommand;
import ServerNetwork.CommandMessage;

import java.io.IOException;

public class LocalCommandSave extends LocalCommand {

    public LocalCommandSave(String[] args, Context context) {
        super(args, context);
    }

    @Override
    public String execute() throws IOException {
        context.getFileManager().saveCollection();
        return null;
    }
}
