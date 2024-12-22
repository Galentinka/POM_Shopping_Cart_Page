package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {

    public WebDriver driver;

    @FindBy(xpath = "(//a[contains(text(),'HP LP3065')])[2]")
    private WebElement HPLaptopAddedToTheCart;

    public ShoppingCartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean HPLaptopAddedToTheCartIsDisplayed() {
        return HPLaptopAddedToTheCart.isDisplayed();
    }
}
