package pages;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseClass {
    WebDriver driver;
    WebDriverWait wait;
    public BaseClass(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    /*private void prepareElement(WebElement element) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].style.border='2px solid Red'", element);
            Thread.sleep(1000);
            js.executeScript("arguments[0].style.border=''", element);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }*/

    /*public void pause(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (Exception e) {
            //
        }
    }*/

    public void inputValue(WebElement locator, String input) {
        WebElement element = wait.until(ExpectedConditions.visibilityOf(locator));
        //prepareElement(element);
        element.clear();
        for (String letter : input.split("")) {
            element.sendKeys(letter);
            //pause(50);
        }
    }

    public void clickOn(WebElement locator) {
        WebElement element = wait.until(ExpectedConditions.visibilityOf(locator));
        //prepareElement(element);
        //pause(1000);
        element.click();

    }
    public void checkText(String text){
        if(driver.getPageSource().contains(text)){
            System.out.println(text +"-> FOUND");
        }else{
            System.out.println(text +"-> NOT FOUND");
        }
    }


    public void selectDropdownByVisibleText(WebElement locator, String text) {
        WebElement element = wait.until(ExpectedConditions.visibilityOf(locator));
        //prepareElement(element);
        Select dropdown = new Select(element);
        dropdown.selectByVisibleText(text);
    }
}
