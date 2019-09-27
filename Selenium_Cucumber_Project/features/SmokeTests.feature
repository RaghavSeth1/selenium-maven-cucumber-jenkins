#Author: raghav seth
@RS
Feature: Validate OrangeHRM Smoke Test Scenarios

  @RS
  Scenario: Validate OrangeHRM title
  When Start application
  Then Correct title should be displayed

  @RS
  Scenario: Validate user able to login successfully
    Given Login Page Navigated
    And I enter "Admin" and "admin122" on Login page and click login button
    Then I should see the Dashboard Page
    Then Logout of the Application
   
