package reservationSpring.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import reservationSpring.model.CompagnieAerienneVol;
import reservationSpring.model.Reservation;
import reservationSpring.model.Vol;

@Repository
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class DaoVolJpaImpl implements DaoVol {

	@PersistenceContext
	EntityManager em;

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void insert(Vol obj) {
		em.persist(obj);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Vol update(Vol obj) {
		Vol v = null;
		v = em.merge(obj);
		return v;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void delete(Vol obj) {
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
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteByKey(Long key) {
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
	}

	@Override
	public Vol findByKey(Long key) {
		Vol v = null;
		v = em.find(Vol.class, key);
		return v;
	}

	@Override
	public List<Vol> findAll() {
		List<Vol> vols = null;
		Query query = em.createQuery("from vol v");
		vols = query.getResultList();
		return vols;
	}

	public Vol findByKeyWithReservation(Long key) {
		Vol v = null;
		Query query = em.createNamedQuery("Vol.findByKeyWithReservation");
		query.setParameter("key", key);
		try {
			v = (Vol) query.getSingleResult();
		} catch (NoResultException e) {

		}
		return v;
	}

	@Override
	public List<Vol> findAllWithReservation() {
		List<Vol> vols = null;
		Query query = em.createNamedQuery("Vol.findAllWithReservation");
		vols = query.getResultList();
		return vols;
	}

	@Override
	public Vol findByKeyWithEscale(Long key) {
		Vol v = null;
		Query query = em.createNamedQuery("Vol.findByKeyWithEscale");
		query.setParameter("key", key);
		try {
			v = (Vol) query.getSingleResult();
		} catch (NoResultException e) {

		}
		return v;
	}

	@Override
	public List<Vol> findAllWithEscale() {
		List<Vol> vols = null;
		Query query = em.createNamedQuery("Vol.findAllWithEscale");
		vols = query.getResultList();
		return vols;
	}

	@Override
	public Vol findByKeyWithCompagnie(Long key) {
		Vol v = null;
		Query query = em.createNamedQuery("Vol.findByKeyWithCompagnie");
		query.setParameter("key", key);
		try {
			v = (Vol) query.getSingleResult();
		} catch (NoResultException e) {

		}
		return v;
	}

	@Override
	public List<Vol> findAllWithCompagnie() {
		List<Vol> vols = null;
		Query query = em.createNamedQuery("Vol.findAllWithCompagnie");
		vols = query.getResultList();
		return vols;
	}

	@Override
	public Vol findByKeyWithAeroport(Long key) {
		Vol v = null;
		Query query = em.createNamedQuery("Vol.findByKeyWithAeroport");
		query.setParameter("key", key);
		try {
			v = (Vol) query.getSingleResult();
		} catch (NoResultException e) {

		}
		return v;
	}

	@Override
	public List<Vol> findAllWithAeroport() {
		List<Vol> vols = null;
		Query query = em.createNamedQuery("Vol.findAllWithAeroport");
		vols = query.getResultList();
		return vols;
	}
}
