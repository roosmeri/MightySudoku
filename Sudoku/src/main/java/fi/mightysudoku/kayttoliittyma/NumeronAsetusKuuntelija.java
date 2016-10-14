package fi.mightysudoku.kayttoliittyma;

import fi.mightysudoku.logiikka.Ruutu;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;

public class NumeronAsetusKuuntelija implements ActionListener {

    private SudokuFrame sudoku;

    public NumeronAsetusKuuntelija(SudokuFrame sudoku) {
        this.sudoku = sudoku;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFormattedTextField valitturuutu = (JFormattedTextField) e.getSource();

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
        String syotetty = sudoku.getTextFieldAt(x, y).getText();
        if (syotetty.isEmpty()) {
            sudoku.getTextFieldAt(x, y).setBackground(Color.WHITE);
        }
        for (Ruutu ruutu : sudoku.getAlusta().getRuudut()) {
            if (ruutu.getY() == y && ruutu.getX() == x) {
                sudoku.getAlusta().asetaArvo(ruutu, Integer.parseInt(syotetty));
                if (ruutu.getArvo() == Integer.parseInt(syotetty)) {
                    sudoku.getTextFieldAt(x, y).setBackground(Color.green);
                } else {
                    sudoku.getTextFieldAt(x, y).setBackground(Color.red);
                }
                break;
            }
        }

    }
}
