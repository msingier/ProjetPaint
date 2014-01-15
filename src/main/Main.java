package main;

import model.Model;
import vues.Vue;

public class Main {
	public static void main(String[] args) {
		Model model = new Model();
		Vue paint = new Vue(model);
		paint.afficher();
	}
}
