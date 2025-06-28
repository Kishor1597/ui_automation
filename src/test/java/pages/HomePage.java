package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.WaitHelper;

public class HomePage {

    private WebDriver driver;
    private WaitHelper wait;


    // Locators
    private By welcomeMsg = By.id("welcome");
    private By logoutBtn = By.id("logout");
    private By settingsLink = By.id("settings");

    // Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitHelper(driver);
    }

    // Page Actions
    public String getWelcomeMessage() {
        WebElement welcomeElement = wait.waitForElementVisible(welcomeMsg, 10);
        return welcomeElement.getText();
    }

    public void clickLogout() {
        wait.waitForElementClickable(logoutBtn, 10).click();
    }

    public boolean isLogoutButtonDisplayed() {
        return wait.waitForElementVisible(logoutBtn, 10).isDisplayed();
    }

    public void navigateToSettings() {
        wait.waitForElementClickable(settingsLink, 10).click();
    }

    public boolean isAtHomePage() {
        return driver.getCurrentUrl().contains("home");
    }
}
