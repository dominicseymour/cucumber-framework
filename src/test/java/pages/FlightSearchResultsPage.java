package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class FlightSearchResultsPage {

    WebDriver driver;

    public FlightSearchResultsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.CSS, using = "#all_flights")
    private WebElement flightResults;

    public void validateResultsDisplayed() {
        Assert.assertTrue(flightResults.isDisplayed());
    }
}
