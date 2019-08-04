package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.en.Then;
import pages.FlightSearchResultsPage;

public class FlightSearchResultsPageSteps {

    TestContext testContext;
    FlightSearchResultsPage flightSearchResultsPage;

    public FlightSearchResultsPageSteps(TestContext testContext) {
        this.testContext = testContext;
        flightSearchResultsPage = testContext.getPageObjectManager().getFlightSearchResultsPage();
    }

    @Then("results are displayed in a list")
    public void results_are_displayed_in_a_list() {
        flightSearchResultsPage.validateResultsDisplayed();
    }
}
