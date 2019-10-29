package reversationSpring;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import reservationSpring.repository.PassagerRepository;
import reservationSpring.repository.ReservationRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/application-context.xml" })
public class TestReservation {

	@Autowired
	private ReservationRepository reservationRepository;

	@Autowired
	private PassagerRepository passagerRepository;

//	@Test
//	public void test() {
//		Reservation reservation = new Reservation();
//		reservationRepository.save(reservation);
//		Optional<Reservation> opt = reservationRepository.findById(reservation.getIdReservation());
//		assertTrue(opt.isPresent());
//	}

	@Test
	public void testFindWithPassager() {
		assertTrue(reservationRepository.findByIdReservationWithPassager((long) 100).isPresent());
	}

	@Test
	public void testFindAllWithPassager() {
		assertNotEquals(0, reservationRepository.findAllWithPassager());
	}

	@Test
	public void testFindByIdReservationWithVols() {
		assertTrue(reservationRepository.findByIdReservationWithVols((long) 100).isPresent());
	}

	@Test
	public void testFindAllWithVols() {
		assertNotEquals(0, reservationRepository.findAllWithVols());
	}

	@Test
	public void testFindByIdReservationWithVolsAndPassager() {
		assertTrue(reservationRepository.findByIdReservationWithVolsAndPassager((long) 100).isPresent());
	}

	@Test
	public void testFindAllWithVolsAndPassager() {
		assertNotEquals(0, reservationRepository.findAllWithVolsAndPassager());
	}

	@Test
	public void testFindWithClient() {
		assertTrue(reservationRepository.findByIdReservationWithClient((long) 100).isPresent());
	}

	@Test
	public void testFindAllWithClient() {
		assertNotEquals(0, reservationRepository.findAllWithClient());
	}

}
