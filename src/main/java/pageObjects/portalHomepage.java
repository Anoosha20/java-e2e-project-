package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class portalHomepage {
    public  WebDriver driver;
    By searchBox=By.name("query");



    public portalHomepage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getSearchBox()
    {
        return  driver.findElement(searchBox);
    }
}

