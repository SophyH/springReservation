package reversationSpring;

import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import reservationSpring.model.CompagnieAerienneVol;
import reservationSpring.repository.CompagnieAerienneVolRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/application-context.xml" })
public class TestCAV {

	@Autowired
	private CompagnieAerienneVolRepository compagnieAerienneVolRepository;

	@Test
	public void test() {
		CompagnieAerienneVol cav = new CompagnieAerienneVol();
		compagnieAerienneVolRepository.save(cav);
		Optional<CompagnieAerienneVol> opt = compagnieAerienneVolRepository.findById(cav.getKey());
		assertTrue(opt.isPresent());
	}

}
