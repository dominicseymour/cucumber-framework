package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import managers.PageObjectManager;
import managers.WebDriverManager;
import org.openqa.selenium.WebDriver;
import pages.MyAccountPage;

public class MyAccountPageSteps {

    TestContext testContext;
    MyAccountPage myAccountPage;

    public MyAccountPageSteps(TestContext testContext) {
        this.testContext = testContext;
        myAccountPage = testContext.getPageObjectManager().getMyAccountPage();
    }

    @Then("I am navigated to the My Account page")
    public void iAmNavigatedToTheMyAccountPage() {
        myAccountPage.validatePageUrl();
    }

    @Then("I should see my account information")
    public void i_should_see_my_account_information() {
        myAccountPage.validateAccountInfo();
    }

    @Given("I navigate to the Flight Booking page")
    public void i_navigate_to_the_Flight_Booking_page() {
        myAccountPage.selectFlightsPageTab();
    }

    @Given("I navigate to the Car Booking page")
    public void i_navigate_to_the_Car_Booking_page() {
       myAccountPage.selectCarsPageTab();
    }

}
