package model;

import java.awt.Color;
import java.awt.Point;
import java.util.Observable;

import javax.swing.JPanel;

import model.Forme;

public class Model extends Observable{
	private ListeDessin listeDessin;
	// Types de modification d'un objet forme
	private Color couleurCourante;
	private String pleinCourant,formeCourante; 
	private String extension;
	private boolean travail_enregistre;

	public Model() {
		super();
		this.listeDessin = new ListeDessin();
		this.couleurCourante = Color.BLACK;
		this.pleinCourant = "plein";
		this.formeCourante = "droite";
		this.setEnregistre(true); // Pas besoin d'enregistrer lorsque le dessin est vide
		this.extension = ".cth";
	}
	
	// Ajoute une figure à  la liste des formes présentes
	// Lorsqu'une forme est ajoutée, l'objet Forme "courant" est envoyé Ã  l'update des vues
	public void addForme(Point pointDebut, Point pointArrivee, JPanel pan){
		Forme courant = new AutresForme(pointDebut, pointArrivee, pleinCourant, formeCourante, couleurCourante);
		listeDessin.add(courant);
		System.out.println("Forme ajoutée"); 
		setChanged();
		notifyObservers(courant); // Envoi de l'objet au vues
		setEnregistre(false);
	}
	
    public void addFormeTemporaire(Point pointDebut, Point pointArrivee, JPanel pan) {
        this.addForme(pointDebut, pointArrivee,pan);
        this.deleteDernier();
    }
    
    public void addForme(String texte, Point pointDebut, Color couleur) {
    	FormeTexte f = new FormeTexte(texte, pointDebut, couleur);
    	this.listeDessin.add(f);
    	
    	setChanged();
		notifyObservers(f); // Envoi de l'objet au vues
		setEnregistre(false);
    }

    //getters and setters
	public Color getColor() {
		return this.couleurCourante; 
	}
	
	public void setColor (Color couleur) {
		this.couleurCourante = couleur;
	}
	
	public void setFormeCourante(String forme){
		this.formeCourante = forme;
	}
	
	public String getFormeCourante(){
		return this.formeCourante;
	}
	
	public void setPleinCourant(String plein){
		this.pleinCourant = plein;
	}
	
	public String getPlein(){
		return this.pleinCourant;
	}
	
	public boolean getEnregistre() {
		return travail_enregistre;
	}
	
	public void setEnregistre(boolean travail) {
		this.travail_enregistre = travail;
	}
	
	public ListeDessin getListeDessin() {
		return this.listeDessin;
	}
	
	public void setListeDessin(ListeDessin listeDessin) {
		this.listeDessin = listeDessin;
		setChanged();
		notifyObservers();
	}
	
	//supprime le dernier élément de la liste que contient le model
	public void deleteDernier(){
		this.listeDessin.deleteLast();
		notifyObservers();
	}
	 
	public String getExtension() {
		return this.extension;
	}
}
