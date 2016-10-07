package fi.mightysudoku.logiikka;

/**
 * Luokan edustaja edustaa Sudokuruudukon yhtä ruutua, jolla on koordinaatit ja
 * arvo väliltä [1,9].
 */
public class Ruutu {

    private int arvo = 0;
    private int x = 0;
    private int y = 0;

    /**
     * Konstruktori asettaa ruudun koordinaatit niiden ollessa väliltä [0,8].
     *
     * @param x x-koordinaatti
     * @param y y-koordinaatti
     */
    public Ruutu(int x, int y) {
        if (x >= 0 && x < 9) {
            this.x = x;
        }

        if (y >= 0 && y < 9) {
            this.y = y;
        }

    }

    public int getArvo() {
        return arvo;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    /**
     * Metodi asettaa arvon Ruudulle jos arvo on pätevä.
     *
     * @param arvo Asetettava arvo.
     */
    public void setArvo(int arvo) {
        if (arvo > 0 && arvo < 10) {
            this.arvo = arvo;
        }
    }

    /**
     * Metodi palauttaa ruudun tekstiesityksen.
     *
     * @return Ruudun arvo ja koordinaatit tekstiesityksenä.
     */
    @Override
    public String toString() {
        return "Arvo:" + getArvo() + ", x:" + getX() + ", y:" + getY();
    }

}
