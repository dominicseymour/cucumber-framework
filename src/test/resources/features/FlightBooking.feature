Feature: Flight booking

  Background: User navigates to landing page
    Given I am on the landing page
    And I navigate to the login page
    And I attempt to login to the application with username "test6800@test.com" and password "Test123"
    And I navigate to the Flight Booking page

    @old_test
    Scenario: As a registered user I am able to search for a flight
      Given I am on the Flight Booking page
      When I input departure airport as "IND"
      And I input destination airport as "DEN"
      And I input todays date as the departure date
      And I search for results
      Then results are displayed in a list




