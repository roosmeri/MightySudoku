
import fi.roosmeri.logiikka.Ruudukko;
import fi.roosmeri.logiikka.Ruutu;
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
        for (int i = 0; i < 9; i++) {
            ruudut.add(new Ruutu(apu, i));
            if (i % 3 == 0) {
                apu++;
            }
        }
        this.ruudukko = new Ruudukko(ruudut);
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
