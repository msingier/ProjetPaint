package controler;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import javax.swing.AbstractAction;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import model.Model;
import ressources.ExtensionFileFilter;
import ressources.JFileChooserOverwrite;

public class ActionEnregistrer extends AbstractAction{
	private Model model;
	private String extension;
	// FileChooser
		private JFileChooser chooser;
		private FileNameExtensionFilter filter;
       
	public ActionEnregistrer(Model model) {
		this.model = model;
		this.extension = model.getExtension();
		
		// Values
		putValue(NAME, "Enregistrer");
		putValue(SHORT_DESCRIPTION, "Enregistre votre travail");
	}
	
	// Permets de donner un nom au fichier
	public void enregistrer() {
		// FileChooser
			JFileChooser filechoose = new JFileChooserOverwrite();
			String nom_du_fichier = "Nom du fichier" + extension;
			filechoose.setSelectedFile(new File(nom_du_fichier));
			String approve = new String("Enregistrer"); 
		// Extension
			ExtensionFileFilter filter = new ExtensionFileFilter("Fichiers .CTH", "cth");
		    filechoose.setFileFilter(filter);

		// DialogBox
		int resultatEnregistrer = filechoose.showDialog(filechoose,	approve);
		
		if (resultatEnregistrer == JFileChooser.APPROVE_OPTION) { 
			nom_du_fichier = new String(filechoose.getSelectedFile().toString());
			
		
			if(!nom_du_fichier.endsWith(extension) && !nom_du_fichier.endsWith(extension.toUpperCase())) {
				nom_du_fichier = nom_du_fichier + extension;
			}
			
			model.setEnregistre(true); // On marque dans le modèle que le fichier est enregistré
			fluxEnregistrement(nom_du_fichier); // On enregistre enfin le flux
		}
	}
	
	private void fluxEnregistrement(String nom_du_fichier) {
		try {
			FileOutputStream fichier = new FileOutputStream(nom_du_fichier);
			ObjectOutputStream oos = new ObjectOutputStream(fichier);
			oos.writeObject(model.getListeDessin());
			oos.flush();
			oos.close();
		} catch (java.io.IOException e) {
			e.printStackTrace();
		}
	}
	
	public void actionPerformed(ActionEvent arg0) {
		enregistrer();
	}
}
