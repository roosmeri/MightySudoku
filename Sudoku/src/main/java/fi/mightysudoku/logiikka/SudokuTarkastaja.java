package fi.mightysudoku.logiikka;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Luokan tarkoitus on tarkistaa onko SudokuGeneraattorin luoma peli
 * selvitettävissä.
 *
 * @author Viliina
 */
public class SudokuTarkastaja {

    private Pelialusta peli;
    ArrayList<ArrayList<Ruutu>> ratkaisut;
    HashSet<Integer> mahdollisetArvot = new HashSet<>();

    /**
     * Konstruktori ei tee mitään.
     */
    public SudokuTarkastaja() {
    }

    /**
     * Metodi tarkistaa, että generoidulla pelillä on ainakin yksi ratkaisu.
     *
     * @param peli osittain täytetty sudoku-alusta.
     * @return true jos on ratkaistavissa, false jos ei ole.
     */
    public boolean selviaako(Pelialusta peli) {
        this.peli = peli;
        if (selvita().size() > 0) {
            return true;
        }
        return false;
    }

    private ArrayList<ArrayList<Ruutu>> selvita() {

        this.ratkaisut = new ArrayList<>();
        ArrayList<Ruutu> tyhjat = getTyhjat();
        ArrayList<Ruutu> selvitetyt = new ArrayList<>();
        selvitaSudoku(tyhjat, selvitetyt, 0);
        return ratkaisut;
    }

    private ArrayList<Ruutu> getTyhjat() {
        ArrayList<Ruutu> tyhjat = new ArrayList<>();
        for (Ruutu ruutu : peli.getRuudut()) {
            if (ruutu.getArvo() == 0) {
                tyhjat.add(ruutu);
            }
        }
        return tyhjat;
    }

    private void selvitaSudoku(ArrayList<Ruutu> tyhjat, ArrayList<Ruutu> selvitetyt, int indeksi) {
        if (ratkaisut.size() > 1) {
            return;
        }
        if (indeksi >= tyhjat.size()) {
            ratkaisut.add(new ArrayList<Ruutu>(selvitetyt));
            return;
        }

        Ruutu tarkasteltava = new Ruutu(tyhjat.get(indeksi).getX(), tyhjat.get(indeksi).getY());

        for (int value : mahdollisetArvot(tarkasteltava)) {

            if (peli.asetaArvo(tarkasteltava, value)) {
                peli.asetaArvo(tarkasteltava, value);

                selvitetyt.add(tarkasteltava);

                int newIndex = indeksi + 1;
                selvitaSudoku(tyhjat, selvitetyt, newIndex);
                tyhjat.get(indeksi).setArvo(0);
                selvitetyt.remove(tarkasteltava);
                peli.asetaArvo(tarkasteltava, value);
            }
        }
    }

    private HashSet<Integer> mahdollisetArvot(Ruutu ruutu) {
        if (ruutu.getArvo() != 0) {
            return null;
        }
        for (int i = 1; i <= 9; i++) {
            this.mahdollisetArvot.add(i);
        }

        this.mahdollisetArvot.removeAll(peli.getRivit().get(ruutu.getX()).getRuudut());
        for (Ruudukko ruudukko : peli.getRuudukot()) {
            if (ruutu.getX() < Character.getNumericValue(ruudukko.getRuudukontunnus().charAt(0)) + 2 && ruutu.getX() >= Character.getNumericValue(ruudukko.getRuudukontunnus().charAt(0))
                    && ruutu.getY() < Character.getNumericValue(ruudukko.getRuudukontunnus().charAt(1)) + 2 && ruutu.getY() >= Character.getNumericValue(ruudukko.getRuudukontunnus().charAt(1))) {
                this.mahdollisetArvot.removeAll(ruudukko.getRuudut());
            }
        }
        this.mahdollisetArvot.removeAll(peli.getSarakkeet().get(ruutu.getY()).getRuudut());
        return this.mahdollisetArvot;
    }

    public ArrayList<ArrayList<Ruutu>> getRatkaisut() {
        return ratkaisut;
    }

}
