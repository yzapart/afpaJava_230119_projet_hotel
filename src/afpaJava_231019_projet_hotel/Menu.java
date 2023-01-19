package afpaJava_231019_projet_hotel;

import java.util.Scanner;
import java.util.ArrayList;

public class Menu {

	static String listeMenu[] = { "A: Afficher état de l'hôtel", " ", "B: Afficher le nombre de chambres réservées",
			"C: Afficher le nombre de chambres libres", " ", "D: Afficher le numéro de la première chambre vide",
			"E: Afficher le numéro de la dernière chambre occupée", " ", "F: Réserver une chambre",
			"G: Libérer une chambre", " ", "Q: Quitter" };

	static Scanner scan = new Scanner(System.in);

	static void afficherMenu(String message) {
		cls();
		System.out.println(message);
		System.out.println("--- Menu ---");
		for (String e : listeMenu) {
			System.out.println(e);
		}
		String choixMenu = scan.nextLine().toLowerCase();
		switch (choixMenu) {
		case "a":
			menu1();
			break;
		case "b":
			menu2();
			break;
		case "c":
			menu3();
			break;
		case "d":
			menu4();
			break;
		case "e":
			menu5();
			break;
//		case "f": 
//			menu6();
//			break;
//		case "g": 
//			menu7();
//			break;
		case "q":
			menu8();
			break;
		}
	}

	// pseudo console clear
	static void cls() {
		for (int i = 0; i < 50; ++i)
			System.out.println();
	}

	// propostiion retour menuu principal (ENTER)
	static void retour() {
		System.out.println("(Retour : Enter)");
		String s = scan.nextLine();
		afficherMenu("");
	}
	
	static void selectionType() {
		System.out.println("Entrer type de chambre :");
		System.out.println("A : single");
		System.out.println("B : twin");
		System.out.println("C : double");
		System.out.println("D : suite");		
	}
	
	static String typeSelectionne() {
		String choixType = scan.nextLine().toLowerCase();
		System.out.println("choixType : "+ choixType);
		switch (choixType) {
		case "a":
			choixType = "single";
			break;
		case "b":
			choixType = "twin";
			break;
		case "c":
			choixType = "double";
			break;
		case "d":
			choixType = "suite";
			break;
		}
		return choixType;
	}
	

	// afficher état hotel
	static void menu1() {
		cls();
		Hotel.afficherEtatHotel();
		retour();
	}

	// afficher nombre de chambres réservées
	static void menu2() {
		cls();
		System.out.println("Nb de chambres réservées : " + Chambre.nbChambresReservees());
		retour();
	}

	// afficher nombre de chambres libres
	static void menu3() {
		cls();
		System.out.println("Nb de chambres libres    : " + Chambre.nbChambresLibres());
		retour();
	}

	// afficher n° première chambre vide
	static void menu4() {
		cls();
		selectionType();
		String choixType = typeSelectionne();
		String res = Chambre.numPremiereChambreVide(choixType) == 999 ? "Aucune chambre libre type " + choixType : Integer.toString(Chambre.numPremiereChambreVide(choixType));
		System.out.println("N° première chambre vide (choixType " + choixType + ")\t: " + res);
		retour();
	}
	
	// afficher n° dernière chambre occupée
	static void menu5() {
		cls();
		selectionType();
		String choixType = typeSelectionne();
		String res = Chambre.numDerniereChambreOccupee(choixType) == 999 ? "Aucune chambre occupée type " + choixType : Integer.toString(Chambre.numDerniereChambreOccupee(choixType));
		System.out.println("N° dernière chambre occupée (choixType " + choixType + ")\t: " + res);
		retour();
	}



	static void menu8() {
		cls();
		System.out.println("Au revoir.");
		System.exit(0);
	}

}