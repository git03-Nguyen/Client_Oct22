package team6.server.handler;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import oshi.SystemInfo;
import oshi.hardware.GlobalMemory;
import oshi.software.os.OSProcess;
import oshi.software.os.OperatingSystem;
import team6.server.socket.SocketHandler;

public class Applications extends Thread {

    private SystemInfo si;
    private OperatingSystem os;
    private Map<Integer, OSProcess> previousProcesses;
    private SocketHandler socketHandler;

    public Applications(Socket socket) throws IOException {
        this.socketHandler = new SocketHandler(socket);
        si = new SystemInfo();
        previousProcesses = new HashMap<Integer, OSProcess>();
        this.start();
    }

    @Override
    public void run() {
        while (!socketHandler.socket.isClosed()) {
            try {
                String message = socketHandler.receive();
                if (message != null) {
                    executeCommand(message);
                }
            } catch (IOException | InterruptedException ex) {
                Logger.getLogger(Applications.class.getName()).log(Level.SEVERE, null, ex);
                close();
            }
        }
    }

    public void executeCommand(String command) {
        String[] message = command.split("\\$", 2);

        do {
            try {
                if (message[0].equals("<GET>")) {
                    sendApplications();
                    break;
                }

                if (message[0].equals("<GET-INSTALLED>")) {
                    sendInstalledApplications();
                    break;
                }

                if (message[0].equals("<START-NAME>")) {
                    String name = message[1].substring(1, message[1].length() - 1);
                    startAppByName(name);
                    break;
                }

                if (message[0].equals("<START-ID>")) {
                    String name = message[1].substring(1, message[1].length() - 1);
                    startAppByID(name);
                    break;
                }

                if (message[0].equals("<KILL>")) {
                    int ID = Integer.parseInt(message[1].substring(1, message[1].length() - 1));
                    killApp(ID);
                    break;
                }
            } catch (NumberFormatException | IOException ex) {
                Logger.getLogger(Applications.class.getName()).log(Level.SEVERE, null, ex);
            }

        } while (false);
    }

    public void close() {
        socketHandler.close();
    }

    // return String data(format "name1/pid1/cpu1/ram1\nname2/pid2/cpu2/ram2\n.." ) and null if throw error
    public void sendApplications() {
        //get information from system
        List<OSProcess> currentProcesses = new ArrayList<>();
        int numberOfLogicalProcess = si.getHardware().getProcessor().getLogicalProcessorCount();
        GlobalMemory globalMemory = si.getHardware().getMemory();
        long totalRam = globalMemory.getTotal();
        long usedRamProcess = 0;

        Process process = null;
        BufferedReader bufferReader = null;
        String data = "";
        String line = null;
        double cpuUsage = 0.0;
        double ramUsage = 0.0;

        try {
            process = new ProcessBuilder("powershell", "\"gps| ? {$_.mainwindowtitle.length -ne 0} | Format-Table -HideTableHeaders ID").start();
            bufferReader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            //Get object OperatingSystem
            os = si.getOperatingSystem();

            while ((line = bufferReader.readLine()) != null) {
                line = line.trim();
                line = line.replaceAll("\\s+", "");
                if (line.equals("\n") || line.equals("")) {
                    continue;
                }
//                System.out.println(line);

                // add OSProcess into list
                if (os.getProcess(Integer.parseInt(line)) == null) {
                    continue;
                }

                currentProcesses.add(os.getProcess(Integer.parseInt(line)));
            }

            for (OSProcess currentProc : currentProcesses) {
                if (currentProc == null) {
                    continue;
                }
                cpuUsage = 100 * currentProc.getProcessCpuLoadBetweenTicks(previousProcesses.get(currentProc.getProcessID())) / numberOfLogicalProcess;
                cpuUsage = (double) Math.round(cpuUsage * 10) / 10;

                usedRamProcess = currentProc.getResidentSetSize();
                ramUsage = (double) Math.round(10 * (double) usedRamProcess * 100 / totalRam) / 10;

                data = data + currentProc.getName() + "/" + currentProc.getProcessID() + "/"
                        + String.valueOf(cpuUsage) + "%/" + String.valueOf(ramUsage) + "%\n";
            }

            previousProcesses.clear();

            for (OSProcess currentProc : currentProcesses) {
                if (currentProc == null) {
                    continue;
                }
                previousProcesses.put(currentProc.getProcessID(), currentProc);
            }

        } catch (IOException ex) {
            Logger.getLogger(Applications.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }

        socketHandler.send(data.getBytes());
    }

    public void sendInstalledApplications() throws IOException {
        Process process = new ProcessBuilder("powershell", "\"Get-StartApps| Format-Table -HideTableHeaders name").start();
        InputStreamReader in = new InputStreamReader(process.getInputStream());

        ByteArrayOutputStream b = new ByteArrayOutputStream();
        int byte_read;
        while ((byte_read = in.read()) != -1) {
            b.write(byte_read);
        }

        String data = new String(b.toByteArray());
        data = data.replaceAll(" +", " ");
        socketHandler.send(data.getBytes());
    }

    private void startAppByName(String nameApp) throws IOException {
        Runtime.getRuntime().exec(new String[]{"cmd.exe", "/c", "start", nameApp});
    }

    private void startAppByID(String nameApp) {
        Thread th = new Thread() {
            public void run() {
                try {
                    // look up appID by name app
                    Process process = Runtime.getRuntime().exec("powershell.exe Get-StartApps | where { $_.name -eq '" + nameApp + "' } |  Format-Table -HideTableHeaders AppID");
                    BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));

                    String appID = null;
                    while ((appID = in.readLine()) != null) {
                        appID = appID.trim();
                        if (!appID.equals("") && !appID.equals("\n")) {
                            break;
                        }
                    }
//                    System.out.println(appID + "/");
                    // start App by ID
                    Runtime.getRuntime().exec("powershell.exe /c start-process shell:AppsFolder\\" + "'" + appID + "'");
                } catch (IOException ex) {
                    Logger.getLogger(Applications.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };

        th.start();
    }

    private void killApp(int ID) {
        Thread thread = new Thread() {
            public void run() {
                try {
                    String cmd = "taskkill /F /PID " + String.valueOf(ID);
                    Runtime.getRuntime().exec(cmd);
                } catch (IOException ex) {
                    Logger.getLogger(Applications.class.getName()).log(Level.SEVERE, null, ex);

                }
            }
        };
        thread.start();
    }

}
