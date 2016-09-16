/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shakki.shakki.logiikka.nappulat;
import shakki.shakki.logiikka.*;
/**
 *
 * @author hasasami
 */
public class Kuningas implements Nappula {
    
    private Pelaaja pelaaja;
    
    public Kuningas(Pelaaja pelaaja) {
        
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
