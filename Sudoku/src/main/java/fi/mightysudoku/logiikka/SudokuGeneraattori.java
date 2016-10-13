package fi.mightysudoku.logiikka;

import java.util.ArrayList;
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
        //täällä toistaiseksi valmis pohja käytössä
        ArrayList<Integer> valmispohja = new ArrayList<>();
        String numerotrivi1 = "000040003";
        String numerotrivi2 = "000600002";
        String numerotrivi3 = "000081050";
        String numerotrivi4 = "600007040";
        String numerotrivi5 = "010300000";
        String numerotrivi6 = "009050000";
        String numerotrivi7 = "000003005";
        String numerotrivi8 = "003925074";
        String numerotrivi9 = "006074080";
        for (int i = 0; i < 9; i++) {
            valmispohja.add(Character.getNumericValue(numerotrivi1.charAt(i)));
        }
        for (int i = 0; i < 9; i++) {
            valmispohja.add(Character.getNumericValue(numerotrivi2.charAt(i)));
        }
        for (int i = 0; i < 9; i++) {
            valmispohja.add(Character.getNumericValue(numerotrivi3.charAt(i)));
        }
        for (int i = 0; i < 9; i++) {
            valmispohja.add(Character.getNumericValue(numerotrivi4.charAt(i)));
        }
        for (int i = 0; i < 9; i++) {
            valmispohja.add(Character.getNumericValue(numerotrivi5.charAt(i)));
        }
        for (int i = 0; i < 9; i++) {
            valmispohja.add(Character.getNumericValue(numerotrivi6.charAt(i)));
        }
        for (int i = 0; i < 9; i++) {
            valmispohja.add(Character.getNumericValue(numerotrivi7.charAt(i)));
        }
        for (int i = 0; i < 9; i++) {
            valmispohja.add(Character.getNumericValue(numerotrivi8.charAt(i)));
        }
        for (int i = 0; i < 9; i++) {
            valmispohja.add(Character.getNumericValue(numerotrivi9.charAt(i)));
        }
        int apu = 0;
        for (Ruutu ruutu : alusta.getRuudut()) {
            ruutu.setArvo(valmispohja.get(apu));
            apu++;
        }

        return this.alusta;
    }

    public Pelialusta getAlusta() {
        return alusta;
    }

}
