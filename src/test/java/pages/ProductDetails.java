package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetails extends BaseClass{
    public ProductDetails(WebDriver driver){
        super(driver);
    }

    public void CheckProductDetails(){
        String[] infos ={"Blue Top", "Women > Tops", "In Stock", "New", "Polo"};
        for(String info : infos){
            checkText(info);
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
