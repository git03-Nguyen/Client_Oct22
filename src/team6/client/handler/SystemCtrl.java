package team6.client.handler;

import team6.client.socket.SocketHandler;

public class SystemCtrl {
    SocketHandler socketHandler;

    public SystemCtrl(SocketHandler socketHandler) {
        this.socketHandler = socketHandler;
        getSystemInfo();
    }
    
    public void getSystemInfo() {
        socketHandler.send("<SYSTEM>$<GET>$<>");
    }
    
    public void shutDown() {
        socketHandler.send("<SYSTEM>$<SHUT>$<>");
    }
    
    public void restart() {
        socketHandler.send("<SYSTEM>$<RES>$<>");
    }
    
    public void logOut() {
        socketHandler.send("<SYSTEM>$<LOGOUT>$<>");
    }
}
