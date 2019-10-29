package reservationSpring.repository;

import java.util.List;
import java.util.Optional;

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
	public Optional <Client> findByIdWithReservations(@Param("id")Long id);
	
	@Query("select distinct c from Client c left join fetch c.reservations")
	public List<Client> findAllCustomWithReservations();

	@Query("select distinct cei from ClientEI")
	public List<ClientEI> findAllCustomClientEI();
	
	@Query("select distinct cm from ClientMoral")
	public List<ClientMoral> findAllCustomClientMoral();
	
	@Query("select distinct cp from ClientPhysique")
	public List<ClientPhysique> findAllCustomClientPhysique();
	
	@Query("select distinct c from Client c left join fetch c.login =:login")
	public Optional<Client> findByLoginWithReservations(@Param("login") Login login);
}
