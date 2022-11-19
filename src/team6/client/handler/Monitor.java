package team6.client.handler;

import team6.client.socket.SocketHandler;

public class Monitor {
    public SocketHandler socketHandler;
    
    public Monitor(SocketHandler socketHandler) {
        this.socketHandler = socketHandler;
        getMonitor();
    }

    private void getMonitor() {
        socketHandler.send("<MONITOR>$<GET>$<>");
    }
    
    
}
