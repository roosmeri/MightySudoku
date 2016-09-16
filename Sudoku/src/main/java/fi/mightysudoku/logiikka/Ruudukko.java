package fi.mightysudoku.logiikka;

import java.util.ArrayList;

public class Ruudukko implements Numeromuodostelma {

    ArrayList<Ruutu> ruudut = new ArrayList<>();
    //   private String ruudukontunnus = "";

    public Ruudukko(ArrayList<Ruutu> ruudut) {
        this.ruudut = ruudut;

    }

    @Override
    public boolean onkoArvoJo(int arvo) {
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
