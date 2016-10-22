package fi.mightysudoku.logiikkaTest;

import fi.mightysudoku.logiikka.Pelialusta;
import fi.mightysudoku.logiikka.Rivi;
import fi.mightysudoku.logiikka.Ruutu;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class RiviTest {

    Rivi rivi;

    public RiviTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        Pelialusta alusta = new Pelialusta();
        rivi = alusta.getRivit().get(2);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void toimiikoOnkoArvoJoJosOn() {
        rivi.getRuudut().get(0).setArvo(8);
        rivi.getRuudut().get(4).setArvo(8);
        rivi.getRuudut().get(5).setArvo(4);
        assertTrue(rivi.onkoArvoJo(rivi.getRuudut().get(4), 8));

    }

    @Test
    public void toimiikoOnkoArvoJoJosEiOle() {
        rivi.getRuudut().get(0).setArvo(8);
        rivi.getRuudut().get(0).setArvo(7);
        assertFalse(rivi.onkoArvoJo(rivi.getRuudut().get(0), 8));

    }

    @Test
    public void onkoGetRivitunnusPalautusOikea() {
        int vastaus = rivi.getRuudut().get(0).getY();

        assertEquals(vastaus, rivi.getRivitunnus());

    }
}
