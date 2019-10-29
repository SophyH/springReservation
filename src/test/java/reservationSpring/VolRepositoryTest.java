package reservationSpring;

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

	@Test
	public void testInsert() {
		Vol vol = new Vol();
		volRepository.save(vol);
		Optional<Vol> opt = volRepository.findById(vol.getIdVol());
		assertTrue(opt.isPresent());
	}

//	@Test
//	public void testFindByKeyWithReservation() {
//		Optional<Vol> opt = volRepository.findByKeyWithReservation((long) 100);
//		assertNotEquals(0, opt.get().getReservation().size());
//	}

//	@Test
//	public void testfindByKeyWithEscale() {
//		Optional<Vol> opt = volRepository.findByKeyWithEscale(100);
//		assertNotEquals(0, opt.get().getEscales().size());
//	}
}
