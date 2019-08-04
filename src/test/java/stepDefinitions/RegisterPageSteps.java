package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import pages.RegisterPage;

public class RegisterPageSteps {

    TestContext testContext;
    RegisterPage registerPage;

    public RegisterPageSteps(TestContext testContext) {
        this.testContext = testContext;
        registerPage = testContext.getPageObjectManager().getRegisterPage();
    }

    @Given("I enter first name as {string}")
    public void i_enter_first_name_as(String firstName) {
        registerPage.inputFirstName(firstName);
    }

    @Given("I enter last name as {string}")
    public void i_enter_last_name_as(String lastName) {
        registerPage.inputLastName(lastName);
    }

    @Given("I enter mobile number as {string}")
    public void i_enter_mobile_number_as(String mobileNumber) {
        registerPage.inputPhone(mobileNumber);
    }

    @Given("I enter Email as {string}")
    public void i_enter_Email_as(String email) {
        registerPage.inputEmail(email);
    }

    @Given("I enter password as {string}")
    public void i_enter_password_as(String password) {
        registerPage.inputPassword(password);
    }

    @Given("I enter confirmation password as {string}")
    public void i_enter_confirmation_password_as(String confirmPassword) {
        registerPage.inputConfirmPassword(confirmPassword);
    }

    @When("I click the sign up button")
    public void i_click_the_sign_up_button() {
        registerPage.clickSignUpButton();
    }
}
