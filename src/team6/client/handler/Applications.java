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

public class Applications {

    private final ControlGUI controlGUI;
    private final SocketHandler socketHandler;
    private DefaultTableModel modelTblApp;
    private DefaultTableModel modelTblStartApp;
    public String saveLocation;

    public Applications(ControlGUI controlGUI, Socket socket) throws IOException {
        this.controlGUI = controlGUI;
        this.socketHandler = new SocketHandler(socket);

        controlGUI.tblApp.setDefaultEditor(Object.class, null);
        modelTblApp = (DefaultTableModel) controlGUI.tblApp.getModel();

        controlGUI.tblStartApp.setDefaultEditor(Object.class, null);
        modelTblStartApp = (DefaultTableModel) controlGUI.tblStartApp.getModel();

        saveLocation = "D:/team6_logs/applications";

        getInstalled();
    }

    public void getApplications() {
        Thread thread = new Thread() {
            @Override
            public void run() {
                while (controlGUI.selectedTab == 1) {
                    try {
                        byte[] byteArray = null;

                        synchronized (socketHandler) {
                            socketHandler.send("<GET>$<>");
                            byteArray = socketHandler.receive();
                        }

                        String data = null;
                        data = new String(byteArray);

                        if (controlGUI.selectedTab == 1) {
                            drawTableApp(data);
                            Thread.sleep(600);
                        } else {
//                            System.out.println("Stop getting apps");
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

    private void drawTableApp(String data) {
        String[] apps = data.split("\n");

        Map<String, String[]> map = new HashMap<>();

        Map<String, Integer> index = new HashMap<>();

        for (String app : apps) {
            if (app.equals("")) {
                continue;
            }
            String[] attribute = app.split("/");
            if (attribute.length != 4) {
                continue;
            }
            map.put(attribute[1], attribute);
        }

        for (int i = 0; i < modelTblApp.getRowCount(); i++) {
            String pid = (String) modelTblApp.getValueAt(i, 1);
            if (map.containsKey(pid)) {
                if (!map.get(pid)[0].equals((String) modelTblApp.getValueAt(i, 0))) {
                    modelTblApp.setValueAt(map.get(pid)[0], i, 0);
                }

                if (!map.get(pid)[2].equals((String) modelTblApp.getValueAt(i, 2))) {
                    modelTblApp.setValueAt(map.get(pid)[2], i, 2);
                }

                if (!map.get(pid)[3].equals((String) modelTblApp.getValueAt(i, 3))) {
                    modelTblApp.setValueAt(map.get(pid)[3], i, 3);
                }

                index.put(pid, i);
            } else {
                modelTblApp.removeRow(i);
            }
        }

        for (Map.Entry<String, String[]> entry : map.entrySet()) {
            if (!index.containsKey(entry.getKey())) {
                modelTblApp.addRow(entry.getValue());
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
                    byte[] byteArray = null;
                    synchronized (socketHandler) {
                        socketHandler.send("<GET-INSTALLED>$<>");
                        byteArray = socketHandler.receive();
                    }

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
            int row = controlGUI.tblApp.getSelectedRow();
            if (row == -1) {
                return;
            }
            socketHandler.send("<KILL>$<" + modelTblApp.getValueAt(row, 1) + ">");
        } catch (IOException ex) {
            Logger.getLogger(Applications.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void startAppBySelection() {
        try {
            int row = controlGUI.tblStartApp.getSelectedRow();
            if (row == -1) {
                return;
            }
            socketHandler.send("<START-ID>$<" + modelTblStartApp.getValueAt(row, 0) + ">");
        } catch (IOException ex) {
            Logger.getLogger(Applications.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void startAppByName() {
        try {
            String appName = controlGUI.txtStartApp.getText();
            if (appName.length() <= 0) {
                return;
            }
            for (int i = 0; i < controlGUI.tblStartApp.getRowCount(); i++) {
                if (appName.toLowerCase().equals(((String) controlGUI.tblStartApp.getModel().getValueAt(i, 0)).toLowerCase())) {
                    socketHandler.send("<START-ID>$<" + appName + ">");
                    controlGUI.txtStartApp.setText("");
                    return;
                }
            }
            JOptionPane.showMessageDialog(controlGUI.startAppGUI, "Application not found!");
        } catch (IOException ex) {
            Logger.getLogger(Applications.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void save() {
        Thread th = new Thread() {
            @Override
            public void run() {
                if (controlGUI.tblApp.getRowCount() == 0) {
                    return;
                }

                File dir = new File(saveLocation);
                if (!dir.exists()) {
                    dir.mkdirs();
                }

                String fileName = "Applications";
                File file = new File(saveLocation + "\\" + fileName + ".txt");

                int count = 0;
                while (file.exists()) {
                    count++;
                    file = new File(saveLocation + "\\" + fileName + " (" + count + ").txt");
                }

                try {
                    BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(file));
                    TableModel tblModel = controlGUI.tblApp.getModel();
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
                    JOptionPane.showMessageDialog(controlGUI, "Saved to " + file.getAbsolutePath() + "!");
                } catch (IOException ex) {
                    Logger.getLogger(Applications.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(controlGUI, "Error!");
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
