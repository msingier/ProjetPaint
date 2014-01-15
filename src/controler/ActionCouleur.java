package controler;

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import model.Model;

public class ActionCouleur extends AbstractAction{
	Color couleur_actuelle;
	Model model;
	
	public ActionCouleur(Model model, String couleur) {
		this.model = model;
		
		switch (couleur) {
		  	case "rouge":
		  		this.couleur_actuelle = Color.RED;
		  		break;
		  	case "magenta":
		  		this.couleur_actuelle = Color.MAGENTA;
		  		break;
		  	case "vert":
		  		this.couleur_actuelle = Color.GREEN;
		  		break;  
		  	case "bleu":
		  		this.couleur_actuelle = Color.BLUE;
		  		break;
		  	case "cyan":
		  		this.couleur_actuelle = Color.CYAN;
		  		break;
		  	case "rose":
		  		this.couleur_actuelle = Color.PINK;
		  		break; 
		  	case "blanc":
		  		this.couleur_actuelle = Color.WHITE;
		  		break;
		  	case "gris":
		  		this.couleur_actuelle = Color.GRAY;
		  		break; 
		  	case "jaune":
		  		this.couleur_actuelle = Color.YELLOW;
		  		break; 
		  	case "orange":
		  		this.couleur_actuelle = Color.ORANGE;
		  		break;
		  	case "grisClair":
		  		this.couleur_actuelle = Color.LIGHT_GRAY;
		  		break;
		  	default :
		  		this.couleur_actuelle = Color.BLACK;     
		}
	}
	
	public void actionPerformed(ActionEvent arg0) {
		this.model.setColor(couleur_actuelle);
	}
}
