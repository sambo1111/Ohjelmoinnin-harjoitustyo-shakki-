/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shakki.shakki.logiikka;
import shakki.shakki.logiikka.nappulat.*;
/**
 *
 * @author hasasami
 */
public class Pelilauta {

    private Nappula[][] pelilauta;
    private Pelaaja pelaaja1;
    private Pelaaja pelaaja2;
    private NappulanLiikuttamisLogiikka logiikka;

    public Pelilauta() {

        pelilauta = new Nappula[8][8];
        pelaaja1 = new Pelaaja(1);
        pelaaja2 = new Pelaaja(2);
        logiikka = new NappulanLiikuttamisLogiikka();

    }

    public void alustaPelilauta() {
        
        pelilauta = new Nappula[8][8];
        
        pelilauta[0][0] = new Torni(pelaaja1);
        pelilauta[0][1] = new Hevonen(pelaaja1);
        pelilauta[0][2] = new Lahetti(pelaaja1);
        pelilauta[0][3] = new Kuningatar(pelaaja1);
        pelilauta[0][4] = new Kuningas(pelaaja1);
        pelilauta[0][5] = new Lahetti(pelaaja1);
        pelilauta[0][6] = new Hevonen(pelaaja1);
        pelilauta[0][7] = new Torni(pelaaja1);

        pelilauta[7][0] = new Torni(pelaaja2);
        pelilauta[7][1] = new Hevonen(pelaaja2);
        pelilauta[7][2] = new Lahetti(pelaaja2);
        pelilauta[7][3] = new Kuningatar(pelaaja2);
        pelilauta[7][4] = new Kuningas(pelaaja2);
        pelilauta[7][5] = new Lahetti(pelaaja2);
        pelilauta[7][6] = new Hevonen(pelaaja2);
        pelilauta[7][7] = new Torni(pelaaja2);

        int j = 0;

        for (int i = 0; i <= 7; i++) {

            pelilauta[1][i] = new Sotilas(pelaaja1);
            pelilauta[6][j] = new Sotilas(pelaaja2);

            j++;

        }

    }

    public boolean[][] liikutaNappulaa(int alkuRivi, int alkuSarake, int loppuRivi, int loppuSarake) {

        boolean[][] mahdollisetSiirrot = new boolean[8][8];

        if (alkuRivi <= 7 && alkuRivi >= 0 && alkuSarake <= 7 && alkuSarake >= 0) {

            Nappula liikutettava = pelilauta[alkuRivi][alkuSarake];
            mahdollisetSiirrot = logiikka.naytaMahdollisetSiirrot(pelilauta, liikutettava, alkuRivi, alkuSarake);

            if (loppuRivi <= 7 && loppuRivi >= 0 && loppuSarake <= 7 && loppuSarake >= 0) {

                if (mahdollisetSiirrot[loppuRivi][loppuSarake] == true) {
                    
                    pelilauta[loppuRivi][loppuSarake] = liikutettava;
                    poistaNappula(alkuRivi, alkuSarake);

                }
            }
        }
        return mahdollisetSiirrot;
    }

    public Nappula[][] getPelilauta() {

        return this.pelilauta;
    }
    
    public void poistaNappula(int rivi, int sarake) {
        
        pelilauta[rivi][sarake] = null;
        
    }
    
    public Nappula annaRuudussaOlevaNappula(int rivi, int sarake) {
        
        return pelilauta[rivi][sarake];
        
    }
    
    //Testejä varten oleva metodi
    public void siirraNappulaVapaasti(int alkuRivi, int alkuSarake, int loppuRivi, int loppuSarake) {
        
        Nappula nappula = null;
        
        if (pelilauta[alkuRivi][alkuSarake] != null) {
            
            nappula = pelilauta[alkuRivi][alkuSarake];
            
        }
        
        poistaNappula(alkuRivi, alkuSarake);
        pelilauta[loppuRivi][loppuSarake] = nappula;
        
    }

}
