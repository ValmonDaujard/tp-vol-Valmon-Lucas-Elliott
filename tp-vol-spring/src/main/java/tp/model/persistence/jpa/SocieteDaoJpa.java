package tp.model.persistence.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tp.model.Societe;
import tp.model.persistence.ISocieteDao;

@Repository
@Transactional
public class SocieteDaoJpa implements ISocieteDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional(readOnly = true)
	public List<Societe> findAll() {

		TypedQuery<Societe> query = em.createQuery("from Societe", Societe.class);

		return query.getResultList();

	}

	@Override
	@Transactional(readOnly = true)
	public Societe find(Long id) {

		return em.find(Societe.class, id);

	}

	@Override
	public Societe save(Societe obj) {

		return em.merge(obj);

	}

	@Override
	public void delete(Societe obj) {

		em.remove(em.merge(obj));

	}

}
