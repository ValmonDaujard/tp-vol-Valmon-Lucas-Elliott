package tp;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import tp.model.persistence.IAeroportDao;
import tp.model.persistence.IArriveeDao;
import tp.model.persistence.IAvionDao;
import tp.model.persistence.ICompagnieDao;
import tp.model.persistence.IDepartDao;
import tp.model.persistence.IVilleDao;
import tp.model.persistence.IVolDao;
import tp.model.persistence.jpa.AeroportDaoJpa;
import tp.model.persistence.jpa.ArriveeDaoJpa;
import tp.model.persistence.jpa.AvionDaoJpa;
import tp.model.persistence.jpa.CompagnieDaoJpa;
import tp.model.persistence.jpa.DepartDaoJpa;
import tp.model.persistence.jpa.VilleDaoJpa;
import tp.model.persistence.jpa.VolDaoJpa;

public class Application {
	private static Application instance = null;

	private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("tp");
	
	private final IVilleDao villeDao =new VilleDaoJpa();
	private final IAeroportDao aeroportDao =new AeroportDaoJpa();
	private final IAvionDao avionDao =new AvionDaoJpa();
	private final IArriveeDao arriveeDao =new ArriveeDaoJpa();
	private final IDepartDao departDao =new DepartDaoJpa();
	private final IVolDao volDao =new VolDaoJpa();
	private final ICompagnieDao compagnieDao =new CompagnieDaoJpa();
	

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

	public IVilleDao getVilleDao() {
		return villeDao;
	}

	public IAeroportDao getAeroportDao() {
		return aeroportDao;
	}

	public IAvionDao getAvionDao() {
		return avionDao;
	}

	public IArriveeDao getArriveeDao() {
		return arriveeDao;
	}

	public IDepartDao getDepartDao() {
		return departDao;
	}

	public IVolDao getVolDao() {
		return volDao;
	}

	public ICompagnieDao getCompagnieDao() {
		return compagnieDao;
	}

}
