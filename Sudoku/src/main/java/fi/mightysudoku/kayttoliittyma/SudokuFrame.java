package fi.mightysudoku.kayttoliittyma;

import fi.mightysudoku.logiikka.Pelialusta;
import fi.mightysudoku.logiikka.Ruutu;
import fi.mightysudoku.logiikka.SudokuGeneraattori;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 * Luokka on JFramen aliluokka, joka muodostaa visuaalisen esityksen pelistä.
 *
 * @author Viliina
 */
public class SudokuFrame extends JFrame {

    private Pelialusta alusta = new Pelialusta();
    private SudokuGeneraattori generaattori = new SudokuGeneraattori(alusta);
    private JTextField[][] alustanruudut;
    private final int ruudunkoko = 50;
    private final int korkeus = ruudunkoko * 9;
    private final int leveys = ruudunkoko * 9;
    private int[][] numerot = new int[9][9];

    /**
     * Konstruktori asettaa otsikon ja asettaa numerot kohdilleen
     * sudokuruudukkoon.
     *
     * @param otsikko On ikkunan otsikko.
     * @throws HeadlessException .
     */
    public SudokuFrame(String otsikko) throws HeadlessException {
        super(otsikko);
        asetanumerot();
        this.alustanruudut = new JTextField[9][9];
        Container cp = getContentPane();
        cp.setLayout(new GridLayout(9, 9));
        for (int rivi = 0; rivi < 9; ++rivi) {
            for (int sarake = 0; sarake < 9; ++sarake) {
                alustanruudut[rivi][sarake] = new JTextField();
                cp.add(alustanruudut[rivi][sarake]);
                if (alustanruudut[rivi][sarake].equals("0")) {
//                if (varatut[rivi][sarake]) {
                    alustanruudut[rivi][sarake].setText("");
                    alustanruudut[rivi][sarake].setEditable(true);
                    alustanruudut[rivi][sarake].setBackground(Color.BLACK);

                    // actionlisteneri tanne
                } else {
                    alustanruudut[rivi][sarake].setText(numerot[rivi][sarake] + "");
                    alustanruudut[rivi][sarake].setEditable(false);
                    alustanruudut[rivi][sarake].setBackground(Color.BLACK);
                    alustanruudut[rivi][sarake].setForeground(Color.WHITE);
                }
                alustanruudut[rivi][sarake].setHorizontalAlignment(JTextField.CENTER);
            }
        }

        cp.setPreferredSize(new Dimension(korkeus, leveys));
        pack();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

    /**
     * Metodi asettaa Ruutu olioiden arvot niitä vastaaviin JTextField-olioihin.
     */
    public void asetanumerot() {
        for (Ruutu ruutu : alusta.getRuudut()) {
            numerot[ruutu.getX()][ruutu.getY()] = ruutu.getArvo();
        }
    }

    public Pelialusta getAlusta() {
        return alusta;
    }

}
