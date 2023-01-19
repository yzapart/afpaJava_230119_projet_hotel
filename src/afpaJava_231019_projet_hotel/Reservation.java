package afpaJava_231019_projet_hotel;

public class Reservation {

	private int id, nbPersonnes;
	private String date;
	private Client client;
	private Chambre chambre;
	private double montant;
	
	public Reservation(int id, String date, Client client, Chambre chambre, int nbPersonnes , double montant) {
		this.id = id;
		this.date = date;
		this.client = client;
		this.chambre = chambre;
		this.montant = montant;
		this.nbPersonnes = nbPersonnes;
		Hotel.listeDesReservations.add(this);
	}
	
	public String toStr() {
		return "Réservation n° " + id + "\t" + client.getNom() + "\tChambre n° " + chambre.getNum() + "\t" + nbPersonnes + "pers.\t"  + date + "\tMontant : " + montant;
	}
	
}
