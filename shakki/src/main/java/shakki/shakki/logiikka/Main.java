/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shakki.shakki.logiikka;

/**
 *
 * @author Sami
 */
public class Main {

    public static void main(String[] args) {
        
        Pelilauta lauta = new Pelilauta();
        
        lauta.alustaPelilauta();
        
        lauta.poistaNappula(1, 7);
        lauta.poistaNappula(6, 7);
        
        lauta.liikutaNappulaa(7, 7, 3, 7);
        lauta.liikutaNappulaa(0, 7, 4, 7);
        
        System.out.println(lauta.annaRuudussaOlevaNappula(4, 7));
        
        
    }
    
}
