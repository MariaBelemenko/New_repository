Feature: Have a log in page (Academic Login excluded)

  Scenario: As a PPI User I want to be able to have a dedicated page to login
    Given PL+ user is not logged in
    When the user navigates to the main PLCUK page
    And the user clicks on Sign On link on the header
    Then the user will be redirected to a login page
    And in this login page he will be able to see username and password boxes
    And he will be able to see a link to Forget my username and password
    And he will be able to select a save username option
    And he will be able to select a save username and password option
    And he will be able to select a Remember me on this computer option to enable the Super Remember me cookie
    And he will be able to click a link to see some help/information about the use of the Super Remember me cookie
    And he will be able to see a link to Create a new OnePass Profile
    And he will be able to see a link to Update an existing OnePass Profile
    And he will be able to see a link to Learn more about OnePass
