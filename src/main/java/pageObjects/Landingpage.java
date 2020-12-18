package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Landingpage {
    public  WebDriver driver;
    private By nothanks=By.xpath("//button[contains(text(),'NO THANKS')]");
  private By title=By.xpath("//h2[contains(text(),'Featured Courses')]");

    private By login=By.xpath("//span[contains(text(),'Login')]");
   private By navbar=By.xpath("//ul[@class='nav navbar-nav navbar-right']");
   private By header=By.xpath("//h3[contains(text(),'An Academy to learn Everything about Testing')]");

    public Landingpage(WebDriver driver) {
        this.driver=driver;
    }
     public int getNoThankssize()
     {
         return  driver.findElements(nothanks).size();
     }
     public WebElement getNoThanks()
     {
         return driver.findElement(nothanks);
     }

     public  WebElement getNavigationBar()
     {
         System.out.println("Trying to identify navigation bar");
         return driver.findElement(navbar);
     }
     public WebElement getTitle()
     {
         return driver.findElement(title);
     }
    public WebElement getLogin()
    {
        return driver.findElement(login);
    }
    public WebElement getHeader()
    {
        return driver.findElement(header);
    }
}
