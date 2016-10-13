/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shakki.shakki.kayttoliittyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import shakki.shakki.logiikka.Logiikka;

/**
 *
 * @author Sami
 */
public class UusiPeliNappulanKuuntelija implements ActionListener {
    
    private Ruutu[][] ruudut;
    private Logiikka logiikka;
    private KayttoliittymaTyokalut tyokalut = new KayttoliittymaTyokalut();
    private JTextField ilmoitusLaatikko;

    public UusiPeliNappulanKuuntelija(Ruutu[][] ruudut, Logiikka logiikka, JTextField ilmoitusLaatikko) {
        
        this.ruudut = ruudut;
        this.logiikka = logiikka;
        this.ilmoitusLaatikko = ilmoitusLaatikko;
        
    }
    
    public void actionPerformed(ActionEvent ae) {
        
        tyokalut.asetaRuudutAktiivisiksi(ruudut);
        logiikka.alustaPelilauta();
        tyokalut.paivitaPelilauta(ruudut, logiikka.annaPelilauta());
        
        ilmoitusLaatikko.setText("Valkoisen vuoro");
        
    }
    
}
