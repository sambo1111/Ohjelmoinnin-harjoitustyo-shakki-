
package shakki.shakki.logiikka;
import shakki.shakki.logiikka.nappulat.*;
/**
 * Luokka sisältää tiedon pelaajan numerosta, mikä liitetään nappuloihin.
 */
public class Pelaaja {
    
    private int pelaajaId;
    
    public Pelaaja(int id) {
        
        pelaajaId = id;
        
    }
    
    public int getId() {
        
        return pelaajaId;
        
    }
    
}
