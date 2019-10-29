package reservationSpring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import reservationSpring.model.Aeroport;

public interface AeroportRepository extends JpaRepository<Aeroport, Integer>{
	
	
	@Query("select distinct a from Aeroport a left join fetch a.liaisons l  left join fetch l.liaisons.key.ville where a.idAeroport=:key")
	public Aeroport findByKeyWithVille(@Param("key") Long key);

	@Query("select distinct a from Aeroport a left join fetch a.liaisons l  left join fetch l.liaisons.key.ville")
	public List<Aeroport> findAllCustomWithVille();

	@Query("select distinct a from Aeroport a left join fetch a.escales where a.idAeroport=:key")
	public Aeroport findByKeyWithEscale(Long key);

	public List<Aeroport> findAllCustomWithEscale(@Param("key") Long key);

}
