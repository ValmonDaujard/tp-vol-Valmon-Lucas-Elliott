package tp;

import tp.model.Aeroport;
import tp.model.Arrivee;
import tp.model.Avion;
import tp.model.Compagnie;
import tp.model.Depart;
import tp.model.Paiement;
import tp.model.Particulier;
import tp.model.Passager;
import tp.model.Reservation;
import tp.model.Societe;
import tp.model.Trajet;
import tp.model.Utilisateur;
import tp.model.Ville;
import tp.model.Vol;

public class Test {

	public static void main(String[] args) {

		Compagnie airFrance = new Compagnie("Air France");

		Avion airbusA380 = new Avion("Airbus A380");

		Ville paris = new Ville("Paris");
		Ville bordeaux = new Ville("Bordeaux");

		Aeroport roissy = new Aeroport("Aeroport de Roissy");
		Aeroport bordeauxAeroport = new Aeroport("Aeroport de Bordeaux");

		////////////////////////////

		Utilisateur valmonUtilisateur = new Utilisateur("valmonIdentifiant", "valmonMotdePasse");

		Particulier valmonClient = new Particulier("valmon@mail.fr");

		valmonClient.setUtilisateur(valmonUtilisateur);

		valmonUtilisateur.setClient(valmonClient);

		Passager valmonPassager = new Passager("Daujard","Valmon");
		
		//De utilisateur on affiche pas le client
		//De passager on affiche pas le client
		//De passager on affiche pas la reservation
		//De la reservation on a pas le client
		//Du paiement on a pas la reservation
		
		valmonPassager.setClient(valmonClient);
		valmonClient.addPassager(valmonPassager);
		
//		System.out.println(valmonPassager);
//		System.out.println(valmonClient);
		
		Reservation valmonReservation = new Reservation();
		valmonReservation.setNumeroDeReservation("1234567890");
		
		valmonPassager.addReservation(valmonReservation);
		valmonReservation.setPassager(valmonPassager);
		
//		System.out.println(valmonClient);
//		System.out.println(valmonPassager);
//		System.out.println(valmonReservation);
		
		valmonClient.addReservation(valmonReservation);
		valmonReservation.setClient(valmonClient);
		
//		System.out.println(valmonClient);
//		System.out.println(valmonReservation);
		
		Paiement valmonPaiement = new Paiement();
		valmonPaiement.setType("cb");
		valmonPaiement.setMontant(100.00f);
		
		valmonPaiement.setReservation(valmonReservation);
		valmonReservation.setPaiement(valmonPaiement);
		
//		System.out.println(valmonReservation);
//		System.out.println(valmonPaiement);
		
		Trajet valmonTrajet = new Trajet();
		valmonTrajet.setReservation(valmonReservation);
		valmonReservation.setTrajet(valmonTrajet);
		
//		System.out.println(valmonReservation);
//		System.out.println(valmonTrajet);
		
		//////
		////// On va associer le trajet au.x vol.s a la fin
		//////
		
		//De la compagnie on a pas le vol
		//De l avion on a pas le vol
		//De depart on a pas le vol
		//D arrivee on a pas le vol
		
		Vol bordeauxParis = new Vol("AF4578");
		
		bordeauxParis.setCompagnie(airFrance);
		airFrance.addVol(bordeauxParis);
		
//		System.out.println(bordeauxParis);
//		System.out.println(airFrance);
		
		bordeauxParis.setAvion(airbusA380);
		airbusA380.addVol(bordeauxParis);
		
//		System.out.println(bordeauxParis);
//		System.out.println(airbusA380);
		
		Depart bordeauxParisDepart = new Depart(bordeauxParis);
		bordeauxParis.setDepart(bordeauxParisDepart);
		
		System.out.println(bordeauxParis);
		System.out.println(bordeauxParisDepart);
		
		Arrivee bordeauxParisArrivee = new Arrivee(bordeauxParis);
		bordeauxParis.setArrivee(bordeauxParisArrivee);
		
		System.out.println(bordeauxParis);
		System.out.println(bordeauxParisArrivee);
		
		// manque l aeroport
		
		bordeauxParisArrivee.setAeroport(roissy);
		bordeauxParisDepart.setAeroport(bordeauxAeroport);

		System.out.println(bordeauxParisDepart);
		System.out.println(bordeauxParisArrivee);

		bordeauxAeroport.addVille(bordeaux);
		bordeaux.addAeroport(bordeauxAeroport);
		
		System.out.println(bordeaux);
		System.out.println(bordeauxAeroport);
		
		roissy.addVille(paris);
		paris.addAeroport(roissy);
		
		System.out.println(roissy);
		System.out.println(paris);
		
	}

}
