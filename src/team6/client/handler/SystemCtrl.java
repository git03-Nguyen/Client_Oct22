package team6.client.handler;

import team6.client.socket.SocketHandler;

public class SystemCtrl extends AbstractHandler {
    SocketHandler socketHandler;

    public SystemCtrl(SocketHandler socketHandler) {
        super(socketHandler);
    }
    
    private void shutDown() {
        socketHandler.send("<SHUT>$<>");
    }
    
    private void restart() {
        socketHandler.send("<RES>$<>");
    }
    
    private void logOut() {
        socketHandler.send("<LGOUT>$<>");
    }
}
