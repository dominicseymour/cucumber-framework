package pages;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;
import net.sourceforge.htmlunit.corejs.javascript.JavaScriptException;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.Wait;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class CarBookingPage {

    WebDriver driver;

    public CarBookingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = ".//*[contains(text(),'Pick up')]")
    WebElement pickUpLocationField;

    @FindBy(how = How.XPATH, using = "//input[contains(@class,'select2-input select2-focused')]")
    WebElement pickUpLocationInputField;

    @FindBy(how = How.CSS, using = "#departcar")
    WebElement calendar1;

    @FindBy(how = How.CSS, using = "#returncar")
    WebElement calendar2;

    @FindBy(how = How.XPATH, using = "//div[@class='bgfade col-md-2 form-group go-right col-xs-12 search-button']//button[@class='btn-primary btn btn-lg btn-block pfb0 loader'][contains(text(),'Search')]")
    WebElement searchButton;

    public void selectPickUpLocation(String searchTerm) throws InterruptedException {
        pickUpLocationField.click();
        pickUpLocationInputField.sendKeys(searchTerm);
        Wait.untilJqueryIsDone(driver);
        pickUpLocationInputField.sendKeys(Keys.RETURN);
    }

    private void invokeFirstCalendar() {
        calendar1.click();
    }

    private void invokeSecondCalendar() {
        calendar2.click();
    }

    public void selectCurrentDate() {
        invokeFirstCalendar();
        calendar1.clear();

        LocalDate today = LocalDate.now();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date rentalDate = java.sql.Date.valueOf(today);
        String rentalDateAsString = sdf.format(rentalDate);
        calendar1.sendKeys(rentalDateAsString);

    }

    public void selectWeekInFutureDate() {
        invokeSecondCalendar();
        calendar2.clear();

        LocalDate nextWeek = LocalDate.now().plus(1, ChronoUnit.WEEKS);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date returnDate = java.sql.Date.valueOf(nextWeek);
        String returnDateAsString = sdf.format(returnDate);
        calendar2.sendKeys(returnDateAsString);
    }

    public void search() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView()", searchButton);
        searchButton.click();
    }

    public void validateUrl() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.titleIs("PHPTRAVELS | Travel Technology Partner"));
        Assert.assertTrue(driver.getCurrentUrl().equals("https://www.phptravels.net/m-cars"));
    }
}
