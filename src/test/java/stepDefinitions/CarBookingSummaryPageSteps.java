package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.en.Then;
import enums.Context;
import org.junit.Assert;
import pages.CarBookingSummaryPage;

public class CarBookingSummaryPageSteps {

    TestContext testContext;
    CarBookingSummaryPage carBookingSummaryPage;

    public CarBookingSummaryPageSteps(TestContext testContext) {
        this.testContext = testContext;
        this.carBookingSummaryPage = testContext.getPageObjectManager().getCarBookingSummaryPage();
    }

    @Then("the car is successully added to my order")
    public void the_car_is_successully_added_to_my_order() {
        String carName = (String) testContext.getScenarioContext().getContext(Context.CAR_NAME);
        Assert.assertTrue(carBookingSummaryPage.getCarName().contains(carName));
    }
}
