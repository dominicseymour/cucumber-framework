package pages;

import dataProvider.ConfigFileReader;
import managers.FileReaderManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import selenium.Settings;

public class LandingPage {

    WebDriver driver;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.CSS, using = "a[href*='controller=my-account']")
    private WebElement signInButton;

    public void clickSignInButton() {
        signInButton.click();
    }

    public void navigateToLandingPage() {
        driver.get(FileReaderManager.getInstance().getConfigFileReader().getBaseUrl());
    }
}
