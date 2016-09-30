package shakki.shakki.logiikka.nappulat;

import shakki.shakki.logiikka.*;

/**
 * Nappula-rajapinnan toteuttava luokka.
 */
public class Sotilas implements Nappula {

    private Pelaaja pelaaja;
    private int siirrot;

    public Sotilas(Pelaaja pelaaja) {

        this.pelaaja = pelaaja;
        siirrot = 0;

    }

    public Pelaaja getPelaaja() {

        return pelaaja;

    }

    public void kasvataSiirtojenLkm() {

        siirrot++;

    }

    /**
     * Palauttaa sotilaan siirtojen määrän.
     * Siirtojen määrää on pidettävä yllä sotilailla, jotta tiedetään milloin sotilas voi liikkua kaksi ja milloin yksi ruutua.
     * Sotilashan voi liikkua ensimmäisellä siirrollaan kaksi ruutua, muuten yhden.
     *
     * @return sotilaan siirtojen lkm.
     */
    
    public int getSiirrot() {

        return siirrot;
    }

}
