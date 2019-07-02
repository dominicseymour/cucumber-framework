package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {

    protected static WebDriver driver;

    protected static Properties properties;

    public static WebDriver initializeDriver() {

        // Load data.properties file
        loadProperties();

        // Get browser from data.properties file
        String browser = properties.getProperty("browser");

        if (browser.equals("chrome")) {

            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

        } else  if (browser.equals("firefox")) {

            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();

        } else if (browser.equals("ie")) {

            WebDriverManager.iedriver().setup();
            driver = new InternetExplorerDriver();

        } else {

            System.out.println("Browser not recognised");
        }

        // Apply global implicit wait of 10 seconds
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        return driver;
    }

    public static Properties loadProperties() {

        properties = new Properties();
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream("src/test/resources/data.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return properties;
    }

}
