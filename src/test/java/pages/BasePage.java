package pages;

import org.openqa.selenium.WebDriver;
import utils.WaitHelper;

public abstract class BasePage {
    protected WebDriver driver;
    protected WaitHelper wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitHelper(driver);
    }

    // Common navigation method
    public abstract boolean isAt();  // implemented per page

    public void navigateTo(String urlPath) {
        driver.get(driver.getCurrentUrl().split("/")[0] + "//" + driver.getCurrentUrl().split("/")[2] + urlPath);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}
