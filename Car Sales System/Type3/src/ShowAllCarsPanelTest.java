import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class ShowAllCarsPanelTest {
	
	ShowAllCarsPanel sacp;	
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
	}
	

	@Test
	public void testShowAllCarsPanel() {
		sacp = new ShowAllCarsPanel(css);
		assertEquals(Arrays.deepEquals(sacp.carList,css.getAllCars()),true);
		assertEquals((sacp.carComponents.getManufacturerText().equals("HONDA") && sacp.carComponents.getModelText().equals("WR-V") && sacp.carComponents.getInfoText().equals("info") && sacp.carComponents.getKmText().equals("72.5") && sacp.carComponents.getPriceText().equals("72500") && sacp.carComponents.getYearText().equals("2010")),true);
	}

//	@Test
//	public void testActionPerformed() {
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

}
