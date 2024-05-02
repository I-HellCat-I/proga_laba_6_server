package Network;

import java.net.InetSocketAddress;
import java.net.SocketAddress;

public record Message(CommandMessage commandMessage, InetSocketAddress address) {
}
