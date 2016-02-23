@wip
Feature: The ability to export an event to Microsoft outlook from the widget lightbox, so that I can integrate events with my personal calendar

  Scenario: Export an event to Microsoft outlook from the widget lightbox, so that I can integrate events with my personal calendar
    Given PL+ user is logged in
    And a user is viewing the calendar widget on the 'Media & telecoms' practice area page
    When the user has clicks on an event indicator on the calendar widget
    And the user has been presented with the event pop-up
    When the user clicks 'Add to outlook' link on the pop-up for an event
    Then the event .ics file for the selected event should download to the users machine

  @manual
  Scenario: Export an event to Microsoft outlook from the widget lightbox, so that I can integrate events with my personal calendar
    Given the user actions to open the downloaded file
    Then the event should appear in the users outlook calendar
