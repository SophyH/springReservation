package reversationSpring;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import reservationSpring.repository.PassagerRepository;
import reservationSpring.service.PassagerService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/application-context.xml" })
public class TestPassager {

	@Autowired
	private PassagerRepository passagerRepository;

	@Autowired
	private PassagerService passagerService;

//	@Test
//	public void test() {
//		Passager passager = new Passager();
//		passagerRepository.save(passager);
//		Optional<Passager> opt = passagerRepository.findById(passager.getIdPassager());
//		assertTrue(opt.isPresent());
//	}

	@Test
	public void testFindWithReservation() {
		assertTrue(passagerRepository.findByIdPassagerWithReservation((long) 100).isPresent());
	}

	@Test
	public void testFindAllWithReservation() {
		assertNotEquals(0, passagerRepository.findAllWithReservation());
	}

	@Test
	public void testFindByNom() {
		assertNotEquals(0, passagerRepository.findByNomPassager("toto"));
	}

	@Test
	public void testDelete() {
		passagerService.deleteByKey((long) 1);
		assertFalse(passagerRepository.findById((long) 1).isPresent());
	}

}
