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
}
