Feature: Flight booking

  Background: User navigates to Flight Booking page
    Given I am on the landing page
    And I navigate to the login page
    And I sign in to the application
    And I navigate to the Flight Booking page

    @old_test
    Scenario: As a registered user I am able to search for a flight
      Given I am on the Flight Booking page
      When I input departure airport as "IND"
      And I input destination airport as "DEN"
      And I input todays date as the departure date
      And I search for results
      Then results are displayed in a list
