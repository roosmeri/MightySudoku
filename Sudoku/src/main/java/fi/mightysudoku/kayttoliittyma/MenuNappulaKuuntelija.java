package fi.mightysudoku.kayttoliittyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 * Kuuntelija SudokuFramen menunappuloille.
 *
 * @author Viliina
 */
public class MenuNappulaKuuntelija implements ActionListener {

    SudokuFrame sudoku;

    /**
     * Konstruktori asettaa SudokuFramen kuuntelijalle.
     *
     * @param sudokuframe SudokuFrame.
     */
    public MenuNappulaKuuntelija(SudokuFrame sudokuframe) {
        this.sudoku = sudokuframe;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton painettu = (JButton) e.getSource();
        if (painettu.getText().equals("Lopeta")) {
            Object[] vaihtoehdot = {"Haluan", "En"};
            int varmistus = JOptionPane.showOptionDialog(sudoku, "Haluatko varmasti lopettaa?", "Lopeta Sudokun pelaaminen", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, vaihtoehdot, vaihtoehdot[0]);
            if (varmistus == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
            System.exit(0);
        } else if (painettu.getText().equals("Aloita alusta")) {
            Object[] vaihtoehdot = {"Haluan", "En"};
            int varmistus = JOptionPane.showOptionDialog(sudoku, "Haluatko varmasti aloittaa alusta?", "Aloita tämä peli alusta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, vaihtoehdot, vaihtoehdot[0]);
            if (varmistus == JOptionPane.YES_OPTION) {
                sudoku.tyhjennaTaytetyt();
            }
        } else if (painettu.getText().equals("Uusi peli")) {
            Object[] vaihtoehdot = {"Helppo", "Keskitaso", "Vaikea"};
            String taso = (String) JOptionPane.showInputDialog(sudoku, "Minkä tasoista sudokua haluat pelata?", "Uusi peli", JOptionPane.PLAIN_MESSAGE, null, vaihtoehdot, "Helppo");
            if (taso != null && taso.length() > 0) {
                if (taso.equals("Helppo")) {
                    sudoku.asetanumerot(1);
                } else if (taso.equals("Keskitaso")) {
                    sudoku.asetanumerot(2);
                } else if (taso.equals("Vaikea")) {
                    sudoku.asetanumerot(3);
                }
            } else {
                return;
            }
        }
    }

}
