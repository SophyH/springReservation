package reservationSpring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import reservationSpring.model.Client;
import reservationSpring.model.ClientEI;
import reservationSpring.model.ClientMoral;
import reservationSpring.model.ClientPhysique;
import reservationSpring.model.Login;

public interface ClientRepository extends JpaRepository<Client, Long>{
	@Query("select distinct c from Client c left join fetch c.reservations where c.id = :id")
	Client findByIdWithReservations(@Param("id")Long id);
	
	@Query("select distinct c from Client c left join fetch c.reservations")
	List<Client> findAllCustomWithReservations();

	List<ClientEI> findAllCustomClientEI();
	
	List<ClientMoral> findAllCustomClientMoral();
	
	List<ClientPhysique> findAllCustomClientPhysique();
	
	@Query("select distinct c from Client c left join fetch c.login =:login")
	Client findByLoginWithReservations(@Param("login") Login login);
}
