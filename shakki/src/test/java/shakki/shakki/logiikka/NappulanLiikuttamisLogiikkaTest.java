/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shakki.shakki.logiikka;
import shakki.shakki.logiikka.nappulat.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sami
 */
public class NappulanLiikuttamisLogiikkaTest {
    
    Logiikka logiikka;
    
    public NappulanLiikuttamisLogiikkaTest() {
        
        logiikka = new Logiikka(new Pelilauta());
    }
    
    @Test
    public void tarkistaOnkoMahdollinenToimiiOikein1() {
        
        logiikka.alustaPelilauta();
        
        logiikka.poistaNappula(1, 7);
        logiikka.poistaNappula(6, 7);
        
        logiikka.vaihdaPeliVuoroa();
        
        logiikka.liikutaNappulaa(7, 7, 3, 7);
        assertEquals(null, logiikka.haeRuudussaOlevaNappula(7, 7));
        assertEquals(Torni.class, logiikka.haeRuudussaOlevaNappula(3, 7).getClass());
        
        logiikka.vaihdaPeliVuoroa();
        
        logiikka.liikutaNappulaa(0, 7, 4, 7);
        assertEquals(null, logiikka.haeRuudussaOlevaNappula(4, 7));
        assertEquals(Torni.class, logiikka.haeRuudussaOlevaNappula(0, 7).getClass());
        
    }
}
