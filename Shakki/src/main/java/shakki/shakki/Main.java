/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shakki.shakki;

/**
 *
 * @author Sami
 */
public class Main {
    
    public static void main(String args[]) {
        
        Pelilauta p = new Pelilauta();
        p.alustaPelilauta();
        
        Nappula[][] napit = p.getPelilauta();
        
        
        
        p.poistaNappula(1, 0);
        p.poistaNappula(0, 1);
        p.poistaNappula(0, 2);
        
        boolean[][] mahdsiirrot = p.liikutaNappulaa(0, 0, 3, 0);
        
        System.out.println(mahdsiirrot[3][0]);
        
        System.out.println(napit[0][0]);
        System.out.println(napit[3][0]);
        
    }
    
}
