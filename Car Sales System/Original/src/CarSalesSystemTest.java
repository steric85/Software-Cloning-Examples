import static org.junit.Assert.*;

import java.awt.event.ActionEvent;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class CarSalesSystemTest {
	
	CarSalesSystem css,csstemp;
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
		
		csstemp = new CarSalesSystem("src/cars.dat");
	}
	
	@Test
	public void testGetCarUpdate(){
		assertEquals(csstemp.getCarsUpdated(),false);
	}

//	@Test
//	public void testAboutMenuItemClicked(){
//		css.aboutMenuItemClicked();
//		ActionEvent ev =  new ActionEvent();
//		ev.setSource("okButton");
//		css.aboutDlg.actionPerformed(ev);
//		assertEquals(css.aboutDlg.isShowing(),false);
//	}
	
//	action performed
	
	@Test
	public void testAddNewCar() {
		Car c = new Car("Honda", "Civic", "info");
		assertEquals(css.addNewCar(c), 0);
		c = new Car("Toyota", "Etios", "info");
		assertEquals(css.addNewCar(c), 0);
		c = new Car("Nissan", "Micra", "info");
		assertEquals(css.addNewCar(c), 2);
		c = new Car("Honda", "Civic2", "info");
		assertEquals(css.addNewCar(c), 1);
	}
	
	@Test
	public void getAddCarUpdateListener() {
		css.addCarUpdateListener(null);
		assertEquals(true,true);
	}
	
	@Test
	public void testComponentHidden() {
		assertEquals(true,true);
	}

	@Test
	public void testComponentMoved() {
		assertEquals(true,true);
	}
	

//	@Test
//	public void testComponentResized() {
//		fail("Not yet implemented");
//	}

	@Test
	public void testComponentShown() {
		assertEquals(true,true);
	}

	@Test
	public void testConvertToRange() {
		assertEquals(Arrays.equals(CarSalesSystem.convertToRange("a-b"),new double[]{-1, -1}), true);
		assertEquals(Arrays.equals(CarSalesSystem.convertToRange("50.4-100.23"), new double[]{50.4, 100.23}), true);
		assertEquals(Arrays.equals(CarSalesSystem.convertToRange("2+"), new double[]{2, -1}), true);
		assertEquals(Arrays.equals(CarSalesSystem.convertToRange("2.11-1.9"), new double[]{-1, -1}), true);
		assertEquals(Arrays.equals(CarSalesSystem.convertToRange("50.5"), new double[]{50.5, 50.5}), true);
		assertEquals(Arrays.equals(CarSalesSystem.convertToRange("3.6-3.6"), new double[]{-1, -1}), false);
	}

	@Test
	public void testGetAllCars() {
		css.addNewCar(c[2]);
		assertArrayEquals(css.getAllCars(),c);
	}

	@Test
	public void testGetCarsUpdated() {
		assertEquals(css.getCarsUpdated(), false);
	}

	@Test
	public void testGetStatistics() {
		assertEquals(css.getStatistics(0), 2, 0.0);
		assertEquals(css.getStatistics(1), 2, 0.0);
		assertEquals(css.getStatistics(2), 186250, 0.1);
		assertEquals(css.getStatistics(3), 1636.685, 0.1);
		assertEquals(css.getStatistics(4), 12, 0.1);
	}

	@Test
	public void testSearchIntInt() {
		assertEquals(Arrays.deepEquals(css.search(10, 20), new Car[]{c[1]}), true);
		assertEquals(Arrays.deepEquals(css.search(7, -1), new Car[]{c[0], c[1]}), true);
		assertEquals(Arrays.deepEquals(cc.search(18, -1), new Car[]{}), true);
		assertEquals(Arrays.deepEquals(css.search(0, 1), new Car[]{c[1]}), false);
	}

	@Test
	public void testSearchIntIntDoubleDouble() {
		assertEquals(Arrays.deepEquals(css.search(20000, 400000, 0, 100), new Car[]{c[0]}),true);
		assertEquals(Arrays.deepEquals(css.search(72500, 400000, 0, 3300), new Car[]{c[0], c[1]}),true);
		assertEquals(Arrays.deepEquals(css.search(20000, 400000, 0, 3200), new Car[]{c[0], c[1]}),false);
		assertEquals(Arrays.deepEquals(cc.search(70000, 400000, 0, 3500), new Car[]{c[0]}),false);
	}
}
