package reservationSpring.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import reservationSpring.model.Login;


public interface LoginRepository extends JpaRepository<Login, Long>{
	
	@Query("select distinct l from Login where id=:id")
	public Optional<Login> findByIdWithClient(@Param("id") Long id);
	
	public Optional<Login> findByLogin(String login); 
	
	public List<Login> findAllCustomWithClient();

}
