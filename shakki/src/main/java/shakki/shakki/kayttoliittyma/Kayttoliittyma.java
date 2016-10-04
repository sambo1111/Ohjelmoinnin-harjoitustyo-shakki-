/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shakki.shakki.kayttoliittyma;

import shakki.shakki.logiikka.*;

import javax.swing.*;
import java.awt.*;
import javax.imageio.ImageIO;
import java.io.*;

/**
 *
 * @author Sami
 */
public class Kayttoliittyma implements Runnable {

    JFrame frame;
    Ruutu[][] ruudut = new Ruutu[8][8];
    Logiikka logiikka = new Logiikka(new Pelilauta());

    public Kayttoliittyma() {

        logiikka.alustaPelilauta();

    }

    public void run() {
        frame = new JFrame("Otsikko");
        frame.setPreferredSize(new Dimension(700, 700));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {

        NappulanKuuntelija kuuntelija = new NappulanKuuntelija(ruudut, logiikka);
        container.setLayout(new GridLayout(8, 8));
        
        //Kuvat
        ImageIcon sotilas_v = new ImageIcon("src/main/resources/images/sotilas_valkoinen.png");
        ImageIcon sotilas_m = new ImageIcon("src/main/resources/images/sotilas_musta.png");
        
        ImageIcon hevonen_v = new ImageIcon("src/main/resources/images/hevonen_valkoinen.png");
        ImageIcon hevonen_m = new ImageIcon("src/main/resources/images/hevonen_musta.png");
        
        ImageIcon torni_v = new ImageIcon("src/main/resources/images/torni_valkoinen.png");
        ImageIcon torni_m = new ImageIcon("src/main/resources/images/torni_musta.png");
        
        ImageIcon kuningas_v = new ImageIcon("src/main/resources/images/kuningas_valkoinen.png");
        ImageIcon kuningas_m = new ImageIcon("src/main/resources/images/kuningas_musta.png");
        
        ImageIcon kuningatar_v = new ImageIcon("src/main/resources/images/kuningatar_valkoinen.png");
        ImageIcon kuningatar_m = new ImageIcon("src/main/resources/images/kuningatar_musta.png");
        
        ImageIcon lahetti_v = new ImageIcon("src/main/resources/images/lahetti_valkoinen.png");
        ImageIcon lahetti_m = new ImageIcon("src/main/resources/images/lahetti_musta.png");

        //1 = musta, 2 = valkonen
        int ruudunVaritys = 1;

        for (int i = 0; i <= 7; i++) {

            for (int j = 0; j <= 7; j++) {

                Ruutu nappi = new Ruutu(i, j);
                nappi.addActionListener(kuuntelija);
                
                // Lisätään kuvat ruuduille
                if (i == 1) {
                
                nappi.setIcon(sotilas_v);
                
                } else if (i == 6) {
                
                nappi.setIcon(sotilas_m);
                
                } else if ((i == 0 && j == 1) || (i == 0 && j == 6)) {
                    
                    nappi.setIcon(hevonen_v);
                    
                } else if ((i == 7 && j == 1) || (i == 7 && j == 6)) {
                    
                    nappi.setIcon(hevonen_m);
                    
                } else if ((i == 0 && j == 0) || (i == 0 && j == 7)) {
                    
                    nappi.setIcon(torni_v);
                    
                } else if ((i == 7 && j == 0) || (i == 7 && j == 7)) {
                    
                    nappi.setIcon(torni_m);
                    
                } else if (i == 0 && j == 4) {
                    
                    nappi.setIcon(kuningas_v);
                    
                } else if (i == 7 && j == 4) {
                    
                    nappi.setIcon(kuningas_m);
                    
                } else if (i == 0 && j == 3) {
                    
                    nappi.setIcon(kuningatar_v);
                    
                } else if (i == 7 && j == 3) {
                    
                    nappi.setIcon(kuningatar_m);
                    
                } else if ((i == 0 && j == 2) || (i == 0 && j == 5)) {
                    
                    nappi.setIcon(lahetti_v);
                    
                } else if ((i == 7 && j == 2) || (i == 7 && j == 5)) {
                    
                    nappi.setIcon(lahetti_m);
                    
                } 
                
                
                if (ruudunVaritys == 1) {

                    nappi.setBackground(Color.white);

                } else {

                    nappi.setBackground(Color.darkGray);

                }

                ruudunVaritys = 3 - ruudunVaritys;

                ruudut[i][j] = nappi;
                container.add(ruudut[i][j]);

            }

            ruudunVaritys = 3 - ruudunVaritys;

        }

    }

    public JFrame getFrame() {

        return frame;

    }

    public Ruutu[][] getRuudut() {

        return ruudut;

    }
}
