package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class MyAccountPage {

    public MyAccountPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.CSS, using = "a[title*='View my customer account'")
    private WebElement customerAccountButton;

    @FindBy(how = How.XPATH, using = "//h1[contains(text(),'MY ACCOUNT')]")
    private WebElement myAccountHeading;

    public void validateAccountInfo() {
        Assert.assertTrue(myAccountHeading.isDisplayed());
    }

}
