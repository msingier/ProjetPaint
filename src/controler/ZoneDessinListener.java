package controler;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.Model;

//cette classe permet d'écouter ce qu'il se passe dans la zone de dessin
public class ZoneDessinListener extends MouseAdapter implements MouseListener, MouseMotionListener{
	Point pointDebut, pointArrivee;
	JPanel panel;
	Model model;
	
	public ZoneDessinListener(JPanel pan, Model model) {
		super();
		this.panel = pan;
		this.model = model;
	}

	public void mousePressed(MouseEvent e) {
		pointDebut = e.getPoint();
		
		if (model.getFormeCourante().equals("texte")) {

			String retour = JOptionPane.showInputDialog(null,"Entrez une phrase","Hello",JOptionPane.INFORMATION_MESSAGE);
			model.addForme(retour, pointDebut, model.getColor());

		}
	}
	
	//est censé dessiner en temps réel mais ne marche pas
	public void mouseDragged(MouseEvent e) {
		pointArrivee = e.getPoint();
        model.addFormeTemporaire(this.pointDebut, e.getPoint(),panel);
	}

	public void mouseReleased(MouseEvent e) {
		pointArrivee = e.getPoint();
		model.addForme(pointDebut, pointArrivee, panel);
	}
	
	// Inutile
	public void mouseClicked(MouseEvent arg0) {
	}
	public void mouseEntered(MouseEvent arg0) {
	}
	public void mouseExited(MouseEvent arg0) {
	}



	@Override
	public void mouseMoved(MouseEvent arg0) {		
	}
}
