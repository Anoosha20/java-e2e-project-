package CucumberOptions;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;

//@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/Features",
        glue = "stepDefinations"
)
public class TestRunner extends AbstractTestNGCucumberTests{
}
