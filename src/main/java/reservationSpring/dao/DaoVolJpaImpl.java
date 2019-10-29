package reservationSpring.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import reservation.model.CompagnieAerienneVol;
import reservation.model.Reservation;
import reservation.model.Vol;
import reservation.util.EntityManagerFactorySingleton;

public class DaoVolJpaImpl implements DaoVol {

	@Override
	public void insert(Vol obj) {
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
	public Vol update(Vol obj) {
		Vol s = null;
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			s = em.merge(obj);
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
		return s;
	}

	@Override
	public void delete(Vol obj) {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			Vol v = em.merge(obj);
			v.getAeroportArrivee().setVolArrivee(null);
			v.getAeroportDepart().setVolDepart(null);
			v.setEscales(null);
			for (CompagnieAerienneVol cav : v.getCompagnieAerienneVol()) {
				cav.getKey().setVol(null);
			}
			for (Reservation r : v.getReservation()) {
				r.setVols(null);
			}
			em.remove(v);
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
			Vol v = em.find(Vol.class, key);
			v.getAeroportArrivee().setVolArrivee(null);
			v.getAeroportDepart().setVolDepart(null);
			v.setEscales(null);
			for (CompagnieAerienneVol cav : v.getCompagnieAerienneVol()) {
				cav.getKey().setVol(null);
			}
			for (Reservation r : v.getReservation()) {
				r.setVols(null);
			}
			em.remove(v);
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
	public Vol findByKey(Long key) {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		Vol s = null;
		s = em.find(Vol.class, key);
		em.close();
		return s;
	}

	@Override
	public List<Vol> findAll() {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		List<Vol> vols = null;
		Query query = em.createQuery("from vol v");
		vols = query.getResultList();
		em.close();
		return vols;
	}

	public Vol findByKeyWithReservation(Long key) {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		Vol v = null;
		Query query = em.createNamedQuery("Vol.findByKeyWithReservation");
		query.setParameter("key", key);
		try {
			v = (Vol) query.getSingleResult();
		} catch (NoResultException e) {

		}
		em.close();
		return v;
	}

	@Override
	public List<Vol> findAllWithReservation() {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		List<Vol> vols = null;
		Query query = em.createNamedQuery("Vol.findAllWithReservation");
		vols = query.getResultList();
		em.close();
		return vols;
	}

	@Override
	public Vol findByKeyWithEscale(Long key) {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		Vol v = null;
		Query query = em.createNamedQuery("Vol.findByKeyWithEscale");
		query.setParameter("key", key);
		try {
			v = (Vol) query.getSingleResult();
		} catch (NoResultException e) {

		}
		em.close();
		return v;
	}

	@Override
	public List<Vol> findAllWithEscale() {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		List<Vol> vols = null;
		Query query = em.createNamedQuery("Vol.findAllWithEscale");
		vols = query.getResultList();
		em.close();
		return vols;
	}

	@Override
	public Vol findByKeyWithCompagnie(Long key) {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		Vol v = null;
		Query query = em.createNamedQuery("Vol.findByKeyWithCompagnie");
		query.setParameter("key", key);
		try {
			v = (Vol) query.getSingleResult();
		} catch (NoResultException e) {

		}
		em.close();
		return v;
	}

	@Override
	public List<Vol> findAllWithCompagnie() {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		List<Vol> vols = null;
		Query query = em.createNamedQuery("Vol.findAllWithCompagnie");
		vols = query.getResultList();
		em.close();
		return vols;
	}

	@Override
	public Vol findByKeyWithAeroport(Long key) {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		Vol v = null;
		Query query = em.createNamedQuery("Vol.findByKeyWithAeroport");
		query.setParameter("key", key);
		try {
			v = (Vol) query.getSingleResult();
		} catch (NoResultException e) {

		}
		em.close();
		return v;
	}

	@Override
	public List<Vol> findAllWithAeroport() {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		List<Vol> vols = null;
		Query query = em.createNamedQuery("Vol.findAllWithAeroport");
		vols = query.getResultList();
		em.close();
		return vols;
	}

}
