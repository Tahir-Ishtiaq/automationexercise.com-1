package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Home extends BaseClass{
    public Home(WebDriver driver){
        super(driver);
    }
    @FindBy(xpath = "//a[@href='/login']")
    WebElement signup_login;

    public Login ClickOnLogin(){
        clickOn(signup_login);
        return new Login(driver);
    }

    @FindBy(xpath = "//a[@href='/delete_account']")
    WebElement delete_account;

    public DeleteAccount CheckAndDeleteAccount(){
        clickOn(delete_account);
        return new DeleteAccount(driver);
    }
}
