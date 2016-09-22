package logiikkaTests;


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
        ArrayList<Ruutu> ruudut = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            ruudut.add(new Ruutu(0, i));
        }

        this.rivi = new Rivi(ruudut);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void toimiikoOnkoArvoJoJosOn() {
        rivi.getRuudut().get(0).setArvo(8);
        rivi.getRuudut().get(4).setArvo(8);
        rivi.getRuudut().get(5).setArvo(4);
        String vastaus = "" + rivi.onkoArvoJo(8);
        assertEquals("true", vastaus);

    }

    @Test
    public void toimiikoOnkoArvoJoJosEiOle() {
        rivi.getRuudut().get(0).setArvo(8);
        rivi.getRuudut().get(0).setArvo(7);
        String vastaus = "" + rivi.onkoArvoJo(8);
        assertEquals("false", vastaus);

    }
}
