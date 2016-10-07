package shakki.shakki.logiikka;

import shakki.shakki.logiikka.nappulat.Nappula;
import shakki.shakki.logiikka.nappulat.*;

/**
 * Luokan tehtävä on näyttää nappuloiden mahdollisten siirtojen paikat
 * pelilaudalla.
 */
public class NappulanLiikuttamisLogiikka {

    private boolean[][] mahdollisetSiirrot;

    /**
     * Metodi kertoo mihin ruutuihin tietyllä nappulalla voi siirtyä nappulan
     * tämähetkisestä paikasta.
     *
     * @param pelilauta tämänhetkinen pelilaudan tilanne.
     * @param nappula nappula, jonka mahdolliset siirtopaikat halutaan
     * selvittää.
     * @param rivi rivi, jossa nappula on tällä hetkellä.
     * @param sarake sarake, jossa nappula on tällä hetkellä.
     *
     * @return boolean-taulukko, joka vastaa shakkilaudan ruutuja, joihin voi
     * tai ei voi siirtää kyseistä nappulaa.
     */
    public boolean[][] naytaMahdollisetSiirrot(Nappula[][] pelilauta, Nappula nappula, int rivi, int sarake) {

        mahdollisetSiirrot = new boolean[8][8];

        if (nappula.getClass().equals(Torni.class)) {

            naytaTorninMahdollisetSiirrot(pelilauta, nappula, rivi, sarake);

        } else if (nappula.getClass().equals(Lahetti.class)) {

            naytaLahetinMahdollisetSiirrot(pelilauta, nappula, rivi, sarake);

        } else if (nappula.getClass().equals(Sotilas.class)) {

            if (nappula.getPelaaja().getId() == 1) {

                naytaPelaajanYksiSotilaanMahdollisetSiirrot(pelilauta, nappula, rivi, sarake);

            } else if (nappula.getPelaaja().getId() == 2) {

                naytaPelaajanKaksiSotilaanMahdollisetSiirrot(pelilauta, nappula, rivi, sarake);

            }

        } else if (nappula.getClass().equals(Kuningatar.class)) {

            naytaKuningattarenMahdollisetSiirrot(pelilauta, nappula, rivi, sarake);

        } else if (nappula.getClass().equals(Kuningas.class)) {

            naytaKuninkaanMahdollisetSiirrot(pelilauta, nappula, rivi, sarake);

        } else if (nappula.getClass().equals(Hevonen.class)) {

            naytaHevosenMahdollisetSiirrot(pelilauta, nappula, rivi, sarake);
        }

        return mahdollisetSiirrot;

    }

    /**
     * Metodi tarkistaa voiko tiettyyn ruutuun siirtyä tietyllä nappulalla.
     *
     * @param rivi rivi, jolle halutaan selvittää tarkistaa voiko siihen siirtyä
     * @param sarake sarake, jolle halutaan selvittää tarkistaa voiko siihen
     * siirtyä
     * @param pelilauta tämänhetkinen pelilaudan tilanne.
     * @param nappula nappula, jonka mahdolliset siirtopaikat halutaan
     * selvittää.
     *
     * @return boolean-arvo, joka kertoo voiko kysyttyyn ruutuun siirtyä
     * kyseisellä nappulalla.
     */
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

    private void tarkistaVoikoSotilasSyoda(int rivi, int sarake, Nappula[][] pelilauta, Nappula nappula) {

        if (rivi <= 7 && rivi >= 0 && sarake <= 7 && sarake >= 0) {

            if (pelilauta[rivi][sarake] != null) {

                if (pelilauta[rivi][sarake].getPelaaja().getId() != nappula.getPelaaja().getId()) {

                    mahdollisetSiirrot[rivi][sarake] = true;

                }
            }
        }
    }

    private void naytaTorninMahdollisetSiirrot(Nappula[][] pelilauta, Nappula nappula, int rivi, int sarake) {

        naytaTorninMahdollisetSiirrotYlos(pelilauta, nappula, rivi, sarake);
        naytaTorninMahdollisetSiirrotAlas(pelilauta, nappula, rivi, sarake);
        naytaTorninMahdollisetSiirrotOikealle(pelilauta, nappula, rivi, sarake);
        naytaTorninMahdollisetSiirrotVasemmalle(pelilauta, nappula, rivi, sarake);

    }

    private void naytaTorninMahdollisetSiirrotYlos(Nappula[][] pelilauta, Nappula nappula, int rivi, int sarake) {

        for (int i = rivi - 1; i >= 0; i--) {

            if (!tarkistaOnkoMahdollinen(i, sarake, pelilauta, nappula)) {

                break;
            }
        }
    }

    private void naytaTorninMahdollisetSiirrotAlas(Nappula[][] pelilauta, Nappula nappula, int rivi, int sarake) {

        for (int i = rivi + 1; i <= 7; i++) {

            if (!tarkistaOnkoMahdollinen(i, sarake, pelilauta, nappula)) {

                break;
            }
        }
    }

    private void naytaTorninMahdollisetSiirrotOikealle(Nappula[][] pelilauta, Nappula nappula, int rivi, int sarake) {

        for (int i = sarake + 1; i <= 7; i++) {

            if (!tarkistaOnkoMahdollinen(rivi, i, pelilauta, nappula)) {

                break;
            }
        }
    }

    private void naytaTorninMahdollisetSiirrotVasemmalle(Nappula[][] pelilauta, Nappula nappula, int rivi, int sarake) {

        for (int i = sarake - 1; i >= 0; i--) {

            if (!tarkistaOnkoMahdollinen(rivi, i, pelilauta, nappula)) {

                break;
            }
        }
    }

    private void naytaPelaajanYksiSotilaanMahdollisetSiirrot(Nappula[][] pelilauta, Nappula nappula, int rivi, int sarake) {

        tarkistaOnkoMahdollinen(rivi + 1, sarake, pelilauta, nappula);
        tarkistaVoikoSotilasSyoda(rivi + 1, sarake + 1, pelilauta, nappula);
        tarkistaVoikoSotilasSyoda(rivi + 1, sarake - 1, pelilauta, nappula);

        if (nappula.getSiirrot() < 1) {

            tarkistaOnkoMahdollinen(rivi + 2, sarake, pelilauta, nappula);
        }
        

    }

    private void naytaPelaajanKaksiSotilaanMahdollisetSiirrot(Nappula[][] pelilauta, Nappula nappula, int rivi, int sarake) {

        tarkistaOnkoMahdollinen(rivi - 1, sarake, pelilauta, nappula);
        tarkistaVoikoSotilasSyoda(rivi - 1, sarake - 1, pelilauta, nappula);
        tarkistaVoikoSotilasSyoda(rivi - 1, sarake + 1, pelilauta, nappula);

        if (nappula.getSiirrot() < 1) {

            tarkistaOnkoMahdollinen(rivi - 2, sarake, pelilauta, nappula);
        }
        
    }

    private void naytaLahetinMahdollisetSiirrot(Nappula[][] pelilauta, Nappula nappula, int rivi, int sarake) {

        naytaLahetinMahdollisetSiirrotOikeaanAlaviistoon(pelilauta, nappula, rivi, sarake);
        naytaLahetinMahdollisetSiirrotOikeaanYlaviistoon(pelilauta, nappula, rivi, sarake);
        naytaLahetinMahdollisetSiirrotVasempaanAlaviistoon(pelilauta, nappula, rivi, sarake);
        naytaLahetinMahdollisetSiirrotVasempaanYlaviistoon(pelilauta, nappula, rivi, sarake);
    }

    private void naytaLahetinMahdollisetSiirrotOikeaanAlaviistoon(Nappula[][] pelilauta, Nappula nappula, int rivi, int sarake) {

        int i = rivi + 1;
        int j = sarake + 1;

        while (i <= 7 || j <= 7) {

            if (!tarkistaOnkoMahdollinen(i, j, pelilauta, nappula)) {
                break;
            }

            i++;
            j++;
        }
    }

    private void naytaLahetinMahdollisetSiirrotOikeaanYlaviistoon(Nappula[][] pelilauta, Nappula nappula, int rivi, int sarake) {

        int i = rivi - 1;
        int j = sarake + 1;

        while (i >= 0 || j <= 7) {

            if (!tarkistaOnkoMahdollinen(i, j, pelilauta, nappula)) {
                break;
            }
            i--;
            j++;
        }
    }

    private void naytaLahetinMahdollisetSiirrotVasempaanAlaviistoon(Nappula[][] pelilauta, Nappula nappula, int rivi, int sarake) {

        int i = rivi + 1;
        int j = sarake - 1;

        while (i <= 7 || j >= 0) {

            if (!tarkistaOnkoMahdollinen(i, j, pelilauta, nappula)) {
                break;
            }
            i++;
            j--;
        }
    }

    private void naytaLahetinMahdollisetSiirrotVasempaanYlaviistoon(Nappula[][] pelilauta, Nappula nappula, int rivi, int sarake) {

        int i = rivi - 1;
        int j = sarake - 1;

        while (i >= 0 || j >= 0) {

            if (!tarkistaOnkoMahdollinen(i, j, pelilauta, nappula)) {
                break;
            }
            i--;
            j--;
        }
    }

    private void naytaKuningattarenMahdollisetSiirrot(Nappula[][] pelilauta, Nappula nappula, int rivi, int sarake) {

        naytaTorninMahdollisetSiirrot(pelilauta, nappula, rivi, sarake);
        naytaLahetinMahdollisetSiirrot(pelilauta, nappula, rivi, sarake);
    }

    private void naytaHevosenMahdollisetSiirrot(Nappula[][] pelilauta, Nappula nappula, int rivi, int sarake) {

        tarkistaOnkoMahdollinen(rivi - 2, sarake + 1, pelilauta, nappula);
        tarkistaOnkoMahdollinen(rivi - 2, sarake - 1, pelilauta, nappula);
        tarkistaOnkoMahdollinen(rivi + 2, sarake + 1, pelilauta, nappula);
        tarkistaOnkoMahdollinen(rivi + 2, sarake - 1, pelilauta, nappula);
        tarkistaOnkoMahdollinen(rivi - 1, sarake + 2, pelilauta, nappula);
        tarkistaOnkoMahdollinen(rivi - 1, sarake - 2, pelilauta, nappula);
        tarkistaOnkoMahdollinen(rivi + 1, sarake + 2, pelilauta, nappula);
        tarkistaOnkoMahdollinen(rivi + 1, sarake - 2, pelilauta, nappula);
    }

    private void naytaKuninkaanMahdollisetSiirrot(Nappula[][] pelilauta, Nappula nappula, int rivi, int sarake) {

        naytaKuninkaanMahdollisetSiirrotYlosJaAlas(pelilauta, nappula, rivi, sarake);
        naytaKuninkaanMahdollisetSiirrotSivuille(pelilauta, nappula, rivi, sarake);
        naytaKuninkaanMahdollisetSiirrotViistosti(pelilauta, nappula, rivi, sarake);
    }

    private void naytaKuninkaanMahdollisetSiirrotYlosJaAlas(Nappula[][] pelilauta, Nappula nappula, int rivi, int sarake) {

        tarkistaOnkoMahdollinen(rivi + 1, sarake, pelilauta, nappula);
        tarkistaOnkoMahdollinen(rivi - 1, sarake, pelilauta, nappula);

    }

    private void naytaKuninkaanMahdollisetSiirrotSivuille(Nappula[][] pelilauta, Nappula nappula, int rivi, int sarake) {

        tarkistaOnkoMahdollinen(rivi, sarake - 1, pelilauta, nappula);
        tarkistaOnkoMahdollinen(rivi, sarake + 1, pelilauta, nappula);

    }

    private void naytaKuninkaanMahdollisetSiirrotViistosti(Nappula[][] pelilauta, Nappula nappula, int rivi, int sarake) {

        tarkistaOnkoMahdollinen(rivi - 1, sarake + 1, pelilauta, nappula);
        tarkistaOnkoMahdollinen(rivi - 1, sarake - 1, pelilauta, nappula);
        tarkistaOnkoMahdollinen(rivi + 1, sarake + 1, pelilauta, nappula);
        tarkistaOnkoMahdollinen(rivi + 1, sarake - 1, pelilauta, nappula);

    }
}
