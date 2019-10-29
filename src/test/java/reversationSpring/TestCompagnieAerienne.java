package reversationSpring;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import reservationSpring.model.CompagnieAerienne;
import reservationSpring.repository.CompagnieAerienneRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/application-context.xml" })
public class TestCompagnieAerienne {

	@Autowired
	private CompagnieAerienneRepository compagnieAerienneRepository;

	@Test
	public void test() {
		CompagnieAerienne compagnieAerienne = new CompagnieAerienne();
		compagnieAerienneRepository.save(compagnieAerienne);
		Optional<CompagnieAerienne> opt = compagnieAerienneRepository
				.findById(compagnieAerienne.getIdCompagnieAerienne());
		assertTrue(opt.isPresent());
	}

	@Test
	public void testFindWithWithCompagniesVols() {
		assertTrue(compagnieAerienneRepository.findByIdCompagnieAerienneWithCompagniesVols((long) 100).isPresent());
	}

	@Test
	public void testFindAllWithCompagniesVols() {
		assertNotEquals(0, compagnieAerienneRepository.findAllWithCompagniesVols());
	}

}
