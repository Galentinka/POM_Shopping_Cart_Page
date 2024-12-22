package TestCases;

import Pages.AddToCartDetailsPage;
import Pages.LandingPage;
import Pages.ProductPage;
import Pages.ShoppingCartPage;
import TestBase.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ShoppingCartTest extends TestBase {

    public ShoppingCartTest() throws Exception {
        super();
    }

    public LandingPage landingPage;
    public ProductPage productPage;
    public AddToCartDetailsPage addToCartDetailsPage;
    public ShoppingCartPage shoppingCartPage;

    @BeforeMethod
    public void setup() {
        driver = initializeBrowser(properties.getProperty("browser"));
        landingPage = new LandingPage(driver);
    }

    @Test
    public void verifyAddProductToShoppingCart() {
        productPage = landingPage.navigateDirectlyToProductPage(properties.getProperty("validProduct"));
        Assert.assertTrue(productPage.displayOfHPLaptop());
        addToCartDetailsPage = productPage.clickOnHPToNavigateToDetailsPage();
        shoppingCartPage = addToCartDetailsPage.navigateDirectlyToAddToShoppingCartPage("2");
        Assert.assertTrue(shoppingCartPage.HPLaptopAddedToTheCartIsDisplayed());

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
