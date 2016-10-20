package fi.mightysudoku.logiikka;

import java.util.ArrayList;

/**
 * Luokka pitää sisällään ja alustaa kaikki pelialustaan kuuluvat komponentit,
 * rivit, sarakkeet, ruudukot ja itse ruudut.
 *
 *
 */
public class Pelialusta {

    private ArrayList<Rivi> rivit = new ArrayList<>();
    private ArrayList<Ruudukko> ruudukot = new ArrayList<>();
    private ArrayList<Ruutu> ruudut = new ArrayList<>();
    private ArrayList<Sarake> sarakkeet = new ArrayList<>();

    /**
     * Konstruktori kutsuu kaikkia pelialustan komponentteja luovia metodeita.
     *
     */
    public Pelialusta() {
        luoRuudut();
        luoRivitJaSarakkeet();
        luoRuudukot();

    }

    private void luoRuudukot() {
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

    private void luoRivitJaSarakkeet() {
        //luodaan 18 rivia,9 horisontaalista ja 9 vertikaalista
        for (int i = 0; i < 9; i++) {
            ArrayList<Ruutu> rivinruudutx = new ArrayList<>();
            for (Ruutu ruutu : this.ruudut) {
                if (ruutu.getX() == i) {
                    rivinruudutx.add(ruutu);
                }
            }
            this.sarakkeet.add(new Sarake(rivinruudutx));
            ArrayList<Ruutu> rivinruuduty = new ArrayList<>();
            for (Ruutu ruutu : this.ruudut) {
                if (ruutu.getY() == i) {
                    rivinruuduty.add(ruutu);
                }
            }
            this.rivit.add(new Rivi(rivinruuduty));
        }
    }

    private void luoRuudut() {
        //luodaan ruudut, 81 kappaletta, kaikilla oma koordinaattinsa
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

    /**
     * Metodi asettaa valittuun ruutuun Käyttäjän antaman arvon, jos samaa arvoa
     * ei ole rivillä, sarakkeella tai ruudukossa mihin kyseinen ruutu kuuluu.
     *
     * @param ruutu Käyttäjan valitsema ruutu
     * @param asetettavaArvo Käyttäjän valitsema asetettava arvo
     */
    public boolean asetaArvo(Ruutu ruutu, int asetettavaArvo) {
        if (onkoArvoJoRuudukossa(ruutu, asetettavaArvo)) {
            return false;
        } else if (onkoArvoJoRivissa(ruutu, asetettavaArvo)) {
            return false;
        } else if (onkoArvoJoSarakkeessa(ruutu, asetettavaArvo)) {
            return false;
        } else {

            ruutu.setArvo(asetettavaArvo);
            return true;
        }
    }

    /**
     * Metodi tarkistaa onko Käyttäjän valitseman ruudun sarakkeessa jo valittua
     * arvoa.
     *
     * @param ruutu Käyttäjan valitsema ruutu
     * @param asetettavaArvo Käyttäjän valitsema asetettava arvo
     * @return True jos on ja false jos ei.
     */
    public boolean onkoArvoJoSarakkeessa(Ruutu ruutu, int asetettavaArvo) {
        for (Sarake sarake : sarakkeet) {
            if (sarake.getSaraketunnus() == ruutu.getX()) {
                if (sarake.onkoArvoJo(asetettavaArvo)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Metodi tarkistaa onko Käyttäjän valitseman ruudun rivissa jo valittua
     * arvoa.
     *
     * @param ruutu Käyttäjan valitsema ruutu
     * @param asetettavaArvo Käyttäjän valitsema asetettava arvo
     * @return True jos on ja false jos ei.
     */
    public boolean onkoArvoJoRivissa(Ruutu ruutu, int asetettavaArvo) {
        for (Rivi rivi : this.rivit) {
            if (rivi.getRivitunnus() == ruutu.getY()) {
                if (rivi.onkoArvoJo(asetettavaArvo)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Metodi tarkistaa onko Käyttäjän valitseman ruudun ruudukossa jo valittua
     * arvoa.
     *
     * @param ruutu Käyttäjan valitsema ruutu
     * @param asetettavaArvo Käyttäjän valitsema asetettava arvo
     * @return True jos on ja false jos ei.
     */
    public boolean onkoArvoJoRuudukossa(Ruutu ruutu, int asetettavaArvo) {
        // tarkistetaan kuuluuko ruudun ruudukkoon
        for (Ruudukko ruudukko : ruudukot) {
            if (ruutu.getX() <= Character.getNumericValue(ruudukko.getRuudukontunnus().charAt(0)) + 2 && ruutu.getX() >= Character.getNumericValue(ruudukko.getRuudukontunnus().charAt(0))
                    && ruutu.getY() <= Character.getNumericValue(ruudukko.getRuudukontunnus().charAt(1)) + 2 && ruutu.getY() >= Character.getNumericValue(ruudukko.getRuudukontunnus().charAt(1))) {
                if (ruudukko.onkoArvoJo(asetettavaArvo)) {
                    return true;
                }
            }
        }
        return false;
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

    public ArrayList<Sarake> getSarakkeet() {
        return sarakkeet;
    }
    /**
     * Metodi hakee ruuduista yhden ruudun joka on annetussa sijainnissa.
     * @param x x-koordinaatti.
     * @param y y-koordinaatti.
     * @return löydetty ruutu tai null, jos ei löytynyt.
     */

    public Ruutu haeRuutu(int x, int y) {
        for (Ruutu ruutu : ruudut) {
            if (ruutu.getX() == x && ruutu.getY() == y) {
                return ruutu;
            }
        }
        return null;
    }

}
