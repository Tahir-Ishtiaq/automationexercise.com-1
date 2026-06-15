package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Products extends BaseClass{
    public Products(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//a[@href='/product_details/1']")
    WebElement view_product1;


    public ProductDetails ClickOnViewProduct(){
        checkText("All Products");
        scrollToElement(view_product1);
        clickOn(view_product1);
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

    @FindBy(xpath = "//div[@class='productinfo text-center']//a[@data-product-id='1']")
    WebElement add_to_cart1_normal;

    // 2. Target the button inside the hover overlay container
    @FindBy(xpath = "//div[@class='product-overlay']//a[@data-product-id='1']")
    WebElement add_to_cart1_overlay;

    // 3. Do the same for the second product
    @FindBy(xpath = "//div[@class='productinfo text-center']//a[@data-product-id='2']")
    WebElement add_to_cart2_normal;

    @FindBy(xpath = "//div[@class='product-overlay']//a[@data-product-id='2']")
    WebElement add_to_cart2_overlay;

    @FindBy(xpath = "//button[text()='Continue Shopping']")
    WebElement continue_shopping;

    @FindBy(xpath = "//u[text()='View Cart']")
    WebElement view_cart;

    public Home AddToCart(){
        // --- PRODUCT 1 FLOW ---
        // Scroll to the regular product box
        scrollToElement(add_to_cart1_normal);
        // Hover to force the overlay container to appear
        hoverOverElement(add_to_cart1_normal);
        // Click the overlay button that is now on top
        clickOn(add_to_cart1_overlay);

        // Clear the popup modal
        clickOn(continue_shopping);

        // --- PRODUCT 2 FLOW ---
        // Scroll to the second regular product box
        scrollToElement(add_to_cart2_normal);
        // Hover to force its overlay to appear
        hoverOverElement(add_to_cart2_normal);
        // Click the second overlay button
        clickOn(add_to_cart2_overlay);

        // Go to the final cart page
        clickOn(view_cart);
        return new Home(driver);
    }

}
