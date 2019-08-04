package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.FlightBookingPage;

public class FlightBookingPageSteps {

    TestContext testContext;
    FlightBookingPage flightBookingPage;

    public FlightBookingPageSteps(TestContext testContext) {
        this.testContext = testContext;
        flightBookingPage = testContext.getPageObjectManager().getFlightBookingPage();
    }

    @Given("I am on the Flight Booking page")
    public void i_am_on_the_Flight_Booking_page() {
        flightBookingPage.validateUrl();
    }

    @When("I input departure airport as {string}")
    public void i_input_departure_airport_as(String searchTerm) throws InterruptedException {
        flightBookingPage.selectDepartureAirport(searchTerm);
    }

    @When("I input destination airport as {string}")
    public void i_input_destination_airport_as(String searchTerm) throws InterruptedException {
        flightBookingPage.setDestinationAirportSelector(searchTerm);
    }

    @When("I input todays date as the departure date")
    public void i_input_todays_date_as_the_departure_date() {
        flightBookingPage.selectCurrentDate();
    }

    @When("I search for results")
    public void i_search_for_results() {
        flightBookingPage.search();
    }
}
