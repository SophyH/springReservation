package reservationSpring.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import reservationSpring.model.Passager;

public interface PassagerRepository extends JpaRepository<Passager, Long> {

	@Query("select p from Passager p left join fetch p.reservation r left join fetch r.vols left join fetch r.client where p.idPassager = :key")
	public Optional<Passager> findByIdPassagerWithReservation(@Param("key") Long key);

	@Query("select p from Passager p left join fetch p.reservation r left join fetch r.vols left join fetch r.client")
	public List<Passager> findAllWithReservation();

}
