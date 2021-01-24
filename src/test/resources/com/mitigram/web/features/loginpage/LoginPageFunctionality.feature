Feature: Functionality of login page

  Background: A user is in Mitigram's login page
    Given a user is in login page

  @high
  Scenario: Successful sign-in with Email ID and password
    When user enters email ID as 'existinguser@google.com' and password as 'correctpassword'
    And user clicks on the login button
    Then the user account page must be displayed

  @high
  Scenario: Failed sign-in with correct email ID but incorrect password
    When user enters email ID as 'nonexistinguser@google.com' and password as 'inncorrectpassword'
    And user clicks on the login button
    Then the user must get a notification message 'Invalid login attempt.'

  @low
  Scenario: User must be able to navigate to forgot password page
    When user clicks on 'Forgot your password' link
    Then the forgot password page must be displayed
