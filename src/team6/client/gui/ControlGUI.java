package team6.client.gui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import team6.client.handler.*;
import team6.client.socket.SocketHandler;

public class ControlGUI extends javax.swing.JFrame {
    public SocketHandler socketHandler;
    
    private Applications applications;
    private Keylogger keylogger;
    private Monitor monitor;
    private Processes processes;
    private SystemCtrl systemCtrl;

    public ControlGUI(SocketHandler socketHandler) {
        initComponents();
        this.socketHandler = socketHandler;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabMain = new javax.swing.JTabbedPane();
        pnlProcess = new javax.swing.JPanel();
        btnEndProc = new javax.swing.JButton();
        btnStartProc = new javax.swing.JButton();
        btnSaveProc = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblProcess = new javax.swing.JTable();
        pnlApp = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblApp = new javax.swing.JTable();
        btnEndApp = new javax.swing.JButton();
        btnStartApp = new javax.swing.JButton();
        btnSaveApp = new javax.swing.JButton();
        pnlMonitor = new javax.swing.JPanel();
        pnlCenterMonitor = new javax.swing.JPanel();
        btnSaveMonitor = new javax.swing.JButton();
        btnChangeDir = new javax.swing.JButton();
        pnlKeylog = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtKeylog = new javax.swing.JTextArea();
        btnSaveKey = new javax.swing.JButton();
        btnClearKey = new javax.swing.JButton();
        pnlSystem = new javax.swing.JPanel();
        pnlSystemInfo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtSystemInfo = new javax.swing.JTextArea();
        pnlSystemCmd = new javax.swing.JPanel();
        btnLogOut = new javax.swing.JButton();
        btnRestart = new javax.swing.JButton();
        btnShutdown = new javax.swing.JButton();

        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        tabMain.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tabMainStateChanged(evt);
            }
        });

        btnEndProc.setText("End process");

        btnStartProc.setText("Start process");

        btnSaveProc.setText("Save logs");

        tblProcess.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "PID", "Name", "CPU", "Memory"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tblProcess);

        javax.swing.GroupLayout pnlProcessLayout = new javax.swing.GroupLayout(pnlProcess);
        pnlProcess.setLayout(pnlProcessLayout);
        pnlProcessLayout.setHorizontalGroup(
            pnlProcessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlProcessLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(btnStartProc)
                .addGap(175, 175, 175)
                .addComponent(btnSaveProc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 191, Short.MAX_VALUE)
                .addComponent(btnEndProc)
                .addGap(29, 29, 29))
            .addGroup(pnlProcessLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4))
        );
        pnlProcessLayout.setVerticalGroup(
            pnlProcessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlProcessLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(pnlProcessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnStartProc)
                    .addComponent(btnEndProc)
                    .addComponent(btnSaveProc))
                .addGap(14, 14, 14))
        );

        tabMain.addTab("Processes", pnlProcess);

        tblApp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "UID", "Name", "CPU", "Memory"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblApp);
        if (tblApp.getColumnModel().getColumnCount() > 0) {
            tblApp.getColumnModel().getColumn(0).setHeaderValue("UID");
            tblApp.getColumnModel().getColumn(1).setHeaderValue("Name");
            tblApp.getColumnModel().getColumn(2).setHeaderValue("CPU");
            tblApp.getColumnModel().getColumn(3).setHeaderValue("Memory");
        }

        btnEndApp.setText("End application");

        btnStartApp.setText("Start application");

        btnSaveApp.setText("Save logs");

        javax.swing.GroupLayout pnlAppLayout = new javax.swing.GroupLayout(pnlApp);
        pnlApp.setLayout(pnlAppLayout);
        pnlAppLayout.setHorizontalGroup(
            pnlAppLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlAppLayout.createSequentialGroup()
                .addGroup(pnlAppLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlAppLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE))
                    .addGroup(pnlAppLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(btnStartApp)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSaveApp)
                        .addGap(191, 191, 191)
                        .addComponent(btnEndApp)))
                .addGap(24, 24, 24))
        );
        pnlAppLayout.setVerticalGroup(
            pnlAppLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAppLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addGroup(pnlAppLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnStartApp)
                    .addComponent(btnSaveApp)
                    .addComponent(btnEndApp))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        tabMain.addTab("Applications", pnlApp);

        javax.swing.GroupLayout pnlCenterMonitorLayout = new javax.swing.GroupLayout(pnlCenterMonitor);
        pnlCenterMonitor.setLayout(pnlCenterMonitorLayout);
        pnlCenterMonitorLayout.setHorizontalGroup(
            pnlCenterMonitorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 663, Short.MAX_VALUE)
        );
        pnlCenterMonitorLayout.setVerticalGroup(
            pnlCenterMonitorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 394, Short.MAX_VALUE)
        );

        btnSaveMonitor.setText("Save picture");

        btnChangeDir.setText("Change location");

        javax.swing.GroupLayout pnlMonitorLayout = new javax.swing.GroupLayout(pnlMonitor);
        pnlMonitor.setLayout(pnlMonitorLayout);
        pnlMonitorLayout.setHorizontalGroup(
            pnlMonitorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMonitorLayout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addComponent(pnlCenterMonitor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMonitorLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(btnChangeDir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSaveMonitor)
                .addGap(52, 52, 52))
        );
        pnlMonitorLayout.setVerticalGroup(
            pnlMonitorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMonitorLayout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(pnlCenterMonitor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlMonitorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSaveMonitor)
                    .addComponent(btnChangeDir))
                .addGap(20, 20, 20))
        );

        tabMain.addTab("Monitor", pnlMonitor);

        txtKeylog.setColumns(20);
        txtKeylog.setRows(5);
        jScrollPane3.setViewportView(txtKeylog);

        btnSaveKey.setText("Save logs");

        btnClearKey.setText("Clear");

        javax.swing.GroupLayout pnlKeylogLayout = new javax.swing.GroupLayout(pnlKeylog);
        pnlKeylog.setLayout(pnlKeylogLayout);
        pnlKeylogLayout.setHorizontalGroup(
            pnlKeylogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlKeylogLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 655, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlKeylogLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(btnClearKey)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSaveKey)
                .addGap(48, 48, 48))
        );
        pnlKeylogLayout.setVerticalGroup(
            pnlKeylogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlKeylogLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlKeylogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSaveKey)
                    .addComponent(btnClearKey))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        tabMain.addTab("Keylogging", pnlKeylog);

        jLabel1.setText("COM System Information:");

        txtSystemInfo.setEditable(false);
        txtSystemInfo.setColumns(20);
        txtSystemInfo.setRows(5);
        jScrollPane1.setViewportView(txtSystemInfo);

        javax.swing.GroupLayout pnlSystemInfoLayout = new javax.swing.GroupLayout(pnlSystemInfo);
        pnlSystemInfo.setLayout(pnlSystemInfoLayout);
        pnlSystemInfoLayout.setHorizontalGroup(
            pnlSystemInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSystemInfoLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(pnlSystemInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlSystemInfoLayout.setVerticalGroup(
            pnlSystemInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSystemInfoLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        btnLogOut.setText("Log out");

        btnRestart.setText("Restart");

        btnShutdown.setText("Shut down");
        btnShutdown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShutdownActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlSystemCmdLayout = new javax.swing.GroupLayout(pnlSystemCmd);
        pnlSystemCmd.setLayout(pnlSystemCmdLayout);
        pnlSystemCmdLayout.setHorizontalGroup(
            pnlSystemCmdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSystemCmdLayout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addGroup(pnlSystemCmdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnShutdown, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                    .addGroup(pnlSystemCmdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnRestart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLogOut, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)))
                .addContainerGap(95, Short.MAX_VALUE))
        );
        pnlSystemCmdLayout.setVerticalGroup(
            pnlSystemCmdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSystemCmdLayout.createSequentialGroup()
                .addGap(151, 151, 151)
                .addComponent(btnLogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRestart, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnShutdown, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlSystemLayout = new javax.swing.GroupLayout(pnlSystem);
        pnlSystem.setLayout(pnlSystemLayout);
        pnlSystemLayout.setHorizontalGroup(
            pnlSystemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSystemLayout.createSequentialGroup()
                .addComponent(pnlSystemInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlSystemCmd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlSystemLayout.setVerticalGroup(
            pnlSystemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlSystemInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlSystemCmd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        tabMain.addTab("System", pnlSystem);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabMain, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabMain, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
	setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        
    }//GEN-LAST:event_formWindowClosing

    private void tabMainStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tabMainStateChanged
//        try {
//            socketHandler.restart();
//        } catch (IOException ex) {
//            Logger.getLogger(ControlGUI.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
        int selectedTab = ((javax.swing.JTabbedPane)evt.getSource()).getSelectedIndex();
        System.out.println("Tab changed to: " + selectedTab);
        
        Thread th = null;
        
        switch (selectedTab) {
            case 0:
                System.out.println("Processsssssssss");
                break;
            case 1:
                System.out.println("Applicationssssss");
                break;
            case 2:
                System.out.println("Monitorrrrrrr");
                monitor = new Monitor(socketHandler);
                System.out.println("About to receive image");
                th = new Thread() {
                    @Override
                    public void run() {
                        try {
                            Image image = socketHandler.receiveImage();
                            System.out.println("Starting drawing image");
                            image = image.getScaledInstance(pnlCenterMonitor.getWidth(),pnlCenterMonitor.getHeight(),Image.SCALE_FAST);
                            Graphics graphics = pnlCenterMonitor.getGraphics();
                            graphics.drawImage(image, 0, 0, pnlCenterMonitor.getWidth(), pnlCenterMonitor.getHeight(), pnlCenterMonitor);
                        } catch (IOException ex) {
                            Logger.getLogger(ControlGUI.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                    }
                };
                th.start();
                
                break;
            case 3:
                System.out.println("Keylogginggg");
                break;
            case 4:
                System.out.println("System Controllll");
                systemCtrl = new SystemCtrl(socketHandler);
                
                th = new Thread() {
                    @Override
                    public void run() {
                        String info = new String(socketHandler.receive());
                        txtSystemInfo.setText(info);
                    }
                }; 
                th.start();
                
                break;
        }
    }//GEN-LAST:event_tabMainStateChanged

    private void btnShutdownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShutdownActionPerformed
        Thread th = new Thread() {
            @Override
            public void run() {
                systemCtrl.shutDown();
            }
        }; 
        th.start();
    }//GEN-LAST:event_btnShutdownActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChangeDir;
    private javax.swing.JButton btnClearKey;
    private javax.swing.JButton btnEndApp;
    private javax.swing.JButton btnEndProc;
    private javax.swing.JButton btnLogOut;
    private javax.swing.JButton btnRestart;
    private javax.swing.JButton btnSaveApp;
    private javax.swing.JButton btnSaveKey;
    private javax.swing.JButton btnSaveMonitor;
    private javax.swing.JButton btnSaveProc;
    private javax.swing.JButton btnShutdown;
    private javax.swing.JButton btnStartApp;
    private javax.swing.JButton btnStartProc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JPanel pnlApp;
    private javax.swing.JPanel pnlCenterMonitor;
    private javax.swing.JPanel pnlKeylog;
    private javax.swing.JPanel pnlMonitor;
    private javax.swing.JPanel pnlProcess;
    private javax.swing.JPanel pnlSystem;
    private javax.swing.JPanel pnlSystemCmd;
    private javax.swing.JPanel pnlSystemInfo;
    private javax.swing.JTabbedPane tabMain;
    private javax.swing.JTable tblApp;
    private javax.swing.JTable tblProcess;
    private javax.swing.JTextArea txtKeylog;
    private javax.swing.JTextArea txtSystemInfo;
    // End of variables declaration//GEN-END:variables
}
