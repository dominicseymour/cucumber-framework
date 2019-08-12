Feature: Car booking

  Background: User navigates to Car Booking page
    Given I am on the landing page
    And I navigate to the login page
    And I sign in to the application
    And I navigate to the Car Booking page

  @new_test
  Scenario: As a registered user I am able to book a car and the car is successfully added to my order
    Given I am on the Car Booking page
    When I input pick up location as "MAN"
    And I input todays date as the pick up date
    And I input one week as the rental period
    And I search for cars
    Then available cars are displayed in a list
    And I select the first car in the list
    And I book the selected car
    Then the car is successully added to my order
