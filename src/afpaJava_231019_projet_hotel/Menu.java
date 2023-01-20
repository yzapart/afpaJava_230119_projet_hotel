package afpaJava_231019_projet_hotel;

import java.util.Scanner;
import java.util.stream.Collectors;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Menu {

	static String listeMenu[] = { "A: Afficher état de l'hôtel", 
								  " ", 
								  "B: Afficher le nombre de chambres réservées",
								  "C: Afficher le nombre de chambres libres", 
								  " ", 
								  "D: Afficher le numéro de la première chambre vide",
								  "E: Afficher le numéro de la dernière chambre occupée", 
								  " ", 
								  "F: Réserver une chambre",
								  "G: Libérer une chambre", 
								  " ", 
								  "H : Afficher liste réservations -------- cas à traiter",
								  "I : Afficher liste clients",
								  "J : Afficher liste des chambres",
								  " ",
								  "K : Etat d'une chambre à une date",
								  "L : Chiffre d'affaires",
								  " ",
								  "Q: Quitter",
								  " ",
								  "--- setEtat() des chambres en fontions de la date du jour et de la liste des réservations"
								  
								};

	
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
		case "g": 
			menu7();
			break;
		case "h": 
			menu8();
			break;
		case "i": 
			menu9();
			break;			
		case "j": 
			menu10();
			break;
		case "k":
			menu11();
			break;
		case "l":
			menu12();
			break;
			
			
		case "q":
			menuQ();
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
		scan.nextLine();
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
	

	// afficher état hotel
	static void menu1() {
		cls();
		Hotel.afficherEtatHotel();
		retour();
	}

	// afficher nombre de chambres réservées
	static void menu2() {
		cls();
		System.out.println("Nb de chambres réservées : " + Hotel.nbChambresReservees());
		retour();
	}

	// afficher nombre de chambres libres
	static void menu3() {
		cls();
		System.out.println("Nb de chambres libres    : " + Hotel.nbChambresLibres());
		retour();
	}

	// afficher n° première chambre vide
	static void menu4() {
		cls();
		selectionType();
		String choixType = typeSelectionne();
		String res = Hotel.numPremiereChambreVide(choixType) == 999 ? "Aucune chambre libre type " + choixType : Integer.toString(Hotel.numPremiereChambreVide(choixType));
		System.out.println("N° première chambre vide (type " + choixType + ")\t: " + res);
		retour();
	}
	
	// afficher n° dernière chambre occupée
	static void menu5() {
		cls();
		selectionType();
		String choixType = typeSelectionne();
		String res = Hotel.numDerniereChambreOccupee(choixType) == 999 ? "Aucune chambre occupée type " + choixType : Integer.toString(Hotel.numDerniereChambreOccupee(choixType));
		System.out.println("N° dernière chambre occupée (type " + choixType + ")\t: " + res);
		retour();
	}
	
	
	// réserver  chambre vide avec authentification
	static void menu6() {
		cls();
		System.out.println("Entrer identifiant : ");
		String user = scan.nextLine().toLowerCase();
		System.out.println("Mot de passe : ");
		String mdp = scan.nextLine().toLowerCase();
		if (loginOk(user, mdp) == true) {
			// réservation chambre
			Hotel.afficherListeDesClients();			
			System.out.println("Entrer n° client : 999 = nouveau");
			int nClient = scan.nextInt();
			Client client = Hotel.listeDesClients.get(nClient);
			System.out.println("Nombre de personne(s) :");
			int nbPersonnes = scan.nextInt(); scan.nextLine();
			selectionType();
			String choixType = typeSelectionne();
			// refonder la méthode numPremiereChambreVide(choixtype, dateArr, dateDep)
			// d'abord checker si un tye de chambre est libre pour une période donnée
//			Chambre chambre = Hotel.listeDesChambres.get(Hotel.numPremiereChambreVide(choixType));  
			System.out.println("Date d'entrée : (format AAAA-MM-JJ)");
			LocalDate dateArr = LocalDate.parse(scan.nextLine());
			System.out.println("Nombre de nuits : ");
			int nbNuits = scan.nextInt(); scan.nextLine();
			LocalDate dateDep = dateArr.plusDays(nbNuits);
			if (Hotel.reservationPossibleTypePeriode(choixType, dateArr, dateDep) == true) {
				Chambre chambre = Hotel.chambreLibreTypePeriode(choixType, dateArr, dateDep);
				double montant = nbPersonnes * nbNuits * chambre.getTarif();
				int id = Hotel.listeDesReservations.size();
				new Reservation(id, client, chambre, nbPersonnes, dateArr, dateDep, montant);
				System.out.println("Chambre n°" + chambre.getNum() + " réservée.");
				System.out.println(Hotel.listeDesReservations.get(Hotel.listeDesReservations.size()-1).toStr());
				Hotel.reserverChambre(chambre.getNum());
			} else {
				System.out.println("Réservation impossible, chambre occupée à cette période");
			}
		} else {
			System.out.println("Identification échouée.");
		}
		retour();
	}
	
	// libérer denrière chambre occupée avec authentification
	// ======================== il faut gérer le cas où il n'y a pas de chambre occupée ==============================
	static void menu7() {
		cls();
		System.out.println("Entrer identifiant : ");
		String user = scan.nextLine().toLowerCase();
		System.out.println("Mot de passe : ");
		String mdp = scan.nextLine().toLowerCase();
		if (loginOk(user, mdp) == true) {
			// réservation chambre
			selectionType();
			String choixType = typeSelectionne();
			System.out.println("Chambre n°" + Hotel.numDerniereChambreOccupee(choixType) + " libérée.");
			Hotel.libererChambre(Hotel.numDerniereChambreOccupee(choixType));
		} else {
			System.out.println("Identification échouée.");
		}
		retour();
	}
	
	static void menu8() {
		cls();
		Hotel.afficherListeDesReservations();
		retour();
	}
	
	static void menu9() {
		cls();
		Hotel.afficherListeDesClients();
		retour();
	}
	
	static void menu10() {
		cls();
		Hotel.afficherListeDesChambres();
		retour();
	}
	
	
	// état d'une chambre à une date donnée
	static void menu11() {
		cls();
		Hotel.afficherListeDesChambres();
		System.out.println("Entrer n° de chambre : ");
		int numChambre = scan.nextInt(); scan.nextLine();
		Chambre chambre = Hotel.listeDesChambres.get(numChambre);
		System.out.println("Date :");
		LocalDate date = LocalDate.parse(scan.nextLine());
		
		double loyer = 0; 
		if (Hotel.existeReservationChambreDate(chambre, date) == true){
			System.out.println(Hotel.reservationChambreDate(chambre, date).toStr());
			loyer = Hotel.reservationChambreDate(chambre, date).getNbPersonnes() * chambre.getTarif();  
		} else {
			System.out.println("Chambre n°" + numChambre + " inoccupée le " + date);
		}
		System.out.println("Loyer : " + loyer + " €");
		
		retour();
	}
	
	
	// calcul des loyers et CA
	static void menu12() {
		cls();
		System.out.println("Année du CA à calculer :");
		int year = scan.nextInt(); scan.nextLine();
		int CA = 0;
		for (Reservation r: Hotel.listeDesReservations) {
			List<LocalDate> listeDates = LocalDate.of(year, 01, 01).datesUntil(LocalDate.of(year+1, 01, 01)).collect(Collectors.toList());
			for (LocalDate date: listeDates) {
				int loyer = 0;
				if (Hotel.existeReservationChambreDate(r.getChambre(), date) == true) {
					loyer = Hotel.reservationChambreDate(r.getChambre(), date).getNbPersonnes() * r.getChambre().getTarif();
					System.out.println("Réservation n° " + r.getId() + "\t" + r.getClient().getType() + " : " + r.getClient().getNom() +  "\tChambre n°" + r.getChambre().getNum() + "\tDate : " + date + "\tLoyer : " + loyer + " €");
				}
				CA += loyer;
			}
		}
		System.out.println("CA " + year + " : " + CA + " €");
		retour();
	}

	static void menuQ() {
		cls();
		System.out.println("Au revoir.");
		System.exit(0);
	}

}