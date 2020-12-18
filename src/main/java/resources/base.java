package resources;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.function.DoubleToIntFunction;

public class base {
    public  WebDriver driver;
    public Properties prop;

    public WebDriver initializeDriver() throws IOException {


        prop = new Properties();

        FileInputStream fis = new FileInputStream( System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
        prop.load(fis);
        String browserName = prop.getProperty("browser");
        if (browserName.contains("chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver.exe");
            ChromeOptions options=new ChromeOptions();
            if(browserName.contains("headless"))
            {
                options.addArguments("headless");
            }
            driver = new ChromeDriver(options);
        } else if (browserName.equals("firefox")) {
            driver = new FirefoxDriver();
        } else if (browserName.equals("IE")) {
            driver = new InternetExplorerDriver();
        }

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;

    }

    public void getscreenshot(String result) throws IOException {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src,new File("c:\\test\\" + result + "Screenshot.png"));

    }
}