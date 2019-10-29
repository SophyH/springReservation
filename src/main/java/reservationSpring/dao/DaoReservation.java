package reservationSpring.dao;

import java.util.List;

import reservation.model.Reservation;

public interface DaoReservation extends DaoGeneric<Reservation, Long> {

	Reservation findByKeyWithPassager(Long key);

	List<Reservation> findAllWithPassager();

	Reservation findByKeyWithVols(Long key);

	List<Reservation> findAllWithVols();

	Reservation findByKeyWithVolsAndPassager(Long key);

	List<Reservation> findAllWithVolsAndPassager();

	Reservation findByKeyWithClient(Long key);

	List<Reservation> findAllWithClient();

}
