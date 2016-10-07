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
public class NappulanKuuntelija implements ActionListener {

    Ruutu[][] ruudut;
    Logiikka logiikka;

    ImageIcon sotilasValkoinen = new ImageIcon("src/main/resources/images/sotilas_valkoinen.png");
    ImageIcon sotilasMusta = new ImageIcon("src/main/resources/images/sotilas_musta.png");

    ImageIcon hevonenValkoinen = new ImageIcon("src/main/resources/images/hevonen_valkoinen.png");
    ImageIcon hevonenMusta = new ImageIcon("src/main/resources/images/hevonen_musta.png");

    ImageIcon torniValkoinen = new ImageIcon("src/main/resources/images/torni_valkoinen.png");
    ImageIcon torniMusta = new ImageIcon("src/main/resources/images/torni_musta.png");

    ImageIcon kuningasValkoinen = new ImageIcon("src/main/resources/images/kuningas_valkoinen.png");
    ImageIcon kuningasMusta = new ImageIcon("src/main/resources/images/kuningas_musta.png");

    ImageIcon kuningatarValkoinen = new ImageIcon("src/main/resources/images/kuningatar_valkoinen.png");
    ImageIcon kuningatarMusta = new ImageIcon("src/main/resources/images/kuningatar_musta.png");

    ImageIcon lahettiValkoinen = new ImageIcon("src/main/resources/images/lahetti_valkoinen.png");
    ImageIcon lahettiMusta = new ImageIcon("src/main/resources/images/lahetti_musta.png");

    Ruutu edellinenPainettuNappula;

    public NappulanKuuntelija(Ruutu[][] ruudut, Logiikka logiikka) {

        this.ruudut = ruudut;
        this.logiikka = logiikka;
        Ruutu edellinenPainettuNappula = null;

    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        paivitaPelilauta();
        Ruutu nappi = (Ruutu) ae.getSource();
        Nappula[][] pelilauta = logiikka.annaPelilauta();

        if (pelilauta[nappi.getRivi()][nappi.getSarake()] != null && edellinenPainettuNappula != null) {

            syoNappula(edellinenPainettuNappula, nappi);

        } else if (pelilauta[nappi.getRivi()][nappi.getSarake()] != null) {

            logiikka.paivitaValitunNappulanMahdollisetSiirrot(nappi.getRivi(), nappi.getSarake());
            boolean[][] mahdollisetSiirtymat = logiikka.naytaValitunNappulanMahdollisetSiirrot();

            varitaMahdollisetSiirtymaRuudut(mahdollisetSiirtymat);
            edellinenPainettuNappula = nappi;

        } else if (pelilauta[nappi.getRivi()][nappi.getSarake()] == null && edellinenPainettuNappula != null) {

            logiikka.paivitaValitunNappulanMahdollisetSiirrot(edellinenPainettuNappula.getRivi(), edellinenPainettuNappula.getSarake());
            boolean[][] mahdollisetSiirtymat = logiikka.naytaValitunNappulanMahdollisetSiirrot();

            if (mahdollisetSiirtymat[nappi.getRivi()][nappi.getSarake()]) {

                logiikka.liikutaNappulaa(edellinenPainettuNappula.getRivi(), edellinenPainettuNappula.getSarake(), nappi.getRivi(), nappi.getSarake());
                edellinenPainettuNappula = null;
                paivitaPelilauta();

            }

        }
    }

    public void paivitaPelilauta() {

        varitaRuudut();

        Nappula[][] nappulat = logiikka.annaPelilauta();

        for (int i = 0; i <= 7; i++) {

            for (int j = 0; j <= 7; j++) {

                if (nappulat[i][j] != null) {

                    Nappula nappula = nappulat[i][j];

                    if (nappula.getClass().equals(Sotilas.class)) {

                        if (nappula.getPelaaja().getId() == 1) {

                            ruudut[i][j].setIcon(sotilasValkoinen);

                        } else {

                            ruudut[i][j].setIcon(sotilasMusta);

                        }

                    } else if (nappula.getClass().equals(Torni.class)) {

                        if (nappula.getPelaaja().getId() == 1) {

                            ruudut[i][j].setIcon(torniValkoinen);

                        } else {

                            ruudut[i][j].setIcon(torniMusta);

                        }

                    } else if (nappula.getClass().equals(Lahetti.class)) {

                        if (nappula.getPelaaja().getId() == 1) {

                            ruudut[i][j].setIcon(lahettiValkoinen);

                        } else {

                            ruudut[i][j].setIcon(lahettiMusta);

                        }

                    } else if (nappula.getClass().equals(Hevonen.class)) {

                        if (nappula.getPelaaja().getId() == 1) {

                            ruudut[i][j].setIcon(hevonenValkoinen);

                        } else {

                            ruudut[i][j].setIcon(hevonenMusta);

                        }

                    } else if (nappula.getClass().equals(Kuningas.class)) {

                        if (nappula.getPelaaja().getId() == 1) {

                            ruudut[i][j].setIcon(kuningasValkoinen);

                        } else {

                            ruudut[i][j].setIcon(kuningasMusta);

                        }

                    } else if (nappula.getClass().equals(Kuningatar.class)) {

                        if (nappula.getPelaaja().getId() == 1) {

                            ruudut[i][j].setIcon(kuningatarValkoinen);

                        } else {

                            ruudut[i][j].setIcon(kuningatarMusta);

                        }

                    }
                }
            }

        }

    }

    public void varitaRuudut() {

        int ruudunVaritys = 1;

        for (int i = 0; i <= 7; i++) {

            for (int j = 0; j <= 7; j++) {

                ruudut[i][j].setIcon(null);

                if (ruudunVaritys == 1) {

                    ruudut[i][j].setBackground(Color.white);

                } else {

                    ruudut[i][j].setBackground(Color.darkGray);

                }

                ruudunVaritys = 3 - ruudunVaritys;

            }

            ruudunVaritys = 3 - ruudunVaritys;
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

        paivitaPelilauta();
        edellinenPainettuNappula = null;

    }

    public boolean painettiinkoSamaaNappulaaUudestaan(Ruutu edellinen, Ruutu nykyinen) {

        if (edellinen != null && nykyinen != null) {

            if ((edellinen.getRivi() == nykyinen.getRivi()) && (edellinen.getSarake() == nykyinen.getSarake())) {

                return true;

            }
        }

        return false;

    }

}
