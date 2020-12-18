package Academy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.Landingpage;
import pageObjects.Loginpage;
import resources.base;

import java.io.IOException;

public class HomePage extends base {
    public static Logger Log= LogManager.getLogger(base.class.getName());
    @BeforeTest
    public  void Initialize() throws IOException {
        driver = initializeDriver();
    }
    @Test(dataProvider = "getData")
    public  void  basePageNavigation(String username, String password, String text) throws IOException {
        driver = initializeDriver();
        driver.get(prop.getProperty("url"));
        Landingpage l = new Landingpage(driver);
        l.getNoThanks().click();
        l.getLogin().click();
        Loginpage lp = new Loginpage(driver);
        lp.getEmail().sendKeys(username);
        lp.getPassword().sendKeys(password);
        Log.info(text);
        lp.getSubmit().click();

    }

    @DataProvider
    public Object[][] getData()
    {
        Object[][] data=new Object[2][3];
        data[0][0]="nonrestrictedusername@qw.com";
        data[0][1]="123456";
       data[0][2]="restricted user";

       data[1][0]="restricteduser@qw.com";
        data[1][1]="456789";
        data[1][2]="nonrestricted user";
        return data;
    }
    @AfterTest
    public void tearDown()
    {
        driver.close();
        driver=null;

    }
}
