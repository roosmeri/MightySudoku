package fi.mightysudoku.logiikka;

import java.util.ArrayList;

/**
 * Luokka edustaa Sudokuruudukon aliruudukkoa 3x3 kokoista ruudukkoa.
 *
 */
public class Ruudukko implements Numeromuodostelma {

    private ArrayList<Ruutu> ruudut = new ArrayList<>();
    private String ruudukontunnus = "";

    /**
     * Konstruktori asettaa ruudukkoon siihen kuuluvat ruudut.
     *
     * @param ruudut Ruudukon ruudut.
     */
    public Ruudukko(ArrayList<Ruutu> ruudut) {
        this.ruudut = ruudut;
        this.ruudukontunnus = "" + ruudut.get(0).getX() + ruudut.get(0).getY();
    }

    /**
     * Metodi tarkistaa onko ruudukossa jo asetettavaa arvoa.
     *
     * @param arvo.
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

    @Override
    public ArrayList<Ruutu> getRuudut() {
        return this.ruudut;
    }

    public String getRuudukontunnus() {
        return ruudukontunnus;
    }

}
