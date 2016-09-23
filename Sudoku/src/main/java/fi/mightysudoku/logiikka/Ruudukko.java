package fi.mightysudoku.logiikka;

import java.util.ArrayList;

public class Ruudukko implements Numeromuodostelma {

    private ArrayList<Ruutu> ruudut = new ArrayList<>();
    private String ruudukontunnus = "";

    public Ruudukko(ArrayList<Ruutu> ruudut) {
        this.ruudut = ruudut;
        this.ruudukontunnus = "" + ruudut.get(0).getX() + ruudut.get(0).getY();
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

    public String getRuudukontunnus() {
        return ruudukontunnus;
    }

}
