package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

    public WebDriver driver;

    @FindBy(linkText = "HP LP3065")
    private WebElement HPLaptop;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean displayOfHPLaptop() {
        return HPLaptop.isDisplayed();
    }

    public AddToCartDetailsPage clickOnHPToNavigateToDetailsPage() {

        HPLaptop.click();

        return new AddToCartDetailsPage(driver);
    }
}
