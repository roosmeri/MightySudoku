package fi.mightysudoku.logiikka;

import java.util.ArrayList;

/**
 * Luokka edustaa Rivi-olioita, jotka koostuvaat Ruuduista.
 *
 *
 */
public class Rivi implements Numeromuodostelma {

    private ArrayList<Ruutu> ruudut = new ArrayList<>();
    private int rivitunnus = 0;

    /**
     * Konstruktori asettaa Rivin muodostavat Ruudut talteen ja muodostaa
     * rivitunnuksen.
     *
     * @param ruudut Pelialustan määräämät ruudut
     */
    public Rivi(ArrayList<Ruutu> ruudut) {
        this.ruudut = ruudut;
        this.rivitunnus = this.ruudut.get(0).getY();
    }

    /**
     * Metodi tarkistaa onko rivillä ehdotettu arvo.
     *
     * @param arvo ehdotettu arvo
     *
     * @return True jos on ja false jos ei ole.
     */
    @Override
    public boolean onkoArvoJo(int arvo) {
        for (Ruutu r : this.ruudut) {
            if (r.getArvo() == arvo) {
                return true;
            }
        }
        return false;
    }

    /**
     * Metodi palauttaa riviin kuuluvat ruudut.
     *
     * @return Ruudut.
     */
    @Override
    public ArrayList<Ruutu> getRuudut() {
        return this.ruudut;
    }

    public int getRivitunnus() {
        return rivitunnus;
    }

}
