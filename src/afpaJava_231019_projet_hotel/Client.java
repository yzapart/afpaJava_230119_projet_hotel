package afpaJava_231019_projet_hotel;

public class Client {

	private int id;
	private String nom;

	public Client(int id, String nom) {
		this.id = id;
		this.nom = nom;
		Hotel.listeDesClients.add(this);
	}

	public int getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}
	
	public String toStr() {
		return "Client n°" + id + "\t" + nom;
	}
}
