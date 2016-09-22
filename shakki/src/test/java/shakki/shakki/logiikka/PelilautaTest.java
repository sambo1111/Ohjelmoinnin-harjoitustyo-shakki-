package shakki.shakki.logiikka;

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
import shakki.shakki.logiikka.*;
import shakki.shakki.logiikka.nappulat.*;

/**
 *
 * @author hasasami
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
    
    @Test
    public void lahettiLiikkuuOikein1() {
        
        lauta.alustaPelilauta();
        
        lauta.poistaNappula(1, 1);
        lauta.poistaNappula(1, 3);
        
        lauta.liikutaNappulaa(0, 2, 2, 0);
        assertEquals(null, lauta.annaRuudussaOlevaNappula(0, 2));
        assertEquals(Lahetti.class, lauta.annaRuudussaOlevaNappula(2, 0).getClass());
        
        lauta.liikutaNappulaa(2, 0, 4, 2);
        assertEquals(null, lauta.annaRuudussaOlevaNappula(2, 0));
        assertEquals(Lahetti.class, lauta.annaRuudussaOlevaNappula(4, 2).getClass());
        
        lauta.liikutaNappulaa(4, 2, 2, 4);
        assertEquals(null, lauta.annaRuudussaOlevaNappula(4, 2));
        assertEquals(Lahetti.class, lauta.annaRuudussaOlevaNappula(2, 4).getClass());
        
        lauta.liikutaNappulaa(2, 4, 0, 2);
        assertEquals(null, lauta.annaRuudussaOlevaNappula(2, 4));
        assertEquals(Lahetti.class, lauta.annaRuudussaOlevaNappula(0, 2).getClass());
        
    }
    
    @Test
    public void lahettiLiikkuuOikein2() {
        
        lauta.alustaPelilauta();
        
        lauta.siirraNappulaVapaasti(0, 2, 3, 4);
        assertEquals(null, lauta.annaRuudussaOlevaNappula(0, 2));
        assertEquals(Lahetti.class, lauta.annaRuudussaOlevaNappula(3, 4).getClass());
        
        lauta.liikutaNappulaa(3, 4, 3, 6);
        assertEquals(null, lauta.annaRuudussaOlevaNappula(3, 6));
        assertEquals(Lahetti.class, lauta.annaRuudussaOlevaNappula(3, 4).getClass());
        
        lauta.liikutaNappulaa(3, 4, 3, 3);
        assertEquals(null, lauta.annaRuudussaOlevaNappula(3, 3));
        assertEquals(Lahetti.class, lauta.annaRuudussaOlevaNappula(3, 4).getClass());
        
        lauta.liikutaNappulaa(3, 4, 5, 4);
        assertEquals(null, lauta.annaRuudussaOlevaNappula(5, 4));
        assertEquals(Lahetti.class, lauta.annaRuudussaOlevaNappula(3, 4).getClass());
        
        lauta.liikutaNappulaa(3, 4, 2, 4);
        assertEquals(null, lauta.annaRuudussaOlevaNappula(2, 4));
        assertEquals(Lahetti.class, lauta.annaRuudussaOlevaNappula(3, 4).getClass());
        
    }
    
    @Test
    public void lahettiEiLiikuNappuloidenYli() {
        
        lauta.alustaPelilauta();
        
        lauta.liikutaNappulaa(0, 2, 2, 0);
        assertEquals(null, lauta.annaRuudussaOlevaNappula(2, 0));
        assertEquals(Lahetti.class, lauta.annaRuudussaOlevaNappula(0, 2).getClass());
        
        lauta.liikutaNappulaa(0, 2, 2, 4);
        assertEquals(null, lauta.annaRuudussaOlevaNappula(2, 4));
        assertEquals(Lahetti.class, lauta.annaRuudussaOlevaNappula(0, 2).getClass());
        
        lauta.liikutaNappulaa(7, 5, 4, 2);
        assertEquals(null, lauta.annaRuudussaOlevaNappula(4, 2));
        assertEquals(Lahetti.class, lauta.annaRuudussaOlevaNappula(7, 5).getClass());
        
        lauta.liikutaNappulaa(7, 5, 5, 7);
        assertEquals(null, lauta.annaRuudussaOlevaNappula(5, 7));
        assertEquals(Lahetti.class, lauta.annaRuudussaOlevaNappula(7, 5).getClass());
        
        
    }
    
    @Test
    public void kuningatarLiikkuuOikein1() {
        
        lauta.alustaPelilauta();
        lauta.poistaNappula(1, 4);
        lauta.poistaNappula(1, 3);
        lauta.poistaNappula(1, 2);
        
        lauta.liikutaNappulaa(0, 3, 3, 6);
        assertEquals(null, lauta.annaRuudussaOlevaNappula(0, 3));
        assertEquals(Kuningatar.class, lauta.annaRuudussaOlevaNappula(3, 6).getClass());
        
        lauta.liikutaNappulaa(3, 6, 3, 0);
        assertEquals(null, lauta.annaRuudussaOlevaNappula(3, 6));
        assertEquals(Kuningatar.class, lauta.annaRuudussaOlevaNappula(3, 0).getClass());
        
        lauta.liikutaNappulaa(3, 0, 0, 3);
        assertEquals(null, lauta.annaRuudussaOlevaNappula(3, 0));
        assertEquals(Kuningatar.class, lauta.annaRuudussaOlevaNappula(0, 3).getClass());
        
        lauta.liikutaNappulaa(0, 3, 5, 5);
        assertEquals(null, lauta.annaRuudussaOlevaNappula(5, 5));
        assertEquals(Kuningatar.class, lauta.annaRuudussaOlevaNappula(0, 3).getClass());
        
    }
    
    @Test
    public void kuningatarLiikkuuOikein2() {
        
        lauta.alustaPelilauta();
        lauta.poistaNappula(6, 2);
        lauta.poistaNappula(6, 3);
        lauta.poistaNappula(6, 4);
        
        lauta.liikutaNappulaa(7, 3, 5, 1);
        assertEquals(null, lauta.annaRuudussaOlevaNappula(7, 3));
        assertEquals(Kuningatar.class, lauta.annaRuudussaOlevaNappula(5, 1).getClass());
        
        lauta.liikutaNappulaa(5, 1, 2, 1);
        assertEquals(null, lauta.annaRuudussaOlevaNappula(5, 1));
        assertEquals(Kuningatar.class, lauta.annaRuudussaOlevaNappula(2, 1).getClass());
        
        lauta.liikutaNappulaa(2, 1, 2, 7);
        assertEquals(null, lauta.annaRuudussaOlevaNappula(2, 1));
        assertEquals(Kuningatar.class, lauta.annaRuudussaOlevaNappula(2, 7).getClass());
        
        lauta.liikutaNappulaa(2, 7, 3, 7);
        assertEquals(null, lauta.annaRuudussaOlevaNappula(2, 7));
        assertEquals(Kuningatar.class, lauta.annaRuudussaOlevaNappula(3, 7).getClass());
        
        lauta.liikutaNappulaa(3, 7, 7, 3);
        assertEquals(null, lauta.annaRuudussaOlevaNappula(3, 7));
        assertEquals(Kuningatar.class, lauta.annaRuudussaOlevaNappula(7, 3).getClass());
        
        lauta.liikutaNappulaa(7, 3, 3, 5);
        assertEquals(null, lauta.annaRuudussaOlevaNappula(3, 5));
        assertEquals(Kuningatar.class, lauta.annaRuudussaOlevaNappula(7, 3).getClass());
    }
    
    @Test
    public void kuningatarLiikkuuOikein3() {
        
        lauta.alustaPelilauta();
        lauta.poistaNappula(6, 2);
        lauta.poistaNappula(6, 3);
        lauta.poistaNappula(6, 4);
        
        lauta.liikutaNappulaa(7, 3, 5, 1);
        assertEquals(null, lauta.annaRuudussaOlevaNappula(7, 3));
        assertEquals(Kuningatar.class, lauta.annaRuudussaOlevaNappula(5, 1).getClass());
        
        lauta.liikutaNappulaa(5, 1, 3, 2);
        assertEquals(null, lauta.annaRuudussaOlevaNappula(3, 2));
        assertEquals(Kuningatar.class, lauta.annaRuudussaOlevaNappula(5, 1).getClass());
        
        lauta.liikutaNappulaa(5, 1, 3, 4);
        assertEquals(null, lauta.annaRuudussaOlevaNappula(3, 4));
        assertEquals(Kuningatar.class, lauta.annaRuudussaOlevaNappula(5, 1).getClass());
        
        lauta.liikutaNappulaa(5, 1, 7, 5);
        assertEquals(Lahetti.class, lauta.annaRuudussaOlevaNappula(7, 5).getClass());
        assertEquals(Kuningatar.class, lauta.annaRuudussaOlevaNappula(5, 1).getClass());
        
    }
    
    @Test
    public void kuningasLiikkuuOikein1() {
        
        lauta.alustaPelilauta();
        
        lauta.siirraNappulaVapaasti(7, 4, 3, 4);
        
        lauta.liikutaNappulaa(3, 4, 2, 3);
        
        assertEquals(null, lauta.annaRuudussaOlevaNappula(3, 4));
        assertEquals(Kuningas.class, lauta.annaRuudussaOlevaNappula(2, 3).getClass());
        
        lauta.liikutaNappulaa(2, 3, 2, 4);
        
        assertEquals(null, lauta.annaRuudussaOlevaNappula(2, 3));
        assertEquals(Kuningas.class, lauta.annaRuudussaOlevaNappula(2, 4).getClass());
        
        lauta.liikutaNappulaa(2, 4, 3, 5);
        
        assertEquals(null, lauta.annaRuudussaOlevaNappula(2, 4));
        assertEquals(Kuningas.class, lauta.annaRuudussaOlevaNappula(3, 5).getClass());
        
        lauta.liikutaNappulaa(3, 5, 4, 5);
        
        assertEquals(null, lauta.annaRuudussaOlevaNappula(3, 5));
        assertEquals(Kuningas.class, lauta.annaRuudussaOlevaNappula(4, 5).getClass());
        
        lauta.liikutaNappulaa(4, 5, 4, 4);
        
        assertEquals(null, lauta.annaRuudussaOlevaNappula(4, 5));
        assertEquals(Kuningas.class, lauta.annaRuudussaOlevaNappula(4, 4).getClass());
        
        lauta.liikutaNappulaa(4, 4, 3, 4);
        
        assertEquals(null, lauta.annaRuudussaOlevaNappula(4, 4));
        assertEquals(Kuningas.class, lauta.annaRuudussaOlevaNappula(3, 4).getClass());
        
        lauta.liikutaNappulaa(3, 4, 3, 5);
        
        assertEquals(null, lauta.annaRuudussaOlevaNappula(3, 4));
        assertEquals(Kuningas.class, lauta.annaRuudussaOlevaNappula(3, 5).getClass());
        
        lauta.liikutaNappulaa(3, 5, 3, 4);
        
        assertEquals(null, lauta.annaRuudussaOlevaNappula(3, 5));
        assertEquals(Kuningas.class, lauta.annaRuudussaOlevaNappula(3, 4).getClass());
        
    }
    
    @Test
    public void kuningasLiikkuuOikein2() {
        
        lauta.alustaPelilauta();
        lauta.poistaNappula(1, 3);
        lauta.poistaNappula(1, 4);
        lauta.poistaNappula(1, 5);
        
        lauta.liikutaNappulaa(0, 4, 2, 6);
        assertEquals(null, lauta.annaRuudussaOlevaNappula(2, 6));
        assertEquals(Kuningas.class, lauta.annaRuudussaOlevaNappula(0, 4).getClass());
        
        lauta.liikutaNappulaa(0, 4, 3, 4);
        assertEquals(null, lauta.annaRuudussaOlevaNappula(3, 4));
        assertEquals(Kuningas.class, lauta.annaRuudussaOlevaNappula(0, 4).getClass());
        
        lauta.liikutaNappulaa(0, 4, 4, 3);
        assertEquals(null, lauta.annaRuudussaOlevaNappula(4, 3));
        assertEquals(Kuningas.class, lauta.annaRuudussaOlevaNappula(0, 4).getClass());
        
    }
    
    @Test
    public void hevonenLiikkuuOikein1() {
        
        lauta.alustaPelilauta();
        
        lauta.liikutaNappulaa(7, 6, 5, 7);
        assertEquals(null, lauta.annaRuudussaOlevaNappula(6, 7));
        assertEquals(Hevonen.class, lauta.annaRuudussaOlevaNappula(5, 7).getClass());
        
        lauta.liikutaNappulaa(5, 7, 4, 5);
        assertEquals(null, lauta.annaRuudussaOlevaNappula(5, 7));
        assertEquals(Hevonen.class, lauta.annaRuudussaOlevaNappula(4, 5).getClass());
        
        lauta.liikutaNappulaa(7, 1, 5, 0);
        assertEquals(null, lauta.annaRuudussaOlevaNappula(7, 1));
        assertEquals(Hevonen.class, lauta.annaRuudussaOlevaNappula(5, 0).getClass());
        
        lauta.liikutaNappulaa(5, 0, 4, 2);
        assertEquals(null, lauta.annaRuudussaOlevaNappula(5, 0));
        assertEquals(Hevonen.class, lauta.annaRuudussaOlevaNappula(4, 2).getClass());
        
    }
    
    @Test
    public void hevonenLiikkuuOikein2() {
        
        lauta.alustaPelilauta();
        
        lauta.liikutaNappulaa(0, 1, 2, 0);
        assertEquals(null, lauta.annaRuudussaOlevaNappula(0, 1));
        assertEquals(Hevonen.class, lauta.annaRuudussaOlevaNappula(2, 0).getClass());
        
        lauta.liikutaNappulaa(2, 0, 3, 2);
        assertEquals(null, lauta.annaRuudussaOlevaNappula(2, 0));
        assertEquals(Hevonen.class, lauta.annaRuudussaOlevaNappula(3, 2).getClass());
        
        lauta.liikutaNappulaa(0, 6, 2, 7);
        assertEquals(null, lauta.annaRuudussaOlevaNappula(0, 6));
        assertEquals(Hevonen.class, lauta.annaRuudussaOlevaNappula(2, 7).getClass());
        
        lauta.liikutaNappulaa(2, 7, 3, 5);
        assertEquals(null, lauta.annaRuudussaOlevaNappula(2, 7));
        assertEquals(Hevonen.class, lauta.annaRuudussaOlevaNappula(3, 5).getClass());
        
    }
    
    @Test
    public void hevonenLiikkuuOikein3() {
        
        lauta.alustaPelilauta();
        
        lauta.liikutaNappulaa(0, 6, 4, 5);
        assertEquals(null, lauta.annaRuudussaOlevaNappula(4, 5));
        assertEquals(Hevonen.class, lauta.annaRuudussaOlevaNappula(0, 6).getClass());
        
        lauta.liikutaNappulaa(0, 1, 3, 3);
        assertEquals(null, lauta.annaRuudussaOlevaNappula(3, 3));
        assertEquals(Hevonen.class, lauta.annaRuudussaOlevaNappula(0, 1).getClass());
        
        lauta.liikutaNappulaa(7, 6, 5, 3);
        assertEquals(null, lauta.annaRuudussaOlevaNappula(5, 3));
        assertEquals(Hevonen.class, lauta.annaRuudussaOlevaNappula(7, 6).getClass());
        
        lauta.liikutaNappulaa(7, 1, 4, 3);
        assertEquals(null, lauta.annaRuudussaOlevaNappula(4, 3));
        assertEquals(Hevonen.class, lauta.annaRuudussaOlevaNappula(7, 1).getClass());
        
    }
    
}
