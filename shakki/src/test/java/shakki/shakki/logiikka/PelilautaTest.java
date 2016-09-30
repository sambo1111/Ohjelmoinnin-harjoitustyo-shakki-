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

}
