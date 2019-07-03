package stepDefinitions;

import base.Base;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.LandingPage;
import pages.LoginPage;
import pages.MyAccountPage;
import selenium.Settings;

import java.io.IOException;
import java.util.Properties;

public class BaseScenarioSteps {

    WebDriver driver;

    @Given("I am on the landing page")
    public void i_am_on_the_landing_page() {

        driver = Base.initializeDriver();
        driver.get(Settings.baseUrl);
    }

    @When("I navigate to the login page")
    public void i_navigate_to_the_login_page() {

        LandingPage landingPage = new LandingPage(driver);
        landingPage.clickSignInButton();
    }

    @When("I attempt to login to the application with username {string} and password {string}")
    public void i_attempt_to_login_to_the_application_with_username_and_password(String username, String password) {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail(username);
        loginPage.enterPassword(password);
        loginPage.clickSignInButton();
    }

    @Then("I am navigated to the My Account page")
    public void iAmNavigatedToTheMyAccountPage() {
        Assert.assertEquals(driver.getCurrentUrl(), Settings.myAccountPageUrl);
    }


    @Then("I should see my account information")
    public void i_should_see_my_account_information() {

        MyAccountPage myAccountPage = new MyAccountPage(driver);

    }

    @Then("an error message is displayed")
    public void anErrorMessageIsDisplayed() {

        System.out.println("Then an error message is displayed");
    }

    @Then("I should see the login button")
    public void i_should_see_the_login_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }



    @Then("I am not logged in")
    public void i_am_not_logged_in() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Then("I am on the login page")
    public void i_am_on_the_login_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }
}
