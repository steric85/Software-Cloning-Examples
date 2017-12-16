import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

public class CarTest {

	Car c = new Car("Honda", "WR-V", "Too good!");
	
	@Before
	public void beforeMethod() {		
	}
	
	@Test
	public void testGetAge() {
		c.setYear(2014);
		assertEquals(c.getAge(), 3);
	}

	@Test
	public void testGetInformation() {
		assertEquals(c.getInformation(), "Too good!");
	}

	@Test
	public void testGetManufacturer() {
		assertEquals(c.getManufacturer(), "HONDA");
	}

	@Test
	public void testGetModel() {
		assertEquals(c.getModel(),"WR-V");
	}

	@Test
	public void testSetInformation() {
		c.setInformation("Better than any model");
		assertEquals(c.getInformation(),"Better than any model");
	}

	@Test
	public void testSetKilometers() {
		c.setKilometers(2.3);
		assertEquals(c.getKilometers(),2.3,0.001);
	}

	@Test
	public void testSetManufacturer() {
		c.setManufacturer("Suzuki");
	    assertNotSame(c.getManufacturer(), "Suzuki");
	}

	@Test
	public void testSetModel() {
		c.setModel("Ciaz");
		assertEquals(c.getModel(),"Ciaz");
	}

	@Test
	public void testSetPrice() {
		c.setPrice(800000);
		assertEquals(c.getPrice(), 800000);
	}

	@Test
	public void testSetYear() {
		c.setYear(2015);
		assertEquals(c.getYear(), 2015);
	}

}
