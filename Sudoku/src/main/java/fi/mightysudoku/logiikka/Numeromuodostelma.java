package fi.mightysudoku.logiikka;

import java.util.ArrayList;

/**
 * Rajapinta edustaa numeromuodostelmia mihin ruutu voi kuulua.
 */
public interface Numeromuodostelma {

    /**
     * Tarkistetaan onko arvo jo numeromuodostelmassa.
     *
     * @param arvo .
     * @return True jos ja false jos ei.
     */
    boolean onkoArvoJo(int arvo);

    /**
     * Aika perus getteri.
     *
     * @return Lista ruutu-olioista.
     */
    ArrayList<Ruutu> getRuudut();

}
