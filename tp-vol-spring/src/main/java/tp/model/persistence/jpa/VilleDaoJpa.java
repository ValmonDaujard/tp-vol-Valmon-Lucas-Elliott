package tp.model.persistence.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tp.model.Ville;
import tp.model.persistence.IVilleDao;

@Repository
@Transactional
public class VilleDaoJpa implements IVilleDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional(readOnly = true)
	public List<Ville> findAll() {

		TypedQuery<Ville> query = em.createQuery("from Ville", Ville.class);

		return query.getResultList();

	}

	@Override
	@Transactional(readOnly = true)
	public Ville find(Long id) {

		return em.find(Ville.class, id);

	}

	@Override
	public Ville save(Ville obj) {

		return em.merge(obj);

	}

	@Override
	public void delete(Ville obj) {

		em.remove(em.merge(obj));

	}
}
