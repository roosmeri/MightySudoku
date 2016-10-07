package fi.mightysudoku;

import fi.mightysudoku.kayttoliittyma.Kayttoliittyma;
import fi.mightysudoku.logiikka.Pelialusta;
import fi.mightysudoku.logiikka.Rivi;
import fi.mightysudoku.logiikka.Ruudukko;
import fi.mightysudoku.logiikka.Ruutu;
import java.util.ArrayList;
import javax.swing.SwingUtilities;

/**
 * Main luokka.
 *
 */
public class MightyMain {

    /**
     * Yllättäen main-metodi.
     *
     * @param args .
     */
    public static void main(String[] args) {
//        Pelialusta alusta = new Pelialusta();

        Kayttoliittyma kayttoliittyma = new Kayttoliittyma();
        SwingUtilities.invokeLater(kayttoliittyma);

    }

}
