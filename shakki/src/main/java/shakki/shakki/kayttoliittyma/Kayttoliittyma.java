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
        frame = new JFrame("Shakki");
        frame.setPreferredSize(new Dimension(700, 700));
        frame.setResizable(false);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {

        container.setLayout(new BorderLayout());
        JLabel alusta = new JLabel();

        alusta.setLayout(new GridLayout(8, 8));

        JToolBar tools = new JToolBar();
        tools.setMargin(new Insets(2,2,2,2));

        JTextField ilmoitusLaatikko = new JTextField("Valkoisen vuoro");
        ilmoitusLaatikko.setEditable(false);
        ilmoitusLaatikko.setHorizontalAlignment(JTextField.CENTER);
        ilmoitusLaatikko.setForeground(Color.blue);
        
        //Lisätän uusipeli nappi
        
        JButton uusiPeliNappi = new JButton();
        uusiPeliNappi.addActionListener(new UusiPeliNappulanKuuntelija(ruudut, logiikka, ilmoitusLaatikko));
        uusiPeliNappi.setText("Uusi Peli");
        tools.add(uusiPeliNappi);
        
        //Lisätään ilmoitusboxi
        
        tools.add(ilmoitusLaatikko);
        
        container.add(tools, BorderLayout.NORTH);
        
        RuutuNappulanKuuntelija kuuntelija = new RuutuNappulanKuuntelija(ruudut, logiikka, ilmoitusLaatikko);

        //Kuvat
        ImageIcon sotilasValkoinen = new ImageIcon("src/main/resources/images/sotilas_valkoinen.png");
        ImageIcon sotilasMusta = new ImageIcon("src/main/resources/images/sotilas_musta.png");

        ImageIcon hevonenValkoinen = new ImageIcon("src/main/resources/images/hevonen_valkoinen.png");
        ImageIcon hevonenMusta = new ImageIcon("src/main/resources/images/hevonen_musta.png");

        ImageIcon torniValkoinen = new ImageIcon("src/main/resources/images/torni_valkoinen.png");
        ImageIcon torniMusta = new ImageIcon("src/main/resources/images/torni_musta.png");

        ImageIcon kuningasValkoinen = new ImageIcon("src/main/resources/images/kuningas_valkoinen.png");
        ImageIcon kuningasMusta = new ImageIcon("src/main/resources/images/kuningas_musta.png");

        ImageIcon kuningatarValkoinen = new ImageIcon("src/main/resources/images/kuningatar_valkoinen.png");
        ImageIcon kuningatarMusta = new ImageIcon("src/main/resources/images/kuningatar_musta.png");

        ImageIcon lahettiValkoinen = new ImageIcon("src/main/resources/images/lahetti_valkoinen.png");
        ImageIcon lahettiMusta = new ImageIcon("src/main/resources/images/lahetti_musta.png");

        //1 = musta, 2 = valkonen
        int ruudunVaritys = 1;

        for (int i = 0; i <= 7; i++) {

            for (int j = 0; j <= 7; j++) {

                Ruutu nappi = new Ruutu(i, j);
                nappi.addActionListener(kuuntelija);

                // Lisätään kuvat ruuduille
                if (i == 1) {

                    nappi.setIcon(sotilasValkoinen);

                } else if (i == 6) {

                    nappi.setIcon(sotilasMusta);

                } else if ((i == 0 && j == 1) || (i == 0 && j == 6)) {

                    nappi.setIcon(hevonenValkoinen);

                } else if ((i == 7 && j == 1) || (i == 7 && j == 6)) {

                    nappi.setIcon(hevonenMusta);

                } else if ((i == 0 && j == 0) || (i == 0 && j == 7)) {

                    nappi.setIcon(torniValkoinen);

                } else if ((i == 7 && j == 0) || (i == 7 && j == 7)) {

                    nappi.setIcon(torniMusta);

                } else if (i == 0 && j == 4) {

                    nappi.setIcon(kuningasValkoinen);

                } else if (i == 7 && j == 4) {

                    nappi.setIcon(kuningasMusta);

                } else if (i == 0 && j == 3) {

                    nappi.setIcon(kuningatarValkoinen);

                } else if (i == 7 && j == 3) {

                    nappi.setIcon(kuningatarMusta);

                } else if ((i == 0 && j == 2) || (i == 0 && j == 5)) {

                    nappi.setIcon(lahettiValkoinen);

                } else if ((i == 7 && j == 2) || (i == 7 && j == 5)) {

                    nappi.setIcon(lahettiMusta);

                }

                if (ruudunVaritys == 1) {

                    nappi.setBackground(Color.white);

                } else {

                    nappi.setBackground(Color.darkGray);
                }

                ruudunVaritys = 3 - ruudunVaritys;

                ruudut[i][j] = nappi;
                alusta.add(ruudut[i][j]);

            }

            ruudunVaritys = 3 - ruudunVaritys;

        }

        container.add(alusta, BorderLayout.CENTER);

    }

    public JFrame getFrame() {

        return frame;

    }

    public Ruutu[][] getRuudut() {

        return ruudut;

    }
}
