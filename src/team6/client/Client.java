package team6.client;

import com.formdev.flatlaf.intellijthemes.FlatSpacegrayIJTheme;
import team6.client.gui.*;

public class Client {
    public static void main(String[] args) {
        
        FlatSpacegrayIJTheme.setup();
        
        try {
            HomeGUI homeGUI = new HomeGUI();
            
        } catch (Exception e) {
            System.out.println("App opening is unsuccessful!");
            e.printStackTrace();
        }
    }
}



