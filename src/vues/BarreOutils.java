package vues;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import model.Model;
import controler.ActionCouleur;
import controler.ActionForme;
import controler.ListenerPlein;

public class BarreOutils extends JPanel{
	Model model;
	// Boutons
	JButton texte;
	JButton droite;
	JButton	rectangle;
	JButton	cercle;
	JButton noir;
	JButton blanc;
	JButton rouge;
	JButton magenta;
	JButton bleu;
	JButton cyan;
	JButton vert;
	JButton rose;
	JButton orange;
	JButton jaune;
	JButton gris;
	JButton grisClair;
	JComboBox box;
		
	public BarreOutils(Model model){
		this.model = model;
		initialiser();
		
		
		// Outils
		//new ActionForme(model,"droite")
		texte = new JButton(new ActionForme(model,"texte"));
		texte.setIcon(new ImageIcon("src/ressources" + System.getProperty("file.separator") + "texte.png"));
		texte.setPreferredSize(new Dimension(30,30));
		droite = new JButton(new ActionForme(model,"droite"));
		droite.setIcon(new ImageIcon("src/ressources" + System.getProperty("file.separator") + "ligne.png"));
		droite.setPreferredSize(new Dimension(30,30));
		rectangle = new JButton(new ActionForme(model,"carre"));
		rectangle.setIcon(new ImageIcon("src/ressources" + System.getProperty("file.separator") + "rectangle.png"));
		rectangle.setPreferredSize(new Dimension(30,30));
		cercle = new JButton(new ActionForme(model,"rond"));
		cercle.setIcon(new ImageIcon("src/ressources" + System.getProperty("file.separator") + "cercle.png"));
		cercle.setPreferredSize(new Dimension(30,30));
		
		//combo box plein ou non
		box = new JComboBox();
		box.addItemListener(new ListenerPlein(model));
		box.addItem("Plein");
		box.addItem("Vide");
		
		// Couleurs
		noir= new JButton(new ActionCouleur(model, "noir"));
		noir.setBackground(Color.BLACK);
		noir.setPreferredSize(new Dimension(30,30));
		
		blanc= new JButton(new ActionCouleur(model, "blanc"));
		blanc.setBackground(Color.WHITE);
		blanc.setPreferredSize(new Dimension(30,30));
		
		rouge= new JButton(new ActionCouleur(model, "rouge"));
		rouge.setBackground(Color.RED);
		rouge.setPreferredSize(new Dimension(30,30));
		
		magenta= new JButton(new ActionCouleur(model, "magenta"));
		magenta.setBackground(Color.MAGENTA);
		magenta.setPreferredSize(new Dimension(30,30));
		
		
		bleu= new JButton(new ActionCouleur(model, "bleu"));
		bleu.setBackground(Color.BLUE);
		bleu.setPreferredSize(new Dimension(30,30));
		
		cyan= new JButton(new ActionCouleur(model, "cyan"));
		cyan.setBackground(Color.CYAN);
		cyan.setPreferredSize(new Dimension(30,30));
		
		
		vert= new JButton(new ActionCouleur(model, "vert"));
		vert.setBackground(Color.GREEN);
		vert.setPreferredSize(new Dimension(30,30));
		
		rose= new JButton(new ActionCouleur(model, "rose"));
		rose.setBackground(Color.PINK);
		rose.setPreferredSize(new Dimension(30,30));
		
		orange= new JButton(new ActionCouleur(model, "orange"));
		orange.setBackground(Color.ORANGE);
		orange.setPreferredSize(new Dimension(30,30));
		
		jaune= new JButton(new ActionCouleur(model, "jaune"));
		jaune.setBackground(Color.YELLOW);
		jaune.setPreferredSize(new Dimension(30,30));
		
		gris= new JButton(new ActionCouleur(model, "gris"));
		gris.setBackground(Color.GRAY);
		gris.setPreferredSize(new Dimension(30,30));
		
		grisClair= new JButton(new ActionCouleur(model, "grisClair"));
		grisClair.setBackground(Color.LIGHT_GRAY);
		grisClair.setPreferredSize(new Dimension(30,30));

		
		
		
		// Ajouts des boutons dans la barre d'outils
		this.add(droite);
		this.add(texte);
		this.add(rectangle);
		this.add(cercle);
		this.add(box);
		this.add(noir);
		this.add(blanc);
		this.add(rouge);
		this.add(magenta);
		this.add(bleu);
		this.add(cyan);
		this.add(vert);
		this.add(rose);
		this.add(orange);
		this.add(jaune);
		this.add(gris);
		this.add(grisClair);
	}
	
	public void initialiser() {
		this.setPreferredSize(new Dimension(75,75));
		this.setMinimumSize(new Dimension(75,5));
		this.setMaximumSize(new Dimension(75,75));
	}


}
