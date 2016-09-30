
package shakki.shakki.logiikka.nappulat;
import shakki.shakki.logiikka.*;
/**
 * Nappula-rajapinnan toteuttava luokka.
 */
public class Torni implements Nappula {
    
    private Pelaaja pelaaja;
    
    public Torni(Pelaaja pelaaja) {
        
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
