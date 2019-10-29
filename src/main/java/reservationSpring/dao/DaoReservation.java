package reservationSpring.dao;

import java.util.List;
import java.util.Optional;

import reservationSpring.model.Reservation;

public interface DaoReservation extends DaoGeneric<Reservation, Long> {

	public Optional<Reservation> findByKeyWithPassager(Long key);

	public List<Reservation> findAllWithPassager();

	public Optional<Reservation> findByKeyWithVols(Long key);

	public List<Reservation> findAllWithVols();

	public Optional<Reservation> findByKeyWithVolsAndPassager(Long key);

	public List<Reservation> findAllWithVolsAndPassager();

	public Optional<Reservation> findByKeyWithClient(Long key);

	public List<Reservation> findAllWithClient();

}
