/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shakki.shakki.kayttoliittyma;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import shakki.shakki.logiikka.*;
import shakki.shakki.logiikka.nappulat.*;

/**
 *
 * @author Sami
 */
public class RuutuNappulanKuuntelija implements ActionListener {

    private Ruutu[][] ruudut;
    private Logiikka logiikka;

    private KayttoliittymaTyokalut tyokalut = new KayttoliittymaTyokalut();
    private Ruutu edellinenPainettuNappula;
    private boolean[][] tamanhetkisetMahdollisetSiirrot;
    
    private Ruutu tamanHetkinenPainettuNappula;

    private JTextField ilmoitusLaatikko;
    private boolean voidaankoLiikkua;

    public RuutuNappulanKuuntelija(Ruutu[][] ruudut, Logiikka logiikka, JTextField ilmoitusLaatikko) {

        this.ruudut = ruudut;
        this.logiikka = logiikka;
        Ruutu edellinenPainettuNappula = null;
        this.ilmoitusLaatikko = ilmoitusLaatikko;
        voidaankoLiikkua = false;

    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        Ruutu nappi = (Ruutu) ae.getSource();
        Nappula[][] pelilauta = logiikka.annaPelilauta();
        tyokalut.paivitaPelilauta(ruudut, pelilauta);
        
        tamanHetkinenPainettuNappula = nappi;

        if (voidaankoLiikkua && tamanhetkisetMahdollisetSiirrot[nappi.getRivi()][nappi.getSarake()]) {

            if (pelilauta[nappi.getRivi()][nappi.getSarake()] != null && edellinenPainettuNappula != null) {

                syoNappula(edellinenPainettuNappula, nappi);
                
                paivitaIlmoitusLaatikonTeksti();
                voidaankoLiikkua = false;

            } else if (pelilauta[nappi.getRivi()][nappi.getSarake()] == null && edellinenPainettuNappula != null) {

                siirraNappulaaRuudulla(nappi);
                
                paivitaIlmoitusLaatikonTeksti();
                voidaankoLiikkua = false;

            }

        } else {

            naytaSiirtymaRuudut(nappi);
            
            
            voidaankoLiikkua = true;

        }

    }

    public void varitaMahdollisetSiirtymaRuudut(boolean[][] siirtymat) {

        for (int i = 0; i <= 7; i++) {

            for (int j = 0; j <= 7; j++) {

                if (siirtymat[i][j]) {

                    ruudut[i][j].setBackground(Color.yellow);

                }

            }
        }

    }

    public void syoNappula(Ruutu syova, Ruutu syotava) {

        logiikka.paivitaValitunNappulanMahdollisetSiirrot(syova.getRivi(), syova.getSarake());
        logiikka.liikutaNappulaa(syova.getRivi(), syova.getSarake(), syotava.getRivi(), syotava.getSarake());

        tyokalut.paivitaPelilauta(ruudut, logiikka.annaPelilauta());
        edellinenPainettuNappula = null;

        paivitaIlmoitusLaatikonTeksti();
    }

    public void naytaSiirtymaRuudut(Ruutu nappi) {

        logiikka.paivitaValitunNappulanMahdollisetSiirrot(nappi.getRivi(), nappi.getSarake());
        boolean[][] mahdollisetSiirtymat = logiikka.naytaValitunNappulanMahdollisetSiirrot();

        tamanhetkisetMahdollisetSiirrot = mahdollisetSiirtymat;
        
        varitaMahdollisetSiirtymaRuudut(mahdollisetSiirtymat);
        edellinenPainettuNappula = nappi;

    }

    public void siirraNappulaaRuudulla(Ruutu nappi) {

        logiikka.paivitaValitunNappulanMahdollisetSiirrot(edellinenPainettuNappula.getRivi(), edellinenPainettuNappula.getSarake());
        boolean[][] mahdollisetSiirtymat = logiikka.naytaValitunNappulanMahdollisetSiirrot();

        if (mahdollisetSiirtymat[nappi.getRivi()][nappi.getSarake()]) {

            logiikka.liikutaNappulaa(edellinenPainettuNappula.getRivi(), edellinenPainettuNappula.getSarake(), nappi.getRivi(), nappi.getSarake());
            edellinenPainettuNappula = null;
            tyokalut.paivitaPelilauta(ruudut, logiikka.annaPelilauta());

        }

    }

    public boolean onkoOikeaPelivuoro(Ruutu nappi) {

        Nappula[][] lauta = logiikka.annaPelilauta();

        if (lauta[nappi.getRivi()][nappi.getSarake()] != null) {

            Nappula nappula = lauta[nappi.getRivi()][nappi.getSarake()];

            if (logiikka.onkoOikeaPeliVuoro(nappula)) {

                return true;

            }

        }

        return false;

    }

    public void paivitaIlmoitusLaatikonTeksti() {

        if (logiikka.paattyikoPeli()) {

            if (logiikka.getPeliVuoro() == 1) {

                ilmoitusLaatikko.setText("Musta voitti!");
                tyokalut.asetaRuudutEpaAktiivisiksi(ruudut);

            } else {

                ilmoitusLaatikko.setText("Valkoinen voitti!");
                tyokalut.asetaRuudutEpaAktiivisiksi(ruudut);

            }

            varitaVoittoRuutu(tamanHetkinenPainettuNappula.getRivi(), tamanHetkinenPainettuNappula.getSarake());

        } else if (logiikka.getPeliVuoro() == 1) {

            ilmoitusLaatikko.setText("Valkoisen vuoro");

        } else {

            ilmoitusLaatikko.setText("Mustan vuoro");

        }

    }

    public void varitaVoittoRuutu(int rivi, int sarake) {

        ruudut[rivi][sarake].setBackground(Color.red);

    }

}
