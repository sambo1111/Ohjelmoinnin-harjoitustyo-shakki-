/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shakki.shakki.nappulat;
import shakki.shakki.Nappula;
import shakki.shakki.Pelaaja;
/**
 *
 * @author Sami
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
    
    public int getSiirrot() {
        
        return siirrot;
    }
    
}
