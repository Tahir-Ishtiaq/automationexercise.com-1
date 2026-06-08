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

    @FindBy(xpath = "//a[@href='/logout']")
    WebElement logout;
    public Login ClickOnLogout(){
        clickOn(logout);
        return new Login(driver);
    }

    @FindBy(xpath = "//a[@href='/contact_us']")
    WebElement contact_us;
    public ContactUs ClickOneContactUs(){
        clickOn(contact_us);
        return new ContactUs(driver);
    }

    @FindBy(xpath = "//a[@href='/test_cases'][1]")
    WebElement test_case;
    public void ClickOneTestCase(){
        clickOn(test_case);
    }

    @FindBy(xpath = "//a[@href='/products']")
    WebElement products;
    public Products ClickOneProducts(){
        clickOn(products);
        return new Products(driver);
    }

    @FindBy(xpath = "//input[@id='susbscribe_email']")
    WebElement susbscribe_email;
    @FindBy(xpath = "//button[@id='subscribe']")
    WebElement subscribe_button;

    public void SubscribeWithEmail(String Email){
        checkText("Subscription");
        inputValue(susbscribe_email,Email);
        clickOn(subscribe_button);
        checkText("You have been successfully subscribed!");
    }

    @FindBy(xpath = "//a[@href='/view_cart'][1]")
    WebElement view_cart;
    public ViewCart ClickOnViewCart(){
        clickOn(view_cart);
        return new ViewCart(driver);
    }
}
