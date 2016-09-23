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

        assertEquals("18", vastaus);
    }

//    @Test
//    //tämä ei toimi vielä oikein
//    public void luoRuudukotLuoRuudukotOikein() {
//        this.alusta = new Pelialusta();
//        String vastaus = "" + alusta.getRuudukot().size();
//
//        assertEquals("9", vastaus);
//    }
}
