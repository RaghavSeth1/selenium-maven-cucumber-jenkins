#Author: raghav seth
@RS
Feature: Validate OrangeHRM Smoke Test Scenarios

  
  Scenario: Validate OrangeHRM title is correct
    When Start application
    Then Correct title should be displayed

  @RS
  Scenario: Validate user able to login successfully
    Given Login Page Navigated
    And I enter following for Login and click login button
      | username | password      |
      | Admin    | Admin123      |
    Then I should see the Dashboard Page
