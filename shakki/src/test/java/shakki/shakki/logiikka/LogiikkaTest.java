/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shakki.shakki.logiikka;

import shakki.shakki.logiikka.nappulat.Nappula;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import shakki.shakki.logiikka.nappulat.*;

/**
 *
 * @author Sami
 */
public class LogiikkaTest {

    Logiikka logiikka;

    public LogiikkaTest() {

        logiikka = new Logiikka(new Pelilauta());
    }

    @Test
    public void sotilasVoiLiikkuaAlussaKaksiRuutuaEteenpain() {

        logiikka.alustaPelilauta();

        //Pelaaja 1: sotilas
        logiikka.liikutaNappulaa(1, 1, 3, 1);

        assertEquals(null, logiikka.haeRuudussaOlevaNappula(1, 1));
        assertEquals(Sotilas.class, logiikka.haeRuudussaOlevaNappula(3, 1).getClass());

        //Pelaaja 2: sotilas
        logiikka.liikutaNappulaa(6, 4, 4, 4);

        assertEquals(null, logiikka.haeRuudussaOlevaNappula(6, 4));
        assertEquals(Sotilas.class, logiikka.haeRuudussaOlevaNappula(4, 4).getClass());

    }

    @Test
    public void sotilasEiVoiLiikkuaKahtaRuutuaEteenpainEnsimmaisenSiirronJalkeen() {

        logiikka.alustaPelilauta();

        //Pelaaja 1: sotilas
        logiikka.liikutaNappulaa(1, 1, 3, 1);

        logiikka.liikutaNappulaa(3, 1, 5, 1);

        assertEquals(Sotilas.class, logiikka.haeRuudussaOlevaNappula(3, 1).getClass());
        assertEquals(null, logiikka.haeRuudussaOlevaNappula(5, 1));

        //Pelaaja 2: sotilas
        logiikka.liikutaNappulaa(6, 3, 4, 3);

        logiikka.liikutaNappulaa(4, 3, 2, 3);

        assertEquals(Sotilas.class, logiikka.haeRuudussaOlevaNappula(4, 3).getClass());
        assertEquals(null, logiikka.haeRuudussaOlevaNappula(2, 3));

    }

    @Test
    public void sotilasSyoOikein() {

        logiikka.alustaPelilauta();

        logiikka.liikutaNappulaa(1, 1, 3, 1);
        logiikka.liikutaNappulaa(6, 1, 4, 1);

        logiikka.liikutaNappulaa(3, 1, 4, 1);
        logiikka.vaihdaPeliVuoroa();
        logiikka.liikutaNappulaa(4, 1, 5, 1);

        assertEquals(null, logiikka.haeRuudussaOlevaNappula(4, 1));
        assertEquals(null, logiikka.haeRuudussaOlevaNappula(3, 1));

        assertEquals(Sotilas.class, logiikka.haeRuudussaOlevaNappula(5, 1).getClass());
        assertEquals(1, logiikka.haeRuudussaOlevaNappula(5, 1).getPelaaja().getId());

    }

    @Test
    public void sotilasLiikkuuOikeinEteenpain() {

        logiikka.alustaPelilauta();

        //Pelaaja 1
        //Ei voi liikkua liikaa
        logiikka.liikutaNappulaa(1, 3, 5, 3);
        assertEquals(null, logiikka.haeRuudussaOlevaNappula(5, 3));
        assertEquals(Sotilas.class, logiikka.haeRuudussaOlevaNappula(1, 3).getClass());

        //Pelaaja 1
        //Ei voi liikkua liikaa
        logiikka.liikutaNappulaa(6, 1, 2, 1);
        assertEquals(null, logiikka.haeRuudussaOlevaNappula(2, 1));
        assertEquals(Sotilas.class, logiikka.haeRuudussaOlevaNappula(6, 1).getClass());

    }

    @Test
    public void sotilasLiikkuuOikeinSivuille1() {

        logiikka.alustaPelilauta();

        //Pelaaja 1
        //Ei voi liikkua sivulle jos vieressä oma nappula
        Nappula nappula = logiikka.haeRuudussaOlevaNappula(1, 1);
        logiikka.liikutaNappulaa(1, 1, 1, 2);
        assertEquals(Sotilas.class, logiikka.haeRuudussaOlevaNappula(1, 1).getClass());
        assertEquals(Sotilas.class, logiikka.haeRuudussaOlevaNappula(1, 2).getClass());
        assertEquals(nappula, logiikka.haeRuudussaOlevaNappula(1, 1));

        //Pelaaja 1
        //Ei voi liikkua sivulle jos vieressä oma nappula
        Nappula nappula2 = logiikka.haeRuudussaOlevaNappula(6, 1);
        logiikka.liikutaNappulaa(6, 1, 6, 0);
        assertEquals(Sotilas.class, logiikka.haeRuudussaOlevaNappula(6, 1).getClass());
        assertEquals(Sotilas.class, logiikka.haeRuudussaOlevaNappula(6, 0).getClass());
        assertEquals(nappula2, logiikka.haeRuudussaOlevaNappula(6, 1));

    }

    @Test
    public void sotilasLiikkuuOikeinSivuille2() {

        //Pelaaja 1
        logiikka.alustaPelilauta();

        //Oikea
        logiikka.liikutaNappulaa(1, 3, 3, 3);
        
        logiikka.vaihdaPeliVuoroa();
        
        logiikka.liikutaNappulaa(3, 3, 3, 4);

        assertEquals(Sotilas.class, logiikka.haeRuudussaOlevaNappula(3, 4).getClass());
        assertEquals(null, logiikka.haeRuudussaOlevaNappula(1, 3));
        assertEquals(null, logiikka.haeRuudussaOlevaNappula(3, 3));

        logiikka.vaihdaPeliVuoroa();
        
        //Vasen
        logiikka.liikutaNappulaa(3, 4, 3, 3);
        assertEquals(Sotilas.class, logiikka.haeRuudussaOlevaNappula(3, 3).getClass());
        assertEquals(null, logiikka.haeRuudussaOlevaNappula(3, 4));

        //Pelaaja 2
        //Oikea
        logiikka.liikutaNappulaa(6, 6, 4, 6);
        
        logiikka.vaihdaPeliVuoroa();
        
        logiikka.liikutaNappulaa(4, 6, 4, 7);
        
        logiikka.vaihdaPeliVuoroa();

        assertEquals(Sotilas.class, logiikka.haeRuudussaOlevaNappula(4, 7).getClass());
        assertEquals(null, logiikka.haeRuudussaOlevaNappula(6, 6));
        assertEquals(null, logiikka.haeRuudussaOlevaNappula(4, 6));

        //Vasen
        logiikka.liikutaNappulaa(4, 7, 4, 6);
        assertEquals(Sotilas.class, logiikka.haeRuudussaOlevaNappula(4, 6).getClass());
        assertEquals(null, logiikka.haeRuudussaOlevaNappula(4, 7));

    }

    @Test
    public void torniLiikkuuOikeinAlasJaYlos() {

        logiikka.alustaPelilauta();

        //Pelaaja 1
        logiikka.siirraNappulaVapaasti(1, 0, 4, 0);

        logiikka.liikutaNappulaa(0, 0, 3, 0);

        assertEquals(Torni.class, logiikka.haeRuudussaOlevaNappula(3, 0).getClass());
        assertEquals(null, logiikka.haeRuudussaOlevaNappula(0, 0));

        //Pelaaja 2
        logiikka.siirraNappulaVapaasti(6, 7, 3, 7);

        logiikka.liikutaNappulaa(7, 7, 4, 7);

        assertEquals(Torni.class, logiikka.haeRuudussaOlevaNappula(4, 7).getClass());
        assertEquals(null, logiikka.haeRuudussaOlevaNappula(7, 7));

    }

    @Test
    public void torniEiLiikuOmienNappuloidenYliEteenpainMentaessa() {

        logiikka.alustaPelilauta();

        //Pelaaja 1
        logiikka.siirraNappulaVapaasti(1, 0, 3, 0);

        logiikka.liikutaNappulaa(0, 0, 4, 0);

        assertEquals(null, logiikka.haeRuudussaOlevaNappula(4, 0));
        assertEquals(Torni.class, logiikka.haeRuudussaOlevaNappula(0, 0).getClass());
        assertEquals(Sotilas.class, logiikka.haeRuudussaOlevaNappula(3, 0).getClass());

        //Pelaaja 2
        logiikka.siirraNappulaVapaasti(6, 7, 4, 7);

        logiikka.liikutaNappulaa(7, 7, 3, 7);

        assertEquals(null, logiikka.haeRuudussaOlevaNappula(3, 7));
        assertEquals(Torni.class, logiikka.haeRuudussaOlevaNappula(7, 7).getClass());
        assertEquals(Sotilas.class, logiikka.haeRuudussaOlevaNappula(4, 7).getClass());

    }

    @Test
    public void torniLiikkuuOikeinSivuille() {

        logiikka.alustaPelilauta();

        //Pelaaja 1
        logiikka.poistaNappula(1, 7);

        logiikka.liikutaNappulaa(0, 7, 3, 7);
        logiikka.vaihdaPeliVuoroa();
        logiikka.liikutaNappulaa(3, 7, 3, 3);

        assertEquals(Torni.class, logiikka.haeRuudussaOlevaNappula(3, 3).getClass());
        assertEquals(null, logiikka.haeRuudussaOlevaNappula(0, 7));
        assertEquals(null, logiikka.haeRuudussaOlevaNappula(3, 7));

        //Pelaaja 2
        logiikka.poistaNappula(6, 0);

        logiikka.liikutaNappulaa(7, 0, 4, 0);
        logiikka.vaihdaPeliVuoroa();
        logiikka.liikutaNappulaa(4, 0, 4, 4);

        assertEquals(Torni.class, logiikka.haeRuudussaOlevaNappula(4, 4).getClass());
        assertEquals(null, logiikka.haeRuudussaOlevaNappula(7, 0));
        assertEquals(null, logiikka.haeRuudussaOlevaNappula(4, 0));

    }

    @Test
    public void lahettiLiikkuuOikein1() {

        logiikka.alustaPelilauta();

        logiikka.poistaNappula(1, 1);
        logiikka.poistaNappula(1, 3);

        logiikka.liikutaNappulaa(0, 2, 2, 0);
        assertEquals(null, logiikka.haeRuudussaOlevaNappula(0, 2));
        assertEquals(Lahetti.class, logiikka.haeRuudussaOlevaNappula(2, 0).getClass());
        
        logiikka.vaihdaPeliVuoroa();
        
        logiikka.liikutaNappulaa(2, 0, 4, 2);
        assertEquals(null, logiikka.haeRuudussaOlevaNappula(2, 0));
        assertEquals(Lahetti.class, logiikka.haeRuudussaOlevaNappula(4, 2).getClass());

        logiikka.vaihdaPeliVuoroa();
        
        logiikka.liikutaNappulaa(4, 2, 2, 4);
        assertEquals(null, logiikka.haeRuudussaOlevaNappula(4, 2));
        assertEquals(Lahetti.class, logiikka.haeRuudussaOlevaNappula(2, 4).getClass());
        
        logiikka.vaihdaPeliVuoroa();

        logiikka.liikutaNappulaa(2, 4, 0, 2);
        assertEquals(null, logiikka.haeRuudussaOlevaNappula(2, 4));
        assertEquals(Lahetti.class, logiikka.haeRuudussaOlevaNappula(0, 2).getClass());

    }

    @Test
    public void lahettiLiikkuuOikein2() {

        logiikka.alustaPelilauta();

        logiikka.siirraNappulaVapaasti(0, 2, 3, 4);
        assertEquals(null, logiikka.haeRuudussaOlevaNappula(0, 2));
        assertEquals(Lahetti.class, logiikka.haeRuudussaOlevaNappula(3, 4).getClass());

        logiikka.liikutaNappulaa(3, 4, 3, 6);
        assertEquals(null, logiikka.haeRuudussaOlevaNappula(3, 6));
        assertEquals(Lahetti.class, logiikka.haeRuudussaOlevaNappula(3, 4).getClass());

        logiikka.liikutaNappulaa(3, 4, 3, 3);
        assertEquals(null, logiikka.haeRuudussaOlevaNappula(3, 3));
        assertEquals(Lahetti.class, logiikka.haeRuudussaOlevaNappula(3, 4).getClass());

        logiikka.liikutaNappulaa(3, 4, 5, 4);
        assertEquals(null, logiikka.haeRuudussaOlevaNappula(5, 4));
        assertEquals(Lahetti.class, logiikka.haeRuudussaOlevaNappula(3, 4).getClass());

        logiikka.liikutaNappulaa(3, 4, 2, 4);
        assertEquals(null, logiikka.haeRuudussaOlevaNappula(2, 4));
        assertEquals(Lahetti.class, logiikka.haeRuudussaOlevaNappula(3, 4).getClass());

    }

    @Test
    public void lahettiEiLiikuNappuloidenYli() {

        logiikka.alustaPelilauta();

        logiikka.liikutaNappulaa(0, 2, 2, 0);
        assertEquals(null, logiikka.haeRuudussaOlevaNappula(2, 0));
        assertEquals(Lahetti.class, logiikka.haeRuudussaOlevaNappula(0, 2).getClass());

        logiikka.liikutaNappulaa(0, 2, 2, 4);
        assertEquals(null, logiikka.haeRuudussaOlevaNappula(2, 4));
        assertEquals(Lahetti.class, logiikka.haeRuudussaOlevaNappula(0, 2).getClass());

        logiikka.liikutaNappulaa(7, 5, 4, 2);
        assertEquals(null, logiikka.haeRuudussaOlevaNappula(4, 2));
        assertEquals(Lahetti.class, logiikka.haeRuudussaOlevaNappula(7, 5).getClass());

        logiikka.liikutaNappulaa(7, 5, 5, 7);
        assertEquals(null, logiikka.haeRuudussaOlevaNappula(5, 7));
        assertEquals(Lahetti.class, logiikka.haeRuudussaOlevaNappula(7, 5).getClass());

    }

    @Test
    public void kuningatarLiikkuuOikein1() {

        logiikka.alustaPelilauta();
        logiikka.poistaNappula(1, 4);
        logiikka.poistaNappula(1, 3);
        logiikka.poistaNappula(1, 2);

        logiikka.liikutaNappulaa(0, 3, 3, 6);
        assertEquals(null, logiikka.haeRuudussaOlevaNappula(0, 3));
        assertEquals(Kuningatar.class, logiikka.haeRuudussaOlevaNappula(3, 6).getClass());
        
        logiikka.vaihdaPeliVuoroa();

        logiikka.liikutaNappulaa(3, 6, 3, 0);
        assertEquals(null, logiikka.haeRuudussaOlevaNappula(3, 6));
        assertEquals(Kuningatar.class, logiikka.haeRuudussaOlevaNappula(3, 0).getClass());
        
        logiikka.vaihdaPeliVuoroa();

        logiikka.liikutaNappulaa(3, 0, 0, 3);
        assertEquals(null, logiikka.haeRuudussaOlevaNappula(3, 0));
        assertEquals(Kuningatar.class, logiikka.haeRuudussaOlevaNappula(0, 3).getClass());
        
        logiikka.vaihdaPeliVuoroa();

        logiikka.liikutaNappulaa(0, 3, 5, 5);
        assertEquals(null, logiikka.haeRuudussaOlevaNappula(5, 5));
        assertEquals(Kuningatar.class, logiikka.haeRuudussaOlevaNappula(0, 3).getClass());

    }

    @Test
    public void kuningatarLiikkuuOikein2() {

        logiikka.alustaPelilauta();
        logiikka.poistaNappula(6, 2);
        logiikka.poistaNappula(6, 3);
        logiikka.poistaNappula(6, 4);

        logiikka.vaihdaPeliVuoroa();
        
        logiikka.liikutaNappulaa(7, 3, 5, 1);
        assertEquals(null, logiikka.haeRuudussaOlevaNappula(7, 3));
        assertEquals(Kuningatar.class, logiikka.haeRuudussaOlevaNappula(5, 1).getClass());
       
        logiikka.vaihdaPeliVuoroa();
        
        logiikka.liikutaNappulaa(5, 1, 2, 1);
        assertEquals(null, logiikka.haeRuudussaOlevaNappula(5, 1));
        assertEquals(Kuningatar.class, logiikka.haeRuudussaOlevaNappula(2, 1).getClass());
        
        logiikka.vaihdaPeliVuoroa();

        logiikka.liikutaNappulaa(2, 1, 2, 7);
        assertEquals(null, logiikka.haeRuudussaOlevaNappula(2, 1));
        assertEquals(Kuningatar.class, logiikka.haeRuudussaOlevaNappula(2, 7).getClass());
        
        logiikka.vaihdaPeliVuoroa();

        logiikka.liikutaNappulaa(2, 7, 3, 7);
        assertEquals(null, logiikka.haeRuudussaOlevaNappula(2, 7));
        assertEquals(Kuningatar.class, logiikka.haeRuudussaOlevaNappula(3, 7).getClass());
        
        logiikka.vaihdaPeliVuoroa();

        logiikka.liikutaNappulaa(3, 7, 7, 3);
        assertEquals(null, logiikka.haeRuudussaOlevaNappula(3, 7));
        assertEquals(Kuningatar.class, logiikka.haeRuudussaOlevaNappula(7, 3).getClass());
        
        logiikka.vaihdaPeliVuoroa();

        logiikka.liikutaNappulaa(7, 3, 3, 5);
        assertEquals(null, logiikka.haeRuudussaOlevaNappula(3, 5));
        assertEquals(Kuningatar.class, logiikka.haeRuudussaOlevaNappula(7, 3).getClass());
    }

    @Test
    public void kuningatarLiikkuuOikein3() {

        logiikka.alustaPelilauta();
        logiikka.poistaNappula(6, 2);
        logiikka.poistaNappula(6, 3);
        logiikka.poistaNappula(6, 4);

        logiikka.vaihdaPeliVuoroa();
        
        logiikka.liikutaNappulaa(7, 3, 5, 1);
        assertEquals(null, logiikka.haeRuudussaOlevaNappula(7, 3));
        assertEquals(Kuningatar.class, logiikka.haeRuudussaOlevaNappula(5, 1).getClass());
        
        logiikka.vaihdaPeliVuoroa();

        logiikka.liikutaNappulaa(5, 1, 3, 2);
        assertEquals(null, logiikka.haeRuudussaOlevaNappula(3, 2));
        assertEquals(Kuningatar.class, logiikka.haeRuudussaOlevaNappula(5, 1).getClass());
        
        logiikka.vaihdaPeliVuoroa();

        logiikka.liikutaNappulaa(5, 1, 3, 4);
        assertEquals(null, logiikka.haeRuudussaOlevaNappula(3, 4));
        assertEquals(Kuningatar.class, logiikka.haeRuudussaOlevaNappula(5, 1).getClass());
        
        logiikka.vaihdaPeliVuoroa();

        logiikka.liikutaNappulaa(5, 1, 7, 5);
        assertEquals(Lahetti.class, logiikka.haeRuudussaOlevaNappula(7, 5).getClass());
        assertEquals(Kuningatar.class, logiikka.haeRuudussaOlevaNappula(5, 1).getClass());

    }

    @Test
    public void kuningasLiikkuuOikein1() {

        logiikka.alustaPelilauta();

        logiikka.siirraNappulaVapaasti(7, 4, 3, 4);

        logiikka.vaihdaPeliVuoroa();
        
        logiikka.liikutaNappulaa(3, 4, 2, 3);

        assertEquals(null, logiikka.haeRuudussaOlevaNappula(3, 4));
        assertEquals(Kuningas.class, logiikka.haeRuudussaOlevaNappula(2, 3).getClass());

        logiikka.vaihdaPeliVuoroa();
        
        logiikka.liikutaNappulaa(2, 3, 2, 4);

        assertEquals(null, logiikka.haeRuudussaOlevaNappula(2, 3));
        assertEquals(Kuningas.class, logiikka.haeRuudussaOlevaNappula(2, 4).getClass());

        logiikka.vaihdaPeliVuoroa();
        
        logiikka.liikutaNappulaa(2, 4, 3, 5);

        assertEquals(null, logiikka.haeRuudussaOlevaNappula(2, 4));
        assertEquals(Kuningas.class, logiikka.haeRuudussaOlevaNappula(3, 5).getClass());

        logiikka.vaihdaPeliVuoroa();
        
        logiikka.liikutaNappulaa(3, 5, 4, 5);

        assertEquals(null, logiikka.haeRuudussaOlevaNappula(3, 5));
        assertEquals(Kuningas.class, logiikka.haeRuudussaOlevaNappula(4, 5).getClass());

        logiikka.vaihdaPeliVuoroa();
        
        logiikka.liikutaNappulaa(4, 5, 4, 4);

        assertEquals(null, logiikka.haeRuudussaOlevaNappula(4, 5));
        assertEquals(Kuningas.class, logiikka.haeRuudussaOlevaNappula(4, 4).getClass());

        logiikka.vaihdaPeliVuoroa();
        
        logiikka.liikutaNappulaa(4, 4, 3, 4);

        assertEquals(null, logiikka.haeRuudussaOlevaNappula(4, 4));
        assertEquals(Kuningas.class, logiikka.haeRuudussaOlevaNappula(3, 4).getClass());

        logiikka.vaihdaPeliVuoroa();
        
        logiikka.liikutaNappulaa(3, 4, 3, 5);

        assertEquals(null, logiikka.haeRuudussaOlevaNappula(3, 4));
        assertEquals(Kuningas.class, logiikka.haeRuudussaOlevaNappula(3, 5).getClass());

        logiikka.vaihdaPeliVuoroa();
        
        logiikka.liikutaNappulaa(3, 5, 3, 4);

        assertEquals(null, logiikka.haeRuudussaOlevaNappula(3, 5));
        assertEquals(Kuningas.class, logiikka.haeRuudussaOlevaNappula(3, 4).getClass());

    }

    @Test
    public void kuningasLiikkuuOikein2() {

        logiikka.alustaPelilauta();
        logiikka.poistaNappula(1, 3);
        logiikka.poistaNappula(1, 4);
        logiikka.poistaNappula(1, 5);

        logiikka.liikutaNappulaa(0, 4, 2, 6);
        assertEquals(null, logiikka.haeRuudussaOlevaNappula(2, 6));
        assertEquals(Kuningas.class, logiikka.haeRuudussaOlevaNappula(0, 4).getClass());

        logiikka.vaihdaPeliVuoroa();
        
        logiikka.liikutaNappulaa(0, 4, 3, 4);
        assertEquals(null, logiikka.haeRuudussaOlevaNappula(3, 4));
        assertEquals(Kuningas.class, logiikka.haeRuudussaOlevaNappula(0, 4).getClass());
        
        logiikka.vaihdaPeliVuoroa();

        logiikka.liikutaNappulaa(0, 4, 4, 3);
        assertEquals(null, logiikka.haeRuudussaOlevaNappula(4, 3));
        assertEquals(Kuningas.class, logiikka.haeRuudussaOlevaNappula(0, 4).getClass());

    }

    @Test
    public void hevonenLiikkuuOikein1() {

        logiikka.alustaPelilauta();

        logiikka.vaihdaPeliVuoroa();
        
        logiikka.liikutaNappulaa(7, 6, 5, 7);
        assertEquals(Sotilas.class, logiikka.haeRuudussaOlevaNappula(6, 7).getClass());
        assertEquals(Hevonen.class, logiikka.haeRuudussaOlevaNappula(5, 7).getClass());
        
        logiikka.vaihdaPeliVuoroa();

        logiikka.liikutaNappulaa(5, 7, 4, 5);
        assertEquals(null, logiikka.haeRuudussaOlevaNappula(5, 7));
        assertEquals(Hevonen.class, logiikka.haeRuudussaOlevaNappula(4, 5).getClass());
        
        logiikka.vaihdaPeliVuoroa();

        logiikka.liikutaNappulaa(7, 1, 5, 0);
        assertEquals(null, logiikka.haeRuudussaOlevaNappula(7, 1));
        assertEquals(Hevonen.class, logiikka.haeRuudussaOlevaNappula(5, 0).getClass());
        
        logiikka.vaihdaPeliVuoroa();

        logiikka.liikutaNappulaa(5, 0, 4, 2);
        assertEquals(null, logiikka.haeRuudussaOlevaNappula(5, 0));
        assertEquals(Hevonen.class, logiikka.haeRuudussaOlevaNappula(4, 2).getClass());

    }

    @Test
    public void hevonenLiikkuuOikein2() {

        logiikka.alustaPelilauta();

        logiikka.liikutaNappulaa(0, 1, 2, 0);
        assertEquals(null, logiikka.haeRuudussaOlevaNappula(0, 1));
        assertEquals(Hevonen.class, logiikka.haeRuudussaOlevaNappula(2, 0).getClass());
        
        logiikka.vaihdaPeliVuoroa();

        logiikka.liikutaNappulaa(2, 0, 3, 2);
        assertEquals(null, logiikka.haeRuudussaOlevaNappula(2, 0));
        assertEquals(Hevonen.class, logiikka.haeRuudussaOlevaNappula(3, 2).getClass());
        
        logiikka.vaihdaPeliVuoroa();

        logiikka.liikutaNappulaa(0, 6, 2, 7);
        assertEquals(null, logiikka.haeRuudussaOlevaNappula(0, 6));
        assertEquals(Hevonen.class, logiikka.haeRuudussaOlevaNappula(2, 7).getClass());
        
        logiikka.vaihdaPeliVuoroa();

        logiikka.liikutaNappulaa(2, 7, 3, 5);
        assertEquals(null, logiikka.haeRuudussaOlevaNappula(2, 7));
        assertEquals(Hevonen.class, logiikka.haeRuudussaOlevaNappula(3, 5).getClass());

    }

    @Test
    public void hevonenLiikkuuOikein3() {

        logiikka.alustaPelilauta();

        logiikka.liikutaNappulaa(0, 6, 4, 5);
        assertEquals(null, logiikka.haeRuudussaOlevaNappula(4, 5));
        assertEquals(Hevonen.class, logiikka.haeRuudussaOlevaNappula(0, 6).getClass());

        logiikka.liikutaNappulaa(0, 1, 3, 3);
        assertEquals(null, logiikka.haeRuudussaOlevaNappula(3, 3));
        assertEquals(Hevonen.class, logiikka.haeRuudussaOlevaNappula(0, 1).getClass());

        logiikka.liikutaNappulaa(7, 6, 5, 3);
        assertEquals(null, logiikka.haeRuudussaOlevaNappula(5, 3));
        assertEquals(Hevonen.class, logiikka.haeRuudussaOlevaNappula(7, 6).getClass());

        logiikka.liikutaNappulaa(7, 1, 4, 3);
        assertEquals(null, logiikka.haeRuudussaOlevaNappula(4, 3));
        assertEquals(Hevonen.class, logiikka.haeRuudussaOlevaNappula(7, 1).getClass());
    }
    
    @Test 
    public void vuoronVaihtoToimiiOikein1() {
        
        logiikka.alustaPelilauta();
        
        assertEquals(1, logiikka.getPeliVuoro());
        
        logiikka.liikutaNappulaa(1, 1, 2, 1);
        
        assertEquals(2, logiikka.getPeliVuoro());
        
        logiikka.liikutaNappulaa(6, 1, 4, 1);
        
        assertEquals(1, logiikka.getPeliVuoro());
        
    }
    
    @Test 
    public void vuoronVaihtoToimiiOikein2() {
        
        logiikka.alustaPelilauta();
        
        logiikka.liikutaNappulaa(1, 1, 3, 1);
        logiikka.liikutaNappulaa(3, 1, 4, 1);
        
        assertEquals(Sotilas.class, logiikka.haeRuudussaOlevaNappula(3, 1).getClass());
        assertEquals(null, logiikka.haeRuudussaOlevaNappula(4, 1));
        
        logiikka.liikutaNappulaa(6, 2, 5, 2);
        
        assertEquals(Sotilas.class, logiikka.haeRuudussaOlevaNappula(5, 2).getClass());
        assertEquals(null, logiikka.haeRuudussaOlevaNappula(6, 2));
        
        logiikka.liikutaNappulaa(3, 1, 4, 1);
        
        assertEquals(Sotilas.class, logiikka.haeRuudussaOlevaNappula(4, 1).getClass());
        assertEquals(null, logiikka.haeRuudussaOlevaNappula(3, 1));
        
    }

}
