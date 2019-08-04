package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyAccountPage {

    WebDriver driver;

    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "//a[contains(text(), 'Dom')]")
    private WebElement customerAccountButton;

    @FindBy(how = How.CSS, using = "a[href='https://www.phptravels.net/m-thflight']")
    private WebElement flightsPageTab;

    @FindBy(how = How.XPATH, using = "//h3[@class='RTL']")
    private WebElement welcomeText;

    public void validateAccountInfo() {
        Assert.assertTrue(welcomeText.getText().equalsIgnoreCase("Hi, Test Test"));
    }

    public void validatePageUrl() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.titleIs("My Account"));
        Assert.assertTrue(driver.getCurrentUrl().equalsIgnoreCase("https://www.phptravels.net/account/"));
    }

    public void selectFlightsPageTab() {
        flightsPageTab.click();
    }

}
