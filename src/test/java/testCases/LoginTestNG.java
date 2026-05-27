package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.Home;

public class LoginTestNG {
    String Email= "asd9cs@gmail.com";
    WebDriver driver;
    Home home;

    @BeforeMethod
    public void login(){
        org.openqa.selenium.chrome.ChromeOptions options = new org.openqa.selenium.chrome.ChromeOptions();

        // 1. Disables extension/popups which often host third-party overlay ads
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://automationexercise.com");
        home = new Home(driver);
    }

    @Test(priority = 1)
    public void signUp(){
        home.ClickOnLogin()
        .SignUp("Tahir", Email)
        .fillAndSubmitSignupForm("tahirtahir","3", "February",
"2003", "Tahir", "Ishtiaq", "ABC","Canada",
"ABC", "ABC", "12354", "01234567890")
        .continueUser();
    }

    @Test(priority = 4)
    public void SignupWithExistingEmail(){
        home.ClickOnLogin()
                .SignUp("Tahir", Email)
                .checkText("Email Address already exist!");
    }

    @Test(priority = 3)
    public void loginThanLogout(){
        home.ClickOnLogin()
                .Login(Email, "tahirtahir")
                .ClickOnLogout();

    }

    @Test(priority = 2)
    public void loginWithCorrectCreds(){
        home.ClickOnLogin()
        .Login(Email, "tahirtahir");
    }

    @Test(priority = 5)
    public void loginWithIncorrectCreds(){
        home.ClickOnLogin()
        .Login("qwerty@gmail.com", "123456")
        .checkText("Your email or password is incorrect!");
    }



    @AfterMethod
    public void close(){
        if (driver != null) {
            driver.quit(); // <-- CHANGED from close() to quit() to prevent NoSuchSessionException
        }
    }
}
