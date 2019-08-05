package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Calendar;
import java.util.List;

public class FlightBookingPage {

    WebDriver driver;

    public FlightBookingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "//*[@id='thflights']/div[1]")
    private WebElement departureAirportSelector;

    @FindBy(how = How.XPATH, using = "//input[@class='select2-input select2-focused']")
    private WebElement inputField;

    @FindBy(how = How.XPATH, using = "//*[@id='thflights']/div[2]")
    private WebElement destinationAirportSelector;

    @FindBy(how = How.CSS, using = "#departure")
    private WebElement calendar;

    @FindBy(how = How.XPATH, using = "//div[contains(@class,'bgfade col-md-3 col-xs-12 search-button')]//button[contains(@class,'btn-primary btn btn-lg btn-block pfb0')][contains(text(),'Search')]")
    private WebElement searchButton;

    public void selectDepartureAirport(String searchTerm) throws InterruptedException {
        departureAirportSelector.click();
        inputField.sendKeys(searchTerm);
        Thread.sleep(3000);
        inputField.sendKeys(Keys.RETURN);
    }

    public void setDestinationAirportSelector (String searchTerm) throws InterruptedException {
        destinationAirportSelector.click();
        inputField.sendKeys(searchTerm);
        Thread.sleep(3000);
        inputField.sendKeys(Keys.RETURN);
    }

    private void invokeCalendar() {
        calendar.click();
    }

    public void selectCurrentDate() {
        invokeCalendar();
        WebElement datePicker = driver.findElement(By.cssSelector(".datepicker-days"));

        List<WebElement> days = datePicker.findElements(By.cssSelector("td"));
        Calendar cal = Calendar.getInstance();
        String dayOfMonth = Integer.toString(cal.get(Calendar.DAY_OF_MONTH));
        for (WebElement day : days) {
            if (day.getText().equalsIgnoreCase(dayOfMonth)) {
                day.click();
                break;
            }
        }
    }

    public void search() {
        searchButton.click();
    }

    public void validateUrl() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.titleIs("PHPTRAVELS | Travel Technology Partner"));
        Assert.assertTrue(driver.getCurrentUrl().equals("https://www.phptravels.net/m-thflight"));
    }

}
