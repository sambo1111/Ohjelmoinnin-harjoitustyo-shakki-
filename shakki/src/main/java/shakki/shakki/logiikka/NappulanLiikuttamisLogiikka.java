/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shakki.shakki.logiikka;

import shakki.shakki.logiikka.nappulat.*;

/**
 *
 * @author hasasami
 */
public class NappulanLiikuttamisLogiikka {

    private boolean[][] mahdollisetSiirrot;

    public boolean[][] naytaMahdollisetSiirrot(Nappula[][] pelilauta, Nappula nappula, int rivi, int sarake) {

        mahdollisetSiirrot = new boolean[8][8];

        if (nappula.getClass().equals(Torni.class)) {

            naytaTorninMahdollisetSiirrot(pelilauta, nappula, rivi, sarake);

        } else if (nappula.getClass().equals(Lahetti.class)) {

            naytaLahetinMahdollisetSiirrot(pelilauta, nappula, rivi, sarake);

        } else if (nappula.getClass().equals(Sotilas.class)) {

            naytaSotilaanMahdollisetSiirrot(pelilauta, nappula, rivi, sarake);

        } else if (nappula.getClass().equals(Kuningatar.class)) {

            naytaKuningattarenMahdollisetSiirrot(pelilauta, nappula, rivi, sarake);
            
        } else if (nappula.getClass().equals(Kuningas.class)) {

            naytaKuninkaanMahdollisetSiirrot(pelilauta, nappula, rivi, sarake);
            
        } else if (nappula.getClass().equals(Hevonen.class)) {

            naytaHevosenMahdollisetSiirrot(pelilauta, nappula, rivi, sarake);
        }

        return mahdollisetSiirrot;

    }

    public void naytaTorninMahdollisetSiirrot(Nappula[][] pelilauta, Nappula nappula, int rivi, int sarake) {

        //YLÖS
        for (int i = sarake + 1; i <= 7; i++) {

            if (!tarkistaOnkoMahdollinen(rivi, i, pelilauta, nappula)) {

                break;
            }
        }

        //VASEN
        for (int i = sarake - 1; i >= 0; i--) {

            if (!tarkistaOnkoMahdollinen(rivi, i, pelilauta, nappula)) {

                break;
            }
        }

        //ALAS
        for (int i = rivi + 1; i <= 7; i++) {

            if (!tarkistaOnkoMahdollinen(i, sarake, pelilauta, nappula)) {

                break;
            }
        }

        //YLÖS
        for (int i = rivi - 1; i >= 0; i--) {

            if (!tarkistaOnkoMahdollinen(i, sarake, pelilauta, nappula)) {

                break;
            }
        }
    }

    public void naytaSotilaanMahdollisetSiirrot(Nappula[][] pelilauta, Nappula nappula, int rivi, int sarake) {

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

    public void naytaLahetinMahdollisetSiirrot(Nappula[][] pelilauta, Nappula nappula, int rivi, int sarake) {

        int i = rivi + 1;
        int j = sarake + 1;

        while (i <= 7 || j <= 7) {

            if (!tarkistaOnkoMahdollinen(i, j, pelilauta, nappula)) {
                break;
            }

            i++;
            j++;

        }

        i = rivi + 1;
        j = sarake - 1;

        while (i <= 7 || j >= 0) {

            if (!tarkistaOnkoMahdollinen(i, j, pelilauta, nappula)) {
                break;
            }
            i++;
            j--;

        }

        i = rivi - 1;
        j = sarake + 1;

        while (i >= 0 || j <= 7) {

            if (!tarkistaOnkoMahdollinen(i, j, pelilauta, nappula)) {
                break;
            }
            i--;
            j++;

        }

        i = rivi - 1;
        j = sarake - 1;

        while (i >= 0 || j >= 0) {

            if (!tarkistaOnkoMahdollinen(i, j, pelilauta, nappula)) {
                break;
            }
            i--;
            j--;

        }
    }

    public void naytaKuningattarenMahdollisetSiirrot(Nappula[][] pelilauta, Nappula nappula, int rivi, int sarake) {

        //Kuningatar liikkuu lahetin ja tornin tavoilla
        naytaTorninMahdollisetSiirrot(pelilauta, nappula, rivi, sarake);
        naytaLahetinMahdollisetSiirrot(pelilauta, nappula, rivi, sarake);

    }

    public void naytaHevosenMahdollisetSiirrot(Nappula[][] pelilauta, Nappula nappula, int rivi, int sarake) {

        tarkistaOnkoMahdollinen(rivi - 2, sarake + 1, pelilauta, nappula);
        tarkistaOnkoMahdollinen(rivi - 2, sarake - 1, pelilauta, nappula);
        tarkistaOnkoMahdollinen(rivi + 2, sarake + 1, pelilauta, nappula);
        tarkistaOnkoMahdollinen(rivi + 2, sarake - 1, pelilauta, nappula);
        tarkistaOnkoMahdollinen(rivi - 1, sarake + 2, pelilauta, nappula);
        tarkistaOnkoMahdollinen(rivi - 1, sarake - 2, pelilauta, nappula);
        tarkistaOnkoMahdollinen(rivi + 1, sarake + 2, pelilauta, nappula);
        tarkistaOnkoMahdollinen(rivi + 1, sarake - 2, pelilauta, nappula);

    }

    public void naytaKuninkaanMahdollisetSiirrot(Nappula[][] pelilauta, Nappula nappula, int rivi, int sarake) {

        tarkistaOnkoMahdollinen(rivi - 1, sarake + 1, pelilauta, nappula);
        tarkistaOnkoMahdollinen(rivi - 1, sarake - 1, pelilauta, nappula);
        tarkistaOnkoMahdollinen(rivi + 1, sarake + 1, pelilauta, nappula);
        tarkistaOnkoMahdollinen(rivi + 1, sarake - 1, pelilauta, nappula);
        tarkistaOnkoMahdollinen(rivi, sarake - 1, pelilauta, nappula);
        tarkistaOnkoMahdollinen(rivi, sarake + 1, pelilauta, nappula);
        tarkistaOnkoMahdollinen(rivi + 1, sarake, pelilauta, nappula);
        tarkistaOnkoMahdollinen(rivi - 1, sarake, pelilauta, nappula);
    }

    private boolean tarkistaOnkoMahdollinen(int rivi, int sarake, Nappula[][] pelilauta, Nappula nappula) {

        if (rivi <= 7 && rivi >= 0 && sarake <= 7 && sarake >= 0) {

            if (pelilauta[rivi][sarake] == null) {

                mahdollisetSiirrot[rivi][sarake] = true;
                return true;

            } else if (pelilauta[rivi][sarake].getPelaaja().getId() != nappula.getPelaaja().getId()) {

                mahdollisetSiirrot[rivi][sarake] = true;
                return false;

            }
        }

        return false;

    }

}
