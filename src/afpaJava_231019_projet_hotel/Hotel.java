package afpaJava_231019_projet_hotel;

import java.util.ArrayList;

public class Hotel {
	
	public static String[] 					listeType = { "single", "twin", "double", "suite" };
	public static ArrayList<Chambre> 		listeDesChambres = new ArrayList<Chambre>();
	public static ArrayList<Reservation> 	listeDesReservations = new ArrayList<Reservation>();
	public static ArrayList<Client> 		listeDesClients = new ArrayList<Client>();


	public static void afficherEtatHotel() {
		afficherListeDesChambres();
	}
	
	

	public static void afficherListeDesChambres() {
		System.out.println("--- Liste des chambres : ---");
		for (Chambre c : listeDesChambres) {
			System.out.println(c.toStr());
		}
		System.out.println("----------------------------");
	}
	
	public static void afficherListeDesClients() {
		System.out.println("--- Liste des clients : ---");
		for (Client c : listeDesClients) {
			System.out.println(c.toStr());
		}
		System.out.println("----------------------------");
	}
	
	public static void afficherListeDesReservations() {
		System.out.println("--- Liste des réservations : ---");
		for (Reservation r : listeDesReservations) {
			System.out.println(r.toStr());
		}
		System.out.println("----------------------------");
	}
	
	

	public static int nbChambresReservees() {
		int sum = 0;
		for (Chambre c : listeDesChambres) {
			if (c.getEtat() == true) {
				sum += 1;
			}
		}
		return sum;
	}

	public static int nbChambresLibres() {
		int sum = 0;
		for (Chambre c : listeDesChambres) {
			if (c.getEtat() == false) {
				sum += 1;
			}
		}
		return sum;
	}

	public static int numPremiereChambreVide(String type) {
		for (Chambre c : listeDesChambres) {
			if (c.getEtat() == false && c.getType().equals(type)) {
				return c.getNum();
			}
		}
		return 999;
	}

	public static int numDerniereChambreVide(String type) {
		int max = 999;
		for (Chambre c : listeDesChambres) {
			if (c.getEtat() == false && c.getType().equals(type)) {
				max = c.getNum();
			}
		}
		return max;
	}

	public static int numPremiereChambreOccupee(String type) {
		for (Chambre c : listeDesChambres) {
			if (c.getEtat() == true && c.getType().equals(type)) {
				return c.getNum();
			}
		}
		return 999;
	}

	public static int numDerniereChambreOccupee(String type) {
		int max = 999;
		for (Chambre c : listeDesChambres) {
			if (c.getEtat() == true && c.getType().equals(type)) {
				max = c.getNum();
			}
		}
		return max;
	}

	public static void reserverChambre(int num) {
		for (Chambre c : listeDesChambres) {
			if (c.getNum() == num)
				c.setEtat(true);
		}
	}

	public static void libererChambre(int num) {
		for (Chambre c : listeDesChambres) {
			if (c.getNum() == num)
				c.setEtat(false);
		}
	}

}
