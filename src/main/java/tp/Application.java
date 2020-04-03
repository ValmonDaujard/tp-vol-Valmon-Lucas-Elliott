package tp;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import tp.model.persistence.IPaiementDao;
import tp.model.persistence.IPassagerDao;
import tp.model.persistence.IReservationDao;
import tp.model.persistence.ITrajetDao;
import tp.model.persistence.jpa.PaiementDaoJpa;
import tp.model.persistence.jpa.PassagerDaoJpa;
import tp.model.persistence.jpa.ReservationDaoJpa;
import tp.model.persistence.jpa.TrajetDaoJpa;
import tp.model.persistence.IClientDao;
import tp.model.persistence.IParticulierDao;
import tp.model.persistence.ISocieteDao;
import tp.model.persistence.IUtilisateurDao;
import tp.model.persistence.jpa.ClientDaoJpa;
import tp.model.persistence.jpa.ParticulierDaoJpa;
import tp.model.persistence.jpa.SocieteDaoJpa;
import tp.model.persistence.jpa.UtilisateurDaoJpa;

public class Application {
	private static Application instance = null;

	private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("tp");

	private final IReservationDao reservationDao =new ReservationDaoJpa();
	private final IPaiementDao paiementDao = new PaiementDaoJpa();
	private final IPassagerDao passagerDao = new PassagerDaoJpa();
	private final ITrajetDao trajetDao = new TrajetDaoJpa();
	private final IClientDao clientDao = new ClientDaoJpa();
	private final IUtilisateurDao utilisateurDao = new UtilisateurDaoJpa();
	private final IParticulierDao particulierDao = new ParticulierDaoJpa();
	private final ISocieteDao societeDao = new SocieteDaoJpa();


	private Application() {
	}

	public static Application getInstance() {
		if (instance == null) {
			instance = new Application();
		}

		return instance;
	}

	public EntityManagerFactory getEmf() {
		return emf;
	}

	public IReservationDao getReservationDao() {
		return reservationDao;
	}
	public IClientDao getClientDao() {
		return clientDao;
	}

	public IPaiementDao getPaiementDao() {
		return paiementDao;
	}

	public IPassagerDao getPassagerDao() {
		return passagerDao;
	}

	public ITrajetDao getTrajetDao() {
		return trajetDao;
	}


	public IUtilisateurDao getUtilisateurDao() {
		return utilisateurDao;
	}

	public IParticulierDao getParticulierDao() {
		return particulierDao;
	}

	public ISocieteDao getSocieteDao() {
		return societeDao;
	}


}
