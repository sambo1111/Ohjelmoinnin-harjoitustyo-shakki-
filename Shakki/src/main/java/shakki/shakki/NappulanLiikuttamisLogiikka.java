/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shakki.shakki;

import shakki.shakki.nappulat.*;

/**
 *
 * @author Sami
 */
public class NappulanLiikuttamisLogiikka {

    private boolean[][] mahdollisetSiirrot;

    public boolean[][] naytaMahdollisetSiirrot(Nappula[][] pelilauta, Nappula nappula, int rivi, int sarake) {

        mahdollisetSiirrot = new boolean[8][8];

        //TORNIN SIIRROT
        if (nappula.getClass().equals(Torni.class)) {

            // OIKEALLE
            for (int i = sarake+1; i <= 7; i++) {

                if (!tarkistaOnkoMahdollinen(rivi, i, pelilauta, nappula)) {

                    break;
                }

            }
            
            //VASEN
            for (int i = sarake-1; i >= 0; i--) {

                if (!tarkistaOnkoMahdollinen(rivi, i, pelilauta, nappula)) {

                    break;
                }

            }

            //ALAS
            for (int i = rivi+1; i <= 7; i++) {

                if (!tarkistaOnkoMahdollinen(i, sarake, pelilauta, nappula)) {

                    break;
                }

            }
            
            //YLÖS
            for (int i = rivi-1; i >= 0; i--) {

                if (!tarkistaOnkoMahdollinen(i, sarake, pelilauta, nappula)) {

                    break;
                }
            }
        } //LÄHETIN SIIRROT
        else if (nappula.getClass().equals(Lahetti.class)) {

            int i = rivi+1;
            int j = sarake+1;

            while (i <= 7 || j <= 7) {

                if (!tarkistaOnkoMahdollinen(i, j, pelilauta, nappula)) {
                    break;
                }

                i++;
                j++;

            }

            i = rivi+1;
            j = sarake-1;

            while (i <= 7 || j >= 0) {

                if (!tarkistaOnkoMahdollinen(i, j, pelilauta, nappula)) {
                    break;
                }
                i++;
                j--;

            }

            i = rivi-1;
            j = sarake+1;

            while (i >= 0 || j <= 7) {

                if (!tarkistaOnkoMahdollinen(i, j, pelilauta, nappula)) {
                    break;
                }
                i--;
                j++;

            }

            i = rivi-1;
            j = sarake-1;

            while (i >= 0 || j >= 0) {

                if (!tarkistaOnkoMahdollinen(i, j, pelilauta, nappula)) {
                    break;
                }
                i--;
                j--;

            }
        } //SOTILAAN SIIRROT
        else if (nappula.getClass().equals(Sotilas.class)) {

            //Pelaaja 1 aloittaa ylhäältä lautaa ja pelaaja 2 alhaalta
            if (nappula.getPelaaja().getId() == 1) {

                tarkistaOnkoMahdollinen(rivi + 1, sarake, pelilauta, nappula);
                tarkistaOnkoMahdollinen(rivi, sarake + 1, pelilauta, nappula);
                tarkistaOnkoMahdollinen(rivi, sarake - 1, pelilauta, nappula);
                //Alussa sotilas voi liikkua 2 ruutua eteenpäin
                if (nappula.getSiirrot() < 1) {
                    
                    tarkistaOnkoMahdollinen(rivi + 2, sarake, pelilauta, nappula);
                }

            } else if (nappula.getPelaaja().getId() == 2) {

                tarkistaOnkoMahdollinen(rivi - 1, sarake, pelilauta, nappula);
                tarkistaOnkoMahdollinen(rivi, sarake + 1, pelilauta, nappula);
                tarkistaOnkoMahdollinen(rivi, sarake - 1, pelilauta, nappula);
                
                if (nappula.getSiirrot() < 1) {
                    
                    tarkistaOnkoMahdollinen(rivi - 2, sarake, pelilauta, nappula);
                }

            }
            
            nappula.kasvataSiirtojenLkm();

        }

        //KUNINGATTAREN SIIRROT
        //KUNINKAAN SIIRROT
        //HEVOSEN SIIRROT
        return mahdollisetSiirrot;

    }

    private boolean tarkistaOnkoMahdollinen(int rivi, int sarake, Nappula[][] pelilauta, Nappula nappula) {

        if (rivi <= 7 && rivi >= 0 && sarake <= 7 && sarake >= 0) {

            if (pelilauta[rivi][sarake] == null || nappula.getPelaaja() != pelilauta[rivi][sarake].getPelaaja()) {

                mahdollisetSiirrot[rivi][sarake] = true;
                return true;

            }
        }

        return false;

    }

}
