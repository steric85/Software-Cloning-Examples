import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class WelcomePanelTest {
	
	WelcomePanel wp;	
	CarSalesSystem css;
	Manufacturer[] m;
	CarsCollection cc;
	Car[] c;
	
	@Before
	public void setUp() throws Exception {
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
		
		m = new Manufacturer[2];
		m[0] = new Manufacturer("Honda", c[0]);
		m[1] = new Manufacturer("Suzuki", c[1]);
		
		cc = new CarsCollection();
		cc.manufacturer = m;
		
		css = new CarSalesSystem("src/cars.dat");
		css.carCollection = cc;	
		
		wp = new WelcomePanel(css,"src/cars.dat");
	}
	
//	@Test
//	public void testWelcomePanel() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testCarsUpdated() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testStateChanged() {
//		fail("Not yet implemented");
//	}

	@Test
	public void testUpdateStats() {
		wp.updateStats();
		assertEquals(wp.carsLabel.getText(),"Total number of cars: 2");
		assertEquals(wp.manufacturersLabel.getText(), "Total number of manufacturers: 2");
		assertEquals(wp.avgAgeLabel.getText(),"Average car age: 12.0");
		assertEquals(wp.avgKmLabel.getText(), "Average car kilometers: 1636.7");
		assertEquals(wp.avgPriceLabel.getText(), "Average car price: 186250.0");
		assertEquals(wp.dataSizeLabel.getText(), "Size of data file: 0 bytes");
		assertEquals(wp.versionLabel.getText(), "Car Sales System, Version 1.0");
	}

}
