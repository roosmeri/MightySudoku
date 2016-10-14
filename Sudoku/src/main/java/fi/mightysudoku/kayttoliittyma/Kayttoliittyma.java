package fi.mightysudoku.kayttoliittyma;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

/**
 * Käyttöliittymä.
 *
 * @author Viliina
 */
public class Kayttoliittyma implements Runnable {

    private SudokuFrame frame;
    //private SudokuFramePanel frame;

    /**
     * Käyttöliittymän konstruktori ei tee mitään.
     */

    public Kayttoliittyma() {
    }

    @Override
    public void run() {
        frame = new SudokuFrame("Mighty Sudoku");
    }

    public SudokuFrame getFrame() {
        return frame;
    }

}
