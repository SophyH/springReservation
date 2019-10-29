package reservationSpring.dao;

import java.util.List;

import reservation.model.Passager;

public interface DaoPassager extends DaoGeneric<Passager, Long> {

	public Passager findByKeyWithReservation(Long key);

	public List<Passager> findAllWithReservation();

}
