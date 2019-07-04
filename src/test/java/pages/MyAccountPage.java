package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class MyAccountPage {

    WebDriver driver;

    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.CSS, using = "a[title*='View my customer account'")
    private WebElement customerAccountButton;

    @FindBy(how = How.XPATH, using = "//h1[contains(text(),'My account')]")
    private WebElement myAccountHeading;

    public void validateAccountInfo() {
        Assert.assertTrue(myAccountHeading.isDisplayed());
    }

    public void validatePageUrl() {
        Assert.assertTrue(driver.getCurrentUrl().contains("account"));
    }

}
