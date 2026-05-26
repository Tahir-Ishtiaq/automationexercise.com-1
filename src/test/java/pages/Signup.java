package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Signup extends BaseClass{
    public Signup(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//input[@name='title'][1]")
    WebElement title;

    @FindBy(xpath = "//input[@id='password']")
    WebElement password ;

    @FindBy(xpath = "//select[@id='days']")
    WebElement days;

    @FindBy(xpath = "//select[@id='months']")
    WebElement months;

    @FindBy(xpath = "//select[@id='years']")
    WebElement years;

    @FindBy(xpath = "//input[@id='newsletter']")
    WebElement agreecheck1 ;


    @FindBy(xpath = "//input[@id='optin']")
    WebElement agreecheck2 ;

    @FindBy(xpath = "//input[@id='first_name']")
    WebElement firstname;

        @FindBy(xpath = "//input[@id='last_name']")
    WebElement lastname;

    @FindBy(xpath = "//input[@id='address1']")
    WebElement address1;

    @FindBy(xpath = "//select[@id='country']")
    WebElement country;

    @FindBy(xpath = "//input[@id='state']")
    WebElement state ;

    @FindBy(xpath = "//input[@id='city']")
    WebElement city;

    @FindBy(xpath = "//input[@id='zipcode']")
    WebElement zipcode  ;

    @FindBy(xpath = "//input[@id='mobile_number']")
    WebElement mobilenumber ;

    @FindBy(xpath = "//button[text()='Create Account']")
    WebElement createaccount ;



    public AccountCreated fillAndSubmitSignupForm(String pass, String dayVal, String monthVal, String yearVal,
                                                  String fName, String lName, String addr, String countryVal,
                                                  String stateVal, String cityVal, String zip, String mobile) {

        checkText("Enter Account Information");

        clickOn(title);
        inputValue(password, pass);

        selectDropdownByVisibleText(days, dayVal);
        selectDropdownByVisibleText(months, monthVal);
        selectDropdownByVisibleText(years, yearVal);

        clickOn(agreecheck1);
        clickOn(agreecheck2);

        inputValue(firstname, fName);
        inputValue(lastname, lName);
        inputValue(address1, addr);
        selectDropdownByVisibleText(country, countryVal);

        inputValue(state, stateVal);
        inputValue(city, cityVal);
        inputValue(zipcode, zip);
        inputValue(mobilenumber, mobile);

        clickOn(createaccount);

        return new AccountCreated(driver);
    }
}
