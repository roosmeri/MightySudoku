package fi.mightysudoku.logiikka;

import java.util.ArrayList;

/**
 * Rajapinta edustaa numeromuodostelmia mihin ruutu voi kuulua.
 */

public interface Numeromuodostelma {

    /**
     * Metodi tarkistaa onko numeromuodostelmassa jo asetettavaa arvoa.
     *
     * @param arvo.
     *
     * @return True jos on ja false jos ei ole.
     */

    boolean onkoArvoJo(int arvo);

    ArrayList<Ruutu> getRuudut();

}
