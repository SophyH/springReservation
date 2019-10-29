package reservationSpring.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import reservationSpring.model.Vol;

public interface VolRepository extends JpaRepository<Vol, Long> {

	@Query("select distinct v from Vol v left join fetch v.reservation r where v.idVol=:key")
	public Optional<Vol> findByKeyWithReservation(@Param("key") Long key);

	@Query("select distinct v from Vol v left join fetch v.reservation")
	public List<Vol> findAllCustomWithReservation();

	@Query("select distinct v from Vol v left join fetch v.escales e where v.idVol=:key")
	public Vol findByKeyWithEscale(@Param("key") Long key);

	@Query("select distinct v from Vol v left join fetch v.escales e")
	public List<Vol> findAllCustomWithEscale();

	@Query("select distinct v from Vol v left join fetch v.compagnieAerienneVol c left join fetch c.key.compagnieAerienne "
			+ "where v.idVol=:key")
	public Vol findByKeyWithCompagnie(@Param("key") Long key);

	@Query("select v from Vol v left join fetch v.compagnieAerienneVol c left join fetch c.key.compagnieAerienne")
	public List<Vol> findAllCustomWithCompagnie();

	@Query("select v from Vol v left join fetch v.aeroportDepart ad left join fetch v.aeroportArrivee aa where v.idVol=:key")
	public Optional<Vol> findByKeyWithAeroport(@Param("key") Long key);

	@Query("select v from Vol v left join fetch v.aeroportDepart ad left join fetch v.aeroportArrivee aa")
	public List<Vol> findAllCustomWithAeroport();

}
