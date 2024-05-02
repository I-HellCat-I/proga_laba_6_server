package Network;

import Classes.SendedFlatUpdateRecord;

import java.net.SocketAddress;

public record CommandMessage(String commandClass, int numericArgument, SendedFlatUpdateRecord sendedFlatUpdateRecord) {

}
