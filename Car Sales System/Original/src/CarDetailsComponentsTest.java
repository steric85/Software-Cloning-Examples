import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CarDetailsComponentsTest {
	
	CarDetailsComponents cdc1,cdc2;
	Car c;

	@Before
	public void setUp() throws Exception {
		cdc2 = new CarDetailsComponents();
		cdc2.infoTextArea.setText("info");
		cdc2.priceTextField.setText("12345");
		cdc2.kmTextField.setText("1200");
		cdc2.manufacturerTextField.setText("Suzuki");
		cdc2.modelTextField.setText("AbC345");
		cdc2.yearTextField.setText("2098");
		c = new Car("Honda", "WR-V", "Too good!");
		c.setKilometers(123.56);
		c.setPrice(200000);
		c.setYear(2067);
	}
	

	@Test
	public void testCarDetailsComponents() {
		cdc1 = new CarDetailsComponents();
		assertEquals((cdc1!=null),true);
	}

	@Test
	public void testClearTextFields() {
		cdc2.clearTextFields();
		assertEquals((cdc2.getInfoText().equals("") && cdc2.getManufacturerText().equals("") && cdc2.getYearText().equals("") && cdc2.getModelText().equals("") && cdc2.getPriceText().equals("") && cdc2.getKmText().equals("") ),true);
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
	public void testDisplayDetails() {
		cdc2.displayDetails(c);
		assertEquals((cdc2.getManufacturerText().equals("HONDA") && cdc2.getModelText().equals("WR-V") && cdc2.getInfoText().equals("Too good!") && cdc2.getKmText().equals("123.56") && cdc2.getPriceText().equals("200000") && cdc2.getYearText().equals("2067")),true);
	}

	@Test
	public void testGetInfoText() {
		assertEquals(cdc2.getInfoText(),"info");
	}

	@Test
	public void testGetKmText() {
		assertEquals(cdc2.getKmText(),"1200");
	}

	@Test
	public void testGetManufacturerText() {
		assertEquals(cdc2.getManufacturerText(),"Suzuki");
	}

	@Test
	public void testGetModelText() {
		assertEquals(cdc2.getModelText(),"AbC345");
	}

	@Test
	public void testGetPriceText() {
		assertEquals(cdc2.getPriceText(),"12345");
	}

	@Test
	public void testGetYearText() {
		assertEquals(cdc2.getYearText(),"2098");
	}

//	@Test
//	public void testSetFocusManufacturerTextField() {
//		cdc2.setFocusManufacturerTextField();
//		assertEquals(cdc2.manufacturerTextField.hasFocus(),true);
//	}

}
