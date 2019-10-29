package reservationSpring.service;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reservationSpring.exception.AeroportCreationException;
import reservationSpring.exception.PassagerCreationException;
import reservationSpring.model.Aeroport;
import reservationSpring.model.Escale;
import reservationSpring.model.Liaisons;
import reservationSpring.model.Passager;
import reservationSpring.model.Reservation;
import reservationSpring.model.Vol;
import reservationSpring.repository.AeroportRepository;
import reservationSpring.repository.EscaleRepository;
import reservationSpring.repository.LiaisonsRepository;
import reservationSpring.repository.VilleRepository;
import reservationSpring.repository.VolRepository;

@Service
public class AeroportService {

	@Autowired
	private AeroportRepository aeroportRepository;

	
	@Autowired
	private VilleRepository villeRepository;

	@Autowired
	private VolRepository volRepository;

	@Autowired
	private LiaisonsRepository liaisonsRepository;

	@Autowired
	private EscaleRepository escaleRepository;

	public Aeroport create(String nom) throws AeroportCreationException {
		if (nom.isEmpty()) {
			throw new AeroportCreationException();
		} else {
			Aeroport aeroport = new Aeroport(nom);
			aeroportRepository.save(aeroport);
			return aeroport;
		}
	}

	public void delete(Aeroport aeroport) {
		Optional<Aeroport> opt = aeroportRepository.findById(aeroport.getIdAeroport());
		if (opt.isPresent()) {
			aeroport = opt.get();
			Set<Vol> volArrivee = aeroport.getVolArrivee();
			for (Vol v : volArrivee) {
				v.setAeroportArrivee(null);
				volRepository.save(v);
			}
			Set<Vol> volDepart = aeroport.getVolDepart();
			for (Vol v : volDepart) {
				v.setAeroportDepart(null);
				volRepository.save(v);
			}
			Set<Liaisons> liaisons = aeroport.getLiaisons();
			for (Liaisons l : liaisons) {
				l.getKey().setAeroport(null);
				liaisonsRepository.save(l);
			}
			
			Set<Escale> escales = aeroport.getEscales();
			for (Escale e : escales) {
				e.getKey().setAeroport(null);
				escaleRepository.save(e);
			}
			

		}
	}
	
	public void deleteByKey(Long key) {
		Optional<Aeroport> opt = aeroportRepository.findById(key);
		if (opt.isPresent()) {
			Aeroport aeroport = opt.get();
			Set<Vol> volArrivee = aeroport.getVolArrivee();
			for (Vol v : volArrivee) {
				v.setAeroportArrivee(null);
				volRepository.save(v);
			}
			Set<Vol> volDepart = aeroport.getVolDepart();
			for (Vol v : volDepart) {
				v.setAeroportDepart(null);
				volRepository.save(v);
			}
			Set<Liaisons> liaisons = aeroport.getLiaisons();
			for (Liaisons l : liaisons) {
				l.getKey().setAeroport(null);
				liaisonsRepository.save(l);
			}
			
			Set<Escale> escales = aeroport.getEscales();
			for (Escale e : escales) {
				e.getKey().setAeroport(null);
				escaleRepository.save(e);
			}
	
	}
		
	}

}
