@wip
Feature: Change the calendar event pop-up into a widget extension

  Scenario: Make changes to calendar event pop-up into a widget extension
    Given PL+ user is logged in with following details
      | userName | LU_AutoUser |
    And a user is on the media & telecoms practice area page
    And a user has clicked on the event indicator
    And the calendar widget has extended to display event information
    When the user clicks on a different event indicator on the calendar
    Then the contents of the extended portion of the widget should change to reflect the events on the selected day
