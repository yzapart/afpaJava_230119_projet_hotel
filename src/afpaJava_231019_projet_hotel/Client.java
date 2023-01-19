package afpaJava_231019_projet_hotel;

public class Client {

	private int id;
	private String nom, type;

	public Client(int id, String nom, String type) {
		this.id = id;
		this.nom = nom;
		this.type = type;
		Hotel.listeDesClients.add(this);
	}

	public int getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}
	
	public String getType() {
		return type;
	}

	public String toStr() {
		return "Client n°" + id + "\t" + nom + "\t" + type; 
	}
}
