package team6.client.handler;

import java.io.IOException;
import java.net.Socket;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import team6.client.gui.ControlGUI;
import team6.client.socket.SocketHandler;

public class Processes {
    private final ControlGUI controlGUI;
    private final SocketHandler socketHandler;
    private DefaultTableModel modelTblProc;
    private DefaultTableModel modelTblStartProc;

    public Processes(ControlGUI controlGUI, Socket socket) throws IOException {
        this.controlGUI = controlGUI;
        this.socketHandler = new SocketHandler(socket);
        
        controlGUI.getTblProc().setDefaultEditor(Object.class, null);
        modelTblProc = (DefaultTableModel) controlGUI.getTblProc().getModel();
        
        controlGUI.getTblStartProc().setDefaultEditor(Object.class, null);
        modelTblStartProc = (DefaultTableModel) controlGUI.getTblStartProc().getModel();
        
        getInstalled();
    }
    
    public void getProcesses() {
        Thread th = new Thread() {
            @Override
            public void run() {
                while(controlGUI.selectedTab == 0){
                    try {
                        byte[] byteArray;
                        sleep(1500);
                        socketHandler.send("<GET>$<>");
                        byteArray = socketHandler.receive();
                        String data = new String(byteArray);
                        
                        if (controlGUI.selectedTab == 0) {
                            drawTblProc(data);
                        } else {
                            System.out.println("Stop getting processes");
                            return;
                        }
                    } catch (InterruptedException | IOException ex) {
                        Logger.getLogger(Processes.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        };
        th.start();
    }
    
    public void drawTblProc(String data) {
        String[] procs = data.split("\n");
        
        Vector<Integer> index = new Vector<>();
        
        for (String proc : procs) {
            if (proc.equals("")) {
                continue;
            }
            String[] attribution = proc.split("/");
            if(attribution.length != 4) continue;
            int j =0;
            for(; j < modelTblProc.getRowCount(); j++){
                String id = (String) modelTblProc.getValueAt(j, 1);
                if(id.equals(attribution[1])){
                    index.add(j);
                    modelTblProc.setValueAt(attribution[1],j,1);
                    modelTblProc.setValueAt(attribution[2],j,2);
                    modelTblProc.setValueAt(attribution[3],j,3);
                    break;
                }
            }
            if(j >= modelTblProc.getRowCount()){
                index.add(j);
                modelTblProc.addRow(new Object[] {attribution[0], attribution[1], attribution[2], attribution[3]});
            }
        }
        
        for(int i = modelTblProc.getRowCount()-1; i>=0; i--){
            if(!index.contains(i)){
                modelTblProc.removeRow(i);
            }
        }
    }
    
    public void getInstalled() throws IOException {
        Thread th = new Thread() {
            @Override
            public void run() {
                try {
                    socketHandler.send("<START-PROCESS>$<>");
                    byte[] byteArray;
                    byteArray = socketHandler.receive();
                    
                    String data = new String(byteArray);
                    
                    String[] pros = data.split("\n");
                    for(int i = 0; i < pros.length; i++){
                        if(pros[i].equals("") || pros[i].equals("\n") || pros[i].equals("\r") || pros[i].equals("\r\n")) continue;
                        modelTblStartProc.addRow(new Object[] {pros[i].trim()});
                    }
                } catch (IOException ex) {
                    Logger.getLogger(Processes.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        th.start();
    }
    
    public void startProc() {
        try {
            int row = controlGUI.getTblStartProc().getSelectedRow();
            if(row == -1) return;
            socketHandler.send("<START-NAME>$<" + modelTblStartProc.getValueAt(row,0) + ">");
        } catch (IOException ex) {
            Logger.getLogger(Applications.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void killProc() {
        try {
            int row = controlGUI.getTblProc().getSelectedRow();
            if (row == -1) return;
            socketHandler.send("<KILL>$<" + modelTblProc.getValueAt(row, 1) + ">");
        } catch (IOException ex) {
            Logger.getLogger(Processes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void close() {
        socketHandler.close();
    }
    
}
