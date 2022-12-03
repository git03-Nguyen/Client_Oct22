package team6.client.handler;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import team6.client.gui.ControlGUI;
import team6.client.socket.SocketHandler;

public class Monitor {

    private final SocketHandler socketHandler;
    private ControlGUI controlGUI;
    private volatile BufferedImage buffImage;
    public String saveLocation;

    public Monitor(ControlGUI controlGUI, Socket socket) throws IOException {
        this.controlGUI = controlGUI;
        this.socketHandler = new SocketHandler(socket);
        saveLocation = "D:/team6_logs/monitor";
    }

    public void getMonitor() {
        Thread th = new Thread() {
            @Override
            public void run() {
                while (controlGUI.selectedTab == 2) {
                    try {
                        synchronized (socketHandler) {
                            socketHandler.send("<GET>$<>");
                            sleep(100);
                            buffImage = (BufferedImage) socketHandler.receiveImage();
                        }

                        Image image = buffImage;

                        image = image.getScaledInstance(controlGUI.pnlCenterMonitor.getWidth(), controlGUI.pnlCenterMonitor.getHeight(), Image.SCALE_FAST);
                        Graphics graphics = controlGUI.pnlCenterMonitor.getGraphics();

                        if (controlGUI.selectedTab == 2) {
                            graphics.drawImage(image, 0, 0, controlGUI.pnlCenterMonitor.getWidth(), controlGUI.pnlCenterMonitor.getHeight(), controlGUI.pnlCenterMonitor);
                        } else {
//                            System.out.println("Stop getting monitor");
                        }

                        graphics.dispose();
                        image.flush();
                        image = null;
                    } catch (NullPointerException ex) {
                    } catch (IOException | InterruptedException ex) {
                        Logger.getLogger(ControlGUI.class.getName()).log(Level.SEVERE, null, ex);
                        break;
                    }
                }
            }
        };

        th.start();
    }

    public void saveMonitor() {
        Thread th = new Thread() {
            @Override
            public void run() {
                File dir = new File(saveLocation);
                if (!dir.exists()) {
                    dir.mkdirs();
                }

                String fileName = "ScreenShot";
                File file = new File(saveLocation + "\\" + fileName + ".jpg");

                int count = 0;
                while (file.exists()) {
                    count++;
                    file = new File(saveLocation + "\\" + fileName + " (" + count + ").jpg");
                }

                try {
                    ImageIO.write(buffImage, "jpg", file);
                    JOptionPane.showMessageDialog(controlGUI, "Saved to " + file.getAbsolutePath());
                } catch (IOException ex) {
                    Logger.getLogger(Monitor.class.getName()).log(Level.SEVERE, null, ex);
                    file.delete();
                    JOptionPane.showMessageDialog(controlGUI, "Error!");
                }
            }
        };
        th.start();
    }

    public void close() {
        socketHandler.close();
    }

}
