@manual
Feature: [740880]The ability to scroll my event pop-up to see events that may not fit on the pop-up

  Scenario: The ability to scroll my event pop-up to see events that may not fit on the pop-up
    Given PL+ user is logged in
    And a user is viewing event pop-up the calendar widget,
    And there are more events on the selected day than can be displayed,
    Then the user should be presented with a scroll bar on the event pop-up,
    When the user moves the scroll bar downward,
    Then the events list should scroll to show the events that are not being displayed.
