package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.IOException;

public class LoginPage extends LandingPage {

    By emailInputField = By.id("email");

    By passwordInputField = By.id("passwd");

    By signInButton = By.id("SubmitLogin");

    public WebElement getEmailInputField() { return driver.findElement(emailInputField);
    }

    public WebElement getPasswordInputField() {
        return driver.findElement(passwordInputField);
    }

    public WebElement getSignInButton() {
        return driver.findElement(signInButton);
    }

    public void validatePageUrl(String expectedUrl) {
        Assert.assertEquals(expectedUrl, driver.getCurrentUrl());
    }
}
