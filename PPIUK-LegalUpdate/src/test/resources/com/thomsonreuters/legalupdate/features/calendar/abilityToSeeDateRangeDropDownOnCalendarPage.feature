@wip
Feature: [741009] the ability to select the time frame to display on my Key Dates list

  Scenario: The ability to select the time frame to display on my Key Dates list
    Given PL+ user is logged in
    Given user is on full calendar view page
    And the user is presented with the date range drop down list
      | 1 Month  |
      | 3 Months |
      | 6 Months |
    And the user is presented with date range arrows
