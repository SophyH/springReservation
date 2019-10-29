package reservationSpring.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reservationSpring.exception.ReservationCreationException;
import reservationSpring.model.Reservation;
import reservationSpring.repository.ReservationRepository;

@Service
public class ReservationService {

	@Autowired
	private ReservationRepository reservationRepository;

	public Reservation create(Integer numero) throws ReservationCreationException {
		if (numero != null) {
			throw new ReservationCreationException();
		} else {
			Reservation reservation = new Reservation(numero);
			reservationRepository.save(reservation);
			return reservation;
		}
	}

	public void delete(Reservation reservation) {
		Optional<Reservation> opt = reservationRepository.findById(reservation.getIdReservation());
		if (opt.isPresent()) {
			reservation = opt.get();
			reservation.getVols().setReservation(null);
			reservation.getPassager().setReservation(null);
			reservation.getClient().setReservations(null);
			reservationRepository.delete(reservation);
		}
	}

	public void deleteByKey(Long key) {
		Optional<Reservation> opt = reservationRepository.findById(key);
		if (opt.isPresent()) {
			Reservation reservation = opt.get();
			reservation.getVols().setReservation(null);
			reservation.getPassager().setReservation(null);
			reservation.getClient().setReservations(null);
			reservationRepository.delete(reservation);
		}
	}

}
