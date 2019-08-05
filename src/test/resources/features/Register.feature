Feature: Account registration

  Background: User navigates to landing page
    Given I am on the landing page

  @old_test
  Scenario: As a new user I am able to create an account
    Given I navigate to the sign up page
    And I enter first name as "Test"
    And I enter last name as "Test"
    And I enter mobile number as "07878887887"
    And I enter Email as "test2503@test.com"
    And I enter password as "password"
    And I enter confirmation password as "password"
    When I click the sign up button
    Then I am navigated to the My Account page
    And I should see my account information


