package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.Home;

public class LoginTestNG {
    WebDriver driver;
    Home home;

    @BeforeMethod
    public void login(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://automationexercise.com");
        home = new Home(driver);
    }

    @Test(priority = 1)
    public void flow(){
        home.ClickOnLogin()
        .SignUp("Tahir", "tahirr@gmail.com")
        .fillAndSubmitSignupForm("tahirtahir","3", "February",
"2003", "Tahir", "Ishtiaq", "ABC","Canada",
"ABC", "ABC", "12354", "01234567890")
        .continueUser();
    }

    @Test(priority = 2)
    public void loginWithCorrectCreds(){
        home.ClickOnLogin()
        .Login("tahirr@gmail.com", "tahirtahir")
        .CheckAndDeleteAccount()
        .checkTEXT();
    }

    @AfterMethod
    public void close(){
        driver.close();
    }
}
