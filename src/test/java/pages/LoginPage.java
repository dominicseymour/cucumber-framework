package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.CSS, using = "input[name = 'username']")
    private WebElement usernameInputField;

    @FindBy(how = How.CSS, using = "input[name = 'password']")
    private WebElement passwordInputField;

    @FindBy(how = How.XPATH, using = "//button[text()='Login']")
    private WebElement loginButton;

    public void enterUsername(String email) {
        usernameInputField.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordInputField.sendKeys(password);
    }

    public void clickSignInButton() {
        loginButton.click();
    }

}
