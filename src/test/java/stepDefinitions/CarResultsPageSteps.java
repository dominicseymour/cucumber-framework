package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.en.Then;
import enums.Context;
import pages.CarResultsPage;

public class CarResultsPageSteps {

    TestContext testContext;
    CarResultsPage carResultsPage;

    public CarResultsPageSteps(TestContext testContext) {
        this.testContext = testContext;
        this.carResultsPage = testContext.getPageObjectManager().getCarResultsPage();
    }

    @Then("available cars are displayed in a list")
    public void available_cars_are_displayed_in_a_list() {
        carResultsPage.validateResultsDisplayed();
    }

    @Then("I select the first car in the list")
    public void i_select_the_first_car_in_the_list() {
        String carName = carResultsPage.getCarName(0);
        testContext.getScenarioContext().setContext(Context.CAR_NAME, carName);

        carResultsPage.clickCarDetailsButton();
    }
}
