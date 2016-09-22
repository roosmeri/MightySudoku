package fi.mightysudoku.logiikka;

public class Ruutu {

    private int arvo = 0;
    private int x = 0;
    private int y = 0;

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

    public void setArvo(int arvo) {
        //tarkistetaan, että ruutuun asetettava arvo on väliltä [1,9]
        // tulisi myös tietää onko tämän ruudun rivillä tai ruudukossa jo asetettava arvo
        if (arvo > 0 && arvo < 10) {
            this.arvo = arvo;
        } else {
            System.out.println("Numeron tulee olla väliltä 1-9.");
        }
    }

}
