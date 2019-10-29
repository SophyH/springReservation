package reservationSpring.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import reservation.model.Aeroport;
import reservation.model.Escale;
import reservation.model.Liaisons;
import reservation.model.Vol;
import reservation.util.EntityManagerFactorySingleton;

public class DaoAeroportJpaImpl implements DaoAeroport {

	@Override
	public void insert(Aeroport obj) {
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
	public Aeroport update(Aeroport obj) {
		Aeroport a = null;
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			a = em.merge(obj);
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
		return a;
	}

	@Override
	public void delete(Aeroport obj) {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			Aeroport a = em.merge(obj);
			for (Vol v : a.getVolArrivee()) {
				v.setAeroportArrivee(null);
			}
			for (Vol v : a.getVolDepart()) {
				v.setAeroportDepart(null);
			}

			for (Liaisons l : a.getLiaisons()) {
				l.getKey().setAeroport(null);
			}

			for (Escale e : a.getEscales()) {
				e.getKey().setAeroport(null);
			}
			em.remove(a);
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
			Aeroport a = em.find(Aeroport.class, key);
			for (Vol v : a.getVolArrivee()) {
				v.setAeroportArrivee(null);
			}
			for (Vol v : a.getVolDepart()) {
				v.setAeroportDepart(null);
			}

			for (Liaisons l : a.getLiaisons()) {
				l.getKey().setAeroport(null);
			}

			for (Escale e : a.getEscales()) {
				e.getKey().setAeroport(null);
			}
			em.remove(a);
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
	public Aeroport findByKey(Long key) {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		Aeroport s = null;
		s = em.find(Aeroport.class, key);
		em.close();
		return s;
	}

	@Override
	public List<Aeroport> findAll() {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		List<Aeroport> aeroports = null;
		Query query = em.createQuery("from vol v");
		aeroports = query.getResultList();
		em.close();
		return aeroports;
	}

	@Override
	public Aeroport findByKeyWithVille(Long key) {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		Aeroport a = null;
		Query query = em.createNamedQuery("Aeroport.findByKeyWithVille");
		query.setParameter("key", key);
		try {
			a = (Aeroport) query.getSingleResult();
		} catch (NoResultException e) {

		}
		em.close();
		return a;
	}

	@Override
	public List<Aeroport> findAllWithVille() {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		List<Aeroport> aeroports = null;
		Query query = em.createNamedQuery("Aeroport.findAllWithVille");
		aeroports = query.getResultList();
		em.close();
		return aeroports;
	}

	@Override
	public Aeroport findByKeyWithEscale(Long key) {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		Aeroport a = null;
		Query query = em.createNamedQuery("Aeroport.findByKeyWithEscale");
		query.setParameter("key", key);
		try {
			a = (Aeroport) query.getSingleResult();
		} catch (NoResultException e) {

		}
		em.close();
		return a;
	}

	@Override
	public List<Aeroport> findAllWithEscale() {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		List<Aeroport> aeroports = null;
		Query query = em.createNamedQuery("Aeroport.findAllWithEscale");
		aeroports = query.getResultList();
		em.close();
		return aeroports;
	}

}
