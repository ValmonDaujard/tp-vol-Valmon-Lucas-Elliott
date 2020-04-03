package tp;

import java.util.Date;

import tp.model.Aeroport;
import tp.model.Arrivee;
import tp.model.Avion;
import tp.model.Compagnie;
import tp.model.Depart;
import tp.model.Ville;
import tp.model.Vol;

public class TestVille {

	public static void main(String[] args) {
//		Ville bordeaux = new Ville("Bordeaux"); // new
//		bordeaux = Application.getInstance().getVilleDao().save(bordeaux); // managed
//		bordeaux.setPays("France"); // detached
//		bordeaux = Application.getInstance().getVilleDao().save(bordeaux);
		
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
	}
}