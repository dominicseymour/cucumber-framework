package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

    WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.CSS, using = "input[name='firstname']")
    private WebElement firstNameInputField;

    @FindBy(how = How.CSS, using = "input[name='lastname']")
    private WebElement lastNameInputField;

    @FindBy(how = How.CSS, using = "input[name='phone']")
    private WebElement phoneInputField;

    @FindBy(how = How.CSS, using = "input[name='email']")
    private WebElement emailInputField;

    @FindBy(how = How.CSS, using = "input[name='password']")
    private WebElement passwordInputField;

    @FindBy(how = How.CSS, using = "input[name='confirmpassword']")
    private WebElement confirmpasswordInputField;

    @FindBy(how = How.CSS, using = "button[type = 'submit']")
    private WebElement signUpButton;

    public void inputFirstName(String firstName) {
        firstNameInputField.sendKeys(firstName);
    }

    public void inputLastName(String lastName) {
        lastNameInputField.sendKeys(lastName);
    }

    public void inputPhone(String phone) {
        phoneInputField.sendKeys(phone);
    }

    public void inputEmail(String email) {
        emailInputField.sendKeys(email);
    }

    public void inputPassword(String password) {
        passwordInputField.sendKeys(password);
    }

    public void inputConfirmPassword(String confirmPassword) {
        confirmpasswordInputField.sendKeys(confirmPassword);
    }

    public void clickSignUpButton() {
        signUpButton.click();
    }
}
