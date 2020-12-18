package stepDefinations;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.junit.Cucumber;
import org.junit.Assert;
import org.junit.runner.RunWith;
import pageObjects.Landingpage;
import pageObjects.Loginpage;
import pageObjects.portalHomepage;
import resources.base;

import java.io.IOException;

@RunWith(Cucumber.class)
public class stepDefination extends base {
    @When("^User enters (.+) and (.+) and logs in$")
    public void user_enters_and_and_logs_in(String username, String password) {
        Loginpage lp = new Loginpage(driver);
        lp.getEmail().sendKeys(username);
        lp.getPassword().sendKeys(password);
        lp.getSubmit().click();

    }


    @Then("^Verify that user is successfully logged in$")
    public void verify_that_user_is_successfully_logged_in() {
        portalHomepage p=new portalHomepage(driver);
       Assert.assertTrue( p.getSearchBox().isDisplayed());
    }


    @Given("^Navigate to \"([^\"]*)\" site$")
    public void navigate_to_something_site(String strArg1){
        driver.get(strArg1);
    }

    @Given("^click on login link in homepage to land on secure sign in page$")
    public void click_on_login_link_in_homepage_to_land_on_secure_sign_in_page() {

        Landingpage l = new Landingpage(driver);
        if (l.getNoThankssize()>0){
            l.getNoThanks().click();
        }
        l.getLogin().click();
    }


    @Given("^Initialize the browser with chrome$")
    public void initializeTheBrowserWithChrome() throws IOException {
        driver=initializeDriver();

    }

    @And("^close browsers$")
    public void closeBrowsers() {
        driver.quit();







    }
}