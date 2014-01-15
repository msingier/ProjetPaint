package controler;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import model.Model;

public class ActionForme extends AbstractAction{
	String forme;
	Model model;
	
	public ActionForme(Model model, String forme) {
		this.model = model;
		
		switch (forme) {
		  	case "rond":
		  		this.forme = "rond";
		  		break;
		  	case "carre":
		  		this.forme = "carre";
		  		break;   
		  	case "texte":
		  		this.forme = "texte";
		  		break;
		  	default :
		  		this.forme = "droite";     
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.model.setFormeCourante(forme);
	}
}
