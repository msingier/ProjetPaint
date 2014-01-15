package controler;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import vues.Vue;

import model.Model;

public class ActionAnnuler extends AbstractAction{
	private Model model;
	private Vue vue;
	
	public ActionAnnuler(Model model, Vue vue) {
		this.model = model;
		this.vue = vue;
		
		putValue(NAME, "Annuler");
		putValue(SHORT_DESCRIPTION, "Annule la dernière forme");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(this.model.getListeDessin().size() != 0){
			this.model.deleteDernier();
			this.vue.update(model,null);
		}
		
	}

}
