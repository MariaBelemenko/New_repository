@wip
Feature: Event pop-up should span the width of the page

  Scenario: Event pop-up should span the width of the page
    Given PL+ user is logged in with following details
      | userName | LU_AutoUser |
    And a user is viewing a the calendar widget on a practice area page
    When the user clicks on an event indicator on the widget
    Then the user should be presented with the event pop-up
    And the event pop-up should expand to the left edge of the page
