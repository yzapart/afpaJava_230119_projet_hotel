package afpaJava_231019_projet_hotel;

import java.lang.Math;
import java.util.ArrayList;

public class DemoHotel {
	static String listeType[] = { "single", "twin", "double", "suite" };
	static int N_CHAMBRES = 20;

	public static void main(String[] args) {

		creationChambres(N_CHAMBRES);
		Menu.afficherMenu("");

		
	}

	public static void creationChambres(int n) {
		// Création aléatoire de n chambres.
		for (int i = 0; i < n; i++) {
			Boolean etat = (int) Math.floor(Math.random() * 2) == 0 ? false : true;
			String type = listeType[(int) Math.floor(Math.random() * 4)];
			new Chambre(Chambre.listeDesChambres.size(), type, etat);
		}
	}

	public static void tests() {
		Hotel.afficherEtatHotel();

		// Affichage première chambre vide de chaque type
		// Est-ce qu'il vaut mieux inclure le test si une chambre est disponible dans la
		// méthode numPremoièreChambreVide de la classe Chambre ?
		// Dans ce cas celle-ci retournerait une valeur String.
		for (String type : listeType) {
			String res = Chambre.numPremiereChambreVide(type) == 999 ? "Aucune chambre libre"
					: Integer.toString(Chambre.numPremiereChambreVide(type));
			System.out.println("N° première chambre vide (type " + type + ")\t: " + res);
		}
		System.out.println(("---"));

		// Affichage dernière chambre vide de chaque type
		for (String type : listeType) {
			String res = Chambre.numDerniereChambreVide(type) == 999 ? "Aucune chambre libre"
					: Integer.toString(Chambre.numDerniereChambreVide(type));
			System.out.println("N° dernière chambre vide (type " + type + ")\t: " + res);
		}
		System.out.println(("---"));

		// Réserver première chambre vide du type "single"
		System.out.println(
				"Réserver première chambre vide type single (n° " + Chambre.numPremiereChambreVide("single") + ") :");
		Chambre.reserverChambre(Chambre.numPremiereChambreVide("single"));
		Hotel.afficherEtatHotel();
		System.out.println(("---"));

		// Libérer dernière chambre occupée du type "single"
		System.out.println("Libérer la dernière chambre vide type single (n° "
				+ Chambre.numDerniereChambreOccupee("single") + ") :");
		Chambre.libererChambre(Chambre.numDerniereChambreOccupee("single"));
		Hotel.afficherEtatHotel();
		System.out.println(("---"));
	}
}
