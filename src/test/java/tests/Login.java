package tests;

import base.Base;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LandingPage;
import pages.LoginPage;
import pages.MyAccountPage;

import java.io.IOException;

public class Login extends Base {

    Logger log = LogManager.getLogger(Base.class.getName());

    @Test(dataProvider="getData")
    public void basePageNavigation(String username, String password, String accountName) throws IOException {

        driver = initializeDriver();
        log.error("Driver is initialized.");

        driver.get(properties.getProperty("url"));
        log.info("Properties file loaded.");

        LandingPage landingPage = new LandingPage();
        landingPage.getSignInButton().click();

        LoginPage loginPage = new LoginPage();
        loginPage.getEmailInputField().sendKeys(username);
        loginPage.getPasswordInputField().sendKeys(password);
        loginPage.getSignInButton().click();

        MyAccountPage myAccountPage = new MyAccountPage();
        WebElement viewCustomerAccountButton = myAccountPage.getViewCutomerAccountButton();
        Assert.assertEquals(accountName, viewCustomerAccountButton.getText());

        driver.close();
        driver = null;
    }

    @DataProvider
    public Object[][] getData() {

        // Two sets of data, each containing 2 data values
        Object[][] data = new Object[2][3];

        data[0][0] = "test5455@test.com";
        data[0][1] = "password";
        data[0][2] = "Dominic Test";

        data[1][0] = "test8148@test.com";
        data[1][1] = "Password1";
        data[1][2] = "Test Test";

        return data;

    }

}
