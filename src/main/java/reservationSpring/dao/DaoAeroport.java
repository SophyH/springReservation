package reservationSpring.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import reservation.model.Aeroport;

public interface DaoAeroport extends DaoGeneric<Aeroport, Long> {

	
	
	public Aeroport findByKeyWithVille(Long key);

	public List<Aeroport> findAllWithVille();

	public Aeroport findByKeyWithEscale(Long key);

	public List<Aeroport> findAllWithEscale();

}
