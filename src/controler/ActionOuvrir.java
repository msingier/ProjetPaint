package controler;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

import javax.swing.AbstractAction;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import model.ListeDessin;
import model.Model;

public class ActionOuvrir extends AbstractAction{
	private Model model;
	
	public ActionOuvrir(Model model) {
		this.model = model;
		
		putValue(NAME, "Ouvrir");
		putValue(SHORT_DESCRIPTION, "Ouvrir un fichier existant");
	}
	
	public void actionPerformed(ActionEvent arg0) {
		if ( model.getEnregistre() ) { // Si le travail est enregistré
			ouvrir();
		} else {
			Object[] options = {"Enregistrer", "Ne pas enregistrer", "Annuler"};
			int n = JOptionPane.showOptionDialog(new JFrame(), 
					"Souhaitez-vous vraiment ouvrir un fichier sans enregistrer ?", 
					"Ouvrir", 
					JOptionPane.YES_NO_CANCEL_OPTION, 
					JOptionPane.QUESTION_MESSAGE, 
					null, 
					options, options[0]);
						
			if ( n == 0 ) {
				new ActionEnregistrer(model).enregistrer();
			}
			ouvrir();
		}
	}
	
	public void ouvrir() {

		JFileChooser filechoose = new JFileChooser();
		String extension = model.getExtension(), nom_du_fichier = "Nom du fichier" + extension; 
		filechoose.setSelectedFile(new File(nom_du_fichier));

		String approve = new String("Ouvrir");
		String monFichier = ""; 
		int resultatOuvrir = filechoose.showDialog(filechoose, approve); 
		
		if(resultatOuvrir == JFileChooser.APPROVE_OPTION) { 
			monFichier = filechoose.getSelectedFile().toString(); 
			this.fluxOuverture(monFichier);
		}
	}
	
	public void fluxOuverture(String monFichier) {
		try {
			FileInputStream fichier = new FileInputStream(monFichier);
			ObjectInputStream ois = new ObjectInputStream(fichier);
			ListeDessin listeDessin = (ListeDessin) ois.readObject();
			model.setListeDessin(listeDessin);
		} catch (java.io.IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
				
		}
	}
}
