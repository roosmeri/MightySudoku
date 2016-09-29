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
        //tÃƒÂ¤ÃƒÂ¤llÃƒÂ¤ kaiken maailman vikaa...
        int x = 0;
        int y = 0;
        for (int i = 0; i < 9; i++) {
            x += 3;
            if (x == 12) {
                x = 3;
                y += 3;
            }
            if (i < 3) {
                y = 3;
            }

            ArrayList<Ruutu> ruudukonRuudut = new ArrayList<>();
            for (Ruutu r : this.ruudut) {
                if ((r.getX() < x) && (r.getX() >= (x - 3)) && (r.getY() < y) && (r.getY() >= (y - 3))) {
                    ruudukonRuudut.add(r);

                }
            }
            this.ruudukot.add(new Ruudukko(ruudukonRuudut));

        }

    }

    public void luoRivit() {
        //luodaan 18 riviÃƒÆ’Ã‚Â¤, 9 horisontaalista ja 9 vertikaalista
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
                    System.out.println("Arvo on jo rivillÃƒÆ’Ã‚Â¤.");
                    return;
                }
            }

        }

        ruutu.setArvo(asetettavaArvo);
    }

    public ArrayList<Rivi> getRivit() {
        return rivit;
    }

    public ArrayList<Ruudukko> getRuudukot() {
        return ruudukot;
    }

    public ArrayList<Ruutu> getRuudut() {
        return ruudut;
    }

}
