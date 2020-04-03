package tp;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import tp.Application;
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
import tp.model.persistence.IPaiementDao;
import tp.model.persistence.IPassagerDao;
import tp.model.persistence.IReservationDao;
import tp.model.persistence.ITrajetDao;

public class Test {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		IPaiementDao testPaiement = Application.getInstance().getPaiementDao();
		IReservationDao testReservation = Application.getInstance().getReservationDao();
		ITrajetDao testTrajet = Application.getInstance().getTrajetDao();
		IPassagerDao testPassager = Application.getInstance().getPassagerDao();
		
		
//		Compagnie airFrance = new Compagnie("Air France");
//
//		Avion airbusA380 = new Avion("Airbus A380");
//
//		Ville paris = new Ville("Paris");
//		Ville bordeaux = new Ville("Bordeaux");
//
//		Aeroport roissy = new Aeroport("Aeroport de Roissy");
//		Aeroport bordeauxAeroport = new Aeroport("Aeroport de Bordeaux");
//
//		////////////////////////////
//
//		Utilisateur valmonUtilisateur = new Utilisateur("valmonIdentifiant", "valmonMotdePasse");
//
//		Particulier valmonClient = new Particulier("valmon@mail.fr");
//
//		valmonClient.setUtilisateur(valmonUtilisateur);
//
//		valmonUtilisateur.setClient(valmonClient);
//
//		Passager valmonPassager = new Passager("Daujard","Valmon");
//		
//		//De utilisateur on affiche pas le client
//		//De passager on affiche pas le client
//		//De passager on affiche pas la reservation
//		//De la reservation on a pas le client
//		//Du paiement on a pas la reservation
//		
//		valmonPassager.setClient(valmonClient);
//		valmonClient.addPassager(valmonPassager);
//		
////		System.out.println(valmonPassager);
////		System.out.println(valmonClient);
//		
//		Reservation valmonReservation = new Reservation();
//		valmonReservation.setNumeroDeReservation("1234567890");
//		
//		valmonPassager.addReservation(valmonReservation);
//		valmonReservation.setPassager(valmonPassager);
//		
////		System.out.println(valmonClient);
////		System.out.println(valmonPassager);
////		System.out.println(valmonReservation);
//		
//		valmonClient.addReservation(valmonReservation);
//		valmonReservation.setClient(valmonClient);
//		
////		System.out.println(valmonClient);
////		System.out.println(valmonReservation);
//		
//		Paiement valmonPaiement = new Paiement();
//		valmonPaiement.setType("cb");
//		valmonPaiement.setMontant(100.00f);
//		
//		valmonPaiement.setReservation(valmonReservation);
//		valmonReservation.setPaiement(valmonPaiement);
//		
////		System.out.println(valmonReservation);
////		System.out.println(valmonPaiement);
//		
//		Trajet valmonTrajet = new Trajet();
//		valmonTrajet.setReservation(valmonReservation);
//		valmonReservation.setTrajet(valmonTrajet);
//		
////		System.out.println(valmonReservation);
////		System.out.println(valmonTrajet);
//		
//		//////
//		////// On va associer le trajet au.x vol.s a la fin
//		//////
//		
//		//De la compagnie on a pas le vol
//		//De l avion on a pas le vol
//		//De depart on a pas le vol
//		//D arrivee on a pas le vol
//		
//		Vol bordeauxParis = new Vol("AF4578");
//		
//		bordeauxParis.setCompagnie(airFrance);
//		airFrance.addVol(bordeauxParis);
//		
////		System.out.println(bordeauxParis);
////		System.out.println(airFrance);
//		
//		bordeauxParis.setAvion(airbusA380);
//		airbusA380.addVol(bordeauxParis);
//		
////		System.out.println(bordeauxParis);
////		System.out.println(airbusA380);
//		
//		Depart bordeauxParisDepart = new Depart(bordeauxParis);
//		bordeauxParis.setDepart(bordeauxParisDepart);
//		
//		System.out.println(bordeauxParis);
//		System.out.println(bordeauxParisDepart);
//		
//		Arrivee bordeauxParisArrivee = new Arrivee(bordeauxParis);
//		bordeauxParis.setArrivee(bordeauxParisArrivee);
//		
//		System.out.println(bordeauxParis);
//		System.out.println(bordeauxParisArrivee);
//		
//		// manque l aeroport
//		
//		bordeauxParisArrivee.setAeroport(roissy);
//		bordeauxParisDepart.setAeroport(bordeauxAeroport);
//
//		System.out.println(bordeauxParisDepart);
//		System.out.println(bordeauxParisArrivee);
//
//		bordeauxAeroport.addVille(bordeaux);
//		bordeaux.addAeroport(bordeauxAeroport);
//		
//		System.out.println(bordeaux);
//		System.out.println(bordeauxAeroport);
//		
//		roissy.addVille(paris);
//		paris.addAeroport(roissy);
//		
//		System.out.println(roissy);
//		System.out.println(paris);
		
		Paiement paiement1 = new Paiement();
		paiement1.setMontant((float) 352);
		paiement1.setType("carte banquaire");
		
		paiement1 = testPaiement.save(paiement1);
		
		Paiement paiement2 = new Paiement();
		paiement2.setMontant((float) 458);
		paiement2.setType("cheque");
		
		paiement2 = testPaiement.save(paiement2);

		Reservation reservation1= new Reservation(false,true,true,"4586");
		reservation1.setPaiement(paiement1);
		
		reservation1 = testReservation.save(reservation1);
		
		Passager valmon = new Passager("daujard","FR785412",sdf.parse("15/07/2025"));
		valmon.addReservation(reservation1);
		
		valmon = testPassager.save(valmon);
		
		Trajet parisNY = new Trajet();
		
		parisNY = testTrajet.save(parisNY);
		
		reservation1.setTrajet(parisNY);
		
		reservation1 = testReservation.save(reservation1);
		
		
		
		
	}

}
