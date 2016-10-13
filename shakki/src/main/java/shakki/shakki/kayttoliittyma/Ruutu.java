/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shakki.shakki.kayttoliittyma;
import javax.swing.*;

/**
 *
 * @author Sami
 */
public class Ruutu extends JButton {
    
    private int rivi;
    private int sarake;
    
    public Ruutu(int rivi, int sarake) {
        
        this.rivi = rivi;
        this.sarake = sarake;
        
    }
    
    public int getRivi() {
        
        return rivi;
        
    }
    
    public int getSarake() {
        
        return sarake;
        
    }
    
    

}
