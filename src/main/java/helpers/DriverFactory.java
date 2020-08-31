package helpers;

import io.github.bonigarcia.wdm.WebDriverManager;
import model.DriverType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    public WebDriver driver;
    String url = "https://codility-frontend-prod.s3.amazonaws.com/media/task_static/qa_search/6f03f4361b080eeb747193aadd94cd2b/static/attachments/reference_page.html";

    public WebDriver getSpecificDriver(DriverType driverType) {

        switch (driverType) {
            case CHROME:
                return getChromeDriver();
            case FIREFOX:
                return getFirefoxDriver();
            default:
                throw new IllegalArgumentException( "Browser doesn't exist" );
        }
    }

    private WebDriver getChromeDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to( url );
        return driver;
    }

    private WebDriver getFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.navigate().to( url );
        return driver;
    }
}
