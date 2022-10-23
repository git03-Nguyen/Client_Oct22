package team6.client.gui;

public class RemoteGUI extends javax.swing.JFrame {

    public RemoteGUI() {
        initComponents();
        this.setLocationRelativeTo(null);
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
        jTextArea1 = new javax.swing.JTextArea();
        pnlSystemCmd = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        btnEndProc.setText("End process");

        btnStartProc.setText("Start new process");

        btnSaveProc.setText("Save logs");
        btnSaveProc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveProcActionPerformed(evt);
            }
        });

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 166, Short.MAX_VALUE)
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

        btnEndApp.setText("End application");
        btnEndApp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEndAppActionPerformed(evt);
            }
        });

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

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

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

        jButton1.setText("Log out");

        jButton2.setText("Restart");

        jButton3.setText("Shut down");

        jButton4.setText("Disconnect");

        jButton5.setText("Access CMD");

        javax.swing.GroupLayout pnlSystemCmdLayout = new javax.swing.GroupLayout(pnlSystemCmd);
        pnlSystemCmd.setLayout(pnlSystemCmdLayout);
        pnlSystemCmdLayout.setHorizontalGroup(
            pnlSystemCmdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSystemCmdLayout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addGroup(pnlSystemCmdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlSystemCmdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jButton3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton5, javax.swing.GroupLayout.Alignment.LEADING)))
                .addContainerGap(95, Short.MAX_VALUE))
        );
        pnlSystemCmdLayout.setVerticalGroup(
            pnlSystemCmdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSystemCmdLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addGap(31, 31, 31)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59))
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
    }// </editor-fold>//GEN-END:initComponents

    private void btnEndAppActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEndAppActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEndAppActionPerformed

    private void btnSaveProcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveProcActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSaveProcActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChangeDir;
    private javax.swing.JButton btnClearKey;
    private javax.swing.JButton btnEndApp;
    private javax.swing.JButton btnEndProc;
    private javax.swing.JButton btnSaveApp;
    private javax.swing.JButton btnSaveKey;
    private javax.swing.JButton btnSaveMonitor;
    private javax.swing.JButton btnSaveProc;
    private javax.swing.JButton btnStartApp;
    private javax.swing.JButton btnStartProc;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea jTextArea1;
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
    // End of variables declaration//GEN-END:variables
}
