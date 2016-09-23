package fi.mightysudoku.logiikkaTest;

import fi.mightysudoku.logiikka.Ruutu;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class RuutuTest {

    public RuutuTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void konstruktoriAsettaaKoordinaatitOikeinOikeilla() {
        Ruutu ruutu = new Ruutu(2, 3);
        String vastaus = "x:" + ruutu.getX() + " ja y:" + ruutu.getY();

        assertEquals("x:2 ja y:3", vastaus);
    }

    @Test
    public void konstruktoriEiAsetaKoordinaattejaHuonoilla() {
        Ruutu ruutu = new Ruutu(18, -7);
        String vastaus = "x:" + ruutu.getX() + " ja y:" + ruutu.getY();

        assertEquals("x:0 ja y:0", vastaus);
    }

    @Test
    public void konstruktoriEiAsetaKoordinaattejaHuonoilla2() {
        Ruutu ruutu = new Ruutu(9, 9);
        String vastaus = "x:" + ruutu.getX() + " ja y:" + ruutu.getY();

        assertEquals("x:0 ja y:0", vastaus);
    }

    @Test
    public void setArvoAsettaaOikeanArvonMaksimilla() {
        Ruutu ruutu = new Ruutu(2, 3);
        ruutu.setArvo(9);
        String vastaus = "" + ruutu.getArvo();

        assertEquals("9", vastaus);
    }

    @Test
    public void setArvoAsettaaOikeanArvonMinimilla() {
        Ruutu ruutu = new Ruutu(2, 3);
        ruutu.setArvo(1);
        String vastaus = "" + ruutu.getArvo();

        assertEquals("1", vastaus);
    }

    @Test
    public void setArvoEiMuutaArvoaVaarallaArvolla() {
        Ruutu ruutu = new Ruutu(2, 3);
        ruutu.setArvo(10);
        ruutu.setArvo(0);
        String vastaus = "" + ruutu.getArvo();

        assertEquals("0", vastaus);
    }

    @Test
    public void getArvoPalauttaaOikeanArvon() {
        Ruutu ruutu = new Ruutu(2, 3);
        ruutu.setArvo(7);
        String vastaus = "" + ruutu.getArvo();

        assertEquals("7", vastaus);
    }

    @Test
    public void getArvoPalauttaaNollanJosMuutaArvoaEiAsetettu() {
        Ruutu ruutu = new Ruutu(2, 3);
        String vastaus = "" + ruutu.getArvo();

        assertEquals("0", vastaus);
    }

    @Test
    public void getXPalauttaaOikeanKoordinaatin() {
        Ruutu ruutu = new Ruutu(2, 3);
        String vastaus = "" + ruutu.getX();

        assertEquals("2", vastaus);
    }

    @Test
    public void getYPalauttaaOikeanKoordinaatin() {
        Ruutu ruutu = new Ruutu(2, 3);
        String vastaus = "" + ruutu.getY();

        assertEquals("3", vastaus);
    }

    @Test
    public void toStringMetodiTuottaaOikeanStringin() {
        Ruutu ruutu = new Ruutu(0, 6);
        ruutu.setArvo(7);

        assertEquals("Arvo:7, x:0, y:6", ruutu.toString());
    }
}
