package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.SettingsPage;
import utils.StepLogger;

public class LoginTest extends BaseTest {

    @Test(retryAnalyzer = utils.RetryAnalyzer.class)
    public void testValidLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(prop.getProperty("username"), prop.getProperty("password"));

        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isLogoutButtonDisplayed(), "Logout button not visible");
        Assert.assertTrue(homePage.getWelcomeMessage().contains("Welcome"), "Welcome message missing");
    }

    @Test
    public void testNavigateToSettings() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(prop.getProperty("username"), prop.getProperty("password"));

        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isLogoutButtonDisplayed());

        StepLogger.log("Navigating to Settings page");
        homePage.navigateToSettings();

        SettingsPage settingsPage = new SettingsPage(driver);
        Assert.assertTrue(settingsPage.getHeaderText().contains("Settings"));
    }
}
