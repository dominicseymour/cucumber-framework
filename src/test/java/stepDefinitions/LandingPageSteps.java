package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import pages.LandingPage;

public class LandingPageSteps {

    TestContext testContext;
    LandingPage landingPage;

    public LandingPageSteps(TestContext testContext) {
        this.testContext = testContext;
        landingPage = testContext.getPageObjectManager().getLandingPage();
    }

    @Given("I am on the landing page")
    public void i_am_on_the_landing_page() {
        landingPage.navigateToLandingPage();
        landingPage.acceptCookiesPopup();
    }

    @When("I navigate to the login page")
    public void i_navigate_to_the_login_page() {
        landingPage.clickSignInButton();
    }

    @Given("I navigate to the sign up page")
    public void i_navigate_to_the_sign_up_page() {
        landingPage.clickSignUpButton();
    }
}
