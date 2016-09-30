package shakki.shakki.logiikka.nappulat;

import shakki.shakki.logiikka.Pelaaja;

/**
 * Rajapina, jonka nappulat toteuttavat.
 */
public interface Nappula {
    
    Pelaaja getPelaaja();
    int getSiirrot();
    void kasvataSiirtojenLkm();
    
}
