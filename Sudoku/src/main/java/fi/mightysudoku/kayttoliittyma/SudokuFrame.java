package fi.mightysudoku.kayttoliittyma;

import fi.mightysudoku.logiikka.Pelialusta;
import fi.mightysudoku.logiikka.Ruutu;
import fi.mightysudoku.logiikka.SudokuGeneraattori;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.logging.Level;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.text.NumberFormatter;

/**
 * Luokka on JFramen aliluokka, joka muodostaa visuaalisen esityksen pelistä.
 *
 * @author Viliina
 */
public class SudokuFrame extends JFrame {

    private Pelialusta alusta = new Pelialusta();
    private SudokuGeneraattori generaattori = new SudokuGeneraattori(alusta);
    private JFormattedTextField[][] alustanruudut;
    private final int ruudunkoko = 60;
    private final int korkeus = ruudunkoko * 9;
    private final int leveys = ruudunkoko * 9;
    private final Font fontti = new Font("Monospaced", Font.BOLD, 25);
    private int[][] numerot = new int[9][9];
    private ActionListener numerokuuntelija = new NumeronAsetusKuuntelija(this);
    private NumberFormatter vainNumerot = new NumberFormatter(NumberFormat.getInstance());

    /**
     * Konstruktori asettaa otsikon ja asettaa numerot kohdilleen
     * sudokuruudukkoon.
     *
     * @param otsikko On ikkunan otsikko.
     * @throws HeadlessException .
     */
    public SudokuFrame(String otsikko) throws HeadlessException {
        super(otsikko);
        rajoitaSyotteenMuotoilua();
        asetanumerot();
        this.alustanruudut = new JFormattedTextField[9][9];
        sisallonAsetus();

    }

    public void rajoitaSyotteenMuotoilua() {
        vainNumerot.setValueClass(Integer.class);
        vainNumerot.setMinimum(1);
        vainNumerot.setMaximum(9);
    }

    /**
     * Metodi määrittelee Container-olion, asettaa JTextField-ruudut
     * muokattavaksi, jos niissä ei ollut valmiina asetettua arvoa. Metodi myös
     * määrittelee ruudukon ja ruutujen ulkomuodon.
     *
     */
    public void sisallonAsetus() {
        Container container = getContentPane();
        container.setLayout(new GridLayout(9, 9));
        for (int rivi = 0; rivi < 9; ++rivi) {
            for (int sarake = 0; sarake < 9; ++sarake) {
                alustanruudut[rivi][sarake] = new JFormattedTextField(vainNumerot);
                container.add(alustanruudut[rivi][sarake]);
                if (numerot[rivi][sarake] == (0)) {
                    alustanruudut[rivi][sarake].setText("");
                    alustanruudut[rivi][sarake].setEditable(true);
                    alustanruudut[rivi][sarake].setBackground(Color.WHITE);

                    alustanruudut[rivi][sarake].addActionListener(numerokuuntelija);
                } else {
                    alustanruudut[rivi][sarake].setText(numerot[rivi][sarake] + "");
                    alustanruudut[rivi][sarake].setEditable(false);
                    alustanruudut[rivi][sarake].setBackground(Color.LIGHT_GRAY);
                    alustanruudut[rivi][sarake].setForeground(Color.BLACK);
                }
                alustanruudut[rivi][sarake].setHorizontalAlignment(JTextField.CENTER);
                alustanruudut[rivi][sarake].setFont(fontti);
            }
        }

        container.setPreferredSize(new Dimension(korkeus, leveys));
        pack();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    /**
     * Metodi kutsuu asettaa ensin Pelialustaksi SudokuGeneraattorin antaman
     * alustan. Metodi asettaa Ruutu olioiden arvot niitä vastaaviin
     * JTextField-olioihin.
     */
    public void asetanumerot() {
        this.alusta = generaattori.generoiPelialusta();
        for (Ruutu ruutu : alusta.getRuudut()) {
            numerot[ruutu.getX()][ruutu.getY()] = ruutu.getArvo();
        }
    }

    public Pelialusta getAlusta() {
        return alusta;
    }

    public JTextField getTextFieldAt(int x, int y) {
        return alustanruudut[x][y];
    }

}
