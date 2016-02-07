Feature: Continue my session from time out screen

  Scenario: A not selected previously Super Remember me cookie should allow me to continue my session from the time out screen message
    Given PL+ user is logged in with routing details
      | mandatoryRouting | YES                              |
      | routing          | SPECIFIED_USER_TIMEOUT_3_MINUTES |
      | userName         | srm_user                         |
    When he sees the timed out pop up screen
    And he clicks on the continue session button
    Then the pop up screen dissappears
    And the user is redirected to the page that he was visiting
