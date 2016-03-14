@wip
Feature: [727290]The ability to navigate to another  months by selecting a future month from the drop down on the mini calendar

  Scenario: Navigate to another month by selecting a future month from the drop down on the mini calendar
    Given PL+ user is logged in
    And a user is viewing the month selector on the mini calendar
    When the user clicks on the option
    Then the user should be presented with a mini calendar for the selcted month
    And the selected month should be maintained as the selected month in the drop down list
