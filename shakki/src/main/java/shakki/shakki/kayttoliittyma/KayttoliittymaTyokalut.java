/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shakki.shakki.kayttoliittyma;

import java.awt.Color;
import javax.swing.ImageIcon;
import shakki.shakki.logiikka.nappulat.*;



/**
 *
 * @author Sami
 */
public class KayttoliittymaTyokalut {
    
    private ImageIcon sotilasValkoinen = new ImageIcon("src/main/resources/images/sotilas_valkoinen.png");
    private ImageIcon sotilasMusta = new ImageIcon("src/main/resources/images/sotilas_musta.png");

    private ImageIcon hevonenValkoinen = new ImageIcon("src/main/resources/images/hevonen_valkoinen.png");
    private ImageIcon hevonenMusta = new ImageIcon("src/main/resources/images/hevonen_musta.png");

    private ImageIcon torniValkoinen = new ImageIcon("src/main/resources/images/torni_valkoinen.png");
    private ImageIcon torniMusta = new ImageIcon("src/main/resources/images/torni_musta.png");

    private ImageIcon kuningasValkoinen = new ImageIcon("src/main/resources/images/kuningas_valkoinen.png");
    private ImageIcon kuningasMusta = new ImageIcon("src/main/resources/images/kuningas_musta.png");

    private ImageIcon kuningatarValkoinen = new ImageIcon("src/main/resources/images/kuningatar_valkoinen.png");
    private ImageIcon kuningatarMusta = new ImageIcon("src/main/resources/images/kuningatar_musta.png");

    private ImageIcon lahettiValkoinen = new ImageIcon("src/main/resources/images/lahetti_valkoinen.png");
    private ImageIcon lahettiMusta = new ImageIcon("src/main/resources/images/lahetti_musta.png");
    
    public KayttoliittymaTyokalut() {
        
        
    }
    
    public void paivitaPelilauta(Ruutu[][] ruudut, Nappula[][] nappulat) {
        
        varitaRuudut(ruudut);

        for (int i = 0; i <= 7; i++) {

            for (int j = 0; j <= 7; j++) {

                if (nappulat[i][j] != null) {

                    Nappula nappula = nappulat[i][j];

                    if (nappula.getClass().equals(Sotilas.class)) {

                        if (nappula.getPelaaja().getId() == 1) {

                            ruudut[i][j].setIcon(sotilasValkoinen);

                        } else {

                            ruudut[i][j].setIcon(sotilasMusta);

                        }

                    } else if (nappula.getClass().equals(Torni.class)) {

                        if (nappula.getPelaaja().getId() == 1) {

                            ruudut[i][j].setIcon(torniValkoinen);

                        } else {

                            ruudut[i][j].setIcon(torniMusta);

                        }

                    } else if (nappula.getClass().equals(Lahetti.class)) {

                        if (nappula.getPelaaja().getId() == 1) {

                            ruudut[i][j].setIcon(lahettiValkoinen);

                        } else {

                            ruudut[i][j].setIcon(lahettiMusta);

                        }

                    } else if (nappula.getClass().equals(Hevonen.class)) {

                        if (nappula.getPelaaja().getId() == 1) {

                            ruudut[i][j].setIcon(hevonenValkoinen);

                        } else {

                            ruudut[i][j].setIcon(hevonenMusta);

                        }

                    } else if (nappula.getClass().equals(Kuningas.class)) {

                        if (nappula.getPelaaja().getId() == 1) {

                            ruudut[i][j].setIcon(kuningasValkoinen);

                        } else {

                            ruudut[i][j].setIcon(kuningasMusta);

                        }

                    } else if (nappula.getClass().equals(Kuningatar.class)) {

                        if (nappula.getPelaaja().getId() == 1) {

                            ruudut[i][j].setIcon(kuningatarValkoinen);

                        } else {

                            ruudut[i][j].setIcon(kuningatarMusta);

                        }

                    }
                }
            }

        }
        
    }
    
    private void varitaRuudut(Ruutu[][] ruudut) {
        
        int ruudunVaritys = 1;

        for (int i = 0; i <= 7; i++) {

            for (int j = 0; j <= 7; j++) {

                ruudut[i][j].setIcon(null);

                if (ruudunVaritys == 1) {

                    ruudut[i][j].setBackground(Color.white);

                } else {

                    ruudut[i][j].setBackground(Color.darkGray);

                }

                ruudunVaritys = 3 - ruudunVaritys;

            }

            ruudunVaritys = 3 - ruudunVaritys;
        }
        
    }
    
    public void asetaRuudutEpaAktiivisiksi(Ruutu[][] ruudut) {
        
        for (int i = 0; i <= 7; i++) {
            
            for (int j = 0; j <= 7; j++) {
                
                ruudut[i][j].setEnabled(false);
                
            }
            
        }
        
    }
    
    public void asetaRuudutAktiivisiksi(Ruutu[][] ruudut) {
        
        for (int i = 0; i <= 7; i++) {
            
            for (int j = 0; j <= 7; j++) {
                
                ruudut[i][j].setEnabled(true);
                
            }
            
        }
        
    }
    
}
