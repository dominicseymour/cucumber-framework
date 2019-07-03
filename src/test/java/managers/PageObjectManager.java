package managers;

import org.openqa.selenium.WebDriver;
import pages.LandingPage;
import pages.LoginPage;
import pages.MyAccountPage;

public class PageObjectManager {

    private WebDriver driver;

    private LandingPage landingPage;

    private LoginPage loginPage;

    private MyAccountPage myAccountPage;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public LandingPage getLandingPage() {

        if (landingPage == null)
            return landingPage = new LandingPage(driver);
        return landingPage;
    }

    public LoginPage getLoginPage() {

        if (loginPage == null)
            return loginPage = new LoginPage(driver);
        return loginPage;
    }

    public MyAccountPage getMyAccountPage() {

        if (myAccountPage == null)
            return myAccountPage = new MyAccountPage(driver);
        return myAccountPage;
    }
}
