Feature: [752694] Bypass Client ID screen

  Scenario: [752694] As a PPI user I want the Client ID field not required when log in so I am able to log in without entering this Client ID field
    Given PL+ user is not logged in
    When the user navigates to the main PLCUK page
    And the user clicks Log in button
    When the user enters his username and password on the login page
      | userName | LoginUser5 |
    And clicks on Sign in
    Then it gets redirected to the home page
    And he is not prompted to enter its Client ID
