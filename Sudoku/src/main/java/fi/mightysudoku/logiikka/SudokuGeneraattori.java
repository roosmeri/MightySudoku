package fi.mightysudoku.logiikka;

import java.util.Random;

/**
 * Luokan tarkoitus on luoda uusi sudokupohja, eli asettaa valmiina annetut
 * numerot niin, että pelin voi niiden pohjalta ratkaista.
 *
 */
public class SudokuGeneraattori {

    private Pelialusta alusta;

    private SudokuTarkastaja tarkastaja;
    private final int leveys = 9;
    private final int korkeus = 9;
    private int[] asetettavat = {1, 2, 3, 4, 5, 6, 7, 8, 9};

    /**
     * Konstruktorissa kutsutaan alustetaan SudokuGeneraattorille alusta jolle
     * asetella numeroita, sekä SudokuTarkastaja, jolla tarkistutetaan
     * generaattorin luomia pelipohjia siltä varalta, että se luo pohjan jota on
     * mahdoton ratkaista.
     *
     * @param alusta on pelialusta, johon asetetaan numerot.
     * @param tyhjienMaara on käyttäjän täytettäviksi jäävien ruutujen määrä.
     */
    public SudokuGeneraattori(Pelialusta alusta, int tyhjienMaara) {
        this.alusta = alusta;
        this.tarkastaja = new SudokuTarkastaja();

        while (true) {
            uusiAlusta(tyhjienMaara);
            Pelialusta testattavaAlusta = getAlusta();
            if (tarkastaja.selviaako(testattavaAlusta)) {
                break;
            }
        }

    }

    /**
     * Metodi kutsuu alustaa muokkaavia metodeita.
     *
     * @param tyhjienMaara tyhjien ruutujen määrä.
     */
    public void uusiAlusta(int tyhjienMaara) {
        asetaRuutuun(0, 0);
        asetaTyhjat(tyhjienMaara);

    }

    /**
     * Metodi, joka asettaa jokaiseen ruutuun semisatunnaisen arvon
     * tarkistettuaan, että se sopii ruutuun.
     *
     * @param x kyseessä olevan ruudun x-koordinaatti.
     * @param y kyseessä olevan ruudun y-koordinaatti.
     * @return true jos saatiin kaikkiin ruutuihin asetettua arvo, muuten false.
     */
    public boolean asetaRuutuun(int x, int y) {
        Random r = new Random();
        int uusiX = x;
        int uusiY = y;

        arvoAsetettavienJarjestys(r);

        for (int i = 0; i < asetettavat.length; i++) {
            if (oikeellinenAsetus(x, y, asetettavat[i])) {
                alusta.haeRuutu(x, y).setArvo(asetettavat[i]);
                if (x == 8) {
                    if (y == 8) {
                        return true;
                    } else {
                        uusiX = 0;
                        uusiY = y + 1;
                    }
                } else {
                    uusiX = x + 1;
                }
                if (asetaRuutuun(uusiX, uusiY)) {
                    return true;
                }
            }
        }
        alusta.haeRuutu(x, y).setArvo(0);
        return false;
    }

    private void arvoAsetettavienJarjestys(Random r) {
        int arvottuidx;
        int apu;
        for (int i = asetettavat.length - 1; i > 0; i--) {
            arvottuidx = r.nextInt(i);
            apu = asetettavat[arvottuidx];
            asetettavat[arvottuidx] = asetettavat[i];
            asetettavat[i] = apu;
        }
    }

    private boolean oikeellinenAsetus(int x, int y, int asetettava) {
        Ruutu ruutu = alusta.haeRuutu(x, y);
        if (alusta.asetaArvo(ruutu, asetettava)) {
            return true;
        }
        return false;
    }

    private void asetaTyhjat(int tyhjia) {
        double taysiaRuutuja = 81;
        double tyhjiaTayttevana = (double) tyhjia;

        for (int i = 0; i < leveys; i++) {
            for (int j = 0; j < korkeus; j++) {
                double tyhjanMahdollisuus = tyhjiaTayttevana / taysiaRuutuja;
                if (Math.random() <= tyhjanMahdollisuus) {
                    alusta.haeRuutu(i, j).setArvo(0);
                    tyhjiaTayttevana--;
                }
                taysiaRuutuja--;
            }
        }
    }

    /**
     * Metodi palauttaa luodun osittain täytetyn sudokupohjan.
     *
     * @return Pelialusta alusta pelivalmiina.
     */
    public Pelialusta getAlusta() {
        return alusta;
    }

}
