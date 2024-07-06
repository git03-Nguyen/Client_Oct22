package team6.client.socket;

import java.awt.Image;
import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class SocketHandler {

    private final Socket socket;
    private DataInputStream in;
    private BufferedWriter out;

    public SocketHandler(Socket socket) throws IOException {
        this.socket = socket;
        in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
        out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
    }

    public byte[] receive() throws IOException {
        byte[] byteArray = null;
        int size = 0;
        try {
            size = in.readInt();
            byteArray = in.readNBytes(size);
//            System.out.println("RECEIVED " + size + "B:" + new String(byteArray));
        } catch (IOException ex) {
            Logger.getLogger(SocketHandler.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return byteArray;
    }

    public Image receiveImage() throws IOException {
        Image image = null;
        byte[] byteArray = new byte[1024 * 1024];
        int count = 0;
        do {
            count += in.read(byteArray, count, byteArray.length - count);
        } while (!(count > 4 && byteArray[count - 2] == (byte) -1 && byteArray[count - 1] == (byte) -39));
        image = ImageIO.read(new ByteArrayInputStream(byteArray));

//        System.out.println("RECEIVED: image");
        return image;
    }

    public void send(String message) throws IOException {
        out.write(message + "\n");
        out.flush();
//        System.out.println("SENT: " + message);
    }

    public void close() {
        try {
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(SocketHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getHost() {
        return socket.getInetAddress().getHostAddress();
    }

    public int getPort() {
        return socket.getPort();
    }

    public Socket getSocket() {
        return socket;
    }
}
