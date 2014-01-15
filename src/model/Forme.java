package model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.io.Serializable;

import javax.swing.JOptionPane;

//Les formes sont des objets qui contiennent toutes les
//caractéristiques dont on a besoin
//elles seront stoquées dans une liste
public abstract class Forme implements Serializable {
	Point pointDebut, pointArrivee;
	String objet;
	String plein;
	Color couleur;
	String texte;
	
	public Forme(Point pointDebut , Point pointArrivee, String plein, String objet, Color couleur) {
		super();
		this.pointDebut = pointDebut;
		this.pointArrivee = pointArrivee;
		this.plein = plein;
		this.objet = objet;
		this.couleur = couleur;
		this.texte = null;
	}	
	
	public Forme(String texte, Point pointDebut, Color couleur) {
		this(pointDebut, null, null, null, couleur);
		this.texte = texte;
		this.pointDebut = pointDebut;
	}
	
	public Point getDeb() {
		return pointDebut;
	}

	public void setDeb(Point pointDebut) {
		this.pointDebut = pointDebut;
	}

	public Point getArr() {
		return this.pointArrivee;
	}

	public void setArr(Point pointArrivee) {
		this.pointArrivee = pointArrivee;
	}

	public String getPlein() {
		return this.plein;
	}

	public void setPlein(String plein) {
		this.plein = plein;
	}

	public String getForme() {
		return this.objet;
	}

	public void setForme(String forme) {
		this.objet = forme;
	}

	public Color getCouleur() {
		return this.couleur;
	}

	public void setCouleur(Color couleur) {
		this.couleur = couleur;
	}
	
	public void setText(String texte) {
		this.texte = texte;
	}
	
	public String getText() {
		 return texte;
	}

	public String toString() {
		return "Forme [deb=" + pointDebut + ", arr=" + pointArrivee + ", type= " + plein
				+ ", forme=" + objet + ", couleur=" + couleur + "]";
	}

}
