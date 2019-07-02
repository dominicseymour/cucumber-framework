package pages;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LandingPage {

    protected WebDriver driver;

    By signInButton = By.cssSelector("a[href*='controller=my-account']");

    public LandingPage() {
        this.driver = Base.initializeDriver();
    }

    public WebElement getSignInButton() {
        return driver.findElement(signInButton);
    }

    public void validatePageUrl(String expectedUrl) {
        Assert.assertEquals(expectedUrl, driver.getCurrentUrl());
    }

    public LoginPage signIn() {

        driver.findElement(signInButton).click();
        return new LoginPage();
    }


}
