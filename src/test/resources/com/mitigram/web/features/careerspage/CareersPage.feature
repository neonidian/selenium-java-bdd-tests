Feature: Functionality of careers page

  @high
  Scenario: Navigation to careers page
    Given a user is in home page
    When user clicks on the careers link in the 'header' section
    Then the careers page is displayed

  @high
  Scenario: 'Open positions' section must be displayed
    Given a user is in careers page
    Then the open position section must be displayed

  @low
  Scenario: Privacy policy label displayed in 'Introduce myself' section
    Given a user is in careers page
    Then the privacy policy must be displayed to the user
