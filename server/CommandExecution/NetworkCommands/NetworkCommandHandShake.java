package CommandExecution.NetworkCommands;

import ServerClasses.Context;
import CommandExecution.NetworkCommand;
import ServerNetwork.CommandMessage;

import java.io.IOException;

public class NetworkCommandHandShake extends NetworkCommand {
    public NetworkCommandHandShake(Context context) {
        super(context);
    }

    @Override
    public String execute(CommandMessage message) throws IOException {
        return "Handshake";
    }

    @Override
    public String toString() {
        return null;
    }
}
