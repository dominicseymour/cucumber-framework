package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CarBookingSummaryPage {

    WebDriver driver;

    public CarBookingSummaryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "//strong[contains(text(),'Kia Pacanto 2014')]")
    WebElement carDetails;

    public void validateCarDetails() {

    }
}
