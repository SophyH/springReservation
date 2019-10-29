package reservationSpring.dao;

import java.util.List;

import reservation.model.Client;
import reservation.model.ClientEI;
import reservation.model.ClientMoral;
import reservation.model.ClientPhysique;

public interface DaoClient extends DaoGeneric<Client, Long>{
	List<ClientEI> findAllClientEI();
	List<ClientMoral> findAllClientMoral();
	List<ClientPhysique> findAllClientPhysique();
	Client findByKeyWithReservations(Long key);
	List<Client> findAllWithReservations();

}
