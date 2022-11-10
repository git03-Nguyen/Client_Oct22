package team6.client.socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SocketHandler {
    Socket socket;
    BufferedReader reader;
    BufferedWriter writer;
    
    Thread thReader;
    Thread thWriter;
    
    public SocketHandler(String host, int port) throws IOException {
        setUpSocket(host, port);
        reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        
        send("<APP>$<GET>$<>");
        receive();
    }
    
    private void setUpSocket(String host, int port) throws IOException {
        socket = new Socket(host, port);
    }
    
    private void receive() {
        thReader = new Thread() {
            String buffer = "";
            @Override
            public void run() {
                System.out.println("Receiving messages ...");
                
                try {
                    while (true) {
                        buffer = reader.readLine();
                        if (buffer.length() <= 0) continue;
                        System.out.println("Message received: " + buffer);
                        
                        if (buffer.equals("<DISC>$<>$<>")) {
                            
                            return;
                        }
                    }
                } catch (IOException ex) {
                    Logger.getLogger(SocketHandler.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        thReader.start();
    }
    
    public void send(String data) {
        try {
            writer.write(data);
            writer.flush();
        } catch (IOException ex) {
            Logger.getLogger(SocketHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void close() {
        try {
            reader.close();
            writer.close();
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(SocketHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
