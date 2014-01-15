package ressources;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class JFileChooserOverwrite extends JFileChooser{
	public void approveSelection() {
        File file = this.getSelectedFile(); 
        
        if ( file.exists() ) {
            int answer = JOptionPane.showConfirmDialog(this, file + " existe déjà. Souhaitez-vous l'écraser ?", "Écraser",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
            
            if (answer != JOptionPane.OK_OPTION) {
                return;
            }
        }
        super.approveSelection(); 
    }
}
