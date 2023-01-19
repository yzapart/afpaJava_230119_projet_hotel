package afpaJava_231019_projet_hotel;

import java.util.ArrayList;

public class Chambre {

	private int num; // identifiant de la chambre
	private String type; // single, twin, double, suite
	private boolean etat; // état de la chambre

	public Chambre(int num, String type, boolean etat) {
		this.num = num;
		this.type = type;
		this.etat = etat;
		listeDesChambres.add(this);
	}

	public int getNum() {
		return num;
	}

	public String getType() {
		return type;
	}

	public boolean getEtat() {
		return etat;
	}

	public String toStr() {
		return "Chambre n°" + num + "\tType : " + type + "\tOccupée : " + etat;
	}

	public void setEtat(boolean etat) {
		this.etat = etat;
	}

	// Est-i préférable de déclarer cette liste dans la classe Hotel ?
	// liste de l'ensemble des chambres
	public static ArrayList<Chambre> listeDesChambres = new ArrayList<Chambre>();

	public static void afficherListeDesChambres() {
		System.out.println("--- Liste des chambres : ---");
		for (Chambre c : listeDesChambres) {
			System.out.println(c.toStr());
		}
		System.out.println("----------------------------");
	}

	public static int nbChambresReservees() {
		int sum = 0;
		for (Chambre c : listeDesChambres) {
			if (c.etat == true) {
				sum += 1;
			}
		}
		return sum;
	}

	public static int nbChambresLibres() {
		int sum = 0;
		for (Chambre c : listeDesChambres) {
			if (c.etat == false) {
				sum += 1;
			}
		}
		return sum;
	}

	public static int numPremiereChambreVide(String type) {
		for (Chambre c : listeDesChambres) {
			if (c.etat == false && c.type.equals(type)) {
				return c.num;
			}
		}
		return 999;
	}

	public static int numDerniereChambreVide(String type) {
		int max = 999;
		for (Chambre c : listeDesChambres) {
			if (c.etat == false && c.type.equals(type)) {
				max = c.num;
			}
		}
		return max;
	}

	public static int numPremiereChambreOccupee(String type) {
		for (Chambre c : listeDesChambres) {
			if (c.etat == true && c.type.equals(type)) {
				return c.num;
			}
		}
		return 999;
	}

	public static int numDerniereChambreOccupee(String type) {
		int max = 999;
		for (Chambre c : listeDesChambres) {
			if (c.etat == true && c.type.equals(type)) {
				max = c.num;
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
