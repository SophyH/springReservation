package reversationSpring;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import reservationSpring.model.Aeroport;
import reservationSpring.model.Reservation;
import reservationSpring.repository.AeroportRepository;
import reservationSpring.repository.EscaleRepository;
import reservationSpring.repository.VilleRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/application-context.xml" })
public class TestAeroport {
	
	@Autowired
	private AeroportRepository aeroportRepository;
	
	@Autowired
	private VilleRepository villeRepository;
	
	@Autowired
	private EscaleRepository escaleRepository;
	
	
	
	@Test 
	public void testFindByKeyWithVille() {
		
		assertTrue(aeroportRepository.findByKeyWithVille((long) 100).isPresent());
	}
	
	@Test
	public void testFindAllCustomWithVille() {
		assertNotEquals(0, aeroportRepository.findAllCustomWithVille());
	}
	
	@Test 
	public void testFindByKeyWithEscales() {
		
		assertTrue(aeroportRepository.findByKeyWithEscales((long) 100).isPresent());
	}
	
	
	@Test
	public void testFindAllCustomWithEscales() {
		assertNotEquals(0, aeroportRepository.findAllCustomWithEscales());
	}
	

}
