import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AddCarPanelTest.class, CarSalesSystemTest.class, CarsCollectionTest.class, CarTest.class,
		ManufacturerTest.class, CarDetailsComponentsTest.class, WelcomePanelTest.class, ShowAllCarsPanelTest.class })
public class AllTests {

}
