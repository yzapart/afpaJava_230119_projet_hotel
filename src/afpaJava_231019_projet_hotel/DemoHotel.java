package afpaJava_231019_projet_hotel;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


public class DemoHotel {
	static int N_CHAMBRES = 20;

	public static void main(String[] args) {

		creationChambres(N_CHAMBRES);
		
		creationClients();

		creationReservations(400);
		
		Menu.afficherMenu("");
		

	}

	
	
	// ==================================================================== //
	public static int nAlea(int min, int max) {
		return min + (int)Math.floor(Math.random() * (max-min));
	}
	
	public static double deuxDecAlea(double min, double max) {
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
				{"OVH         ", "soc."},
				{"Google      ","soc."},
				{"KISS        ","grp."},
				{"Blondie     ","grp."},
				{"Amanda Simpson","prs."},
				{"Yohann Zapart","prs."},
				{"Daniel Balav.","prs."},
				{"Michel Berger","prs."}
		};
		for (int i=0; i<listeClients.length; i++) {
			new Client(i, listeClients[i][0], listeClients[i][1]);
		}
	}
	
	//création n réservations
	public static void creationReservations(int n) {
		for (int id = 0; id < n; id++) {
			Client client = Hotel.listeDesClients.get(nAlea(0, Hotel.listeDesClients.size()));
			int nbPersonnes = nAlea(1, 4);
			LocalDate dateArr = LocalDate.of(nAlea(2022, 2023), 1, 1).plusDays(nAlea(1, 365*2));
			LocalDate dateDep = dateArr.plusDays(nAlea(1, 7));	
			String type = Hotel.listeType[nAlea(1, 4)];
			if (Hotel.reservationPossibleTypePeriode(type, dateArr, dateDep) == true) {
				Chambre chambre = Hotel.chambreLibreTypePeriode(type, dateArr, dateDep);
				double montant = nbPersonnes*chambre.getTarif()*ChronoUnit.DAYS.between(dateArr, dateDep);		
				new Reservation(id, client, chambre, nbPersonnes, dateArr, dateDep, montant);				
			} else {
				System.out.println("Réservation impossible");
			}
		}
	}

	
}
