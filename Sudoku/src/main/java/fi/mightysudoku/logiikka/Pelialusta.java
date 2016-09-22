package fi.mightysudoku.logiikka;

import java.util.ArrayList;

public class Pelialusta {

    private ArrayList<Rivi> rivit = new ArrayList<>();
    private ArrayList<Ruudukko> ruudukot = new ArrayList<>();
    private ArrayList<Ruutu> ruudut = new ArrayList<>();

    public Pelialusta() {
        luoRuudut();
        luoRivit();
        luoRuudukot();

    }

    public void luoRuudukot() {
        //täällä kaiken maailman vikaa...
        int x = 3;
        int y = 3;
        for (int i = 0; i < 9; i++) {
            if (y > 8) {
                y = 0;
            }
            ArrayList<Ruutu> ruudukonRuudut = new ArrayList<>();
            x += 3;
            if (x % 9 == 0) {
                x = 0;
                y += 3;

            }
            for (Ruutu r : this.ruudut) {
                if ((r.getX() < x) && (r.getX() >= (x - 3)) && (r.getY() < y) && (r.getY() >= (y - 3))) {
                    ruudukonRuudut.add(r);

                }
            }
            this.ruudukot.add(new Ruudukko(ruudukonRuudut));
        }

        for (Ruudukko r : this.ruudukot) {
            System.out.println(r.getRuudut().size());
        }
    }

    public void luoRivit() {
        //luodaan 18 riviÃ¤, 9 horisontaalista ja 9 vertikaalista
        for (int i = 0; i < 9; i++) {
            ArrayList<Ruutu> rivinruudutx = new ArrayList<>();
            for (Ruutu ruutu : this.ruudut) {
                if (ruutu.getX() == i) {
                    rivinruudutx.add(ruutu);
                }
            }
            this.rivit.add(new Rivi(rivinruudutx));
            ArrayList<Ruutu> rivinruuduty = new ArrayList<>();
            for (Ruutu ruutu : this.ruudut) {
                if (ruutu.getY() == i) {
                    rivinruuduty.add(ruutu);
                }
            }
            this.rivit.add(new Rivi(rivinruuduty));
        }
    }

    public void luoRuudut() {
        //luodaan ruudut 81 kappaletta, kaikilla oma koordinaattinsa
        int x = 0;
        int y = 0;
        for (int i = 0; i < 81; i++) {
            if (x > 8) {
                continue;
            }
            this.ruudut.add(new Ruutu(x, y));
            y++;
            if (y % 9 == 0 && i > 0) {
                x++;
                y = 0;
            }
        }
    }

    public void asetaArvo(Ruutu ruutu, int asetettavaArvo) {
        // tarkistetaan kuuluuko ruudun ruudukkoon tai kumpaankaan riviin jo asetettavana olevaa arvoa
        for (Ruudukko ruudukko : ruudukot) {
            if (ruutu.getX() < ruudukko.getRuudukontunnus().charAt(0) + 2 && ruutu.getX() >= ruudukko.getRuudukontunnus().charAt(0)
                    && ruutu.getY() < ruudukko.getRuudukontunnus().charAt(0) + 2 && ruutu.getY() >= ruudukko.getRuudukontunnus().charAt(1)) {
                if (ruudukko.onkoArvoJo(asetettavaArvo)) {
                    System.out.println("Arvo on jo ruudukossa.");
                    return;
                }
            }
        }
        for (Rivi rivi : rivit) {
            if (rivi.getRivitunnus().charAt(0) == ruutu.getX() || rivi.getRivitunnus().charAt(1) == ruutu.getY()) {
                if (rivi.onkoArvoJo(asetettavaArvo)) {
                    System.out.println("Arvo on jo rivillÃ¤.");
                    return;
                }
            }

        }

        ruutu.setArvo(asetettavaArvo);
    }

}
