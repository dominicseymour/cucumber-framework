package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import pages.CarBookingPage;

public class CarBookingPageSteps {

    TestContext testContext;
    CarBookingPage carBookingPage;

    public CarBookingPageSteps(TestContext testContext) {
        this.testContext = testContext;
        this.carBookingPage = testContext.getPageObjectManager().getCarBookingPage();
    }

    @Given("I am on the Car Booking page")
    public void i_am_on_the_Car_Booking_page() {
        carBookingPage.validateUrl();
    }

    @When("I input pick up location as {string}")
    public void i_input_pick_up_location_as(String searchTerm) throws InterruptedException {
        carBookingPage.selectPickUpLocation(searchTerm);
    }

    @When("I input todays date as the pick up date")
    public void i_input_todays_date_as_the_pick_up_date() {
        carBookingPage.selectCurrentDate();
    }

    @When("I input one week as the rental period")
    public void i_input_one_week_as_the_rental_period() {
        carBookingPage.selectWeekInFutureDate();
    }

    @When("I search for cars")
    public void i_search_for_cars() {
        carBookingPage.search();
    }

}
