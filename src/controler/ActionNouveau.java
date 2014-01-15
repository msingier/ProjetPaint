package controler;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

public class ActionNouveau extends AbstractAction{
	public ActionNouveau() {
		putValue(NAME, "Nouveau");
		putValue(SHORT_DESCRIPTION, "Crée un nouveau fichier");
	}
	
	public void actionPerformed(ActionEvent arg0) {
		
	}
}
