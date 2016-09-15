/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import shakki.shakki.*;
import shakki.shakki.nappulat.*;

/**
 *
 * @author Sami
 */
public class PelilautaTest {
    
    Pelilauta lauta;
    
    public PelilautaTest() {
        
        lauta = new Pelilauta();
        
    }
    
    @Test
    public void pelilautaAlustetaanOikein() {
        
        lauta.alustaPelilauta();

        //Pelaaja 1
        assertEquals(Torni.class, lauta.annaRuudussaOlevaNappula(0, 0).getClass());
        assertEquals(Hevonen.class, lauta.annaRuudussaOlevaNappula(0, 1).getClass());
        assertEquals(Lahetti.class, lauta.annaRuudussaOlevaNappula(0, 2).getClass());
        assertEquals(Kuningatar.class, lauta.annaRuudussaOlevaNappula(0, 3).getClass());
        assertEquals(Kuningas.class, lauta.annaRuudussaOlevaNappula(0, 4).getClass());
        assertEquals(Lahetti.class, lauta.annaRuudussaOlevaNappula(0, 5).getClass());
        assertEquals(Hevonen.class, lauta.annaRuudussaOlevaNappula(0, 6).getClass());
        assertEquals(Torni.class, lauta.annaRuudussaOlevaNappula(0, 7).getClass());
        
        for (int i = 0; i <= 7; i++) {
            
            assertEquals(Sotilas.class, lauta.annaRuudussaOlevaNappula(1, i).getClass());
            
        }
        
        //Pelaaja 2
        assertEquals(Torni.class, lauta.annaRuudussaOlevaNappula(7, 0).getClass());
        assertEquals(Hevonen.class, lauta.annaRuudussaOlevaNappula(7, 1).getClass());
        assertEquals(Lahetti.class, lauta.annaRuudussaOlevaNappula(7, 2).getClass());
        assertEquals(Kuningatar.class, lauta.annaRuudussaOlevaNappula(7, 3).getClass());
        assertEquals(Kuningas.class, lauta.annaRuudussaOlevaNappula(7, 4).getClass());
        assertEquals(Lahetti.class, lauta.annaRuudussaOlevaNappula(7, 5).getClass());
        assertEquals(Hevonen.class, lauta.annaRuudussaOlevaNappula(7, 6).getClass());
        assertEquals(Torni.class, lauta.annaRuudussaOlevaNappula(7, 7).getClass());
        
        for (int i = 0; i <= 7; i++) {
            
            assertEquals(Sotilas.class, lauta.annaRuudussaOlevaNappula(6, i).getClass());
            
        }
        
    }
    
    @Test
    public void sotilasVoiLiikkuaAlussaKaksiRuutuaEteenpain() {
        
        lauta.alustaPelilauta();
        
        //Pelaaja 1: sotilas
        lauta.liikutaNappulaa(1, 1, 3, 1);
        
        assertEquals(null, lauta.annaRuudussaOlevaNappula(1, 1));
        assertEquals(Sotilas.class, lauta.annaRuudussaOlevaNappula(3, 1).getClass());
        
        //Pelaaja 2: sotilas
        lauta.liikutaNappulaa(6, 4, 4, 4);
        
        assertEquals(null, lauta.annaRuudussaOlevaNappula(6, 4));
        assertEquals(Sotilas.class, lauta.annaRuudussaOlevaNappula(4, 4).getClass());
        
    }
    
    @Test
    public void sotilasEiVoiLiikkuaKahtaRuutuaEteenpainEnsimmaisenSiirronJalkeen() {
        
        lauta.alustaPelilauta();
        
        //Pelaaja 1: sotilas
        lauta.liikutaNappulaa(1, 1, 3, 1);
        
        lauta.liikutaNappulaa(3, 1, 5, 1);
        
        assertEquals(Sotilas.class, lauta.annaRuudussaOlevaNappula(3, 1).getClass());
        assertEquals(null, lauta.annaRuudussaOlevaNappula(5, 1));
        
        //Pelaaja 2: sotilas
        lauta.liikutaNappulaa(6, 3, 4, 3);
        
        lauta.liikutaNappulaa(4, 3, 2, 3);
        
        assertEquals(Sotilas.class, lauta.annaRuudussaOlevaNappula(4, 3).getClass());
        assertEquals(null, lauta.annaRuudussaOlevaNappula(2, 3));
        
    }
    
    @Test
    public void sotilasSyoOikein() {
        
        lauta.alustaPelilauta();
        
        lauta.liikutaNappulaa(1, 1, 3, 1);
        lauta.liikutaNappulaa(6, 1, 4, 1);
        
        lauta.liikutaNappulaa(3, 1, 4, 1);
        lauta.liikutaNappulaa(4, 1, 5, 1);
        
        assertEquals(null, lauta.annaRuudussaOlevaNappula(4, 1));
        assertEquals(null, lauta.annaRuudussaOlevaNappula(3, 1));
        
        assertEquals(Sotilas.class, lauta.annaRuudussaOlevaNappula(5, 1).getClass());
        assertEquals(1, lauta.annaRuudussaOlevaNappula(5, 1).getPelaaja().getId());  
        
    }
    
    @Test
    public void sotilasLiikkuuOikeinEteenpain() {
        
        lauta.alustaPelilauta();
        
        //Pelaaja 1
        //Ei voi liikkua liikaa
        lauta.liikutaNappulaa(1, 3, 5, 3);
        assertEquals(null, lauta.annaRuudussaOlevaNappula(5, 3));
        assertEquals(Sotilas.class, lauta.annaRuudussaOlevaNappula(1, 3).getClass());
        
        //Pelaaja 1
        //Ei voi liikkua liikaa
        lauta.liikutaNappulaa(6, 1, 2, 1);
        assertEquals(null, lauta.annaRuudussaOlevaNappula(2, 1));
        assertEquals(Sotilas.class, lauta.annaRuudussaOlevaNappula(6, 1).getClass());
        
    }
    
    @Test
    public void sotilasLiikkuuOikeinSivuille1() {
        
        lauta.alustaPelilauta();
        
        //Pelaaja 1
        //Ei voi liikkua sivulle jos vieressä oma nappula
        Nappula nappula = lauta.annaRuudussaOlevaNappula(1, 1);
        lauta.liikutaNappulaa(1, 1, 1, 2);
        assertEquals(Sotilas.class, lauta.annaRuudussaOlevaNappula(1, 1).getClass());
        assertEquals(Sotilas.class, lauta.annaRuudussaOlevaNappula(1, 2).getClass());
        assertEquals(nappula, lauta.annaRuudussaOlevaNappula(1, 1));
        
        //Pelaaja 1
        //Ei voi liikkua sivulle jos vieressä oma nappula
        Nappula nappula2 = lauta.annaRuudussaOlevaNappula(6, 1);
        lauta.liikutaNappulaa(6, 1, 6, 0);
        assertEquals(Sotilas.class, lauta.annaRuudussaOlevaNappula(6, 1).getClass());
        assertEquals(Sotilas.class, lauta.annaRuudussaOlevaNappula(6, 0).getClass());
        assertEquals(nappula2, lauta.annaRuudussaOlevaNappula(6, 1));
        
    }
    
    @Test
    public void sotilasLiikkuuOikeinSivuille2() {
        
        //Pelaaja 1
        lauta.alustaPelilauta();
        
        //Oikea
        lauta.liikutaNappulaa(1, 3, 3, 3);
        lauta.liikutaNappulaa(3, 3, 3, 4);
        
        assertEquals(Sotilas.class, lauta.annaRuudussaOlevaNappula(3, 4).getClass());
        assertEquals(null, lauta.annaRuudussaOlevaNappula(1, 3));
        assertEquals(null, lauta.annaRuudussaOlevaNappula(3, 3));
        
        //Vasen
        lauta.liikutaNappulaa(3, 4, 3, 3);
        assertEquals(Sotilas.class, lauta.annaRuudussaOlevaNappula(3, 3).getClass());
        assertEquals(null, lauta.annaRuudussaOlevaNappula(3, 4));
        
        //Pelaaja 2
        //Oikea
        lauta.liikutaNappulaa(6, 6, 4, 6);
        lauta.liikutaNappulaa(4, 6, 4, 7);
        
        assertEquals(Sotilas.class, lauta.annaRuudussaOlevaNappula(4, 7).getClass());
        assertEquals(null, lauta.annaRuudussaOlevaNappula(6, 6));
        assertEquals(null, lauta.annaRuudussaOlevaNappula(4, 6));
        
        //Vasen
        lauta.liikutaNappulaa(4, 7, 4, 6);
        assertEquals(Sotilas.class, lauta.annaRuudussaOlevaNappula(4, 6).getClass());
        assertEquals(null, lauta.annaRuudussaOlevaNappula(4, 7));
        
    }
    
    @Test
    public void torniLiikkuuOikeinAlasJaYlos() {
        
        lauta.alustaPelilauta();
        
        //Pelaaja 1
        lauta.siirraNappulaVapaasti(1, 0, 4, 0);
        
        lauta.liikutaNappulaa(0, 0, 3, 0);
        
        assertEquals(Torni.class, lauta.annaRuudussaOlevaNappula(3, 0).getClass());
        assertEquals(null, lauta.annaRuudussaOlevaNappula(0, 0));
        
        //Pelaaja 2
        lauta.siirraNappulaVapaasti(6, 7, 3, 7);
        
        lauta.liikutaNappulaa(7, 7, 4, 7);
        
        assertEquals(Torni.class, lauta.annaRuudussaOlevaNappula(4, 7).getClass());
        assertEquals(null, lauta.annaRuudussaOlevaNappula(7, 7));
        
    }
    
    @Test
    public void torniEiLiikuOmienNappuloidenYliEteenpainMentaessa() {
        
        lauta.alustaPelilauta();
        
        //Pelaaja 1
        lauta.siirraNappulaVapaasti(1, 0, 3, 0);
        
        lauta.liikutaNappulaa(0, 0, 4, 0);
        
        assertEquals(null, lauta.annaRuudussaOlevaNappula(4, 0));
        assertEquals(Torni.class, lauta.annaRuudussaOlevaNappula(0, 0).getClass());
        assertEquals(Sotilas.class, lauta.annaRuudussaOlevaNappula(3, 0).getClass());
        
        
        //Pelaaja 2
        lauta.siirraNappulaVapaasti(6, 7, 4, 7);
        
        lauta.liikutaNappulaa(7, 7, 3, 7);
        
        assertEquals(null, lauta.annaRuudussaOlevaNappula(3, 7));
        assertEquals(Torni.class, lauta.annaRuudussaOlevaNappula(7, 7).getClass());
        assertEquals(Sotilas.class, lauta.annaRuudussaOlevaNappula(4, 7).getClass());
        
    }
    
    @Test
    public void torniLiikkuuOikeinSivuille() {
        
        lauta.alustaPelilauta();
        
        //Pelaaja 1
        lauta.poistaNappula(1, 7);
        
        lauta.liikutaNappulaa(0, 7, 3, 7);
        lauta.liikutaNappulaa(3, 7, 3, 3);
        
        assertEquals(Torni.class, lauta.annaRuudussaOlevaNappula(3, 3).getClass());
        assertEquals(null, lauta.annaRuudussaOlevaNappula(0, 7));
        assertEquals(null, lauta.annaRuudussaOlevaNappula(3, 7));
        
        //Pelaaja 2
        lauta.poistaNappula(6, 0);
        
        lauta.liikutaNappulaa(7, 0, 4, 0);
        lauta.liikutaNappulaa(4, 0, 4, 4);
        
        assertEquals(Torni.class, lauta.annaRuudussaOlevaNappula(4, 4).getClass());
        assertEquals(null, lauta.annaRuudussaOlevaNappula(7, 0));
        assertEquals(null, lauta.annaRuudussaOlevaNappula(4, 0));
        
    }
    
}
