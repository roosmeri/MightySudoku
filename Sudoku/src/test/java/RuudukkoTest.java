
import fi.mightysudoku.logiikka.Ruudukko;
import fi.mightysudoku.logiikka.Ruutu;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class RuudukkoTest {

    Ruudukko ruudukko;

    public RuudukkoTest() {
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
        int apu = 0;
        int apu2 = 0;
        for (int i = 0; i < 9; i++) {
            ruudut.add(new Ruutu(apu, apu2));
            if (i % 3 == 0) {
                apu++;
                apu2 = 0;
            }
        }
        this.ruudukko = new Ruudukko(ruudut);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void toimiikoOnkoArvoJoMetodiJosOn() {
        ruudukko.getRuudut().get(0).setArvo(3);
        String vastaus = "" + ruudukko.onkoArvoJo(3);

        assertEquals("true", vastaus);
    }

    @Test
    public void toimiikoOnkoArvoJoMetodiJosEiOle() {
        ruudukko.getRuudut().get(0).setArvo(4);
        String vastaus = "" + ruudukko.onkoArvoJo(3);

        assertEquals("false", vastaus);
    }
}
