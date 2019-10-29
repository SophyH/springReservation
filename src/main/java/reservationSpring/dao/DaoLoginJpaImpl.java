package reservationSpring.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import reservation.model.Client;
import reservation.model.Login;
import reservation.model.Reservation;
import reservation.util.EntityManagerFactorySingleton;

class DaoLoginJpaImpl implements DaoLogin{

	@Override
	public void insert(Login obj) {
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
	public Login update(Login obj) {
		Login l = null;
		EntityManager em = null;
		em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			l = em.merge(obj);
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
		return l;
	}

	@Override
	public void delete(Login obj) {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			Login l = em.merge(obj);
			Client c =l.getClient();
			c.setLogin(null);	
			em.remove(l);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if(tx !=null && tx.isActive()) {
				tx.rollback(); 		
				}
		}finally{
			if (em !=null && em.isOpen()) {
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
			Login l = em.merge(em.find(Login.class, key));
			Client c =l.getClient();
			c.setLogin(null);	
			em.remove(l);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if(tx !=null && tx.isActive()) {
				tx.rollback(); 		
				}
		}finally{
			if (em !=null && em.isOpen()) {
				em.close();
			}
		}		
	}

	@Override
	public Login findByKey(Long key) {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		Login l = null;
		l = em.find(Login.class, key);
		em.close();
		return l;
	}

	@Override
	public List<Login> findAll() {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		List<Login> logins = null;
		Query query = em.createQuery("from Login l");
		logins = query.getResultList();
		em.close();
		return logins;
	}

}
