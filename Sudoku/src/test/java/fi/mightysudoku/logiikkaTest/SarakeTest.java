/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.mightysudoku.logiikkaTest;

import fi.mightysudoku.logiikka.Pelialusta;
import fi.mightysudoku.logiikka.Sarake;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Viliina
 */
public class SarakeTest {

    Sarake sarake;

    public SarakeTest() {
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
        sarake = alusta.getSarakkeet().get(1);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void toimiikoOnkoArvoJoJosOn() {
        sarake.getRuudut().get(0).setArvo(6);
        sarake.getRuudut().get(4).setArvo(6);
        sarake.getRuudut().get(5).setArvo(3);
        assertTrue(sarake.onkoArvoJo(sarake.getRuudut().get(4), 6));

    }

    @Test
    public void toimiikoOnkoArvoJoJosEiOle() {
        sarake.getRuudut().get(0).setArvo(8);
        sarake.getRuudut().get(0).setArvo(7);
        assertFalse(sarake.onkoArvoJo(sarake.getRuudut().get(0), 8));

    }

    @Test
    public void onkoGetRivitunnusPalautusOikea() {
        int vastaus = sarake.getRuudut().get(0).getX();

        assertEquals(vastaus, sarake.getSaraketunnus());
    }
}
