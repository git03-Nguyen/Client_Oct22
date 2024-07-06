package team6.server.handler;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import oshi.SystemInfo;
import oshi.hardware.GlobalMemory;
import oshi.software.os.OSProcess;
import oshi.software.os.OperatingSystem;
import team6.server.socket.SocketHandler;

public class Processes extends Thread {

    private SystemInfo si;
    private OperatingSystem os;
    private Map<Integer, OSProcess> previousProcesses;
    private SocketHandler socketHandler;
    List<String> name_processes = null;
    List<String> path_processes = null;

    public Processes(Socket socket) throws IOException {
        this.socketHandler = new SocketHandler(socket);

        si = new SystemInfo();
        os = si.getOperatingSystem();
        previousProcesses = new HashMap<>();
        name_processes = new ArrayList<>();
        path_processes = new ArrayList<>();

        this.start();
    }

    @Override
    public void run() {
        List<OSProcess> os_processes;
        os_processes = os.getProcesses();

        for (OSProcess process : os_processes) {
            if (process == null) {
                continue;
            }
            if (name_processes.contains(process.getName())) {
                continue;
            }
            name_processes.add(process.getName());
            path_processes.add(process.getPath());
        }

        while (!socketHandler.socket.isClosed()) {
            try {
                String message = socketHandler.receive();
                if (message != null) {
                    executeCommand(message);
                }
            } catch (IOException | InterruptedException ex) {
                Logger.getLogger(Processes.class.getName()).log(Level.SEVERE, null, ex);
                close();
            }
        }
    }

    public void executeCommand(String command) {
        String[] message = command.split("\\$", 2);
        byte[] byteArray = null;

        do {
            try {
                if (message[0].equals("<GET>")) {
                    sendRunningProc();
                    break;
                }

                if (message[0].equals("<START-PROCESS>")) {
                    sendStartProc();
                    break;
                }

                if (message[0].equals("<START-PATH>")) {
                    String name = message[1].substring(1, message[1].length() - 1);
                    startProcessByPath(name);
                    break;
                }

                if (message[0].equals("<START-NAME>")) {
                    String name = message[1].substring(1, message[1].length() - 1);
                    startProcessByName(name);
                    break;
                }

                if (message[0].equals("<KILL>")) {
                    int ID = Integer.parseInt(message[1].substring(1, message[1].length() - 1));
                    killProcess(ID);
                    break;
                }
            } catch (NumberFormatException | IOException ex) {
                Logger.getLogger(Processes.class.getName()).log(Level.SEVERE, null, ex);
            }

        } while (false);
    }

    public void close() {
        socketHandler.close();
    }

    // return String data(format "name1 pid1 cpu1 ram1\nname2 pid2 cpu2 ram2\n.." ) and null if throw error
    public void sendRunningProc() {
        List<OSProcess> currentProcesses = null;
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

        currentProcesses = os.getProcesses();

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

        //send data
        socketHandler.send(data.getBytes());
    }

    public void sendStartProc() {
        String data = "";
        for (String name : name_processes) {
            data = data + name + "\n";
        }
        socketHandler.send(data.getBytes());
    }

    // throws IOException
    private void startProcessByPath(String namePro) throws IOException {
        Process process = new ProcessBuilder("powershell", "\"start '" + path_processes.get(name_processes.indexOf(namePro)) + "'").start();
    }

    private void startProcessByName(String namePro) throws IOException {
        Runtime.getRuntime().exec(new String[]{"powershell.exe", "/c", "start", "'" + namePro + "'"});
    }

    private void killProcess(int ID) {
        try {            // TODO: send 
            String cmd = "taskkill /F /PID " + String.valueOf(ID);
            Runtime.getRuntime().exec(cmd);
        } catch (IOException ex) {
            Logger.getLogger(Processes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
