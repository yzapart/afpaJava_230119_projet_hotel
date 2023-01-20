package afpaJava_231019_projet_hotel;

import java.time.LocalDate;

public class Reservation {

	private int id, nbPersonnes;
	private LocalDate dateArr, dateDep;
	private Client client;
	private Chambre chambre;
	private double montant;
	
	public Reservation(int id, Client client, Chambre chambre, int nbPersonnes, LocalDate dateArr, LocalDate dateDep, double montant) {
		this.id = id;
		this.dateArr = dateArr;
		this.dateDep = dateDep;
		this.client = client;
		this.chambre = chambre;
		this.montant = montant;
		this.nbPersonnes = nbPersonnes;
		Hotel.listeDesReservations.add(this);
	}
	
	public int getId() {
		return id;
	}
	
	public LocalDate getDateArr() {
		return dateArr;
	}
	
	public LocalDate getDateDep() {
		return dateDep;
	}
	
	public Client getClient() {
		return client;
	}
	
	public Chambre getChambre() {
		return chambre;
	}
	
	public double getMontant() {
		return montant;
	}

	public int getNbPersonnes() {
		return nbPersonnes;
	}
	
	
	public String toStr() {
		return "Réservation n° " + id + "\t" + client.getType() + " : " + client.getNom() + "\tChambre n° " + chambre.getNum() + "\t"+ chambre.getType() + "\t" + nbPersonnes + "pers.\tA: "  + dateArr + "\tD: " + dateDep + "\tMontant : " + montant + " €";
	}
	
}
