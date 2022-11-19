package team6.client.gui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import team6.client.socket.SocketHandler;

public class HomeGUI extends javax.swing.JFrame {
    private ControlGUI[] controlGUI;
    private int currentSelection;

    public HomeGUI() {
        initComponents();
        controlGUI = new ControlGUI[] {null, null, null, null, null, null};
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LoginGUI = new javax.swing.JFrame();
        jLabel1 = new javax.swing.JLabel();
        tfHost = new javax.swing.JTextField();
        tfPort = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnConnect = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        btnGroupCOM = new javax.swing.ButtonGroup();
        pnlMain = new javax.swing.JPanel();
        lblAppName = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        pnlCenter = new javax.swing.JPanel();
        btnCOM0 = new javax.swing.JToggleButton();
        btnCOM1 = new javax.swing.JToggleButton();
        btnCOM2 = new javax.swing.JToggleButton();
        btnCOM3 = new javax.swing.JToggleButton();
        btnCOM4 = new javax.swing.JToggleButton();
        btnCOM5 = new javax.swing.JToggleButton();
        btnAdd = new javax.swing.JButton();
        btnDisconnect = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        btnControl = new javax.swing.JButton();

        LoginGUI.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        LoginGUI.setTitle("Add Connection");
        LoginGUI.setAlwaysOnTop(true);
        LoginGUI.setBounds(new java.awt.Rectangle(0, 0, 333, 200));
        LoginGUI.setResizable(false);
        LoginGUI.setSize(333, 200);
        LoginGUI.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                LoginGUIWindowClosing(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Add new connection");

        tfHost.setText("127.0.0.1");

        tfPort.setText("9888");

        jLabel3.setText("Port:");

        jLabel2.setText("IP Host:");

        btnConnect.setText("Connect");
        btnConnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConnectActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout LoginGUILayout = new javax.swing.GroupLayout(LoginGUI.getContentPane());
        LoginGUI.getContentPane().setLayout(LoginGUILayout);
        LoginGUILayout.setHorizontalGroup(
            LoginGUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LoginGUILayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66))
            .addGroup(LoginGUILayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator2)
                .addContainerGap())
            .addGroup(LoginGUILayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(LoginGUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(LoginGUILayout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(LoginGUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfHost, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(LoginGUILayout.createSequentialGroup()
                                .addComponent(tfPort, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                                .addComponent(btnConnect)))))
                .addGap(44, 44, 44))
        );
        LoginGUILayout.setVerticalGroup(
            LoginGUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LoginGUILayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(LoginGUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LoginGUILayout.createSequentialGroup()
                        .addGroup(LoginGUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(tfHost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(LoginGUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(tfPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(LoginGUILayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(btnConnect, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(58, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Home");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        pnlMain.setPreferredSize(new java.awt.Dimension(682, 454));

        lblAppName.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblAppName.setText("Remote Control Application");

        pnlCenter.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnGroupCOM.add(btnCOM0);
        btnCOM0.setText("COM0");
        btnCOM0.setFocusPainted(false);
        btnCOM0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCOM0ActionPerformed(evt);
            }
        });
        pnlCenter.add(btnCOM0, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 120, 120));

        btnGroupCOM.add(btnCOM1);
        btnCOM1.setText("COM1");
        btnCOM1.setFocusPainted(false);
        btnCOM1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCOM1ActionPerformed(evt);
            }
        });
        pnlCenter.add(btnCOM1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, 120, 120));

        btnGroupCOM.add(btnCOM2);
        btnCOM2.setText("COM2");
        btnCOM2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCOM2ActionPerformed(evt);
            }
        });
        pnlCenter.add(btnCOM2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 20, 120, 120));

        btnGroupCOM.add(btnCOM3);
        btnCOM3.setText("COM3");
        btnCOM3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCOM3ActionPerformed(evt);
            }
        });
        pnlCenter.add(btnCOM3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 120, 120));

        btnGroupCOM.add(btnCOM4);
        btnCOM4.setText("COM4");
        btnCOM4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCOM4ActionPerformed(evt);
            }
        });
        pnlCenter.add(btnCOM4, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 180, 120, 120));

        btnGroupCOM.add(btnCOM5);
        btnCOM5.setText("COM5");
        btnCOM5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCOM5ActionPerformed(evt);
            }
        });
        pnlCenter.add(btnCOM5, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 180, 120, 120));

        btnAdd.setText("Add New");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnDisconnect.setText("Disconnect");
        btnDisconnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDisconnectActionPerformed(evt);
            }
        });

        btnControl.setText("Control");
        btnControl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnControlActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlMainLayout = new javax.swing.GroupLayout(pnlMain);
        pnlMain.setLayout(pnlMainLayout);
        pnlMainLayout.setHorizontalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlMainLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1))
                    .addGroup(pnlMainLayout.createSequentialGroup()
                        .addGap(218, 218, 218)
                        .addComponent(lblAppName)
                        .addGap(0, 217, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator3)
                .addContainerGap())
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(btnAdd)
                .addGap(167, 167, 167)
                .addComponent(btnControl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnDisconnect)
                .addGap(31, 31, 31))
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(pnlCenter, javax.swing.GroupLayout.PREFERRED_SIZE, 636, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlMainLayout.setVerticalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lblAppName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlCenter, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnDisconnect)
                    .addComponent(btnControl, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        btnAdd.setEnabled(false);
        btnDisconnect.setEnabled(false);
        btnControl.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMain, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setVisible(true);
        System.out.println("HomeGUI is running ...");
        currentSelection = 0;

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    // Event handlings when click btnAdd
    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        LoginGUI.setLocationRelativeTo(this);
        LoginGUI.setVisible(true);
        this.setEnabled(false);
        System.out.println("Login window is opening ...");
    }//GEN-LAST:event_btnAddActionPerformed

    // Event handling when closing LoginGUI
    private void LoginGUIWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_LoginGUIWindowClosing
        System.out.println("Login window is hiding ... ");
        this.setEnabled(true);
        tfHost.setText("127.0.0.1");
        tfPort.setText("9888");
    }//GEN-LAST:event_LoginGUIWindowClosing

    // Event handling when closing HomeGUI
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // Disconnect all
        for (int i = 0; i< 6;i++) {
            if (controlGUI[i] == null) continue;
            controlGUI[i].socketHandler.send("<DISC>$<>$<>");
            controlGUI[i].socketHandler.close();
            controlGUI[i].dispose();
            controlGUI[i] = null;
        }
        System.out.println("HomeGUI is closing ....");        
    }//GEN-LAST:event_formWindowClosing

    // Event handling when clicking btnConnect on LoginGUI
    private void btnConnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConnectActionPerformed
        SocketHandler socketHandler; 
        String host;
        int port;
        try {
            host = tfHost.getText();
            port = Integer.parseInt(tfPort.getText());
            
            for (int i = 0; i < 6; i++) {
                ControlGUI cGUI = controlGUI[i];
                if (cGUI != null && cGUI.socketHandler.getHost().equals(host) && cGUI.socketHandler.getPort() == port) {
                    LoginGUI.setAlwaysOnTop(false);
                    JOptionPane.showMessageDialog(rootPane, "IP/port is existed at COM" + i + "!");
                    LoginGUI.setAlwaysOnTop(true);
                    return;
                }   
            }
            
            socketHandler = new SocketHandler(host, port);
        }
        catch (NumberFormatException | IOException e) {
            LoginGUI.setAlwaysOnTop(false);
            JOptionPane.showMessageDialog(rootPane, "IP/port is uncorrect!");
            LoginGUI.setAlwaysOnTop(true);
            return;
        }  
        // if connected successfully
        controlGUI[currentSelection] = new ControlGUI(socketHandler);
        controlGUI[currentSelection].setTitle(host + ":" + Integer.toString(port));
        LoginGUI.dispose();
        this.setEnabled(true);
        this.setVisible(true);
        btnAdd.setEnabled(false);
        btnDisconnect.setEnabled(true);
        btnControl.setEnabled(true);
    }//GEN-LAST:event_btnConnectActionPerformed

    private void btnControlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnControlActionPerformed
        controlGUI[currentSelection].setVisible(true);
    }//GEN-LAST:event_btnControlActionPerformed

    // Event handlings when choosing one COM
    private void btnCOM0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCOM0ActionPerformed
        System.out.println("COM0 selected");
        currentSelection = 0;
        if (controlGUI[0] == null) {
            btnAdd.setEnabled(true);
            btnControl.setEnabled(false);
            btnDisconnect.setEnabled(false);
        }
        else {
            btnAdd.setEnabled(false);
            btnControl.setEnabled(true);
            btnDisconnect.setEnabled(true);
        }
    }//GEN-LAST:event_btnCOM0ActionPerformed
    
    private void btnCOM1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCOM1ActionPerformed
        System.out.println("COM1 selected");
        currentSelection = 1;
        if (controlGUI[1] == null) {
            btnAdd.setEnabled(true);
            btnControl.setEnabled(false);
            btnDisconnect.setEnabled(false);
        }
        else {
            btnAdd.setEnabled(false);
            btnControl.setEnabled(true);
            btnDisconnect.setEnabled(true);
        }
    }//GEN-LAST:event_btnCOM1ActionPerformed

    private void btnCOM2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCOM2ActionPerformed
        System.out.println("COM2 selected");
        currentSelection = 2;
        if (controlGUI[2] == null) {
            btnAdd.setEnabled(true);
            btnControl.setEnabled(false);
            btnDisconnect.setEnabled(false);
        }
        else {
            btnAdd.setEnabled(false);
            btnControl.setEnabled(true);
            btnDisconnect.setEnabled(true);
        }
    }//GEN-LAST:event_btnCOM2ActionPerformed

    private void btnCOM3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCOM3ActionPerformed
        System.out.println("COM3 selected");
         currentSelection = 3;
        if (controlGUI[3] == null) {
            btnAdd.setEnabled(true);
            btnControl.setEnabled(false);
            btnDisconnect.setEnabled(false);
        }
        else {
            btnAdd.setEnabled(false);
            btnControl.setEnabled(true);
            btnDisconnect.setEnabled(true);
        }
    }//GEN-LAST:event_btnCOM3ActionPerformed

    private void btnCOM4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCOM4ActionPerformed
        System.out.println("COM4 selected");
        currentSelection = 4;
        if (controlGUI[4] == null) {
            btnAdd.setEnabled(true);
            btnControl.setEnabled(false);
            btnDisconnect.setEnabled(false);
        }
        else {
            btnAdd.setEnabled(false);
            btnControl.setEnabled(true);
            btnDisconnect.setEnabled(true);
        }
    }//GEN-LAST:event_btnCOM4ActionPerformed

    private void btnCOM5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCOM5ActionPerformed
        System.out.println("COM5 selected");
        currentSelection = 5;
        if (controlGUI[5] == null) {
            btnAdd.setEnabled(true);
            btnControl.setEnabled(false);
            btnDisconnect.setEnabled(false);
        }
        else {
            btnAdd.setEnabled(false);
            btnControl.setEnabled(true);
            btnDisconnect.setEnabled(true);
        }
    }//GEN-LAST:event_btnCOM5ActionPerformed

    // Event handling when clicking btnDisconnect
    private void btnDisconnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDisconnectActionPerformed
        controlGUI[currentSelection].socketHandler.send("<DISC>$<>$<>");
        controlGUI[currentSelection].socketHandler.close();
        controlGUI[currentSelection].dispose();
        controlGUI[currentSelection] = null;
        btnDisconnect.setEnabled(false);
        btnAdd.setEnabled(true);
        btnControl.setEnabled(false);
    }//GEN-LAST:event_btnDisconnectActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFrame LoginGUI;
    private javax.swing.JButton btnAdd;
    private javax.swing.JToggleButton btnCOM0;
    private javax.swing.JToggleButton btnCOM1;
    private javax.swing.JToggleButton btnCOM2;
    private javax.swing.JToggleButton btnCOM3;
    private javax.swing.JToggleButton btnCOM4;
    private javax.swing.JToggleButton btnCOM5;
    private javax.swing.JButton btnConnect;
    private javax.swing.JButton btnControl;
    private javax.swing.JButton btnDisconnect;
    private javax.swing.ButtonGroup btnGroupCOM;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lblAppName;
    private javax.swing.JPanel pnlCenter;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JTextField tfHost;
    private javax.swing.JTextField tfPort;
    // End of variables declaration//GEN-END:variables
}
