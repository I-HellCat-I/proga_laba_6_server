package CommandExecution;

import Classes.Context;
import Network.CommandMessage;

import java.io.IOException;

/**
 * База для всех команд.
 */
public abstract class Command {

    protected Context context;

    public Command(Context context) {
        this.context = context;
    }

    public abstract String execute(CommandMessage message) throws IOException;

    public abstract String toString();
}
