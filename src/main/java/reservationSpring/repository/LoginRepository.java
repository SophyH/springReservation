package reservationSpring.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import reservationSpring.model.Login;


public interface LoginRepository extends JpaRepository<Login, Long>{
	
	@Query("select distinct l from Login l left join fetch l.client where l.id=:id")
	public Optional<Login> findByIdWithClient(@Param("id") Long id);
	
	@Query("select distinct l from Login l where l.login=:login")
	public Optional<Login> findByLogin(@Param("login") String login); 
	
	@Query("select distinct l from Login l left join fetch l.client")
	public List<Login> findAllCustomWithClient();

}
