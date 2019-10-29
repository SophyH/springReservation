package reservationSpring.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import reservation.model.Passager;
import reservation.model.Reservation;
import reservation.util.EntityManagerFactorySingleton;

public class DaoPassagerJpaImpl implements DaoPassager {

	@Override
	public void insert(Passager obj) {
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
	public Passager update(Passager obj) {
		Passager p = null;
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			p = em.merge(obj);
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
		return p;
	}

	@Override
	public void delete(Passager obj) {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			Passager p = em.merge(obj);
			for (Reservation r : p.getReservation()) {
				r.setPassagers(null);
			}
			em.remove(p);
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
			Passager p = em.find(Passager.class, key);
			for (Reservation r : p.getReservation()) {
				r.setPassagers(null);
			}
			em.remove(p);
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
	public Passager findByKey(Long key) {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		Passager p = null;
		p = em.find(Passager.class, key);
		em.close();
		return p;
	}

	@Override
	public List<Passager> findAll() {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		List<Passager> passagers = null;
		Query query = em.createQuery("from Passager p");
		passagers = query.getResultList();
		em.close();
		return passagers;
	}

	@Override
	public Passager findByKeyWithReservation(Long key) {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		Passager p = null;
		Query query = em.createNamedQuery("Passager.findByKeyWithReservation");
		query.setParameter("key", key);
		try {
			p = (Passager) query.getSingleResult();
		} catch (NoResultException e) {

		}
		em.close();
		return p;
	}

	@Override
	public List<Passager> findAllWithReservation() {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		List<Passager> passagers = null;
		Query query = em.createNamedQuery("Passager.findAllWithReservation");
		passagers = query.getResultList();
		em.close();
		return passagers;
	}

}
