package pages;

import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class ElementFinder {

    @Test
    public void test() throws InterruptedException {


        System.setProperty("webdriver.chrome.driver", "/Users/dom/Learning/Selenium/Drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://www.phptravels.net/m-thflight");

        driver.findElement(By.cssSelector("#cookyGotItBtn")).click();

        WebElement departure = driver.findElement(By.xpath("//*[@id='thflights']/div[1]"));
        departure.click();

        WebElement element = driver.findElement(By.xpath("//input[@class='select2-input select2-focused']"));
        element.sendKeys("IND");
        Thread.sleep(3000);
        element.sendKeys(Keys.RETURN);

        WebElement destination = driver.findElement(By.xpath("//*[@id='thflights']/div[2]"));
        destination.click();

        element = driver.findElement(By.xpath("//input[@class='select2-input select2-focused']"));
        element.sendKeys("DEN");
        Thread.sleep(3000);
        element.sendKeys(Keys.RETURN);

        driver.findElement(By.name("departure")).click();

        Calendar cal = Calendar.getInstance();
        int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);

        WebElement calendar = driver.findElement(By.cssSelector("[class*='datepicker dropdown-menu'][style*='display']"));


        List<WebElement> days = calendar.findElements(By.cssSelector("td"));

        for (WebElement day : days) {
            if (Integer.parseInt(day.getText()) == dayOfMonth) {
                day.click();
                System.out.println("clicked");
                break;
            }
        }

        WebElement searchButton = driver.findElement(By.xpath("//div[contains(@class,'bgfade col-md-3 col-xs-12 search-button')]//button[contains(@class,'btn-primary btn btn-lg btn-block pfb0')][contains(text(),'Search')]"));
        searchButton.click();

    }
}
