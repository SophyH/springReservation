package reservationSpring.dao;

import java.util.List;

import reservationSpring.model.Vol;

public interface DaoVol extends DaoGeneric<Vol, Long> {

	public Vol findByKeyWithReservation(Long key);

	public List<Vol> findAllWithReservation();

	public Vol findByKeyWithEscale(Long key);

	public List<Vol> findAllWithEscale();

	public Vol findByKeyWithCompagnie(Long key);

	public List<Vol> findAllWithCompagnie();

	public Vol findByKeyWithAeroport(Long key);

	public List<Vol> findAllWithAeroport();

}
