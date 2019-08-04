package pages;

import managers.FileReaderManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class LandingPage {

    WebDriver driver;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

//    @FindBy(how = How.XPATH, using = "//ul[@class='nav navbar-nav navbar-right hidden-sm go-left']//a[@class='dropdown-toggle go-text-right'][contains(text(),'My Account')]")
//    private WebElement accountButton;

    @FindBy(how = How.XPATH, using = "//ul[@class='nav navbar-nav navbar-right hidden-sm go-left']//ul[@class='nav navbar-nav navbar-side navbar-right sidebar go-left user_menu']//li[@id='li_myaccount']//ul[@class='dropdown-menu']//li//a[@class='go-text-right'][contains(text(),'Login')]")
    private WebElement signInButton;

    @FindBy(how = How.XPATH, using = "(//a[contains(.,'Sign Up')])[2]")
    private WebElement signUpButton;

    @FindBy(how = How.CSS, using = "#cookyGotItBtn")
    private WebElement acceptCookiesButton;

//    public void clickaccountButton() {
//        accountButton.click();
//            }

    public void clickSignInButton() {

        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", signInButton);
    }

    public void clickSignUpButton() {

        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", signUpButton);
    }

    public void navigateToLandingPage() {
        driver.get(FileReaderManager.getInstance().getConfigFileReader().getBaseUrl());
    }

    public void acceptCookiesPopup() {
        acceptCookiesButton.click();
    }
}
