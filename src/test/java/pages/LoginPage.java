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

    @FindBy(how = How.CSS, using = "#email")
    private WebElement emailInputField;

    @FindBy(how = How.CSS, using = "#passwd")
    private WebElement passwordInputField;

    @FindBy(how = How.CSS, using = "#SubmitLogin")
    private WebElement signInButton;

    public void enterEmail(String email) {
        emailInputField.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordInputField.sendKeys(password);
    }

    public void clickSignInButton() {
        signInButton.click();
    }

}
