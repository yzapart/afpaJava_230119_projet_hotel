package afpaJava_231019_projet_hotel;
import java.lang.Math;

public class DemoHotel {

	public static void main(String[] args) {
		int N_CHAMBRES = 20;
		String listeType[] = {"single", "twin", "double", "suite"};
		
		
		for (int i=0; i<N_CHAMBRES; i++) {
			Boolean etat = (int)Math.floor(Math.random()*2) == 0 ? false : true;
			String type = listeType[(int)Math.floor(Math.random()*4)];
			new Chambre(Chambre.listeDesChambres.size(), type, etat);
		}
		
		Chambre.afficherListeDesChambres();
		System.out.println("Nb de chambres réservées : " + Chambre.nbChambresReservees());
		System.out.println("Nb de chambres libres    : " + Chambre.nbChambresLibres());
		
		
		for (String type: listeType) {
			System.out.println("N° première chambre vide (type " + type + ")\t:" + Chambre.numPremiereChambreVide(type));
		}
		System.out.println(("---"));

		for (String type: listeType) {
			System.out.println("N° dernière chambre vide (type " + type + ")\t:" + Chambre.numDerniereChambreVide(type));
		}
		System.out.println(("---"));
		
		
	}
	
}
