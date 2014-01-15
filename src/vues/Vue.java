package vues;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import model.Model;
import model.Forme;
import controler.ActionAnnuler;
import controler.ActionCopier;
import controler.ActionCouper;
import controler.ActionEnregistrer;
import controler.ActionNouveau;
import controler.ActionOuvrir;
import controler.ActionQuitter;
import controler.ZoneDessinListener;
import vues.BarreOutils;
import vues.zoneDessin;

public class Vue extends JFrame implements Observer{
	// Fenêtre
	private Container container;
	private BarreOutils outils; 
	private zoneDessin zoneDessin; 

	private Model model;	
	// Menu
	private JMenuBar menuBar;
	private JMenu fileMenu;
	private JMenu editMenu;
	private JMenuItem nouveau;
	private JMenuItem ouvrir;
	private JMenuItem enregistrer;
	private JMenuItem exitAction;
	private JMenuItem copy;
	private JMenuItem paste;
	private JMenuItem annuler;

	public Vue(Model model) throws HeadlessException {
		super();
		this.model = model;
		this.model.addObserver(this);
	
		this.initialiser();
		this.creation_menu();
		this.pack();
	}

	public void afficher() {
		this.setVisible(true);
	}

	public void initialiser() {
		// Configuration du container
		container = this.getContentPane();
		container.setLayout(new BorderLayout());
	
		// Ajout des panels au container
		outils = new BarreOutils(model);
		zoneDessin = new zoneDessin(model, this);
		ZoneDessinListener zoneDessinListener = new ZoneDessinListener(zoneDessin, model);
		zoneDessin.addMouseListener(zoneDessinListener);
		zoneDessin.addMouseMotionListener(zoneDessinListener);
		container.add(outils, BorderLayout.WEST);
		container.add(zoneDessin , BorderLayout.CENTER);

		// Configuration de la JFrame
		this.setTitle("Ze Paint of Death");
		this.setResizable(true);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new ActionQuitter(model));
		this.setMinimumSize(new Dimension(1000, 600));
	}

	public void creation_menu() { 
		// Barre de menu
		menuBar = new JMenuBar();
		this.setJMenuBar(menuBar);
	 
		// Menus
		fileMenu = new JMenu("Fichier");
		editMenu = new JMenu("Edition");
	
		// Ajouts
		menuBar.add(fileMenu);
		menuBar.add(editMenu);
	
		// Items
		nouveau = new JMenuItem(new ActionNouveau());
		nouveau.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N,java.awt.Event.CTRL_MASK));
		ouvrir = new JMenuItem(new ActionOuvrir(model));
		ouvrir.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O,java.awt.Event.CTRL_MASK));
		enregistrer = new JMenuItem(new ActionEnregistrer(model));
		enregistrer.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S,java.awt.Event.CTRL_MASK));
		exitAction = new JMenuItem(new ActionQuitter(model));
		exitAction.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q,java.awt.Event.CTRL_MASK));
		copy = new JMenuItem(new ActionCopier());
		copy.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C,java.awt.Event.CTRL_MASK));
		paste = new JMenuItem(new ActionCouper());
		paste.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V,java.awt.Event.CTRL_MASK));
		annuler = new JMenuItem(new ActionAnnuler(model, this));
		annuler.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z,java.awt.Event.CTRL_MASK));
	
		// Menu fichiers
		fileMenu.add(nouveau);
		fileMenu.add(ouvrir);
		fileMenu.add(enregistrer);
		editMenu.addSeparator();
		fileMenu.add(exitAction);

		//  Menu édition
		editMenu.add(annuler);
		editMenu.addSeparator();
		editMenu.add(copy);
		editMenu.add(paste);
	}
	
	
	public void update(Observable arg0, Object arg1) {

		Forme courant = null;
		
		if (arg1 instanceof Forme) { // Si l'argument est une forme, on le caste
			courant = (Forme) arg1;
			zoneDessin.setCourante((Forme) arg1);
		} else {
			zoneDessin.setCourante(null);
		}
	
		zoneDessin.repaint();
	}
}
