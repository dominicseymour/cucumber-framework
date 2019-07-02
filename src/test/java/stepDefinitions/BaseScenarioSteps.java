package stepDefinitions;

import base.Base;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.LandingPage;
import pages.LoginPage;

import java.io.IOException;
import java.util.Properties;

public class BaseScenarioSteps {

    @Given("I am on the landing page")
    public void i_am_on_the_landing_page() {

        LandingPage landingPage = new LandingPage();
        Properties properties = Base.loadProperties();
        landingPage.validatePageUrl(properties.getProperty("url"));
    }

    @When("I navigate to the login page")
    public void i_navigate_to_the_login_page() {

        LandingPage landingPage = new LandingPage();
        LoginPage loginPage = landingPage.signIn();
    }

    @When("I attempt to login to the application with username {string} and password {string}")
    public void i_attempt_to_login_to_the_application_with_username_and_password(String username, String password) {

        LoginPage loginPage = new LoginPage();
        loginPage.getEmailInputField().sendKeys(username);
        loginPage.getPasswordInputField().sendKeys(password);
        loginPage.getSignInButton().click();
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

    @Then("I am navigated to the {string} page")
    public void i_am_navigated_to_the_page(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Then("I should see my account information")
    public void i_should_see_my_account_information() {
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
