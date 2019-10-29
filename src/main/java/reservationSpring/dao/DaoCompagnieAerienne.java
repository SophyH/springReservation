package reservationSpring.dao;

import java.util.List;

import reservation.model.CompagnieAerienne;

public interface DaoCompagnieAerienne extends DaoGeneric<CompagnieAerienne, Long> {

	CompagnieAerienne findByKeyWithCompagniesVols(Long key);

	List<CompagnieAerienne> findAllWithCompagniesVols(Long key);

}
