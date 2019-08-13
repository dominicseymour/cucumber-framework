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

    @FindBy(how = How.CSS, using = "h6[class='m0']")
    WebElement carName;

    public String getCarName() {
        return carName.getText();
    }

}
