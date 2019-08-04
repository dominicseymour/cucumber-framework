package managers;

import enums.DriverType;
import enums.EnvironmentType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

import static enums.DriverType.*;
import static enums.EnvironmentType.LOCAL;
import static enums.EnvironmentType.REMOTE;

public class WebDriverManager {

    private WebDriver driver;
    private static EnvironmentType environmentType;
    private static DriverType driverType;
    private final static String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";

    public WebDriverManager() {
        environmentType = FileReaderManager.getInstance().getConfigFileReader().getEnvironment();
        driverType = FileReaderManager.getInstance().getConfigFileReader().getBrowser();
    }

    public WebDriver getDriver() {
        if (driver == null)
            driver = createDriver();
        return driver;
    }

    private WebDriver createDriver() {
        if (environmentType == LOCAL)
            driver = createLocalDriver();
        else if (environmentType == REMOTE)
            driver = createRemoteDriver();

        return driver;
    }

    private WebDriver createRemoteDriver() {
        throw new RuntimeException("Remote driver not yet configured.");
    }

    private WebDriver createLocalDriver() {

        // Select browser
        if (driverType == CHROME) {
            System.setProperty(CHROME_DRIVER_PROPERTY, FileReaderManager.getInstance().getConfigFileReader().getDriverPath());
            driver = new ChromeDriver();
        } else if (driverType == FIREFOX)
            driver = new FirefoxDriver();
        else if (driverType == INTERNETEXPLORER)
            driver = new InternetExplorerDriver();

        // Set window size
        if (FileReaderManager.getInstance().getConfigFileReader().getWindowMaximise())
            driver.manage().window().maximize();

        // Clear cache
        driver.manage().deleteAllCookies();

        // Set implicit wait time
        driver.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getConfigFileReader().getImplicitlyWait(), TimeUnit.SECONDS);

        return driver;
    }

    public void closeDriver() {
        driver.close();
        driver.quit();
    }
}
