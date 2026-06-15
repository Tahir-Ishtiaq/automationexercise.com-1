package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ViewCart extends BaseClass{
    public ViewCart(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//input[@id='susbscribe_email']")
    WebElement susbscribe_email;
    @FindBy(xpath = "//button[@id='subscribe']")
    WebElement subscribe_button;

    public void SubscribeEmailFromViewCart(String Email){
        scrollToElement(susbscribe_email);
        checkText("Subscription");
        inputValue(susbscribe_email,Email);
        clickOn(subscribe_button);
        checkText("You have been successfully subscribed!");
    }

    @FindBy(xpath ="//a[text()='Proceed To Checkout']")
    WebElement click_on_button;

    @FindBy(xpath ="//u[text()='Register / Login']")
    WebElement click_on_register;


    public Login CLickOnCheckOutWhenNoLogin(){
        clickOn(click_on_button);
        clickOn(click_on_register);
        return new Login(driver);
    }

    @FindBy(xpath ="//textarea[@name='message']")
    WebElement textarea;

    @FindBy(xpath ="//a[@href='/payment']")
    WebElement placeOrder;
    public Payment CLickOnCheckOutWhenLogin(){
        clickOn(click_on_button);
        scrollToElement(textarea);
        inputValue(textarea, "Hello123");
        clickOn(placeOrder);
        return new Payment(driver);
    }
}
