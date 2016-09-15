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
