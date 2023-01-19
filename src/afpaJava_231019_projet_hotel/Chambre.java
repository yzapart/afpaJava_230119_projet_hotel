package afpaJava_231019_projet_hotel;

public class Chambre {

	private int num; // identifiant de la chambre
	private String type; // single, twin, double, suite
	private int tarif;  // tarif par personne
	private boolean etat; // état de la chambre

	public Chambre(int num, String type, boolean etat, int tarif) {
		this.num = num;
		this.type = type;
		this.etat = etat;
		this.tarif = tarif;
		
		Hotel.listeDesChambres.add(this);
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

	public int getTarif() {
		return tarif;
	}
	
	public String toStr() {
		return "Chambre n°" + num + "\tType : " + type + "\tOccupée : " + etat + "\t\t€/p. : " + tarif;
	}

	public void setEtat(boolean etat) {
		this.etat = etat;
	}

}
