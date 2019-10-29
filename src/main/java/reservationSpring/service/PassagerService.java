package reservationSpring.service;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reservationSpring.exception.PassagerCreationException;
import reservationSpring.model.Passager;
import reservationSpring.model.Reservation;
import reservationSpring.repository.PassagerRepository;
import reservationSpring.repository.ReservationRepository;

@Service
public class PassagerService {

	@Autowired
	private PassagerRepository passagerRepository;

	@Autowired
	private ReservationRepository reservationRepository;

	public Passager create(String nom) throws PassagerCreationException {
		if (nom.isEmpty()) {
			throw new PassagerCreationException();
		} else {
			Passager passager = new Passager(nom);
			passagerRepository.save(passager);
			return passager;
		}
	}

	public void delete(Passager passager) {
		Optional<Passager> opt = passagerRepository.findByIdPassagerWithReservation(passager.getIdPassager());
		if (opt.isPresent()) {
			passager = opt.get();
			Set<Reservation> reservation = passager.getReservation();
			for (Reservation r : reservation) {
				r.setPassager(null);
				reservationRepository.save(r);
			}
			passagerRepository.delete(passager);
		}
	}

	public void deleteByKey(Long key) {
		Optional<Passager> opt = passagerRepository.findByIdPassagerWithReservation(key);
		Passager passager = null;
		if (opt.isPresent()) {
			passager = opt.get();
			Set<Reservation> reservation = passager.getReservation();
			for (Reservation r : reservation) {
				r.setPassager(null);
				reservationRepository.save(r);
			}
			passagerRepository.delete(passager);
		}
	}

}
