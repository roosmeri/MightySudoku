package fi.mightysudoku.logiikkaTest;

import fi.mightysudoku.logiikka.Pelialusta;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PelialustaTest {

    Pelialusta alusta;

    public PelialustaTest() {
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
    public void kontruktoriLuoAlustanKaikkiKomponentit() {
        this.alusta = new Pelialusta();

        assertNotNull(alusta.getRivit());
        assertNotNull(alusta.getRuudut());
        assertNotNull(alusta.getRuudukot());
    }

    @Test
    public void luoRuudutLuoRuudutOikein() {
        this.alusta = new Pelialusta();
        String vastaus = "" + alusta.getRuudut().size();

        assertEquals("81", vastaus);
    }

    @Test
    public void luoRivitLuoRivitOikein() {
        this.alusta = new Pelialusta();
        String vastaus = "" + alusta.getRivit().size();

        assertEquals("9", vastaus);
    }

    @Test
    public void luoRivitLuoSarakkeetOikein() {
        this.alusta = new Pelialusta();
        String vastaus = "" + alusta.getSarakkeet().size();

        assertEquals("9", vastaus);
    }

    @Test
    public void luoRuudukotLuoRuudukotOikein() {
        this.alusta = new Pelialusta();
        String vastaus = "" + alusta.getRuudukot().size();

        assertEquals("9", vastaus);
    }

    @Test
    public void numeronAsetusEiToimiJosArvoOnJoRivissa() {
        this.alusta = new Pelialusta();
        alusta.asetaArvo(alusta.getRivit().get(0).getRuudut().get(2), 4);
        alusta.asetaArvo(alusta.getRivit().get(0).getRuudut().get(0), 4);
        assertEquals(0, alusta.getRivit().get(0).getRuudut().get(0).getArvo());
    }

    @Test
    public void numeronAsetusEiToimiJosArvoOnJoSarakkeessa() {
        this.alusta = new Pelialusta();
        alusta.asetaArvo(alusta.getSarakkeet().get(0).getRuudut().get(2), 5);
        alusta.asetaArvo(alusta.getSarakkeet().get(0).getRuudut().get(7), 5);
        assertEquals(0, alusta.getSarakkeet().get(0).getRuudut().get(7).getArvo());
    }

    @Test
    public void numeronAsetusEiToimiJosArvoOnJoRuudukossa() {
        this.alusta = new Pelialusta();
        alusta.asetaArvo(alusta.getRuudukot().get(0).getRuudut().get(3), 4);
        alusta.asetaArvo(alusta.getRuudukot().get(0).getRuudut().get(5), 4);
        assertEquals(0, alusta.getRuudukot().get(0).getRuudut().get(0).getArvo());
    }

//    @Test
//    public void numeronAsetusToimii() {
//        //joku on pielessä.
//        this.alusta = new Pelialusta();
//        alusta.asetaArvo(alusta.getRivit().get(0).getRuudut().get(2), 4);
//        alusta.asetaArvo(alusta.getRuudukot().get(0).getRuudut().get(0), 6);
//        alusta.asetaArvo(alusta.getSarakkeet().get(0).getRuudut().get(5), 9);
//        assertEquals(4, alusta.getRivit().get(0).getRuudut().get(2).getArvo());
//        assertEquals(6, alusta.getRuudukot().get(0).getRuudut().get(0).getArvo());
//        assertEquals(9, alusta.getSarakkeet().get(0).getRuudut().get(6).getArvo());
//    }
}
