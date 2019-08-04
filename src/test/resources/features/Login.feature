Feature: Application Login

  Background: User navigates to landing page
    Given I am on the landing page

  @old_test
  Scenario Outline: As a registered user with valid password I am able to login to the application
    When I navigate to the login page
    And I attempt to login to the application with username "<username>" and password "<password>"
    Then I am navigated to the My Account page
    And I should see my account information
    Examples:
      | username                    | password     |
      | test6800@test.com           | Test123      |
      | domseymour83@hotmail.co.uk  | LeoHeg@01    |

