package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CarResultsPage {

    WebDriver driver;

    public CarResultsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "//button[@class='btn btn-action loader loader btn-block br25']")
    WebElement carDetailsButton;

    @FindAll
    (@FindBy(how = How.CSS, using = "h4[class='RTL go-text-right mt0 list_title']"))
    private List<WebElement> carResultsList;

    @FindBy(how = How.CSS, using = "h4[class='RTL go-text-right mt0 list_title']")
    private WebElement carName;

    public void clickCarDetailsButton() {
        carDetailsButton.click();
    }

    public String getCarName(int positionInList) {
        return carResultsList.get(positionInList).getText();
    }

    public void validateResultsDisplayed() {
        Assert.assertFalse(carResultsList.isEmpty());
    }
}
