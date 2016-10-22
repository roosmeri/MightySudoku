/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.mightysudoku.kayttoliittyma;

import fi.mightysudoku.logiikka.Ruutu;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * Luokka kuuntelee JTextFrame-ruutuihin asetettuja syötteitä.
 *
 * @author Viliina
 */
public class SyoteKuuntelija implements ActionListener {

    SudokuFrame sudoku;

    /**
     * Konstruktori asettaa SudokuFrame olion.
     *
     * @param sudoku SudokuFrame.
     */
    public SyoteKuuntelija(SudokuFrame sudoku) {
        this.sudoku = sudoku;
    }

    /**
     * Metodi etsii ruudun johon pelaaja asetti arvon ja tarkistaa käykö arvo.
     * Ilmoittaa myös jos peli ratkaistiin siirrolla ja kutsuu SudokuFramen
     * metodia onko ratkaistu, joka lukitsee ruudukon ruudut jos on ratkaistu.
     *
     * @param e Numeroasetus.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
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

}
