package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CarResultsPage {

    WebDriver driver;

    public CarResultsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "//button[@class='btn btn-action loader loader btn-block br25']")
    WebElement carDetailsButton;

    @FindBy(how = How.CSS, using = ".itemscontainer")
    private WebElement carResultsList;

    public void selectCarDetailsButton() {
        carDetailsButton.click();
    }

    public void validateResultsDisplayed() {
        Assert.assertTrue(carResultsList.isDisplayed());
    }
}
