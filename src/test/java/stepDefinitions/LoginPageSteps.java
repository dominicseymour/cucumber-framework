package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import pages.LoginPage;

public class LoginPageSteps {

    TestContext testContext;
    LoginPage loginPage;

    public LoginPageSteps(TestContext testContext) {
        this.testContext = testContext;
        loginPage = testContext.getPageObjectManager().getLoginPage();
    }

    @When("I attempt to login to the application with username {string} and password {string}")
    public void i_attempt_to_login_to_the_application_with_username_and_password(String username, String password) {

        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickSignInButton();
    }

    @Given("I sign in to the application")
    public void i_sign_in_to_the_application() {
        loginPage.signIn();
    }
}
