package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Payment extends BaseClass{
    public Payment(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//input[@name='name_on_card']")
    WebElement name_on_card;

    @FindBy(xpath = "//input[@name='card_number']")
    WebElement card_number;

    @FindBy(xpath = "//input[@name='cvc']")
    WebElement cvc;

    @FindBy(xpath = "//input[@name='expiry_month']")
    WebElement expiry_month;

    @FindBy(xpath = "//input[@name='expiry_year']")
    WebElement expiry_year;

    @FindBy(xpath = "//button[@id='submit']")
    WebElement submit;

    WebElement[] locators ={name_on_card,card_number,cvc,expiry_month,expiry_year};
    String[] inputs = {"Muhammad Tahir","1234567812345678","545","06","2029"};

    public Home makePayment(){
        for(int i=0; i<inputs.length;i++){
            inputValue(locators[i], inputs[i]);
        }
        clickOn(submit);
        return new Home(driver);
    }
}
