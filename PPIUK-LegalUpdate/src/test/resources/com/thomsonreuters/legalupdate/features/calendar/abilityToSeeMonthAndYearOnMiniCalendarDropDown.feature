@wip
Feature: [737225] The ability to see the month and the year on the mini-calendar drop down

  Scenario: I want to see the month and the year on the mini-calendar drop down
    Given PL+ user is logged in
    Given a user is vewing the drop down list on the mini-calendar
    Then the user should be presented with a list of months followed by the associated year
