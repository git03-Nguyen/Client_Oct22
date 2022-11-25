package team6.client.handler;

import java.io.IOException;
import java.net.Socket;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import team6.client.gui.ControlGUI;
import team6.client.socket.SocketHandler;

public class Applications{

    private final ControlGUI controlGUI;
    private SocketHandler socketHandler;
    private DefaultTableModel modelTblApp;
    private DefaultTableModel modelTblStartApp;
    
    public Applications(ControlGUI controlGUI, Socket socket) throws IOException {
        this.controlGUI = controlGUI;
        this.socketHandler = new SocketHandler(socket);
        
        controlGUI.getTblApp().setDefaultEditor(Object.class, null);
        modelTblApp = (DefaultTableModel) controlGUI.getTblApp().getModel();
        
        controlGUI.getTblStartApp().setDefaultEditor(Object.class, null);
        modelTblStartApp = (DefaultTableModel) controlGUI.getTblStartApp().getModel();
        
        getInstalled();
    }
    
    public void getApplications() {        
        Thread thread = new Thread(){
            @Override
            public void run() {
                while(controlGUI.selectedTab == 1){
                    try {
                        byte[] byteArray = null;
                        socketHandler.send("<GET>$<>");
                        byteArray = socketHandler.receive();
                        
                        String data = null;
                        data = new String(byteArray);
                        
                        if (controlGUI.selectedTab == 1) {
                            drawTableApp(data);
                            Thread.sleep(3000);
                        } else {
                            System.out.println("Stop getting apps");
                            return;
                        }
                    } catch (IOException | InterruptedException ex) {
                        Logger.getLogger(Applications.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        };
        
        thread.start();
    }
    
    private void drawTableApp(String data){
        String[] apps = data.split("\n");
        Vector<Integer> index = new Vector<>();
        for (int i = 0; i < apps.length; i++) {
            if(apps[i].equals("")) continue;
            String[] attribution = apps[i].split("/");
            if(attribution.length != 4) continue;
            
            int j =0;
            for(; j < modelTblApp.getRowCount(); j++){
                String id = (String) modelTblApp.getValueAt(j, 1);
                if(id.equals(attribution[1])){
                    index.add(j);
                    modelTblApp.setValueAt(attribution[1],j,1);
                    modelTblApp.setValueAt(attribution[2],j,2);
                    modelTblApp.setValueAt(attribution[3],j,3);
                    break;
                }
            }
            
            if(j >= modelTblApp.getRowCount()){
                index.add(j);
                modelTblApp.addRow(new Object[] {attribution[0], attribution[1], attribution[2], attribution[3]});
            }
        }
        
        for(int i = modelTblApp.getRowCount()-1; i>=0; i--){
            if(!index.contains(i)){
                modelTblApp.removeRow(i);
            }
        }
    }
    
    public void getInstalled() throws IOException {
        Thread th = new Thread() {
            @Override
            public void run() {
                try {
                    socketHandler.send("<GET-INSTALLED>$<>");
                    byte[] byteArray = null;
                    byteArray = socketHandler.receive();
                    String data = new String(byteArray);
                    String[] apps = data.split("\r\n");
                    for (String app : apps) {
                        if (app.equals(" ") || app.equals("") || app.equals("\n") || app.equals("\r") || app.equals("\r\n")) {
                            continue;
                        }
                        
                        modelTblStartApp.addRow(new Object[]{app.trim()});
                    }
                } catch (IOException ex) {
                    Logger.getLogger(Applications.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        th.start();
    }
    
    public void killApp() {
        try {
            int row = controlGUI.getTblApp().getSelectedRow();
            if(row == -1) return;
            socketHandler.send("<KILL>$<" + modelTblApp.getValueAt(row,1)+">");
        } catch (IOException ex) {
            Logger.getLogger(Applications.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void startApp() {
        try {
            int row = controlGUI.getTblStartApp().getSelectedRow();
            if(row == -1) return;
            socketHandler.send("<START-ID>$<" + modelTblStartApp.getValueAt(row,0) + ">");
        } catch (IOException ex) {
            Logger.getLogger(Applications.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void startNameMessage(String name) throws IOException{
        socketHandler.send("<START-NAME>$<" + name + ">");
    }
    
    public void startIDMessage(String name) throws IOException{
        socketHandler.send("<START-ID>$<" + name + ">");
    }

    public void close() {
        socketHandler.close();
    }
}
