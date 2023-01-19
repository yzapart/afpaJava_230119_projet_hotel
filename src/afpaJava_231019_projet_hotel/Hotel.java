package afpaJava_231019_projet_hotel;

import java.util.ArrayList;

public class Hotel {
	
	public static ArrayList<Chambre> listeDesChambres = new ArrayList<Chambre>();

	public static void afficherEtatHotel() {
		Chambre.afficherListeDesChambres();
	}

}
