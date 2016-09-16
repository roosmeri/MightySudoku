package fi.mightysudoku;

import fi.mightysudoku.logiikka.Ruudukko;
import fi.mightysudoku.logiikka.Ruutu;
import java.util.ArrayList;

public class MightyMain {

    public static void main(String[] args) {
        ArrayList<Ruutu> ruudut = new ArrayList<>();

        int apu = 0;
        int apu2 = -1;
        for (int i = 0; i < 81; i++) {
            apu2++;
            if (apu > 8) {
                break;
            }
            ruudut.add(new Ruutu(apu, apu2));

            if (i > 0 && i % 8 == 0) {
                apu++;
                apu2 = 0;
            }
        }
        ArrayList<Ruutu> ruudukonRuudut = new ArrayList<>();
        for (Ruutu r : ruudut) {
            if (r.getX() <= 2 && r.getY() <= 2) {
                ruudukonRuudut.add(r);

            }
        }
        Ruudukko ruudukko = new Ruudukko(ruudukonRuudut);
    }

}
