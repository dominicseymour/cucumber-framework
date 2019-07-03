Feature: Application Login

  Background: User navigates to login page
    Given I am on the landing page

  Scenario: As a registered user with valid password I am able to login to the application
    When I navigate to the login page
    And I attempt to login to the application with username "test5455@test.com" and password "password"
    Then I am navigated to the My Account page
    And I should see my account information

#  Scenario: As a registered user with incorrect password I am not able to login to the application
#    When I navigate to the login page
#    And I attempt to login to the application with username "test5455@test.com" and password "wrongPassword"
#    Then an error message is displayed
#    And I am not logged in
#    And I am on the login page
#
#  Scenario: Unregistered user can not login to the application
#    When I navigate to the login page
#    And I attempt to login to the application with username "test8148@test.com" and password "password"
#    Then an error message is displayed
#    And I am not logged in
#    And I am on the login page
