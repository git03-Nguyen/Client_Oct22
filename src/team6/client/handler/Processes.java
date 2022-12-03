package team6.client.handler;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import team6.client.gui.ControlGUI;
import team6.client.socket.SocketHandler;

public class Processes {

    private final ControlGUI controlGUI;
    private final SocketHandler socketHandler;
    private DefaultTableModel modelTblProc;
    private DefaultTableModel modelTblStartProc;
    public String saveLocation;

    public Processes(ControlGUI controlGUI, Socket socket) throws IOException {
        this.controlGUI = controlGUI;
        this.socketHandler = new SocketHandler(socket);

        controlGUI.tblProcess.setDefaultEditor(Object.class, null);
        modelTblProc = (DefaultTableModel) controlGUI.tblProcess.getModel();

        controlGUI.tblStartProc.setDefaultEditor(Object.class, null);
        modelTblStartProc = (DefaultTableModel) controlGUI.tblStartProc.getModel();

        saveLocation = "D:/team6_logs/processes";

        getInstalled();
    }

    public void getProcesses() {
        Thread th = new Thread() {
            @Override
            public void run() {
                while (controlGUI.selectedTab == 0) {
                    try {
                        byte[] byteArray;

                        synchronized (socketHandler) {
                            socketHandler.send("<GET>$<>");
                            byteArray = socketHandler.receive();
                        }

                        String data = new String(byteArray);

                        if (controlGUI.selectedTab == 0) {
                            drawTblProc(data);
                            Thread.sleep(600);
                        } else {
//                            System.out.println("Stop getting processes");
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

        Map<String, String[]> map = new HashMap<>();

        Map<String, Integer> index = new HashMap<>();

        for (String proc : procs) {
            if (proc.equals("")) {
                continue;
            }
            String[] attribute = proc.split("/");
            if (attribute.length != 4) {
                continue;
            }
            map.put(attribute[1], attribute);
        }

        for (int i = 0; i < modelTblProc.getRowCount(); i++) {
            String pid = (String) modelTblProc.getValueAt(i, 1);
            if (map.containsKey(pid)) {
                if (!map.get(pid)[0].equals((String) modelTblProc.getValueAt(i, 0))) {
                    modelTblProc.setValueAt(map.get(pid)[0], i, 0);
                }

                if (!map.get(pid)[2].equals((String) modelTblProc.getValueAt(i, 2))) {
                    modelTblProc.setValueAt(map.get(pid)[2], i, 2);
                }

                if (!map.get(pid)[3].equals((String) modelTblProc.getValueAt(i, 3))) {
                    modelTblProc.setValueAt(map.get(pid)[3], i, 3);
                }

                index.put(pid, i);
            } else {
                modelTblProc.removeRow(i);
            }
        }

        for (Map.Entry<String, String[]> entry : map.entrySet()) {
            if (!index.containsKey(entry.getKey())) {
                modelTblProc.addRow(entry.getValue());
            }
        }

        map.clear();
        map = null;
        index.clear();
        index = null;
    }

    public void getInstalled() throws IOException {
        Thread th = new Thread() {
            @Override
            public void run() {
                try {
                    byte[] byteArray;

                    synchronized (socketHandler) {
                        socketHandler.send("<START-PROCESS>$<>");
                        byteArray = socketHandler.receive();
                    }

                    String data = new String(byteArray);

                    String[] pros = data.split("\n");
                    for (int i = 0; i < pros.length; i++) {
                        if (pros[i].equals("") || pros[i].equals("\n") || pros[i].equals("\r") || pros[i].equals("\r\n")) {
                            continue;
                        }
                        modelTblStartProc.addRow(new Object[]{pros[i].trim()});
                    }
                } catch (IOException ex) {
                    Logger.getLogger(Processes.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        th.start();
    }

    public void startProcBySelection() {
        try {
            int row = controlGUI.tblStartProc.getSelectedRow();
            if (row == -1) {
                return;
            }
            socketHandler.send("<START-PATH>$<" + modelTblStartProc.getValueAt(row, 0) + ">");
        } catch (IOException ex) {
            Logger.getLogger(Processes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void startProcByName() {

        try {
            String procName = controlGUI.txtStartProc.getText();
            if (procName.equals("")) {
                return;
            }
            socketHandler.send("<START-NAME>$<" + procName + ">");
            controlGUI.txtStartProc.setText("");
        } catch (IOException ex) {
            Logger.getLogger(Processes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void killProc() {
        try {
            int row = controlGUI.tblProcess.getSelectedRow();
            if (row == -1) {
                return;
            }
            socketHandler.send("<KILL>$<" + modelTblProc.getValueAt(row, 1) + ">");
        } catch (IOException ex) {
            Logger.getLogger(Processes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void save() {
        Thread th = new Thread() {
            @Override
            public void run() {
                if (controlGUI.tblProcess.getRowCount() == 0) {
                    return;
                }

                File dir = new File(saveLocation);
                if (!dir.exists()) {
                    dir.mkdirs();
                }

                String fileName = "Processes";
                File file = new File(saveLocation + "\\" + fileName + ".txt");

                int count = 0;
                while (file.exists()) {
                    count++;
                    file = new File(saveLocation + "\\" + fileName + " (" + count + ").txt");
                }

                try {
                    BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(file));
                    TableModel tblModel = controlGUI.tblProcess.getModel();
                    StringBuilder buff = new StringBuilder();
                    for (int i = 0; i < tblModel.getColumnCount(); i++) {
                        buff.append(tblModel.getColumnName(i) + ",");
                    }
                    buff.append("\n");
                    for (int i = 0; i < tblModel.getRowCount(); i++) {
                        for (int j = 0; j < tblModel.getColumnCount(); j++) {
                            buff.append(tblModel.getValueAt(i, j) + ",");
                        }
                        buff.append("\n");
                    }
                    out.write(buff.toString().getBytes());
                    out.flush();
                    out.close();
                    JOptionPane.showMessageDialog(controlGUI, "Saved to " + file.getAbsolutePath());
                } catch (IOException ex) {
                    Logger.getLogger(Processes.class.getName()).log(Level.SEVERE, null, ex);
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
