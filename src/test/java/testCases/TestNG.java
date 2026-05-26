package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.Home;

public class TestNG {
    WebDriver driver;
    Home home;

    @BeforeTest
    public void login(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://automationexercise.com");
        home = new Home(driver);
    }

    @Test
    public void flow(){
        home.ClickOnLogin()
        .SignUp("Tahir", "tahirr@gmail.com")
        .fillAndSubmitSignupForm("tahirtahir","3", "February",
        "2003", "Tahir", "Ishtiaq", "ABC","India",
         "ABC", "ABC", "12354", "01234567890")
        .continueUser()
        .CheckAndDeleteAccount()
        .Continueflow();

    }


}
