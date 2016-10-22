package fi.mightysudoku.logiikka;

import java.util.ArrayList;

/**
 * Rajapinta edustaa numeromuodostelmia mihin ruutu voi kuulua.
 */
public interface Numeromuodostelma {

    /**
     * Tarkistetaan onko arvo jo numeromuodostelmassa, jos on niin se saa olla
     * vain siinä ruudussa mihin ollaan asettamassa.
     *
     * @param arvo .
     * @return True jos ja false jos ei.
     */
    boolean onkoArvoJo(Ruutu ruutu, int arvo);

    /**
     * Aika perus getteri.
     *
     * @return Lista ruutu-olioista.
     */
    ArrayList<Ruutu> getRuudut();

}
