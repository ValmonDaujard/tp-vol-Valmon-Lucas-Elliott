package tp.model.persistence.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tp.model.Particulier;
import tp.model.persistence.IParticulierDao;

@Repository
@Transactional
public class ParticulierDaoJpa implements IParticulierDao {

	@PersistenceContext
	private EntityManager em; // entityManagerFactory.createEntityManager()
	
	@Override
	@Transactional(readOnly = true)
	public List<Particulier> findAll() {

			TypedQuery<Particulier> query = em.createQuery("from Particulier", Particulier.class);

			return query.getResultList();
	}

	@Override
	@Transactional(readOnly = true)
	public Particulier find(Long id) {

			return em.find(Particulier.class, id);
	}

	@Override
	public Particulier save(Particulier obj) {
		
			return em.merge(obj);
	}

	@Override
	public void delete(Particulier obj) {

			em.remove(em.merge(obj));
	}
}
