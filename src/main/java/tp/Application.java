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

public class Application {
	private static Application instance = null;

	private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("tp");

	private final IReservationDao reservationDao =new ReservationDaoJpa();
	private final IPaiementDao paiementDao = new PaiementDaoJpa();
	private final IPassagerDao passagerDao = new PassagerDaoJpa();
	private final ITrajetDao trajetDao = new TrajetDaoJpa();


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

	public IPaiementDao getPaiementDao() {
		return paiementDao;
	}

	public IPassagerDao getPassagerDao() {
		return passagerDao;
	}

	public ITrajetDao getTrajetDao() {
		return trajetDao;
	}


}
