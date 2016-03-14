@wip
Feature: [730501] The ability to see an Events without Dates widget on the right have side of the full calendar view,
  So that I can see major events happening in the future

  Scenario: See events without Dates widget on the right hand side of the full calendar view to see major events happening in the future
    Given PL+ user is logged in
    Given user is on full calendar view page
    Then user should be presented with a Events without Dates widget
    And Events without Dates widget should contain sections mentioned in description
      | Early  |
      | Mid    |
      | Late   |
      | During |
