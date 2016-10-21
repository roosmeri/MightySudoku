package fi.mightysudoku.kayttoliittyma;

import fi.mightysudoku.logiikka.Ruutu;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * Luokka kuuntelee käyttöliittymässä tapahtuvia numeroasetuksia.
 *
 * @author Viliina
 */
public class NumeronAsetusKuuntelija implements KeyListener {

    private SudokuFrame sudoku;

    /**
     * Konstruktori asettaa SudokuFrame olion.
     *
     * @param sudoku SudokUFrame.
     */
    public NumeronAsetusKuuntelija(SudokuFrame sudoku) {
        this.sudoku = sudoku;

    }

    /**
     * Metodi etsii ruudun johon pelaaja asetti arvon ja tarkistaa käykö arvo.
     * Ilmoittaa myös jos peli ratkaistiin siirrolla.
     *
     * @param e Numeroasetus.
     */
    @Override
    public void keyTyped(KeyEvent e) {

        JTextField valitturuutu = (JTextField) e.getSource();

        boolean found = false;
        int x = -1;
        int y = -1;
        for (int rivi = 0; rivi < 9 && !found; ++rivi) {
            for (int sarake = 0; sarake < 9 && !found; ++sarake) {
                if (this.sudoku.getTextFieldAt(rivi, sarake) == valitturuutu) {
                    x = rivi;
                    y = sarake;
                    found = true;
                }
            }
        }
        Ruutu ruutu = sudoku.getAlusta().haeRuutu(x, y);
        String syotetty = sudoku.getTextFieldAt(x, y).getText();
        if (syotetty.length() > 1) {
            sudoku.getTextFieldAt(x, y).setText("");
            sudoku.getTextFieldAt(x, y).setBackground(Color.WHITE);
        } else if (syotetty.isEmpty()) {
            ruutu.setArvo(0);
            sudoku.getTextFieldAt(x, y).setBackground(Color.WHITE);
        } else if (Character.digit(syotetty.charAt(0), 10) < 10 && Character.digit(syotetty.charAt(0), 10) > 0) {

            if (sudoku.getAlusta().asetaArvo(ruutu, Integer.parseInt(syotetty))) {
                sudoku.getTextFieldAt(x, y).setBackground(Color.green);
            } else {
                sudoku.getAlusta().haeRuutu(x, y).setArvo(Integer.parseInt(syotetty));
                sudoku.getTextFieldAt(x, y).setBackground(Color.red);
            }
        } else {
            sudoku.getTextFieldAt(x, y).setText("");;
        }

        if (sudoku.onkoRatkaistu()) {
            JOptionPane.showMessageDialog(sudoku, "Ratkaisit sudokun!");

        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
