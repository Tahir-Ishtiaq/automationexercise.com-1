package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUs extends BaseClass{
    public ContactUs(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//input[@name='name']")
    WebElement name;

    @FindBy(xpath = "//input[@name='email']")
    WebElement email;

    @FindBy(xpath = "//input[@name='subject']")
    WebElement subject;

    @FindBy(xpath = "//textarea[@name='message']")
    WebElement message;

    @FindBy(xpath = "//input[@name='upload_file']")
    WebElement upload_file;

    @FindBy(xpath = "//input[@name='submit']")
    WebElement submit;

    @FindBy(xpath = "//a[@class='btn btn-success']")
    WebElement home_button;

    public Home ContactUsFormFilling(String Name,String Email, String Subject, String Message, String Path){
        checkText("Get In Touch");
        WebElement[] locators = {name, email, subject, message};
        String[] info = {Name, Email, Subject, Message};
        for(int i =0; i<4; i++){
            inputValue(locators[i], info[i]);
        }
        uploadFile(upload_file, Path);
        clickOn(submit);
        handleAlert();
        checkText("Success! Your details have been submitted successfully.");
        clickOn(home_button);
        return new Home(driver);
    }
}
