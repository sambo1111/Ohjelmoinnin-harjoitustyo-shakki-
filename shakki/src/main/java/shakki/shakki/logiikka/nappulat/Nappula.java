package shakki.shakki.logiikka.nappulat;

import shakki.shakki.logiikka.Pelaaja;

/**
 * Rajapina, jonka nappulat toteuttavat.
 */
public interface Nappula {
    
    Pelaaja getPelaaja();
    int getSiirrot();
    
    /**
     * Kasvattaa nappulan siirtojen tähänastista lukumäärää. Tämä metodi on sotilas-nappulaa varten.
     * Sotilas siis saa liikkua alussa kaksi ruutua, jonka jälkeen vain yhden kerrallaan. Tähän siis tarvitaan siirtojen lukumäärän ylläpitämisä.
     */
    void kasvataSiirtojenLkm();
    
}
