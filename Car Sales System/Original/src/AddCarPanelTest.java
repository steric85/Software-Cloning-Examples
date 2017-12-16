import static org.junit.Assert.*;
import org.junit.Test;

public class AddCarPanelTest {

	CarSalesSystem carSys = new CarSalesSystem("cars.dat");
	AddCarPanel acp = new AddCarPanel(carSys);
	
	@Test
	public void testValidateString() {
		assertEquals(acp.validateString("abc a b"), true);
		assertEquals(acp.validateString("a abc b"), true);
		assertEquals(acp.validateString("a a b"), false);
		assertEquals(acp.validateString("a"), false);
		assertEquals(acp.validateString("abcde"), true);
		assertEquals(acp.validateString("ab"), false);
	}

	@Test
	public void testValidateKilometers() {
		assertEquals(acp.validateKilometers("200.12"), false);
		assertEquals(acp.validateKilometers("200.10000000"), true);
		assertEquals(acp.validateKilometers("200"), true);
		assertEquals(acp.validateKilometers("200.1"), true);
	}
	
	@Test
	public void testResetButtonClicked() {
		acp.resetButtonClicked();
		assertEquals((acp.carComponents.getInfoText().equals("") && acp.carComponents.getManufacturerText().equals("") && acp.carComponents.getYearText().equals("") && acp.carComponents.getModelText().equals("") && acp.carComponents.getPriceText().equals("") ),true);
	}
}
