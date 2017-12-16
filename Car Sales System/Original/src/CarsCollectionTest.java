import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class CarsCollectionTest {

	Manufacturer[] m,temp;
	CarsCollection cc,cctemp;
	Car[] c;
	
	@Before
	public void beforeMethod() {
		c = new Car[3];
		c[0] = new Car("Honda","WR-V","info");
		c[1] = new Car("Suzuki", "Ciaz", "Better!");
		c[2] = new Car("Toyota", "Etios", "Good");
		c[0].setYear(2010);
		c[1].setYear(2000);
		c[0].setKilometers(72.5);
		c[1].setKilometers(3200.87);
		c[0].setPrice(72500);
		c[1].setPrice(300000);
		
		m = new Manufacturer[3];
		m[0] = new Manufacturer("Honda", c[0]);
		m[1] = new Manufacturer("Suzuki", c[1]);
		m[2] = new Manufacturer("Toyota", c[2]);
		temp = new Manufacturer[2];
		temp[0]=m[0];
		temp[1]=m[1];
		cc = new CarsCollection();
		cc.manufacturer = temp;
		cctemp = new CarsCollection(m[0]);
	}
	
	@Test
	public void testAddCar() {
		Car c = new Car("Honda", "Civic", "info");
		assertEquals(cc.addCar(c), 0);
		c = new Car("Toyota", "Etios", "info");
		assertEquals(cc.addCar(c), 0);
		c = new Car("Nissan", "Micra", "info");
		assertEquals(cc.addCar(c), 2);
		c = new Car("Honda", "Civic2", "info");
		assertEquals(cc.addCar(c), 1);
	}

	@Test
	public void testCarsCount() {
		assertEquals(cc.carsCount(),2);
	}

	@Test
	public void testManufacturerCount() {
		assertEquals(cc.manufacturerCount(),2);
	}

	@Test
	public void testGetAllCars() {
		cc.addCar(c[2]);
		assertArrayEquals(cc.getAllCars(),c);
	}

	@Test
	public void testGetAllManufacturers() {
		cc.addCar(c[1]);
		assertEquals(Arrays.deepEquals(cc.getAllManufacturers(), temp), true);
		assertEquals(Arrays.deepEquals(cctemp.getAllManufacturers(), new Manufacturer[] {m[0]}), true);
		
	}

	@Test
	public void testGetAverageAge() {
		assertEquals(cc.getAverageAge(),12.0,0.0);
		assertEquals((new CarsCollection()).getAverageAge(),0.0,0.0);
	}

	@Test
	public void testGetAverageDistance() {
		assertEquals(cc.getAverageDistance(),1636.680,0.005);
		assertEquals((new CarsCollection()).getAverageDistance(),0.0,0.0);
	}

	@Test
	public void testGetAveragePrice() {
		assertEquals(cc.getAveragePrice(),186250.0,0.0);
		assertEquals((new CarsCollection()).getAveragePrice(),0.0,0.0);
	}
	
	@Test
	public void testSearchIntIntDoubleDouble() {
		assertEquals(Arrays.deepEquals(cc.search(20000, 400000, 72.5, 100), new Car[]{c[0]}),true);
		assertEquals(Arrays.deepEquals(cc.search(72500, 400000, 0, 3300), new Car[]{c[0], c[1]}),true);
		assertEquals(Arrays.deepEquals(cc.search(20000, 400000, 0, 3200), new Car[]{c[0], c[1]}),false);
		assertEquals(Arrays.deepEquals(cc.search(70000, 400000, 0, 3500), new Car[]{c[0]}),false);
		assertEquals(Arrays.deepEquals(cc.search(170000, 300000, 0, 3200.87), new Car[]{c[1]}),true);
	}

	@Test
	public void testSearchIntInt() {
		assertEquals(Arrays.deepEquals(cc.search(10, 20), new Car[]{c[1]}), true);
		assertEquals(Arrays.deepEquals(cc.search(7, -1), new Car[]{c[0], c[1]}), true);
		assertEquals(Arrays.deepEquals(cc.search(18, -1), new Car[]{}), true);
		assertEquals(Arrays.deepEquals(cc.search(0, 1), new Car[]{c[1]}), false);
		assertEquals(Arrays.deepEquals(cc.search(20, 50), new Car[]{c[0]}), false);
		assertEquals(Arrays.deepEquals(cc.search(7, 17), new Car[]{c[1]}), false);
		assertEquals(Arrays.deepEquals(cc.search(7, 9), new Car[]{c[0]}), true);
		assertEquals(Arrays.deepEquals(cc.search(15, 17), new Car[]{c[1]}), true);
		assertEquals(Arrays.deepEquals(cc.search(0, 9), new Car[]{c[0]}), true);
		assertEquals(Arrays.deepEquals(cc.search(10, 15), new Car[]{c[1]}), false);
	}

}
