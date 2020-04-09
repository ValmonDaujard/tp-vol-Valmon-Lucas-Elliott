package tp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.context.support.ClassPathXmlApplicationContext;

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
import tp.model.persistence.IAeroportDao;
import tp.model.persistence.IArriveeDao;
import tp.model.persistence.IAvionDao;
import tp.model.persistence.IClientDao;
import tp.model.persistence.ICompagnieDao;
import tp.model.persistence.IDepartDao;
import tp.model.persistence.IPaiementDao;
import tp.model.persistence.IParticulierDao;
import tp.model.persistence.IPassagerDao;
import tp.model.persistence.IReservationDao;
import tp.model.persistence.ISocieteDao;
import tp.model.persistence.ITrajetDao;
import tp.model.persistence.IUtilisateurDao;
import tp.model.persistence.IVilleDao;
import tp.model.persistence.IVolDao;

public class Test {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");

		IPaiementDao testPaiement = context.getBean(IPaiementDao.class);
		IReservationDao testReservation = context.getBean(IReservationDao.class);
		ITrajetDao testTrajet = context.getBean(ITrajetDao.class);
		ICompagnieDao testCompagnie = context.getBean(ICompagnieDao.class);
		IPassagerDao testPassager = context.getBean(IPassagerDao.class);
		ISocieteDao testSociete = context.getBean(ISocieteDao.class);
		IAeroportDao testAeroport = context.getBean(IAeroportDao.class);
		IVilleDao testVille = context.getBean(IVilleDao.class);
		IAvionDao testAvion = context.getBean(IAvionDao.class);
		IVolDao testVol = context.getBean(IVolDao.class);
		IDepartDao testDepart = context.getBean(IDepartDao.class);
		IParticulierDao testParticulier = context.getBean(IParticulierDao.class);
		IClientDao testClient = context.getBean(IClientDao.class);
		IUtilisateurDao testUtilisateur = context.getBean(IUtilisateurDao.class);
		IArriveeDao testArrivee = context.getBean(IArriveeDao.class);
		
		
		
		
		
		
		Compagnie airFrance = new Compagnie("Air France");
		airFrance = testCompagnie.save(airFrance);
		
			Avion airbusA380 = new Avion("Airbus A380");
			airbusA380 =testAvion.save(airbusA380);
		
				Ville paris = new Ville("Paris");
				paris =testVille.save(paris);
				Ville bordeaux = new Ville("Bordeaux");
				bordeaux = testVille.save(bordeaux);
		
			Aeroport roissy = new Aeroport("Aeroport de Roissy");
			roissy = testAeroport.save(roissy);
			Aeroport bordeauxAeroport = new Aeroport("Aeroport de Bordeaux");
			bordeauxAeroport = testAeroport.save(bordeauxAeroport);
		
			Vol bordeauxParis = new Vol("AF4578");
			bordeauxParis = testVol.save(bordeauxParis);
			
			bordeauxParis.setCompagnie(airFrance);
//			airFrance.addVol(bordeauxParis);
			
			bordeauxParis.setAvion(airbusA380);
//			airbusA380.addVol(bordeauxParis);

			
			Depart bordeauxParisDepart = new Depart(new Date());
			bordeauxParisDepart = testDepart.save(bordeauxParisDepart);
			bordeauxParis.setDepart(bordeauxParisDepart);
			
			Arrivee bordeauxParisArrivee = new Arrivee(new Date());
			bordeauxParisArrivee = testArrivee.save(bordeauxParisArrivee);
			bordeauxParis.setArrivee(bordeauxParisArrivee);
			
			bordeauxParisArrivee.setAeroport(roissy);
			bordeauxParisDepart.setAeroport(bordeauxAeroport);
	
	
			bordeauxAeroport.addVille(bordeaux);
			roissy.addVille(paris);
			
			bordeauxParisDepart = testDepart.save(bordeauxParisDepart);
			bordeauxParisArrivee = testArrivee.save(bordeauxParisArrivee);
			roissy = testAeroport.save(roissy);
			bordeauxAeroport = testAeroport.save(bordeauxAeroport);
			bordeauxParis = testVol.save(bordeauxParis);
	
		
		Societe sopraSteria = new Societe("Societe", "SOPRA",  "Numero de siret", "Numero de TVA", "SopraMail", "Tel Sopra", 20, "Avenue Pythagore", null, 33700,
				"MERIGNAC", "FRANCE");

		Particulier eric = new Particulier("Particulier", "SULTAN", "Eric", "e.sultan@ajc-ingenierie.fr", "0645104506", 86, "Avenue JFK", null, 33700,
				"MERIGNAC", "FRANCE");
		
		sopraSteria = testSociete.save(sopraSteria);
		eric = testParticulier.save(eric);

		System.out.println(sopraSteria);
		System.out.println(eric);

		Utilisateur userSopra = new Utilisateur("id SOPRA", "mdp");
		Utilisateur userEric = new Utilisateur("id Eric", "MDP");

		userSopra = testUtilisateur.save(userSopra);
		userEric = testUtilisateur.save(userEric);
		
		sopraSteria.setUtilisateur(userSopra);
		userSopra.setClient(sopraSteria);
		eric.setUtilisateur(userEric);
		userEric.setClient(eric);
		
		sopraSteria = testSociete.save(sopraSteria);
		userSopra = testUtilisateur.save(userSopra);
		eric = testParticulier.save(eric);
		userEric = testUtilisateur.save(userEric);
		
		
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
		
		bordeauxParis = testVol.save(bordeauxParis);
		reservation1.setTrajet(parisNY);
		
		reservation1 = testReservation.save(reservation1);
		
		valmon.setClient(sopraSteria);
		
		reservation1.setClient(sopraSteria);
		reservation1.setPassager(valmon);
		
		valmon = testPassager.save(valmon);
		
		reservation1 = testReservation.save(reservation1);
		
		
	}

}
