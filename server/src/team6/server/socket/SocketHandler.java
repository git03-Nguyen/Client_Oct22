package team6.server.socket;

import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.Thread.sleep;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class SocketHandler {

    public Socket socket;
    private BufferedReader in;
    private DataOutputStream out;

    public SocketHandler(Socket socket) throws IOException {
        this.socket = socket;
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
    }

    public String receive() throws IOException, InterruptedException {
        if (in == null) {
            return null;
        }
        sleep(50);
        String message = null;
        message = in.readLine();
        if (message == null) {
            return null;
        }
//        System.out.println("RECEIVED: " + message);
        return message;
    }

    public void send(byte[] data) {
        try {
            out.writeInt(data.length);
            out.write(data);
            out.flush();
//            System.out.println("SENT " + data.length + "B" + " DATA:" + new String(data));
        } catch (IOException ex) {
            Logger.getLogger(SocketHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void send(BufferedImage image) {
        try {
            ImageIO.write(image, "jpeg", out);
//            System.out.println("SENT: image!");
        } catch (IOException ex) {
            Logger.getLogger(SocketHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void close() {
        try {
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(SocketHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
