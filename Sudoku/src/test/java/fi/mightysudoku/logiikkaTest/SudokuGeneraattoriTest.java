package fi.mightysudoku.logiikkaTest;

import fi.mightysudoku.logiikka.Pelialusta;
import fi.mightysudoku.logiikka.SudokuGeneraattori;
import java.util.Random;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class SudokuGeneraattoriTest {
    
    Pelialusta alusta;
    SudokuGeneraattori generaattori;
    
    public SudokuGeneraattoriTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        alusta = new Pelialusta();
        Random r = new Random();
        generaattori = new SudokuGeneraattori(alusta,r.nextInt((81 - 29) + 1) + 29);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void konstruktoriToimii() {
        SudokuGeneraattori generaattori2 = new SudokuGeneraattori(alusta,35);
        assertTrue(alusta.equals(generaattori.getAlusta()));
    }

    @Test
    public void generointiToimii() {
        Pelialusta generoitualusta = generaattori.getAlusta();
        for (int i = 0; i < 9; i++) {
            assertTrue(10 > generoitualusta.getRuudut().get(i).getArvo());
        }

    }

}
