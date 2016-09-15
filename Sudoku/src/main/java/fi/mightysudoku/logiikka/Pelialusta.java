package fi.mightysudoku.logiikka;

import java.util.ArrayList;

public class Pelialusta {

    ArrayList<Rivi> rivit = new ArrayList<>();
    ArrayList<Ruudukko> ruudukot = new ArrayList<>();

    public Pelialusta(ArrayList<Rivi> rivit, ArrayList<Ruudukko> ruudukot) {
        this.rivit = rivit;
        this.ruudukot = ruudukot;

    }

}
