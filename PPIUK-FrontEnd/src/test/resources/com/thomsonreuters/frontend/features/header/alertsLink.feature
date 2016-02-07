@wip
Feature: I want the Alerts link and dropdown icon to appear in the Global Utility Links
  So that when clicked the user has 2 navigation options appear.

  Scenario: I want the alert links to display and function accordingly.
    Given PL+ user is logged in
    Then user should see alert link
    And  user mouse over the Alert link
    And user should see the alert popup
    And user clicks on Alert Center sublink
    And user should see alert page
