package reservationSpring.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import reservationSpring.model.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

	public List<Reservation> findByDateReservation(Date dateReservation);

	@Query("select distinct r from Reservation r left join fetch r.passager left join fetch r.client where r.idReservation=:key")
	public Optional<Reservation> findByIdReservationWithPassager(@Param("key") Long key);

	@Query("select distinct r from Reservation r left join fetch r.passager left join fetch r.client ")
	public List<Reservation> findAllWithPassager();

	@Query("select distinct r from Reservation r left join fetch r.vols v left join fetch v.aeroportDepart left join fetch v.aeroportArrivee "
			+ "left join fetch v.escales left join fetch r.client where r.idReservation=:key")
	public Optional<Reservation> findByIdReservationWithVols(@Param("key") Long key);

	@Query("select distinct r from Reservation r left join fetch r.vols v left join fetch v.aeroportDepart left join fetch v.aeroportArrivee "
			+ "left join fetch v.escales left join fetch r.client")
	public List<Reservation> findAllWithVols();

	@Query("select distinct r from Reservation r left join fetch r.passager p left join fetch r.client "
			+ "left join fetch r.vols v left join fetch v.aeroportDepart left join fetch v.aeroportArrivee left join fetch v.escales where r.idReservation=:key")
	public Optional<Reservation> findByIdReservationWithVolsAndPassager(@Param("key") Long key);

	@Query("select distinct r from Reservation r left join fetch r.passager p left join fetch r.client "
			+ "left join fetch r.vols v left join fetch v.aeroportDepart left join fetch v.aeroportArrivee left join fetch v.escales")
	public List<Reservation> findAllWithVolsAndPassager();

	@Query("select distinct r from Reservation r left join fetch r.client left join fetch r.passager where r.idReservation = :key")
	public Optional<Reservation> findByIdReservationWithClient(@Param("key") Long key);

	@Query("select distinct r from Reservation r left join fetch r.client left join fetch r.passager ")
	public List<Reservation> findAllWithClient();

	@Query("select distinct r from Reservation r left join fetch r.passager p left join fetch p.reservation left join fetch r.client "
			+ "left join fetch r.vols v left join fetch v.reservation left join fetch r.client c left join fetch c.reservations where r.idReservation=:key")
	public Optional<Reservation> findByIdReservationWithVolsAndPassagerAndClient(@Param("key") Long key);

	@Query("select distinct r from Reservation r left join fetch r.passager p left join fetch p.reservation left join fetch r.client "
			+ "left join fetch r.vols v left join fetch v.reservation left join fetch r.client c left join fetch c.reservations")
	public List<Reservation> findAllWithVolsAndPassagerAndClient();

}
