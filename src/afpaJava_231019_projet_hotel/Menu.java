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
		case "f": 
			menu6();
			break;
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
	
	// réserver première chambre vide avec authentification
	// ======================== il faut gérer le cas où il n'y a pas de chambre vide ==============================
	static void menu6() {
		cls();
		System.out.println("Entrer identifiant : ");
		String user = scan.nextLine().toLowerCase();
		System.out.println("Mot de passe : ");
		String mdp = scan.nextLine().toLowerCase();
		if (loginOk(user, mdp) == true) {
			// réservation chambre
			selectionType();
			String choixType = typeSelectionne();
			System.out.println("Chambre n°" + Chambre.numPremiereChambreVide(choixType) + " réservée.");
			Chambre.reserverChambre(Chambre.numPremiereChambreVide(choixType));
		} else {
			System.out.println("Identification échouée.");
		}
		retour();
	}
	
	
	
	
	
	
	
	static boolean loginOk(String user, String mdp) {
		ArrayList<String[]> listeLogin = new ArrayList<String[]>();

		String logins[][] = { 
								{ "user", "mdp" }, 
								{ "toto", "tata" }, 
								{ "allo", "bobo" } 
							};

		for (String[] l : logins) {
			listeLogin.add(l);
		}

		for (String[] l : listeLogin) {
			if (l[0].equals(user) && l[1].equals(mdp)) {
				return true;
			}
		}
		
		return false;
	}

	//
//	// créer habitation
//	static void menu2() {
//		cls();
//		System.out.println("Propriétaire :");
//		scan.nextLine(); String proprietaire = scan.nextLine();
//		System.out.println("Adresse :");
//		String adresse = scan.nextLine();
//		System.out.println("Surface :");
//		double surface = scan.nextDouble();
//		System.out.println("Type (1: individuelle / 2: professionnelle");
//		int typeChoix = scan.nextInt();
//		if (typeChoix == 1) {
//			String type = "individuelle";
//			System.out.println("Nombre de pièces :");
//			int nbPieces = scan.nextInt();
//			System.out.println("Présence piscine (1: oui / 2: non");
//			boolean piscine = scan.nextInt() == 1 ? true : false;
//			new HabitationIndividuelle(proprietaire, adresse, surface, nbPieces, piscine);
//		} else {
//			String type = "professionnelle";
//			System.out.println("Nombre d'employés :");
//			int nbEmployes= scan.nextInt();
//			new HabitationProfessionnelle(proprietaire, adresse, surface, nbEmployes);
//		}
//		afficherMenu("");
//	}
//	
//
//	// ajouter habitation à une commune
//	static void menu3() {
//		cls();
//		Habitation.afficherListeDeToutesLesHabitations();
//		System.out.println("Sélection n° habitation :");
//		int choixHab = scan.nextInt();
//		
//		Commune.afficherListeDesCommunes();
//		System.out.println("Sélection n° commune :");
//		int choixCommune = scan.nextInt();
//		
//		Commune.listeDesCommunes.get(choixCommune - 1).ajoutHabitation(Habitation.listeDeToutesLesHabitations.get(choixHab - 1));
//		afficherMenu("L'habitation n°" + choixHab + " a été ajoutée à la commune de " + Commune.listeDesCommunes.get(choixCommune - 1).getNom());;
//	}
//	
//	// modifier proprio
//	static void menu4() {
//		cls();
//		Habitation.afficherListeDeToutesLesHabitations();
//		System.out.println("Sélection n° habitation :");
//		int choixHab = scan.nextInt();
//		Habitation habitationChoisie = Habitation.listeDeToutesLesHabitations.get(choixHab - 1);
//		
//		System.out.println("Nom du propriétaire :");
//		scan.nextLine(); String nouveauProprio = scan.nextLine();
//		
//		habitationChoisie.setProprietaire(nouveauProprio);
//		afficherMenu("Modification propriétaire habitation n°" + choixHab + "\tnom :" + nouveauProprio);
//		
//	}
//	
//	static void menu5() {
//		cls();
//		Habitation.afficherListeDeToutesLesHabitations();
//		System.out.println("(Retour : Enter)");
//		String s = scan.nextLine();s = scan.nextLine();
//		afficherMenu("");
//	}
//
//	static void menu6() {
//		cls();
//		Commune.afficherListeDesCommunes();
//		System.out.println("Sélection n° commune :");
//		int choixCommune = scan.nextInt();
//		Commune communeChoisie = Commune.listeDesCommunes.get(choixCommune - 1);
//		communeChoisie.afficherHabitations();
//		
//		System.out.println("(Retour : Enter)");
//		Scanner s = new Scanner(System.in);
//		s.nextLine();
//		afficherMenu("");
//	}
//
//	static void menu7() {
//		cls();
//		Commune.afficherListeDesCommunes();
//		System.out.println("(Retour : Enter)");
//		Scanner s = new Scanner(System.in);
//		s.nextLine();
//		afficherMenu("");
//		
//	}

	static void menu8() {
		cls();
		System.out.println("Au revoir.");
		System.exit(0);
	}

}