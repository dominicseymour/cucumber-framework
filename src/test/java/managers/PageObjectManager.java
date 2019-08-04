package managers;

import org.openqa.selenium.WebDriver;
import pages.*;

public class PageObjectManager {

    private WebDriver driver;

    private LandingPage landingPage;

    private LoginPage loginPage;

    private MyAccountPage myAccountPage;

    private FlightBookingPage flightBookingPage;

    private FlightSearchResultsPage flightSearchResultsPage;

    private RegisterPage registerPage;

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

    public FlightBookingPage getFlightBookingPage() {
        if (flightBookingPage == null)
            return flightBookingPage = new FlightBookingPage(driver);
        return flightBookingPage;
    }

    public FlightSearchResultsPage getFlightSearchResultsPage() {
        if (flightSearchResultsPage == null)
            return flightSearchResultsPage = new FlightSearchResultsPage(driver);
        return flightSearchResultsPage;
    }

    public RegisterPage getRegisterPage() {
        if (registerPage == null)
            return registerPage = new RegisterPage(driver);
        return registerPage;
    }
}
