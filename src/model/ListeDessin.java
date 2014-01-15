package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

import model.Forme;

public class ListeDessin implements Serializable{
	private ArrayList<Forme> listeDessin;
	
	public ListeDessin() {
		this.listeDessin = new ArrayList<Forme>();
	}
	
	public void add(Forme forme) {
		this.listeDessin.add(forme);
	}
	
	public void deleteLast(){
		int last = (this.listeDessin.size()) - 1;
		this.listeDessin.remove(last);
	}
	
	public Iterator iterator() {
		return this.listeDessin.iterator();
	}
	
	public int size(){
		return this.listeDessin.size();
	}
	
	public String toString() {
		return this.listeDessin.toString();
	}
	
}
