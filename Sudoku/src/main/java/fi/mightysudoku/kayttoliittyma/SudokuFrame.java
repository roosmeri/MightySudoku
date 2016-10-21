package fi.mightysudoku.kayttoliittyma;

import fi.mightysudoku.logiikka.Pelialusta;
import fi.mightysudoku.logiikka.Ruutu;
import fi.mightysudoku.logiikka.SudokuGeneraattori;
import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.ParseException;
import java.util.Random;
import java.util.logging.Level;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Luokka on JFramen aliluokka, joka muodostaa visuaalisen esityksen pelistä.
 *
 * @author Viliina
 */
public class SudokuFrame extends JFrame {

    private Pelialusta alusta = new Pelialusta();
    private SudokuGeneraattori generaattori;
    private JTextField[][] alustanruudut;
    private final int ruudunkoko = 80;
    private final int korkeus = ruudunkoko * 9;
    private final int leveys = ruudunkoko * 9;
    private final Font fontti = new Font("Monospaced", Font.BOLD, 28);
    private int[][] numerot = new int[9][9];
    private JButton tyhjenna;

    /**
     * Konstruktori asettaa otsikon ja asettaa numerot kohdilleen
     * sudokuruudukkoon ja kysyy sitten Kayttajalta vaikeustasoa jonka
     * perusteella valmiit numerot asetetaan ruudukkoon.
     *
     * @param otsikko On ikkunan otsikko.
     * @throws HeadlessException .
     */
    public SudokuFrame(String otsikko) throws HeadlessException {
        super(otsikko);
        this.alustanruudut = new JTextField[9][9];
        sisallonAsetus();
        Object[] vaihtoehdot = {"Helppo", "Keskitaso", "Vaikea"};
        String taso = (String) JOptionPane.showInputDialog(this, "Minkä tasoista sudokua haluat pelata?", "Uusi peli", JOptionPane.PLAIN_MESSAGE, null, vaihtoehdot, "Helppo");
        if (taso != null && taso.length() > 0) {
            if (taso.equals("Helppo")) {
                asetanumerot(1);
            } else if (taso.equals("Keskitaso")) {
                asetanumerot(2);
            } else if (taso.equals("Vaikea")) {
                asetanumerot(3);
            }
        } else {
            return;
        }
    }

    /**
     * Metodi määrittelee Container-olion, sen ulkomuodon,kutsuu sitten
     * sudokuruudukon asettavaa metodia luoRuudukko(Container container) ja
     * sitten alareunamenun luovaa metodia luoPainikkeet(Container container).
     *
     */
    public void sisallonAsetus() {
        Container container = getContentPane();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        luoRuudukko(container);
        luoPainikkeet(container);
        container.setPreferredSize(new Dimension(leveys, korkeus + 100));
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void luoPainikkeet(Container container) {
        JPanel painikePaneeli = new JPanel();
        painikePaneeli.setLayout(new GridLayout(1, 3));
        painikePaneeli.setPreferredSize(new Dimension(720, 100));
        container.add(painikePaneeli);
        JButton lopeta = new JButton("Lopeta");
        JButton uusipeli = new JButton("Uusi peli");
        tyhjenna = new JButton("Aloita alusta");
        lopeta.setFont(new Font("Monospaced", Font.BOLD, 20));
        uusipeli.setFont(new Font("Monospaced", Font.BOLD, 20));
        tyhjenna.setFont(new Font("Monospaced", Font.BOLD, 20));
        ActionListener nappulakuuntelija = new MenuNappulaKuuntelija(this);

        lopeta.addActionListener(nappulakuuntelija);
        uusipeli.addActionListener(nappulakuuntelija);
        tyhjenna.addActionListener(nappulakuuntelija);
        painikePaneeli.add(tyhjenna);
        painikePaneeli.add(uusipeli);
        painikePaneeli.add(lopeta);
    }

    private void luoRuudukko(Container container) {
        JPanel sudokuruudukko = new JPanel();
        sudokuruudukko.setLayout(new GridLayout(9, 9));
        sudokuruudukko.setPreferredSize(new Dimension(korkeus, leveys));
        container.add(sudokuruudukko);
        KeyListener numerokuuntelija = new NumeronAsetusKuuntelija(this);
        for (int rivi = 0; rivi < 9; ++rivi) {
            for (int sarake = 0; sarake < 9; ++sarake) {
                alustanruudut[rivi][sarake] = new JTextField();
                asetaReunat(rivi, sarake);
                sudokuruudukko.add(alustanruudut[rivi][sarake]);
                if (numerot[rivi][sarake] == (0)) {
                    alustanruudut[rivi][sarake].setText("");
                    alustanruudut[rivi][sarake].setEditable(true);
                    alustanruudut[rivi][sarake].setBackground(Color.WHITE);
                    alustanruudut[rivi][sarake].addKeyListener(numerokuuntelija);
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
    }

    private void asetaReunat(int rivi, int sarake) {
        alustanruudut[rivi][sarake].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        if (rivi == 2 || rivi == 5) {
            alustanruudut[rivi][sarake].setBorder(BorderFactory.createMatteBorder(1, 1, 3, 1, Color.BLACK));
        }
        if (sarake == 2 || sarake == 5) {
            if (rivi == 2 || rivi == 5) {
                alustanruudut[rivi][sarake].setBorder(BorderFactory.createMatteBorder(1, 1, 3, 3, Color.BLACK));
            } else {
                alustanruudut[rivi][sarake].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 3, Color.BLACK));
            }
        }
    }

    /**
     * Metodi käyttää SudokuGeneraattoria uuden pelialustan luomiseen
     * vaikeustason mukaan. Asettaa ruutujen arvot numeroruudukkoon.
     *
     * @param taso Vaikeustaso.
     */
    public void asetanumerot(int taso) {
        tyhjenna.setEnabled(true);
        generoiPelialusta(taso);
        this.alusta = generaattori.getAlusta();
        for (Ruutu ruutu : alusta.getRuudut()) {
            numerot[ruutu.getX()][ruutu.getY()] = ruutu.getArvo();
        }
        for (int rivi = 0; rivi < 9; ++rivi) {
            for (int sarake = 0; sarake < 9; ++sarake) {
                if (numerot[rivi][sarake] == (0)) {
                    alustanruudut[rivi][sarake].setText("");
                    alustanruudut[rivi][sarake].setEditable(true);
                    alustanruudut[rivi][sarake].setBackground(Color.WHITE);
                } else {
                    alustanruudut[rivi][sarake].setText(numerot[rivi][sarake] + "");
                    alustanruudut[rivi][sarake].setEditable(false);
                    alustanruudut[rivi][sarake].setBackground(Color.LIGHT_GRAY);
                    alustanruudut[rivi][sarake].setForeground(Color.BLACK);
                }
            }

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
     * Metodi palauttaa JTextField:in joka sijaitsee kohdassa x,y.
     *
     * @param x x-koordinaatti.
     * @param y y-koordinaatti.
     * @return JTextField annetussa sijainnissa.
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
                if (getTextFieldAt(i, j).getBackground() == Color.red
                        || getTextFieldAt(i, j).getBackground() == Color.WHITE) {
                    return false;
                }
            }
        }
        lukitseKaikkiRuudut();
        tyhjenna.setEnabled(false);
        return true;

    }

    private void lukitseKaikkiRuudut() {
        for (int i = 0; i < alustanruudut.length; i++) {
            for (int j = 0; j < alustanruudut.length; j++) {
                getTextFieldAt(i, j).setEditable(false);
            }
        }
    }

    /**
     * Metodi tyhjentää kaikki käyttäjän täytettävissä olleet ruudut.
     */
    public void tyhjennaTaytetyt() {
        for (int i = 0; i < alustanruudut.length; i++) {
            for (int j = 0; j < alustanruudut.length; j++) {
                if (getTextFieldAt(i, j).isEditable()) {
                    getTextFieldAt(i, j).setText("");
                    getTextFieldAt(i, j).setBackground(Color.WHITE);
                    alusta.haeRuutu(i, j).setArvo(0);
                }
            }

        }
    }
}
