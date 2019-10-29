package reservationSpring.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import reservationSpring.model.Login;


public interface LoginRepository extends JpaRepository<Login, Long>{
	public Optional<Login> findById(Long id);
	
	public Optional<Login> findByLogin(String login); 

}
