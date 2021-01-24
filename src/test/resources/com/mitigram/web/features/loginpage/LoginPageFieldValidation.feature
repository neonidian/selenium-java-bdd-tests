Feature: Field validation in login page

  Background: A user is in Mitigram's login page
    Given a user is in login page

  @high
  Scenario: User receives a notification message when username and password is empty
    When user enters empty email ID and password
    And user clicks on the login button
    Then the user must get a notification message 'Email is required'
    And stays on the login page

  @low
  Scenario: User receives a notification message when invalid email ID format is used
    When user enters an invalid email ID like 'someone@google,com'
    And user clicks on the login button
    Then the user must get a notification message 'The Email field is not a valid e-mail address.'

  @low
  Scenario: User receives a notification message when password is empty
    When user enters an valid email ID but invalid password
    And user clicks on the login button
    Then the user must get a notification message 'Password is required'
