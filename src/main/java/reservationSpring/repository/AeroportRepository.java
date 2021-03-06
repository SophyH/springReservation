package reservationSpring.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import reservationSpring.model.Aeroport;

public interface AeroportRepository extends JpaRepository<Aeroport, Long>{
	
	
	@Query("select distinct a from Aeroport a left join fetch a.liaisons l  left join fetch l.key.ville where a.idAeroport=:key")
	public Optional<Aeroport> findByKeyWithVille(@Param("key") Long key);

	@Query("select distinct a from Aeroport a left join fetch a.liaisons l  left join fetch l.key.ville")
	public List<Aeroport> findAllCustomWithVille();

	@Query("select distinct a from Aeroport a left join fetch a.escales where a.idAeroport=:key")
	public Optional<Aeroport> findByKeyWithEscales(Long key);

	@Query("select distinct a from Aeroport a left join fetch a.escales ")
	public List<Aeroport> findAllCustomWithEscales();
	
	

}
