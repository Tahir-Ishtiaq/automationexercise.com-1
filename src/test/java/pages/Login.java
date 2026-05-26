package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class Login extends BaseClass{
    public Login(WebDriver driver){
        super(driver);
    }
    @FindBy(xpath = "//input[@name='name']")
    WebElement name;

    @FindBy(xpath = "//input[@data-qa='signup-email']")
    WebElement email;

    @FindBy(xpath = "//button[text()='Signup']")
    WebElement signup;

    public Signup SignUp(String Name, String Email){
        checkText("New User Signup!");
        inputValue(name, Name);
        inputValue(email, Email);
        clickOn(signup);
        return new Signup(driver);
    }
}
