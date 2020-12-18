package Academy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.Landingpage;
import pageObjects.Loginpage;
import resources.base;

import java.io.IOException;

public class validateTitle extends base {
    public static Logger Log= LogManager.getLogger(base.class.getName());
    Landingpage l;
    @BeforeTest
    public  void Initialize() throws IOException {
        driver=initializeDriver();
        Log.info("Driver is initialized");
        driver.get(prop.getProperty("url"));
        Log.info("Navigated to homepage");
    }
    @Test

    public  void  validateapptitle() throws IOException {

        Landingpage l=new Landingpage(driver);
        l.getNoThanks().click();
        Assert.assertEquals(l.getTitle().getText(),"FEATURED COURSES123");
        Log.info("Successfully validate textmessage");



    }
    @Test

    public  void  validateHeader() throws IOException {

        l=new Landingpage(driver);
        Assert.assertEquals(l.getHeader().getText(),"AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING");
        Log.info("Successfully validate textmessage");



    }
@AfterTest
    public void tearDown()
{
    driver.close();
    driver=null;
}
}
