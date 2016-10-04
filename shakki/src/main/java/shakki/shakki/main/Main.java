package shakki.shakki.main;
import shakki.shakki.logiikka.*;
import shakki.shakki.kayttoliittyma.*;
import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        
        Kayttoliittyma l = new Kayttoliittyma();
        SwingUtilities.invokeLater(l);
        
    }
    
}
