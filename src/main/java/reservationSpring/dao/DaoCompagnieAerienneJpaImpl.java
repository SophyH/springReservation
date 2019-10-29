package reservationSpring.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import reservation.model.CompagnieAerienne;
import reservation.model.CompagnieAerienneVol;
import reservation.util.EntityManagerFactorySingleton;

public class DaoCompagnieAerienneJpaImpl implements DaoCompagnieAerienne {

	@Override
	public void insert(CompagnieAerienne obj) {
		EntityManager em = null;
		em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			em.persist(obj);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		} finally {
			if (em != null && em.isOpen()) {
				em.close();
			}
		}
	}

	@Override
	public CompagnieAerienne update(CompagnieAerienne obj) {
		CompagnieAerienne ca = null;
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			ca = em.merge(obj);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		} finally {
			if (em != null && em.isOpen()) {
				em.close();
			}
		}
		return ca;
	}

	@Override
	public void delete(CompagnieAerienne obj) {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			CompagnieAerienne ca = em.merge(obj);
			for (CompagnieAerienneVol cav : ca.getCompagnieAerienneVol()) {
				cav.getKey().setCompagnieAerienne(null);
			}
			em.remove(ca);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		} finally {
			if (em != null && em.isOpen()) {
				em.close();
			}
		}
	}

	@Override
	public void deleteByKey(Long key) {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			CompagnieAerienne ca = em.find(CompagnieAerienne.class, key);
			for (CompagnieAerienneVol cav : ca.getCompagnieAerienneVol()) {
				cav.getKey().setCompagnieAerienne(null);
			}
			em.remove(ca);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		} finally {
			if (em != null && em.isOpen()) {
				em.close();
			}
		}
	}

	@Override
	public CompagnieAerienne findByKey(Long key) {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		CompagnieAerienne ca = null;
		ca = em.find(CompagnieAerienne.class, key);
		em.close();
		return ca;
	}

	@Override
	public List<CompagnieAerienne> findAll() {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		List<CompagnieAerienne> compagnieAeriennes = null;
		Query query = em.createQuery("from CompagnieAerienne ca");
		compagnieAeriennes = query.getResultList();
		em.close();
		return compagnieAeriennes;
	}

	@Override
	public CompagnieAerienne findByKeyWithCompagniesVols(Long key) {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		CompagnieAerienne ca = null;
		Query query = em.createNamedQuery("CompagnieAerienne.findByKeyWithCompagniesVols");
		query.setParameter("key", key);
		try {
			ca = (CompagnieAerienne) query.getSingleResult();
		} catch (NoResultException e) {

		}
		em.close();
		return ca;
	}

	@Override
	public List<CompagnieAerienne> findAllWithCompagniesVols(Long key) {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		List<CompagnieAerienne> compagnieAeriennes = null;
		Query query = em.createNamedQuery("CompagnieAerienne.findAllWithCompagniesVols");
		compagnieAeriennes = query.getResultList();
		em.close();
		return compagnieAeriennes;
	}

}
