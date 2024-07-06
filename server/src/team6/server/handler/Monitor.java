package team6.server.handler;

import java.awt.AWTException;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import team6.server.socket.SocketHandler;

public class Monitor extends Thread {

    private final SocketHandler socketHandler;
    private Robot robot;
    private Rectangle rectangle;

    public Monitor(Socket socket) throws AWTException, IOException, InterruptedException {
        this.socketHandler = new SocketHandler(socket);
        this.start();
    }

    @Override
    public void run() {
        while (!socketHandler.socket.isClosed()) {
            try {
                String message = socketHandler.receive();
                if (message != null) {
                    executeCommand(message);
                }
            } catch (IOException | InterruptedException ex) {
                Logger.getLogger(Monitor.class.getName()).log(Level.SEVERE, null, ex);
                close();
            }
        }
    }

    public void executeCommand(String command) {
        while (true) {
            try {
                if (command.equals("<GET>$<>")) {
                    getMonitor();
                    break;
                }
            } catch (Exception ex) {
                Logger.getLogger(Monitor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void getMonitor() throws AWTException {
        GraphicsEnvironment graphicEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice userScreen = graphicEnvironment.getDefaultScreenDevice();
        rectangle = userScreen.getDefaultConfiguration().getBounds();
        robot = new Robot(userScreen);

        Thread th = new Thread() {
            @Override
            public void run() {
                BufferedImage image = robot.createScreenCapture(rectangle);
                socketHandler.send(image);
            }
        };
        th.start();
    }

    public void close() {
        socketHandler.close();
    }

}
