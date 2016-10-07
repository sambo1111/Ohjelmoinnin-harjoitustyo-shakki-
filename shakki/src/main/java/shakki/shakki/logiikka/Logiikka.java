package shakki.shakki.logiikka;

import shakki.shakki.logiikka.nappulat.Nappula;
import shakki.shakki.logiikka.nappulat.*;

/**
 * Luokka yhdistää shakin pelilogiikan, nappuloiden liikuttamislogiikan ja
 * pelilaudan.
 */
public class Logiikka {

    private NappulanLiikuttamisLogiikka nappulanLiikuttamisLogiikka;
    private Pelilauta pelilauta;
    private boolean[][] valitunNappulanMahdollisetSiirrot;
    private int peliVuoro;

    public Logiikka(Pelilauta pelilauta) {

        peliVuoro = 1;
        this.pelilauta = pelilauta;
        nappulanLiikuttamisLogiikka = new NappulanLiikuttamisLogiikka();
        valitunNappulanMahdollisetSiirrot = new boolean[8][8];

    }

    /**
     * Metodi päivittää valitun nappulan mahdolliset siirtymäpaikat laudalla globaaliin boolean-taulukkoon jatkokäyttöä varten.
     *
     * @param rivi siirrettävän nappulan rivi laudalla.
     * @param sarake siirrettävän nappulan sarake laudalla.
     * 
     */
    
    public void paivitaValitunNappulanMahdollisetSiirrot(int rivi, int sarake) {

        valitunNappulanMahdollisetSiirrot = new boolean[8][8];

        if (rivi <= 7 && rivi >= 0 && sarake <= 7 && sarake >= 0) {

            if (haeRuudussaOlevaNappula(rivi, sarake) != null) {

                if (onkoOikeaPeliVuoro(pelilauta.annaRuudussaOlevaNappula(rivi, sarake))) {

                    Nappula valittuNappula = haeRuudussaOlevaNappula(rivi, sarake);
                    valitunNappulanMahdollisetSiirrot = nappulanLiikuttamisLogiikka.naytaMahdollisetSiirrot(pelilauta.getPelilauta(), valittuNappula, rivi, sarake);
                }
            }
        }
    }

    public boolean[][] naytaValitunNappulanMahdollisetSiirrot() {

        return valitunNappulanMahdollisetSiirrot;

    }

    /**
     * Metodi siirtää nappulaa, jos siirto on mahdollinen.
     *
     * @param alkuRivi siirrettävän nappulan tämänhetkinen rivi laudalla.
     * @param alkuSarake siirrettävän nappulan tämänhetkinen sarake laudalla.
     * @param loppuRivi rivi mihin nappula halutaan siirtää.
     * @param loppuSarake sarake mihin nappula halutaan siirtää.
     * 
     * @return boolean-arvo, joka kertoo onnistuiko siirto vai ei.
     */
    
    public boolean liikutaNappulaa(int alkuRivi, int alkuSarake, int loppuRivi, int loppuSarake) {

        paivitaValitunNappulanMahdollisetSiirrot(alkuRivi, alkuSarake);

        if (valitunNappulanMahdollisetSiirrot[loppuRivi][loppuSarake]) {

            pelilauta.annaRuudussaOlevaNappula(alkuRivi, alkuSarake).kasvataSiirtojenLkm();
            pelilauta.siirraNappulaVapaasti(alkuRivi, alkuSarake, loppuRivi, loppuSarake);
            vaihdaPeliVuoroa();
            return true;
        }
        return false;
    }

    /**
     * Metodi kertoo voiko haluttua nappulaa käyttää tällä pelivuorolla.
     * Metodi siis tarkistaa vastaako kyseisen nappulan pelaajan numero tämänhetkisen vuoron numeroa.
     *
     * @param nappula nappula, jota halutaan käyttää
     * 
     * @return boolean-arvo, joka kertoo voidaanko nappulaa käyttää tämänhetkisessä pelitilanteessa.
     */
    
    public boolean onkoOikeaPeliVuoro(Nappula nappula) {

        if (nappula.getPelaaja().getId() == peliVuoro) {

            return true;

        }
        return false;
    }

    /**
     * Metodi vaihtaa pelivuoroa. Esim jos pelivuoro on 1, niin 3 - 1 = 2 eli vaihdetaan pelaajan 2 vuoroon.
     */
    
    public void vaihdaPeliVuoroa() {

        peliVuoro = 3 - peliVuoro;

    }

    public void alustaPelilauta() {

        pelilauta.alustaPelilauta();

    }

    /**
     * Metodi palauttaa Pelilauta-luokan shakkilaudan 2d-taulukkona.
     */
    
    public Nappula[][] annaPelilauta() {

        return pelilauta.getPelilauta();
    }

    /**
     * Metodi tarkistaa ollaanko pelitilanteessa, jossa peli on päättynyt.
     * Metodi siis tarkistaa, onko molemmat kuninkaat laudalla vai ei.
     * Tämä toiminnallisuus ei periaatteessa noudata shakin oikeita sääntöjä, joissa pitäisi tarkistaa shakki ja shakkimatti.
     * 
     * @return boolean-arvo, joka kertoo onko peli päättynyt.
     */
    
    public boolean paattyikoPeli() {

        int kuninkaidenLkmLaudalla = 0;
        Nappula[][] lauta = annaPelilauta();

        for (int i = 0; i <= 7; i++) {

            for (int j = 0; j <= 7; j++) {

                if (lauta[i][j].getClass().equals(Kuningas.class)) {
                    kuninkaidenLkmLaudalla++;
                }
            }
        }

        if (kuninkaidenLkmLaudalla < 2) {
            return true;
        }
        return false;
    }

    public Nappula haeRuudussaOlevaNappula(int rivi, int sarake) {

        return pelilauta.annaRuudussaOlevaNappula(rivi, sarake);

    }

    public void poistaNappula(int rivi, int sarake) {

        pelilauta.poistaNappula(rivi, sarake);
    }

    /**
     * Metodi siirtää nappula-olion tietystä pelilaudan taulukon kohdasta toiseen kohtaan kutsumalla Pelilauta-luokan saman nimistä metodia.
     *
     * @param alkurivi rivi, jossa siirrettävä nappula on tällä hetkellä.
     * @param alkusarake sarake, jossa siirrettävä nappula on tällä hetkellä.
     * @param loppurivi rivi, johon nappula halutaan siirtää.
     * @param loppusarake sarake, johon nappula halutaan siirtää.
     * 
     */
    
    public void siirraNappulaVapaasti(int alkurivi, int alkusarake, int loppurivi, int loppusarake) {

        pelilauta.siirraNappulaVapaasti(alkurivi, alkusarake, loppurivi, loppusarake);

    }
    
    public int getPeliVuoro() {
        
        return peliVuoro;
        
    }

}
