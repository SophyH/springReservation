package reversationSpring;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import reservationSpring.model.Vol;
import reservationSpring.repository.VolRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/application-context.xml" })
public class VolRepositoryTest {

	@Autowired
	private VolRepository volRepository;

	// @Test
	public void testInsert() {
		Vol vol = new Vol();
		volRepository.save(vol);
		Optional<Vol> opt = volRepository.findById(vol.getIdVol());
		assertTrue(opt.isPresent());
	}

//	@Test
//	public void testDelete() {
//
//	}
//
//	@Test
//	public void testUpdate() {
//
//	}
//
//	@Test
//	public void testFindByKey() {
//
//	}
//
//	@Test
//	public void testFindAll() {
//
//	}

	@Test
	public void testFindByKeyWithReservation() {
		assertTrue(volRepository.findByKeyWithReservation((long) 100).isPresent());
	}

	@Test
	public void testFindAllCustomWithReservation() {
		assertNotEquals(0, volRepository.findAllCustomWithReservation());
	}

	@Test
	public void testFindByKeyWithEscale() {
		assertTrue(volRepository.findByKeyWithEscale((long) 100).isPresent());
	}

	@Test
	public void testFindByKeyWithCompagnie() {
		assertTrue(volRepository.findByKeyWithCompagnie((long) 100).isPresent());
	}

	@Test
	public void testFindAllCustomWithCompagnie() {
		assertNotEquals(0, volRepository.findAllCustomWithCompagnie());
	}

	@Test
	public void testFindByKeyWithAeroport() {
		assertTrue(volRepository.findByKeyWithAeroport((long) 100).isPresent());
	}

	@Test
	public void testFindAllCustomWithAeroport() {
		assertNotEquals(0, volRepository.findAllCustomWithAeroport());
	}
}
