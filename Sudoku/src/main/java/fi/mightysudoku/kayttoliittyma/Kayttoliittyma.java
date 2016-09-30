package fi.mightysudoku.kayttoliittyma;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

public class Kayttoliittyma implements Runnable {

    private SudokuFrame frame;

    public Kayttoliittyma() {
    }

    @Override
    public void run() {
        frame = new SudokuFrame("Mighty Sudoku");
        frame.setPreferredSize(new Dimension(500, 500));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //luoKomponentit(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }

    public SudokuFrame getFrame() {
        return frame;
    }

}
