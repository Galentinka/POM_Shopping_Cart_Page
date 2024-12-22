package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCartDetailsPage {

    public WebDriver driver;
    public ShoppingCartPage shoppingCartPage;

    @FindBy(name = "quantity")
    private WebElement quantity;

    @FindBy(css = "button.btn.btn-primary.btn-lg.btn-block")
    private WebElement addToCartButton;

    @FindBy(css = "button.btn.btn-inverse.btn-block.btn-lg.dropdown-toggle")
    private WebElement cartPreviewButton;

    @FindBy(linkText = "View Cart")
    private WebElement viewCartButton;

    public AddToCartDetailsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void changeQuantity(String Quantity) {
        quantity.clear();
        quantity.sendKeys(Quantity);
    }

    public void clickOnAddToCartButton() {
        addToCartButton.click();
    }

    public void clickOnCartPreviewButton() {
        cartPreviewButton.click();
    }

    public void clickViewCartButton() {
        viewCartButton.click();
    }

    public ShoppingCartPage navigateDirectlyToAddToShoppingCartPage(String Quantity) {
        quantity.clear();
        quantity.sendKeys(Quantity);
        addToCartButton.click();
        cartPreviewButton.click();
        viewCartButton.click();

        return new ShoppingCartPage(driver);
    }
}
