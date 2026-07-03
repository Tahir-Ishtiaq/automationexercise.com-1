package testCases;

//cd "C:\Users\Tahir\Downloads\QA Automation\automationexercise.com-1"
//Get-Content target/logs/automation.log -Wait

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;
import pages.BaseClass;
import pages.Home;
import pages.Login;

public class LoginTestNG {
    private static final Logger logger =
            LoggerFactory.getLogger(LoginTestNG.class);
    String baseEmailPrefix = "tahir";
    WebDriver driver;
    Home home;

    @BeforeMethod
    public void login(){
        org.openqa.selenium.chrome.ChromeOptions options = new org.openqa.selenium.chrome.ChromeOptions();

        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-notifications");
        logger.info("Opening Chrome");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        logger.info("Navigating to website");
        driver.get("https://automationexercise.com");
        logger.info("Google opened successfully: https://automationexercise.com");
        home = new Home(driver);
    }

    @Test(priority = 1)
    public void signUp(){
        home.ClickOnLogin()
        .SignUp("Tahir", baseEmailPrefix)
        .fillAndSubmitSignupForm("tahirtahir","3", "February",
"2003", "Tahir", "Ishtiaq", "ABC","Canada",
"ABC", "ABC", "12354", "01234567890")
        .continueUser();
    }

    @Test(priority = 4)
    public void SignupWithExistingEmail(){
        home.ClickOnLogin()
                .SignUp("Tahir", Login.finalGeneratedEmail);
    }

    @Test(priority = 3)
    public void loginThanLogout(){
        home.ClickOnLogin()
                .Login(Login.finalGeneratedEmail, "tahirtahir")
                .ClickOnLogout();

    }

    @Test(priority = 2)
    public void loginWithCorrectCreds(){
        home.ClickOnLogin()
        .Login(Login.finalGeneratedEmail, "tahirtahir");
    }

    @Test(priority = 5)
    public void loginWithIncorrectCreds(){
        home.ClickOnLogin()
        .Login("qwerty@gmail.com", "123456")
        .checkText("Your email or password is incorrect!");
    }

    @Test(priority = 6)
    public void contactUsModule(){
        home.ClickOneContactUs()
        .ContactUsFormFilling("Tahir", "tahir@gamil.com", "Hello How are you!?",
"My name is TAHIR, and I'm a Software Engineer!","C:/Users/Tahir/Downloads/2025F-MSE-022.pdf");
    }
    @Test(priority = 7)
    public void testCaseModule(){
        home.ClickOneTestCase();
      }

    @Test(priority = 8)
    public void productsModule(){
        home.ClickOneProducts()
        .ClickOnViewProduct()
        .CheckProductDetails();
    }

    @Test(priority = 9)
    public void searchProductsModule(){
        home.ClickOneProducts()
        .SearchCustomer("Shirt");
    }

    @Test(priority = 10)
    public void subscribeThroughEmail(){
        home.SubscribeWithEmail("tahir@gmail.com");
    }

    @Test(priority = 11)
    public void subscribeFromViewCart(){
        home.ClickOnViewCart()
        .SubscribeEmailFromViewCart("tahir@gmail.com");
    }

    @Test(priority = 12)
    public void checkAddToCart(){
        home.ClickOneProducts()
         .AddToCart();
    }
    @Test(priority = 13)
    public void productQuantity(){
        home.ClickOnProduct2()
        .IncreaseQuantity();
    }

    @Test(priority = 14)
    public void PlaceOrderAndCheckOutWithRegister(){
        home.ClickOneProducts()
        .AddToCart()
        .ClickOnViewCart()
        .CLickOnCheckOutWhenNoLogin()
        .SignUp("Tahir","tahir.ishtiaq")
        .fillAndSubmitSignupForm("tahirtahir","3", "February",
                "2003", "Tahir", "Ishtiaq", "ABC","Canada",
                "ABC", "ABC", "12354", "01234567890")
        .continueUser()
        .ClickOnViewCart()
        .CLickOnCheckOutWhenLogin()
        .makePayment()
        .CheckAndDeleteAccount()
        .Continueflow();
    }

    @AfterMethod
    public void close(){
        if (driver != null) {
            driver.quit();
        }
    }
}
