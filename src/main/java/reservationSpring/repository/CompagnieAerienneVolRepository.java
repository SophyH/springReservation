package reservationSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import reservationSpring.model.CompagnieAerienneVol;
import reservationSpring.model.CompagnieAerienneVolPk;

public interface CompagnieAerienneVolRepository extends JpaRepository<CompagnieAerienneVol, CompagnieAerienneVolPk> {

}
