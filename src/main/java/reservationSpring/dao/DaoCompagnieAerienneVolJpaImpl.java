package reservationSpring.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import reservation.model.CompagnieAerienneVol;
import reservation.model.CompagnieAerienneVolPk;
import reservation.util.EntityManagerFactorySingleton;

public class DaoCompagnieAerienneVolJpaImpl implements DaoCompagnieAerienneVol {

	@Override
	public void insert(CompagnieAerienneVol obj) {
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
	public CompagnieAerienneVol update(CompagnieAerienneVol obj) {
		CompagnieAerienneVol cav = null;
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			cav = em.merge(obj);
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
		return cav;
	}

	@Override
	public void delete(CompagnieAerienneVol obj) {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			em.remove(em.merge(obj));
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
	public void deleteByKey(CompagnieAerienneVolPk key) {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			em.remove(em.find(CompagnieAerienneVol.class, key));
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
	public CompagnieAerienneVol findByKey(CompagnieAerienneVolPk key) {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		CompagnieAerienneVol cav = null;
		cav = em.find(CompagnieAerienneVol.class, key);
		em.close();
		return cav;
	}

	@Override
	public List<CompagnieAerienneVol> findAll() {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		List<CompagnieAerienneVol> compagnieAerienneVols = null;
		Query query = em.createQuery("from CompagnieAerienneVol cav");
		compagnieAerienneVols = query.getResultList();
		em.close();
		return compagnieAerienneVols;
	}

}
