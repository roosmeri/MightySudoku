
package fi.mightysudoku.kayttoliittyma;

import java.awt.HeadlessException;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class SudokuFrame extends JFrame{
    private final int alustankoko = 9;
    private JTextField[][] alustanruudut = new JTextField[alustankoko][alustankoko];
    
    public SudokuFrame(String otsikko) throws HeadlessException {
        super(otsikko);
    }
    
    
    
}
