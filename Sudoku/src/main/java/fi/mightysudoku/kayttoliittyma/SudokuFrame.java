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
import java.util.Random;
import java.util.logging.Level;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.NumberFormatter;

/**
 * Luokka on JFramen aliluokka, joka muodostaa visuaalisen esityksen pelistä.
 *
 * @author Viliina
 */
public class SudokuFrame extends JFrame {

    private Pelialusta alusta = new Pelialusta();
    private SudokuGeneraattori generaattori;
    //private JFormattedTextField[][] alustanruudut;
    private JTextField[][] alustanruudut;
    private final int ruudunkoko = 80;
    private final int korkeus = ruudunkoko * 9;
    private final int leveys = ruudunkoko * 9;
    private final Font fontti = new Font("Monospaced", Font.BOLD, 28);
    private int[][] numerot = new int[9][9];
    private ActionListener numerokuuntelija = new NumeronAsetusKuuntelija(this);
    //private NumberFormatter vainNumerot = new NumberFormatter(NumberFormat.getInstance());

    /**
     * Konstruktori asettaa otsikon ja asettaa numerot kohdilleen
     * sudokuruudukkoon.
     *
     * @param otsikko On ikkunan otsikko.
     * @throws HeadlessException .
     */
    public SudokuFrame(String otsikko) throws HeadlessException {
        super(otsikko);
        //rajoitaSyotteenMuotoilua();
        asetanumerot(1);
        this.alustanruudut = new JTextField[9][9];
        sisallonAsetus();

    }

//    /**
//     * Metodi määrittelee formatteria syotteelle.
//     */
//    public void rajoitaSyotteenMuotoilua() {
//        vainNumerot.setValueClass(Integer.class);
//        vainNumerot.setAllowsInvalid(true);
//        vainNumerot.setMinimum(1);
//        vainNumerot.setMaximum(9);
//    }

    /**
     * Metodi määrittelee Container-olion, asettaa JTextField-ruudut
     * muokattavaksi, jos niissä ei ollut valmiina asetettua arvoa. Metodi myös
     * määrittelee ruudukon ja ruutujen ulkomuodon.
     *
     */
    public void sisallonAsetus() {
        Container container = getContentPane();
        container.setLayout(new GridLayout(10, 9));
        for (int rivi = 0; rivi < 9; ++rivi) {
            for (int sarake = 0; sarake < 9; ++sarake) {
                //alustanruudut[rivi][sarake] = new JFormattedTextField(vainNumerot);
                alustanruudut[rivi][sarake] = new JTextField();
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
        JPanel menu = luoMenu();
        container.add(menu);
        container.setPreferredSize(new Dimension(korkeus, leveys));
        pack();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private JPanel luoMenu() {
        //korjata pitää
        JPanel menuframe = new JPanel(new GridLayout(1, 3));
        menuframe.setOpaque(false);
        menuframe.setLayout(new GridLayout(1, 3));
        JButton lopeta = new JButton();
        menuframe.add(lopeta);
        menuframe.setFont(fontti);
        return menuframe;
    }

    /**
     * Metodi käyttää SudokuGeneraattoria uuden pelialustan luomiseen
     * vaikeustason mukaan. Asettaa ruutujen arvot numeroruudukkoon.
     *
     * @param taso Vaikeustaso.
     */
    public void asetanumerot(int taso) {
        generoiPelialusta(taso);

        this.alusta = generaattori.getAlusta();
        for (Ruutu ruutu : alusta.getRuudut()) {
            numerot[ruutu.getX()][ruutu.getY()] = ruutu.getArvo();
        }
    }

    private void generoiPelialusta(int taso) {
        Random r = new Random();
        if (taso == 1) {
            int tyhjia = r.nextInt((49 - 18) + 1) + 18;
            this.generaattori = new SudokuGeneraattori(alusta, tyhjia);
        } else if (taso == 2) {
            int tyhjia = r.nextInt((54 - 50) + 1) + 50;
            this.generaattori = new SudokuGeneraattori(alusta, tyhjia);
        } else if (taso == 3) {
            int tyhjia = r.nextInt((60 - 51) + 1) + 51;
            this.generaattori = new SudokuGeneraattori(alusta, tyhjia);
        }
    }

    public Pelialusta getAlusta() {
        return alusta;
    }

    /**
     * Metodi palauttaa JFormattedTextField:in joka sijaitsee kohdassa x,y.
     *
     * @param x x-koordinaatti.
     * @param y y-koordinaatti.
     * @return JFormattedTextField annetussa sijainnissa.
     */
    public JTextField getTextFieldAt(int x, int y) {
        return alustanruudut[x][y];
    }

    /**
     * Metodi tarkastamaan onko sudoku ratkaistu numeron asetuksen jälkeen.
     *
     * @return true jos yhtään puna- tai valkotaustaista ruutua ei löytnyt,
     * muuten false.
     */
    public boolean onkoRatkaistu() {
        for (int i = 0; i < alustanruudut.length; i++) {
            for (int j = 0; j < alustanruudut.length; j++) {
                if (getTextFieldAt(i, j).getBackground() == Color.red || getTextFieldAt(i, j).getBackground() == Color.WHITE) {
                    return false;
                }
            }
        }
        return true;

    }
}
