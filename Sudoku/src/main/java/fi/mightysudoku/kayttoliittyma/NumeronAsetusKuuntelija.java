package fi.mightysudoku.kayttoliittyma;

import fi.mightysudoku.logiikka.Ruutu;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;

public class NumeronAsetusKuuntelija implements ActionListener {

    private SudokuFrame sudoku;

    public NumeronAsetusKuuntelija(SudokuFrame sudoku) {
        this.sudoku = sudoku;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JTextField source = (JTextField) e.getSource();

        boolean found = false;
        int valitturivi = -1;
        int valittusarake = -1;
        for (int rivi = 0; rivi < 9 && !found; ++rivi) {
            for (int sarake = 0; sarake < 9 && !found; ++sarake) {
                if (this.sudoku.getTextFieldAt(rivi,sarake) == source) {
                    valitturivi = rivi;
                    valittusarake = sarake;
                    found = true;
                }
            }
        }
        String syotetty = sudoku.getTextFieldAt(valitturivi, valittusarake).getText();
        for (Ruutu ruutu : sudoku.getAlusta().getRuudut()) {
            if (ruutu.getY() == valittusarake && ruutu.getX() == valitturivi) {
                sudoku.getAlusta().asetaArvo(ruutu, Integer.parseInt(syotetty));
                if (ruutu.getArvo() != 0) {
                    sudoku.getTextFieldAt(valitturivi, valittusarake).setBackground(Color.green);
                } else {
                    sudoku.getTextFieldAt(valitturivi, valittusarake).setBackground(Color.red);
                }
                break;
            }
        }

    }
}
