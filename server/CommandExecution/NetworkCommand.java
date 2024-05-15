package CommandExecution;

import ServerClasses.Context;
import ServerNetwork.CommandMessage;

import java.io.IOException;

/**
 * База для всех команд.
 */
public abstract class NetworkCommand {

    protected Context context;

    public NetworkCommand(Context context) {
        this.context = context;
    }

    public abstract String execute(CommandMessage message) throws IOException;

    public abstract String toString();
}
