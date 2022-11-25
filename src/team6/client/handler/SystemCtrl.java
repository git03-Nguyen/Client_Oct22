package team6.client.handler;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import team6.client.gui.ControlGUI;
import team6.client.socket.SocketHandler;

public class SystemCtrl {
    private ControlGUI controlGUI;
    private SocketHandler socketHandler;

    public SystemCtrl(ControlGUI controlGUI, Socket socket) throws IOException {
        this.controlGUI = controlGUI;
        this.socketHandler = new SocketHandler(socket);
        getSystemInfo();
    }    
    
    public void getSystemInfo() {
        Thread th = new Thread() {
            @Override
            public void run() {
                try {
                    socketHandler.send("<GET>$<>");
                    String info = new String(socketHandler.receive());
                    controlGUI.getTxtSystemInfo().setText(info);
                } catch (IOException ex) {
                    Logger.getLogger(SystemCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        th.start();
    }
    
    public void shutDown() {
        Thread th = new Thread() {
            @Override
            public void run() {
                try {
                    socketHandler.send("<SHUT>$<>");
                } catch (IOException ex) {
                    Logger.getLogger(SystemCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        th.start();
    }
    
    public void restart() {
        Thread th = new Thread() {
            @Override
            public void run() {
                try {
                    socketHandler.send("<RES>$<>");
                } catch (IOException ex) {
                    Logger.getLogger(SystemCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        th.start();
    }
    
    public void logOut() {
        Thread th = new Thread() {
            @Override
            public void run() {
                try {
                    socketHandler.send("<LOGOUT>$<>");
                } catch (IOException ex) {
                    Logger.getLogger(SystemCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        th.start();
    }
    
    public void save(String directory) {
        Thread th = new Thread() {
            @Override
            public void run() {
                File dir = new File(directory);
                if (!dir.exists()) {
                    dir.mkdirs();
                }
                
                String fileName = "SystemInfomation";
                File file = new File(directory + "\\" + fileName + ".txt");

                int count = 0;
                while (file.exists()) {
                    count++;
                    file = new File(directory + "\\" + fileName + " (" + count + ").txt");
                }
                
                try {
                    FileOutputStream out = new FileOutputStream(file);
                    out.write(controlGUI.getTxtSystemInfo().getText().getBytes());
                    out.flush();
                    out.close();
                    System.out.println("Saved to " + file.getAbsolutePath());
                } catch (IOException ex) {
                    Logger.getLogger(Monitor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        
        th.start();
    }

    public void close() {
        socketHandler.close();
    }
}
