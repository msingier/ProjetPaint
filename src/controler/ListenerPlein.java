package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import model.Model;

public class ListenerPlein implements ItemListener{
	private Model model;
	public ListenerPlein(Model model){
		super();
		this.model=model;
	}


	@Override
	public void itemStateChanged(ItemEvent e) {
		String plein = "plein";
		if(e.getItem().equals("Vide")){
			plein = "vide";
		}	
		this.model.setPleinCourant(plein);
	}

}
