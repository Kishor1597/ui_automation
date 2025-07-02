package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import utils.DriverFactory;
import utils.ConfigReader;

import java.time.Duration;
import java.util.Properties;

public class BaseTest {
    protected WebDriver driver;
    protected Properties prop;

    @BeforeClass
    public void setUpClass() {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeMethod
    public void setUp() {
        prop = ConfigReader.initProp();
        driver = DriverFactory.initDriver();
        driver.get(prop.getProperty("sauceDemoUrl"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
