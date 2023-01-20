package afpaJava_231019_projet_hotel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Hotel {
	
	public static String[] 					listeType = { "single", "twin", "double", "suite" };
	public static ArrayList<Chambre> 		listeDesChambres = new ArrayList<Chambre>();
	public static ArrayList<Reservation> 	listeDesReservations = new ArrayList<Reservation>();
	public static ArrayList<Client> 		listeDesClients = new ArrayList<Client>();


	public static void afficherEtatHotel() {
		afficherListeDesChambres();
	}
	
	

	public static void afficherListeDesChambres() {
		System.out.println("--- Liste des chambres : ---");
		for (Chambre c : listeDesChambres) {
			System.out.println(c.toStr());
		}
		System.out.println("----------------------------");
	}
	
	public static void afficherListeDesClients() {
		System.out.println("--- Liste des clients : ---");
		for (Client c : listeDesClients) {
			System.out.println(c.toStr());
		}
		System.out.println("----------------------------");
	}
	
	public static void afficherListeDesReservations() {
		Collections.sort(listeDesReservations, Comparator.comparing(Reservation::getDateArr));
		System.out.println("--- Liste des réservations : ---");
		for (Reservation r : listeDesReservations) {
			System.out.println(r.toStr());
		}
		System.out.println("----------------------------");
	}
	
	

	public static int nbChambresReservees() {
		int sum = 0;
		for (Chambre c : listeDesChambres) {
			if (c.getEtat() == true) {
				sum += 1;
			}
		}
		return sum;
	}

	public static int nbChambresLibres() {
		int sum = 0;
		for (Chambre c : listeDesChambres) {
			if (c.getEtat() == false) {
				sum += 1;
			}
		}
		return sum;
	}

	public static int numPremiereChambreVide(String type) {
		for (Chambre c : listeDesChambres) {
			if (c.getEtat() == false && c.getType().equals(type)) {
				return c.getNum();
			}
		}
		return 999;
	}

	public static int numDerniereChambreVide(String type) {
		int max = 999;
		for (Chambre c : listeDesChambres) {
			if (c.getEtat() == false && c.getType().equals(type)) {
				max = c.getNum();
			}
		}
		return max;
	}

	public static int numPremiereChambreOccupee(String type) {
		for (Chambre c : listeDesChambres) {
			if (c.getEtat() == true && c.getType().equals(type)) {
				return c.getNum();
			}
		}
		return 999;
	}

	public static int numDerniereChambreOccupee(String type) {
		int max = 999;
		for (Chambre c : listeDesChambres) {
			if (c.getEtat() == true && c.getType().equals(type)) {
				max = c.getNum();
			}
		}
		return max;
	}

	public static void reserverChambre(int num) {
		for (Chambre c : listeDesChambres) {
			if (c.getNum() == num)
				c.setEtat(true);
		}
	}

	public static void libererChambre(int num) {
		for (Chambre c : listeDesChambres) {
			if (c.getNum() == num)
				c.setEtat(false);
		}
	}
	
	public static boolean dateIncluse(LocalDate date, LocalDate dateInf, LocalDate dateSup) {
		if (date.isAfter(dateInf.minusDays(1)) && date.isBefore(dateSup)) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean existeReservationChambreDate(Chambre chambre, LocalDate date) {
		for (Reservation r: listeDesReservations) {
			if (r.getChambre().equals(chambre) && dateIncluse(date, r.getDateArr(), r.getDateDep())) {
				return true;
			}
		}
		return false;
	}
	
	public static Reservation reservationChambreDate(Chambre chambre, LocalDate date) {
		for (Reservation r: listeDesReservations) {
			if ((r.getChambre().equals(chambre) == true) && (dateIncluse(date, r.getDateArr(), r.getDateDep()) == true)) {
				return r;
			}
		}
		return null;
	}
	
	
	public static boolean reservationPossibleChambrePeriode(Chambre chambre, LocalDate dateArr, LocalDate dateDep) {
		List<LocalDate> listeDatesAVerifier = dateArr.datesUntil(dateDep).collect(Collectors.toList());
		for (LocalDate dateAVerif: listeDatesAVerifier) {
			if (existeReservationChambreDate(chambre, dateAVerif) == true) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean reservationPossibleTypePeriode(String type, LocalDate dateArr, LocalDate dateDep) {
		List<LocalDate> listeDatesAVerifier = dateArr.datesUntil(dateDep).collect(Collectors.toList());
		for (Chambre chambre: Hotel.listeDesChambres) {
			if (chambre.getType().equals(type)) {
				boolean chambreLibre = true;
				for (LocalDate dateAVerif : listeDatesAVerifier) {
					if (existeReservationChambreDate(chambre, dateAVerif) == true) {
						chambreLibre = false;
					}
				}
				if (chambreLibre == true) return true;
			}
		}
		return false;
	}
	
	public static Chambre chambreLibreTypePeriode(String type, LocalDate dateArr, LocalDate dateDep) {
		List<LocalDate> listeDatesAVerifier = dateArr.datesUntil(dateDep).collect(Collectors.toList());
		for (Chambre chambre: Hotel.listeDesChambres) {
			if (chambre.getType().equals(type)) {
				boolean libre = true;
				for (LocalDate dateAVerif : listeDatesAVerifier) {
					if (existeReservationChambreDate(chambre, dateAVerif) == true) {
						libre = false;
					}
				}
				if (libre == true) return chambre;
			}
		}
		return null;
	}
	
	
	
	
//	public static boolean reservationPossible(Chambre chambre, LocalDate dateArr, LocalDate dateDep) {
//		List<LocalDate> listeDatesAVerifier = dateArr.datesUntil(dateDep).collect(Collectors.toList());
//		for (Reservation r: Hotel.listeDesReservations) {
//			if (r.getChambre().equals(chambre)) {
//				List<LocalDate> listeDatesOccupées = r.getDateArr().datesUntil(r.getDateDep()).collect(Collectors.toList());
//				for (LocalDate dateAVerif: listeDatesAVerifier) {
//					if (listeDatesOccupées.contains(dateAVerif)) {
//						return false;
//					}
//				}
//				
//			}
//		}
//		return true;
//	}

}
