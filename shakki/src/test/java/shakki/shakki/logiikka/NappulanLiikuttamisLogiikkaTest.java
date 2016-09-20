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
    
    Pelilauta lauta;
    
    public NappulanLiikuttamisLogiikkaTest() {
        
        lauta = new Pelilauta();
    }
    
    @Test
    public void tarkistaOnkoMahdollinenToimiiOikein1() {
        
        lauta.alustaPelilauta();
        
        lauta.poistaNappula(1, 7);
        lauta.poistaNappula(6, 7);
        
        lauta.liikutaNappulaa(7, 7, 3, 7);
        assertEquals(null, lauta.annaRuudussaOlevaNappula(7, 7));
        assertEquals(Torni.class, lauta.annaRuudussaOlevaNappula(3, 7).getClass());
        
        lauta.liikutaNappulaa(0, 7, 4, 7);
        assertEquals(null, lauta.annaRuudussaOlevaNappula(4, 7));
        assertEquals(Torni.class, lauta.annaRuudussaOlevaNappula(0, 7).getClass());
        
    }
    
}
