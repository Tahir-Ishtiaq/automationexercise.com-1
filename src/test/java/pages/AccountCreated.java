package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountCreated extends BaseClass{
    public AccountCreated(WebDriver driver){
        super(driver);
    }
    @FindBy(xpath = "//a[text()='Continue']")
    WebElement Continue;

    public Home continueUser(){
        checkText("Account Created!");
        clickOn(Continue);
        return new Home(driver);
    }
}
