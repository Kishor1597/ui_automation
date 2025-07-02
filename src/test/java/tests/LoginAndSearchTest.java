package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductPage;

public class LoginAndSearchTest extends BaseTest {

    @Test
    public void testLoginAndOpenFirstProduct() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isOnProductsPage(), "Login failed or not on Products page");

        homePage.clickFirstProduct();

        ProductPage productPage = new ProductPage(driver);
        String productName = productPage.getProductName();
        Assert.assertFalse(productName.isEmpty(), "Product name is empty - Product page may not have loaded");
    }
}
