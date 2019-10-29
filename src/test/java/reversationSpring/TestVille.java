package reversationSpring;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import reservationSpring.repository.AeroportRepository;
import reservationSpring.repository.VilleRepository;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/application-context.xml" })
public class TestVille {
	
	@Autowired
	private AeroportRepository aeroportRepository;
	
	@Autowired
	private VilleRepository villeRepository;
	
	@Test 
	public void testFindByKeyWithAeroport() {
		
		System.out.println(villeRepository);
		assertTrue(villeRepository.findByKeyWithAeroport((long) 100).isPresent());
	}
	
	@Test
	public void testFindAllCustomWithVille() {
		assertNotEquals(0, villeRepository.findAllCustomWithAeroport());
	}
	

}
