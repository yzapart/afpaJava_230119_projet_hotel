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
		System.out.println(("---"));
		
		
		
		// Est-ce qu'il vaut mieux inclure le test si une chambre est disponible dans la méthode numPremoièreChambreVide de la classe Chambre ?
		// Dans ce cas celle-ci retournerait une valeur String.
		for (String type: listeType) {
			String res = Chambre.numPremiereChambreVide(type) == 999 ? "Aucune chambre libre" : Integer.toString(Chambre.numDerniereChambreVide(type));
			System.out.println("N° première chambre vide (type " + type + ")\t: " + res);
		}
		System.out.println(("---"));

		for (String type: listeType) {
			String res = Chambre.numDerniereChambreVide(type) == 999 ? "Aucune chambre libre" : Integer.toString(Chambre.numDerniereChambreVide(type));
			System.out.println("N° dernière chambre vide (type " + type + ")\t: " + res);
		}
		System.out.println(("---"));
		
		
	}
	
}
