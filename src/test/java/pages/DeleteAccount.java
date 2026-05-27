package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeleteAccount extends BaseClass{
    public DeleteAccount(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//a[text()='Continue']")
    WebElement Continue;

    public  Home Continueflow(){
        clickOn(Continue);
        return new Home(driver);
    }
    public  Home checkTEXT(){
        checkText("Account Deleted!");
        return new Home(driver);
    }

}
