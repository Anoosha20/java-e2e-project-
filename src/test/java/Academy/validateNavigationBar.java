package Academy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.Landingpage;
import resources.base;

import java.io.IOException;

public class validateNavigationBar extends base {
    public static Logger Log=LogManager.getLogger(base.class.getName());
    @BeforeTest
    public  void Initialize() throws IOException {
        driver=initializeDriver();
        driver.get(prop.getProperty("url"));
    }

    @Test

    public  void  validateappnavbar() throws IOException {


        Landingpage l=new Landingpage(driver);
        l.getNoThanks().click();
        Assert.assertTrue(l.getNavigationBar().isDisplayed());
        Log.info("Navigation bar is displayed");




    }

    @AfterTest
    public void tearDown()
    {
        driver.close();
        driver=null;

    }

}
