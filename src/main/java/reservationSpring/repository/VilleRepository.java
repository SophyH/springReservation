package reservationSpring.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import reservationSpring.model.Ville;

public interface VilleRepository extends JpaRepository<Ville, Long>{
	
	@Query("select distinct v from Ville v left join fetch v.liaisons l  left join fetch l.key.aeroport where v.idVille=:key")
	public Optional<Ville> findByKeyWithAeroport(@Param("key") Long key);

	@Query("select distinct v from Ville v left join fetch v.liaisons l  left join fetch l.key.aeroport")
	public List<Ville> findAllCustomWithAeroport();
	
	

}
