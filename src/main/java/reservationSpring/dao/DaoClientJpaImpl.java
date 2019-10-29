package reservationSpring.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import reservation.model.Client;
import reservation.model.ClientEI;
import reservation.model.ClientMoral;
import reservation.model.ClientPhysique;
import reservation.model.Login;
import reservation.model.Reservation;
import reservation.util.EntityManagerFactorySingleton;

class DaoClientJpaImpl implements DaoClient {

	@Override
	public void insert(Client obj) {
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
	public Client update(Client obj) {
		Client c = null;
		EntityManager em = null;
		em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			c = em.merge(obj);
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
		return c;
	}

	@Override
	public void delete(Client obj) {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			Client c = em.merge(obj);
			for (Reservation r: c.getReservations()) { 
					r.setClient(null);
				}
			c.setLogin(null);
			em.remove(c);
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
			Client c = em.find(Client.class, key);
			for (Reservation r : c.getReservations()) { 
				r.setClient(null);
			}
			c.setLogin(null);
			em.remove(c);
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
	public Client findByKey(Long key) {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		Client c = null;
		c = em.find(Client.class, key);
		em.close();
		return c;
	}

	@Override
	public List<Client> findAll() {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		List<Client> clients = null;
		Query query = em.createQuery("from Client c");
		clients = query.getResultList();
		em.close();
		return clients;
	}

	@Override
	public List<ClientEI> findAllClientEI() {
		List<ClientEI> clients = null;
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		Query query = em.createQuery("from ClientEI cei ");
		clients = query.getResultList();
		em.close();
		return clients;
	}

	@Override
	public List<ClientMoral> findAllClientMoral() {
		List<ClientMoral> clients = null;
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		Query query = em.createQuery("from ClientMoral cm ");
		clients = query.getResultList();
		em.close();
		return clients;
	}

	@Override
	public List<ClientPhysique> findAllClientPhysique() {
		List<ClientPhysique> clients = null;
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		Query query = em.createQuery("from ClientPhysique cp ");
		clients = query.getResultList();
		em.close();
		return clients;
	}

	@Override
	public Client findByKeyWithReservations(Long key){
		Client client = null;
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		Query query = em.createNamedQuery("Client.findByKeyWithReservations"); 
		query.setParameter("key", key);
		try {
		client = (Client) query.getSingleResult(); 
		}catch (NoResultException e){
			
		}
		em.close();
		return client;	
	}

	@Override
	public List<Client> findAllWithReservations() {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		List<Client> clients = null;
		Query query = em.createNamedQuery("Client.findAllWithReservations");
		clients = query.getResultList();
		em.close();
		return clients;
	}
}
