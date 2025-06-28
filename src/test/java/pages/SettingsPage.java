package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SettingsPage {

    private WebDriver driver;

    private By pageHeader = By.tagName("h1");

    public SettingsPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getHeaderText() {
        return driver.findElement(pageHeader).getText();
    }
}
