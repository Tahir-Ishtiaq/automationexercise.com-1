package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetails extends BaseClass{
    public ProductDetails(WebDriver driver){
        super(driver);
    }

    public void CheckProductDetails(){
        try{
            String[] infos ={"Blue Top","In Stock", "New", "Polo"};
            for(String info : infos){
                checkText(info);
                logger.info("Expected Element matched! '{}'", info);
            }
        } catch (Throwable t) {
            logger.error("Element not matched.", t);
            throw t;
        }
    }

    @FindBy(xpath = "//input[@id='quantity']")
    WebElement quantity;
    @FindBy(xpath = "//button[@type='button']")
    WebElement add_to_cart;
    @FindBy(xpath = "//u[text()='View Cart']")
    WebElement view_cart;
    public ViewCart IncreaseQuantity(){
        inputValue(quantity, "4");
        clickOn(add_to_cart);
        clickOn(view_cart);
        return new ViewCart(driver);
    }
}
