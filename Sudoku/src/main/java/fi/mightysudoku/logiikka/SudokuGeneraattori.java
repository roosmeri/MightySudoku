package fi.mightysudoku.logiikka;

import java.util.Random;

/**
 * Luokan tarkoitus on luoda uusi sudokupohja, eli asettaa valmiina annetut
 * numerot.
 *
 */
public class SudokuGeneraattori {

    Pelialusta alusta;

    /**
     * Generaattorille asetetaan alusta johon asettaa arvot.
     *
     * @param alusta Pelin alusta.
     */
    public SudokuGeneraattori(Pelialusta alusta) {
        this.alusta = alusta;
    }

    /**
     * Metodi asettaa alustalle valmiit numerot.
     *
     * @return alusta täytettynä
     */
    public Pelialusta generoiPelialusta() {
        //vikaa on
        Random random = new Random();
        for (Ruutu ruutu : alusta.getRuudut()) {
            while (ruutu.getArvo() == 0) {
                alusta.asetaArvo(ruutu, random.nextInt(9 - 1) + 1);
            }
        }
        return this.alusta;
    }

    public Pelialusta getAlusta() {
        return alusta;
    }

}
