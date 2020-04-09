package tp.model.persistence.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tp.model.Passager;
import tp.model.persistence.IPassagerDao;

@Repository
@Transactional
public class PassagerDaoJpa implements IPassagerDao {

	@PersistenceContext
	private EntityManager em; // entityManagerFactory.createEntityManager()
	
	@Override
	@Transactional(readOnly = true)
	public List<Passager> findAll() {

			TypedQuery<Passager> query = em.createQuery("from Passager", Passager.class);

			return query.getResultList();
	}

	@Override
	@Transactional(readOnly = true)
	public Passager find(Long id) {

			return em.find(Passager.class, id);
	}

	@Override
	public Passager save(Passager obj) {
		
			return em.merge(obj);
	}

	@Override
	public void delete(Passager obj) {

			em.remove(em.merge(obj));
	}
}
