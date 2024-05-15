package ServerNetwork;

import ServerClasses.SendedFlatUpdateRecord;

public record CommandMessage(String commandClass, int numericArgument, SendedFlatUpdateRecord sendedFlatUpdateRecord) {

}
