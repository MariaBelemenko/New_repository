Feature: [752689] Save username option on login

  Scenario: [752689] As a PPI User I want to be able to login by using the saved username
    Given PL+ user is not logged in
    When the user navigates to the main PLCUK page
    And the user clicks on Sign On link on the header
    When a PPI user enter its username and password
      | userName | LoginUser3 |
    And user selects Save my Username checkbox
    And clicks on Sign in
    Then user logs out
    And user tries to log in again
    Then he will see the username box in the log in page populated with his username

  Scenario: [752689] As a PPI User I want to be able to login using the previously saved login credentials
    Given PL+ user is not logged in
    When the user navigates to the main PLCUK page
    And the user clicks on Sign On link on the header
    When a PPI user enter its username and password
      | userName | LoginUser3 |
    And user selects Save my Username and Password checkbox
    And clicks on Sign in
    Then user logs out
    And user tries to log in again
    Then he will see the username box in the log in page populated with his username
    And his password will be populated in the password box
    And his password will not be readable in the screen and only asterisks will be visible
