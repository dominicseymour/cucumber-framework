package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.en.Then;
import pages.CarDetailsPage;

public class CarDetailsPageSteps {

    TestContext testContext;
    CarDetailsPage carDetailsPage;

    public CarDetailsPageSteps(TestContext testContext) {
        this.testContext = testContext;
        this.carDetailsPage = testContext.getPageObjectManager().getCarDetailsPage();
    }

    @Then("I book the selected car")
    public void i_book_the_selected_car() {
        carDetailsPage.clickBookNowButton();
    }
}
