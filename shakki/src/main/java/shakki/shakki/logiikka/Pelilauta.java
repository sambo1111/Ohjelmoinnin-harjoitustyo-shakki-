package shakki.shakki.logiikka;

import shakki.shakki.logiikka.nappulat.Nappula;
import shakki.shakki.logiikka.nappulat.*;

/**
 * Sisältää tiedon pelilaudan tilasta sekä tarjoaa metodit ruutujen
 * päivittämiseen ja nappuloiden poistamiseen.
 */
public class Pelilauta {

    private Nappula[][] pelilauta;
    private NappulanLiikuttamisLogiikka logiikka;

    public Pelilauta() {

        pelilauta = new Nappula[8][8];
        logiikka = new NappulanLiikuttamisLogiikka();

    }

    /**
     * Metodi alustaa pelilaudan eli lisää nappulat niiden aloituspaikoilleen.
     */
    public void alustaPelilauta() {

        Pelaaja pelaaja1 = new Pelaaja(1);
        Pelaaja pelaaja2 = new Pelaaja(2);

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

    public Nappula[][] getPelilauta() {

        return this.pelilauta;
    }

    public void poistaNappula(int rivi, int sarake) {

        pelilauta[rivi][sarake] = null;

    }

    public Nappula annaRuudussaOlevaNappula(int rivi, int sarake) {

        return pelilauta[rivi][sarake];

    }

    /**
     * Metodi siirtää nappulan pelilaudalla paikasta toiseen. Ei sisällä siirron
     * validoimiseen liittyvää logiikkaa.
     *
     * @param alkuRivi nappulan tämänhetkinen rivi laudalla.
     * @param alkuSarake nappulan tämänhetkinen sarake laudalla.
     * @param loppuRivi rivi johon nappula halutaan siirtää.
     * @param loppuSarake sarake johon nappula halutaan siirtää.
     */
    public void siirraNappulaVapaasti(int alkuRivi, int alkuSarake, int loppuRivi, int loppuSarake) {

        Nappula nappula = null;

        if (pelilauta[alkuRivi][alkuSarake] != null) {

            nappula = pelilauta[alkuRivi][alkuSarake];
            poistaNappula(alkuRivi, alkuSarake);
            pelilauta[loppuRivi][loppuSarake] = nappula;

        }

    }

}
