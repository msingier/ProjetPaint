package vues;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.Iterator;

import javax.swing.JPanel;

import model.Forme;
import model.Model;


//cette classe contiendra la zone de dessin
public class zoneDessin extends JPanel{
	Forme courante;
	Model model;
	Vue vue;
	
	public zoneDessin(Model model, Vue vue) {
		super();
		this.courante = null;
		this.model = model;
		this.setBackground(Color.WHITE);
		this.vue = vue;
	}
	
	//méthode pour paint
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		if ( courante != null ) { 
			if (courante.getText() != null) {
				g2d.drawString(courante.getText(), courante.getDeb().x, courante.getDeb().y);
			} else {
				 dessiner(courante, g2d);
			}
			System.out.println("Forme non init"); 
		}
		
		Iterator<Forme> it = model.getListeDessin().iterator();
		while ( it.hasNext() ) { 
			Forme forme = it.next();
			
			if (forme.getText() != null) {
				g.drawString(forme.getText(), forme.getDeb().x, forme.getDeb().y);
			} else {
				 dessiner(forme, g2d);
			}
		}
		System.out.println("Forme dessinée"); 
	}
	
	public void dessiner(Forme forme, Graphics2D g) {
		g.setColor(forme.getCouleur());
		
		// Ici sont déclarés les differentes façon de dessiner
		
		//ronds
		if (forme.getForme().equals("rond")) {
			int xDeb=(int)forme.getDeb().getX();
			int yDeb=(int)forme.getDeb().getY();
			int xFin=(int)forme.getArr().getX();
			int yFin=(int)forme.getArr().getY();
			int tmp;
		
			if(xDeb > xFin) { tmp = xDeb; xDeb = xFin; xFin = tmp; }
			if(yDeb > yFin) { tmp = yDeb; yDeb = yFin; yFin = tmp; }
			
			if(forme.getPlein()=="plein"){
				g.fillOval(	xDeb,yDeb, xFin-xDeb, yFin-yDeb);
			}
			if(forme.getPlein()=="vide"){
				g.drawOval(xDeb,yDeb, xFin-xDeb, yFin-yDeb);
			}
			
		//carrés
		} else if (forme.getForme().equals("carre")) { 
			int xDeb=(int)forme.getDeb().getX();
			int yDeb=(int)forme.getDeb().getY();
			int xFin=(int)forme.getArr().getX();
			int yFin=(int)forme.getArr().getY();
			int tmp;
			
	        if(xDeb > xFin) { tmp = xDeb; xDeb = xFin; xFin = tmp; }
	        if(yDeb > yFin) { tmp = yDeb; yDeb = yFin; yFin = tmp; }
			
			if(forme.getPlein()=="plein"){
				g.fillRect(	xDeb,yDeb, xFin-xDeb, yFin-yDeb);
			}
			if(forme.getPlein()=="vide"){
				g.drawRect(xDeb,yDeb, xFin-xDeb, yFin-yDeb);
			}

			
		//droites
		} else if (forme.getForme().equals("droite")) {
			
			g.drawLine(	(int)forme.getDeb().getX(),
						(int)forme.getDeb().getY(),
						(int)forme.getArr().getX(),
						(int)forme.getArr().getY());
		
			
		//texte
		}
	}
	

	public Forme getCourante() {
		return courante;
	}

	public void setCourante(Forme courante) {
		this.courante = courante;
	}
}
