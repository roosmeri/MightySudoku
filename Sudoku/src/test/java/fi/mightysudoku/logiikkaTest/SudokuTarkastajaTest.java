package fi.mightysudoku.logiikkaTest;

import fi.mightysudoku.logiikka.Pelialusta;
import fi.mightysudoku.logiikka.Ruutu;
import fi.mightysudoku.logiikka.SudokuGeneraattori;
import fi.mightysudoku.logiikka.SudokuTarkastaja;
import java.util.ArrayList;
import java.util.HashSet;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class SudokuTarkastajaTest {

    SudokuTarkastaja tarkastaja;
    Pelialusta alusta;
    SudokuGeneraattori generaattori;
    HashSet<Integer> mahdollisetNumerot;

    public SudokuTarkastajaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        this.alusta = new Pelialusta();
        this.generaattori = new SudokuGeneraattori(alusta, 35);
        this.mahdollisetNumerot = new HashSet();
        for (int i = 1; i < 10; i++) {
            this.mahdollisetNumerot.add(i);
        }

    }

    @After
    public void tearDown() {
    }

    @Test
    public void ratkaisulistanEkaOnOK() {
        this.tarkastaja = new SudokuTarkastaja();
        if (tarkastaja.selviaako(alusta)) {
            for (ArrayList ruutulista : tarkastaja.getRatkaisut()) {
                assertTrue(ruutulista.size() == 35);

            }

        }
    }

    @Test
    public void selviaakoPalauttaaFalseJosMahdotonPeli() {
        this.alusta = new Pelialusta();
        this.tarkastaja = new SudokuTarkastaja();
        int[][] mahdotonpohja = {{5, 1, 6, 8, 4, 9, 7, 3, 2},
        {3, 0, 7, 6, 0, 5, 0, 0, 0},
        {8, 0, 9, 7, 0, 0, 0, 6, 5},
        {1, 3, 5, 0, 6, 0, 9, 0, 7},
        {4, 7, 2, 5, 9, 1, 0, 0, 6},
        {9, 6, 8, 3, 7, 0, 0, 5, 0},
        {2, 5, 3, 1, 8, 6, 0, 7, 4},
        {6, 8, 4, 2, 0, 7, 5, 0, 0},
        {7, 9, 1, 0, 5, 0, 6, 0, 8}};
        int x = 0;
        int y = 0;
        for (int i = 0; i < 81; i++) {
            if (x == 8) {
                if (y == 8) {
                    break;
                } else {
                    x = 0;
                    y++;
                }
            }
            this.alusta.getRuudut().get(i).setArvo(mahdotonpohja[x][y]);
            x++;
        }
        assertFalse(this.tarkastaja.selviaako(this.alusta));
    }
}
