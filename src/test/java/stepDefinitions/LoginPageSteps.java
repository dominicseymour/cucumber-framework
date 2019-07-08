package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.en.When;
import managers.PageObjectManager;
import managers.WebDriverManager;
import org.openqa.selenium.WebDriver;
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

        loginPage.enterEmail(username);
        loginPage.enterPassword(password);
        loginPage.clickSignInButton();
    }
}
