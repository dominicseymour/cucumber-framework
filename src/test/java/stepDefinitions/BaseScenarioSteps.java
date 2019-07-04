package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dataProvider.ConfigFileReader;
import managers.FileReaderManager;
import managers.PageObjectManager;
import managers.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pages.LandingPage;
import pages.LoginPage;
import pages.MyAccountPage;

public class BaseScenarioSteps {

    WebDriver driver;
    LandingPage landingPage;
    LoginPage loginPage;
    MyAccountPage myAccountPage;
    PageObjectManager pageObjectManager;
    WebDriverManager webDriverManager;

    @Given("I am on the landing page")
    public void i_am_on_the_landing_page() {

        webDriverManager = new WebDriverManager();
        driver = webDriverManager.getDriver();
        pageObjectManager = new PageObjectManager(driver);

        landingPage = pageObjectManager.getLandingPage();
        landingPage.navigateToLandingPage();
    }

    @When("I navigate to the login page")
    public void i_navigate_to_the_login_page() {

        landingPage.clickSignInButton();
    }

    @When("I attempt to login to the application with username {string} and password {string}")
    public void i_attempt_to_login_to_the_application_with_username_and_password(String username, String password) {

        loginPage = pageObjectManager.getLoginPage();
        loginPage.enterEmail(username);
        loginPage.enterPassword(password);
        loginPage.clickSignInButton();
    }

    @Then("I am navigated to the My Account page")
    public void iAmNavigatedToTheMyAccountPage() {
        myAccountPage = new MyAccountPage(driver);
        myAccountPage.validatePageUrl();
    }


    @Then("I should see my account information")
    public void i_should_see_my_account_information() {

        myAccountPage = pageObjectManager.getMyAccountPage();
        myAccountPage.validateAccountInfo();
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
