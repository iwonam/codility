import helpers.DriverFactory;
import model.DriverType;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class Base {

    public static WebDriver driver;

    @BeforeClass
    public static void setUpTest(){
        DriverFactory driverFactory = new DriverFactory();
        driver = driverFactory.getSpecificDriver( DriverType.CHROME );
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.MILLISECONDS);
    }

    @AfterClass
    public static void tearDown(){
        driver.close();
        driver.quit();
    }

}
