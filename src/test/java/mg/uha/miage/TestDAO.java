package mg.uha.miage;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import mg.uha.miage.entities.Ville;
import mg.uha.miage.metier.interf.VilleMetierInterf;

public class TestDAO {
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		try {
			ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext(
					new String[] { "applicationContext.xml" });
			assertTrue(true);
			// test napidirana anle base
		} catch (Exception e) {
			assertTrue(e.getMessage(), false);

		}

	}
}
