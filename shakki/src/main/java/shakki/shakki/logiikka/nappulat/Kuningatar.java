
package shakki.shakki.logiikka.nappulat;
import shakki.shakki.logiikka.*;
/**
 * Nappula-rajapinnan toteuttava luokka.
 */
public class Kuningatar implements Nappula {
    
    private Pelaaja pelaaja;
    
    public Kuningatar(Pelaaja pelaaja) {
        
        this.pelaaja = pelaaja;
        
    }
    
    public Pelaaja getPelaaja() {
        
        return pelaaja;
        
    }
    
    public int getSiirrot() {
        
        return 10;
    }
    
    public void kasvataSiirtojenLkm(){
        
    }
    
}
