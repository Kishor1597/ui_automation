package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import utils.DriverFactory;
import utils.ConfigReader;

import java.util.Properties;

public class BaseTest {
    protected WebDriver driver;
    protected Properties prop;

    @BeforeMethod
    public void setUp() {
        prop = ConfigReader.initProp();
        driver = DriverFactory.initDriver();
        driver.get(prop.getProperty("url"));
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
