package fi.mightysudoku.logiikkaTest;

import fi.mightysudoku.logiikka.Pelialusta;
import fi.mightysudoku.logiikka.SudokuGeneraattori;
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
        generaattori = new SudokuGeneraattori(alusta);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void konstruktoriToimii() {
        SudokuGeneraattori generaattori2 = new SudokuGeneraattori(alusta);
        assertTrue(alusta.equals(generaattori.getAlusta()));
    }

//    @Test
//    public void generointiToimii() {
//        Pelialusta generoitualusta = generaattori.generoiPelialusta();
//        for (int i = 0; i < 9; i++) {
//            assertTrue(0 < generoitualusta.getRuudut().get(i).getArvo());
//        }
//
//    }
}
