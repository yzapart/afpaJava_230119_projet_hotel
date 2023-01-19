package afpaJava_231019_projet_hotel;


public class DemoHotel {
	static int N_CHAMBRES = 20;

	public static void main(String[] args) {

		creationChambres(N_CHAMBRES);
//		Hotel.afficherListeDesChambres();
		
		creationClients();
//		Hotel.afficherListeDesClients();		

		creationReservations(10);
//		Hotel.afficherListeDesReservations();

		Menu.afficherMenu("");
		
	}

	
	
	// ==================================================================== //
	public static int nAlea(int min, int max) {
		return min + (int)Math.floor(Math.random() * (max-min));
	}
	
	public static double deuxDecAlea(double min, double max) {
//		return min + (double)(Math.floor(100 * Math.random() * (max - min) / 100));
		return (double)(Math.floor(100 * Math.random() * (max-min) ) / 100);
	}
	
	// création aléatoire des chambres
	public static void creationChambres(int n) {
		// Création aléatoire de n chambres.
		for (int i = 0; i < n; i++) {
			String type = Hotel.listeType[(int) Math.floor(Math.random() * Hotel.listeType.length)];
			Boolean etat = (int) Math.floor(Math.random() * 2) == 0 ? false : true;
			int tarif = nAlea(50, 100); 
			new Chambre(Hotel.listeDesChambres.size(), type, etat, tarif);
		}
	}
	
	// création clients
	public static void creationClients() {
		String[][] listeClients = {
				{"OVH         ", "société"},
				{"Google      ","société"},
				{"KISS        ","groupe"},
				{"Blondie     ","groupe"},
				{"Amanda Simpson","personne"},
				{"Yohann Zapart","personne"},
				{"Daniel Balav.","personne"},
				{"Michel Berger","personne"}
		};
		for (int i=0; i<listeClients.length; i++) {
			new Client(i, listeClients[i][0], listeClients[i][1]);
		}
	}
	
	//création n réservations
	public static void creationReservations(int n) {
		for (int id = 0; id < n; id++) {
			String date = "2023-" + nAlea(1, 13) + "-" + nAlea(1, 31);
			Client client = Hotel.listeDesClients.get(nAlea(0, Hotel.listeDesClients.size()));
			Chambre chambre = Hotel.listeDesChambres.get(nAlea(0, Hotel.listeDesChambres.size()));
			int nbPersonnes = nAlea(1, 4);
			double montant = nbPersonnes*chambre.getTarif();
			
			new Reservation(id, date, client, chambre, nbPersonnes, montant);
		}
	}
	
	
	
}
