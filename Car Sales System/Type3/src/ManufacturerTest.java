import static org.junit.Assert.*;


import org.junit.Test;
import org.junit.Before;

public class ManufacturerTest {
	
	Manufacturer m;
	Car[] cars ;
	
	@Before
	public void beforeMethod() {
		cars = new Car[3];
		cars[0] = new Car("Honda", "WR-V", "Too good!");
		cars[1] = new Car("Suzuki", "Ciaz", "Better!");
		cars[2] = new Car("Toyota", "Etios", "Good");
		m = new Manufacturer("Honda", cars[0]);
	}
	
	@Test
	public void testManufacturer() {
		assertEquals(m.getManufacturerName(), "HONDA");
	}

	@Test
	public void testCarCount() {
		m.addCar(new Car());
		m.addCar(new Car());
		m.addCar(new Car());
		assertEquals(m.carCount(), 4);
	}

	@Test
	public void testGetAllCars() {
		m.addCar(cars[1]);
		m.addCar(cars[2]);
		assertArrayEquals(m.getAllCars(), cars);
	}

	@Test
	public void testSetManufacturersName() {
		m.setManufacturersName("Suzuki");
		assertEquals(m.getManufacturerName(), "SUZUKI");
	}

}
