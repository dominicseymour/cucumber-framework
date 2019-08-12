package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CarDetailsPage {

    WebDriver driver;

    public CarDetailsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = ".//button[contains(text(),'Book Now')]")
    WebElement bookNowButton;

    public void clickBookNowButton() {
        bookNowButton.click();
    }
}
