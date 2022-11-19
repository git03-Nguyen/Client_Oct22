package team6.client.socket;

import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class SocketHandler {
    private Socket socket;
    private DataInputStream in;
    private PrintWriter out;
    
    public SocketHandler(String host, int port) throws IOException {
        socket = new Socket(host, port);
        in = new DataInputStream(socket.getInputStream());
        out = new PrintWriter(socket.getOutputStream());
    }
    
    public byte[] receive() {
        byte[] byteArray = null;
        int size= 0;
        try {
            size = in.readInt();
            byteArray = new byte[size];
            in.read(byteArray, 0, size);
            System.out.println("RECEIVED: " + new String(byteArray));
        } catch (IOException ex) {
            Logger.getLogger(SocketHandler.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return byteArray;
    }
    
    public Image receiveImage() throws IOException {
        Image image = null;
        byte[] byteArray = new byte[1024*1024];
        int count = 0;
        System.out.println("About to read byte-by-byte");
        do {
            count += in.read(byteArray,count,byteArray.length-count);
        } while(!(count>4 && byteArray[count-2]==(byte)-1 && byteArray[count-1]==(byte)-39));
        System.out.println("Complete read");
        image = ImageIO.read(new ByteArrayInputStream(byteArray));
        
        System.out.println("RECEIVED image");
        return image;
        
    }
    
    public void send(String data) {
        out.write(data + "\n");
        out.flush();
        System.out.println("Sent: " + data);
    }
    
    public void close() {
        try {
            in.close();
            out.close();
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
} 