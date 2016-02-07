Feature: Bypass Client ID screen

  Scenario: As a PPI user I want the Client ID field not required when log in so I am able to log in without entering this Client ID field
    Given PL+ user is not logged in
    When the user navigates to the main PLCUK page
    And the user clicks Log in button
    When a PPI user enter its username and password
      | userName | Login_AutoUser |
    And clicks on Sign in
    Then it gets redirected to the home page
    And he is not prompted to enter its Client ID
