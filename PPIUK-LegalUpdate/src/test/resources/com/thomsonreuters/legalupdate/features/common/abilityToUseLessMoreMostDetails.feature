@wip
Feature: PA LU Results: Less/More/Most

  Scenario: The user should be able to view a list of LU results for the relevant�PA that they have come from and they should be able to use the Less/More/Most functionality
    Given PL+ user is logged in with following details
      | userName | LU_AutoUser |
    And that a user is viewing a specific legal updates page "/Browse/Home/Resources/Alllegalupdates"
    Then the user should be presented with a Less/More/Most dropdown
    And the User can click on Less option to see less detail in result list
    And the User can click on More option to see more detail in result list
    And the User can click on Most option to see most detail in result list