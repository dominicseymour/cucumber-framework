Feature: Account registration

  Background: User navigates to landing page
    Given I am on the landing page

  @old_test
  Scenario Outline: As a new user I am able to create an account
    Given I navigate to the sign up page
    And I enter first name as "<firstName>"
    And I enter last name as "<lastName>"
    And I enter mobile number as "<phone>"
    And I enter Email as "<email>"
    And I enter password as "<password>"
    And I enter confirmation password as "<confirmationPassword>"
    When I click the sign up button
    Then I am navigated to the My Account page
    And I should see my account information
  Examples:
    | firstName | lastName | phone      | email             | password | confirmationPassword |
    | Dom      | Test     | 0787887887 | test2155@test.com | password | password             |

    @old_test
    Scenario Outline: As a new user I am able to register an account
      Given I navigate to the sign up page
      And I enter registration details for "<user>"
      When I click the sign up button
      Then I am navigated to the My Account page
      And I should see my account information
    Examples:
      | user  |
      | Sally |