package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Products extends BaseClass{
    public Products(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//a[@href='/product_details/1']")
    WebElement view_product;

    public ProductDetails ClickOnViewProduct(){
        checkText("All Products");
        scrollToElement(view_product);
        clickOn(view_product);
        return new ProductDetails(driver);
    }

    @FindBy(xpath = "//input[@id='search_product']")
    WebElement search_product;
    @FindBy(xpath = "//button[@id='submit_search']")
    WebElement submit_search;

    public void SearchCustomer(String value){
        scrollToElement(search_product);
        checkText("All Products");
        inputValue(search_product, value);
        clickOn(submit_search);
    }
}
