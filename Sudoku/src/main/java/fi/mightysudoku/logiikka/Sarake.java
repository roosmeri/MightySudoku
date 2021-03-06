/*
 * Pystyrivi.
 */
package fi.mightysudoku.logiikka;

import java.util.ArrayList;

/**
 * Luokka edustaa Sarake-olioita, jotka koostuvaat Ruuduista.
 *
 *
 */
public class Sarake implements Numeromuodostelma {

    private ArrayList<Ruutu> ruudut = new ArrayList<>();
    private int saraketunnus = 0;

    /**
     * Konstruktori asettaa Sarakkeen muodostavat Ruudut talteen ja muodostaa
     * saraketunnuksen.
     *
     * @param ruudut Pelialustan määräämät ruudut
     */
    public Sarake(ArrayList<Ruutu> ruudut) {
        this.ruudut = ruudut;
        this.saraketunnus = this.ruudut.get(0).getX();
    }

    /**
     * Metodi tarkistaa onko sarakkeessa ehdotettu arvo.
     *
     * @param arvo Ehdotettu arvo.
     *
     * @return True jos on ja false jos ei ole TAI sama arvo on siinä ruudussa
     * mihina asetetaan.
     */
    @Override
    public boolean onkoArvoJo(Ruutu ruutu, int arvo) {
        for (Ruutu r : this.ruudut) {
            if (r.getArvo() == arvo) {
                if (r.getX() == ruutu.getX() && r.getY() == ruutu.getY()) {
                    return false;
                } else {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Metodi palauttaa sarakkeeseen kuuluvat ruudut.
     *
     * @return Ruudut.
     */
    @Override
    public ArrayList<Ruutu> getRuudut() {
        return this.ruudut;
    }

    /**
     * Metodi palauttaa sarakkeen tunnuksen.
     *
     * @return Saraketunnus.
     */
    public int getSaraketunnus() {
        return saraketunnus;
    }

}
