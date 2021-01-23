Feature: Navigation to login page

  Background: A new user is in Mitigram's home page
    Given a user is in home page

  @major
  Scenario: Navigate to login page using login link in header section
    When user clicks on the login link in the 'header' section
    Then the login page is displayed

  @minor
  Scenario: Navigate to login page using login link in footer section
    When user clicks on the login link in the 'footer' section
    Then the login page is displayed
