package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAccountPage extends LoginPage {

    By viewCustomerAccountButton = By.cssSelector("a[title*='View my customer account'");

    public WebElement getViewCutomerAccountButton() {
        return driver.findElement(viewCustomerAccountButton);
    }
}
