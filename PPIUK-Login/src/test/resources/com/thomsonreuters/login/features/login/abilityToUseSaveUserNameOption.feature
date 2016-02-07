Feature: Save username option on login

  Background:
    Given PL+ user is not logged in
    When the user navigates to the main PLCUK page
    And the user clicks on Sign On link on the header

  Scenario: As a PPI User I want to be able to login by using the saved username
    When a PPI user enter its username and password
      | userName | srm_user2 |
    And user selects Save my Username checkbox
    And clicks on Sign in
    Then user logs out
    And user tries to log in again
    Then he will see the username box in the log in page populated with his username

  Scenario: As a PPI User I want to be able to login using the previously saved login credentials
    When a PPI user enter its username and password
      | userName | srm_user2 |
    And user selects Save my Username and Password checkbox
    And clicks on Sign in
    Then user logs out
    And user tries to log in again
    Then he will see the username box in the log in page populated with his username
    And his password will be populated in the password box
    And his password will not be readable in the screen and only asterisks will be visible
