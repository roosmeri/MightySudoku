package fi.mightysudoku.logiikka;

public class Ruutu {

    private int arvo = 0;
    private int x = 0;
    private int y = 0;

    public Ruutu(int x, int y) {
        this.x = x;
        this.y = y;
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
        //tawrkistetaan, että ruutuun asetettava arvo on väliltä [1,9]
        if (arvo > 0 && arvo < 10) {
            this.arvo = arvo;
        } else {
            System.out.println("Numeron tulee olla väliltä 1-9.");
        }
    }

}
