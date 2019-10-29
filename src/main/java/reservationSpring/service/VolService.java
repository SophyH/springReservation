package reservationSpring.service;

import java.util.Set;
import java.sql.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reservationSpring.exception.VolCreationException;
import reservationSpring.model.Aeroport;
import reservationSpring.model.CompagnieAerienne;
import reservationSpring.model.CompagnieAerienneVol;
import reservationSpring.model.Reservation;
import reservationSpring.model.Vol;
import reservationSpring.repository.VolRepository;

@Service
public class VolService {

	@Autowired
	private VolRepository volRepository;

	public Vol create(Date dateDepart) throws VolCreationException {
		if (dateDepart == null) {
			throw new VolCreationException();
		}
		Vol Vol = new Vol(dateDepart);
		volRepository.save(Vol);
		return Vol;
	}

	public void delete(Vol vol) {
		Optional<Vol> opt = volRepository.findById(vol.getIdVol());
		if (opt.isPresent()) {
			vol = opt.get();
			Aeroport aeroportDepart = vol.getAeroportDepart();
			for (Aeroport aeroport : vol.getAeroportDepart()) {
				aeroport.setVolDepart(null);
				aeroportRepository.save(aeroport);
			}
		}
	}
}
