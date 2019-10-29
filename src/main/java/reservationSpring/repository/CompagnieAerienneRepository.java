package reservationSpring.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import reservationSpring.model.CompagnieAerienne;

public interface CompagnieAerienneRepository extends JpaRepository<CompagnieAerienne, Long> {

	@Query("select c from CompagnieAerienne c left join fetch c.compagnieAerienneVol cv left join fetch cv.key.vol where c.idCompagnieAerienne = :key")
	public Optional<CompagnieAerienne> findByIdCompagnieAerienneWithCompagniesVols(@Param("key") Long key);

	@Query("select c from CompagnieAerienne c left join fetch c.compagnieAerienneVol cv left join fetch cv.key.vol ")
	public List<CompagnieAerienne> findAllWithCompagniesVols();

}
