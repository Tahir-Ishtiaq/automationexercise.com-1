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


    @FindBy(xpath = "//input[@name='email'][1]")
    WebElement emailForLogin;

    @FindBy(xpath = "//input[@name='password']")
    WebElement passwordForLogin;

    @FindBy(xpath = "//button[text()='Login']")
    WebElement loginButton;

    public Home  Login(String Email, String Password){
        checkText("New User Signup!");
        inputValue(emailForLogin, Email);
        inputValue(passwordForLogin, Password);
        clickOn(loginButton);
        return new Home(driver);

    }
}

/*
public Signup  Login(String Email, String Password){
        checkText("New User Signup!");
        inputValue(emailForLogin, Email);
        inputValue(passwordForLogin, Password);
        clickOn(loginButton);
        return new Signup(driver);

    }
*/