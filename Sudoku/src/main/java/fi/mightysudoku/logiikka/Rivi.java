package fi.mightysudoku.logiikka;

import java.util.ArrayList;

public class Rivi implements Numeromuodostelma {

    ArrayList<Ruutu> ruudut = new ArrayList<>();
    private String rivitunnus = "";

    public Rivi(ArrayList<Ruutu> ruudut) {
        this.ruudut = ruudut;
        this.rivitunnus = "" + this.ruudut.get(0).getX() + this.ruudut.get(0).getY();
    }

    @Override
    public boolean onkoArvoJo(int arvo) {
        //tarkistetaan onko rivillä jo ehdotettu arvo
        for (Ruutu r : this.ruudut) {
            if (r.getArvo() == arvo) {
                return true;
            }
        }
        return false;
    }

    @Override
    public ArrayList<Ruutu> getRuudut() {
        return this.ruudut;
    }

}
