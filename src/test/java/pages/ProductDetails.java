package pages;

import org.openqa.selenium.WebDriver;

public class ProductDetails extends BaseClass{
    public ProductDetails(WebDriver driver){
        super(driver);
    }

    public void CheckProductDetails(){
        String[] infos ={"Blue Top", "Women > Tops", "In Stock", "New", "Polo"};
        for(String info : infos){
            checkText(info);
        }
    }
}
