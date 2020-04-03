package tp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
		
		
		Compagnie airFrance = new Compagnie("Air France");
		airFrance = Application.getInstance().getCompagnieDao().save(airFrance);
		
			Avion airbusA380 = new Avion("Airbus A380");
			airbusA380 = Application.getInstance().getAvionDao().save(airbusA380);
		
				Ville paris = new Ville("Paris");
				paris = Application.getInstance().getVilleDao().save(paris);
				Ville bordeaux = new Ville("Bordeaux");
				bordeaux = Application.getInstance().getVilleDao().save(bordeaux);
		
			Aeroport roissy = new Aeroport("Aeroport de Roissy");
			roissy = Application.getInstance().getAeroportDao().save(roissy);
			Aeroport bordeauxAeroport = new Aeroport("Aeroport de Bordeaux");
			bordeauxAeroport = Application.getInstance().getAeroportDao().save(bordeauxAeroport);
		
			Vol bordeauxParis = new Vol("AF4578");
			bordeauxParis = Application.getInstance().getVolDao().save(bordeauxParis);
			
			bordeauxParis.setCompagnie(airFrance);
//			airFrance.addVol(bordeauxParis);
			
			bordeauxParis.setAvion(airbusA380);
//			airbusA380.addVol(bordeauxParis);

			
			Depart bordeauxParisDepart = new Depart(new Date());
			bordeauxParisDepart = Application.getInstance().getDepartDao().save(bordeauxParisDepart);
			bordeauxParis.setDepart(bordeauxParisDepart);
			
			Arrivee bordeauxParisArrivee = new Arrivee(new Date());
			bordeauxParisArrivee = Application.getInstance().getArriveeDao().save(bordeauxParisArrivee);
			bordeauxParis.setArrivee(bordeauxParisArrivee);
			
			bordeauxParisArrivee.setAeroport(roissy);
			bordeauxParisDepart.setAeroport(bordeauxAeroport);
	
	
			bordeauxAeroport.addVille(bordeaux);
			roissy.addVille(paris);
			
			bordeauxParisDepart = Application.getInstance().getDepartDao().save(bordeauxParisDepart);
			bordeauxParisArrivee = Application.getInstance().getArriveeDao().save(bordeauxParisArrivee);
			roissy = Application.getInstance().getAeroportDao().save(roissy);
			bordeauxAeroport = Application.getInstance().getAeroportDao().save(bordeauxAeroport);
			bordeauxParis = Application.getInstance().getVolDao().save(bordeauxParis);
	
		
		Societe sopraSteria = new Societe("Societe", "SOPRA",  "Numero de siret", "Numero de TVA", "SopraMail", "Tel Sopra", 20, "Avenue Pythagore", null, 33700,
				"MERIGNAC", "FRANCE");

		Particulier eric = new Particulier("Particulier", "SULTAN", "Eric", "e.sultan@ajc-ingenierie.fr", "0645104506", 86, "Avenue JFK", null, 33700,
				"MERIGNAC", "FRANCE");
		
		sopraSteria = Application.getInstance().getSocieteDao().save(sopraSteria);
		eric = Application.getInstance().getParticulierDao().save(eric);

		System.out.println(sopraSteria);
		System.out.println(eric);

		Utilisateur userSopra = new Utilisateur("id SOPRA", "mdp");
		Utilisateur userEric = new Utilisateur("id Eric", "MDP");

		userSopra = Application.getInstance().getUtilisateurDao().save(userSopra);
		userEric = Application.getInstance().getUtilisateurDao().save(userEric);
		
		sopraSteria.setUtilisateur(userSopra);
		userSopra.setClient(sopraSteria);
		eric.setUtilisateur(userEric);
		userEric.setClient(eric);
		
		sopraSteria = Application.getInstance().getSocieteDao().save(sopraSteria);
		userSopra = Application.getInstance().getUtilisateurDao().save(userSopra);
		eric = Application.getInstance().getParticulierDao().save(eric);
		userEric = Application.getInstance().getUtilisateurDao().save(userEric);
		
		
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
		bordeauxParis.addTrajet(parisNY);
		
		bordeauxParis = Application.getInstance().getVolDao().save(bordeauxParis);
		reservation1.setTrajet(parisNY);
		
		reservation1 = testReservation.save(reservation1);
		
		valmon.setClient(sopraSteria);
		
		reservation1.setClient(sopraSteria);
		reservation1.setPassager(valmon);
		
		valmon = testPassager.save(valmon);
		
		reservation1 = testReservation.save(reservation1);
		
		
	}

}
