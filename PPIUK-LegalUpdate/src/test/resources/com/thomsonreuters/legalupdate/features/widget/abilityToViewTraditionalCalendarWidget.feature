@wip
Feature: The ability to view a traditional calendar in a widget on Practice area browse page, so that I can see upcoming events

  Scenario: View a traditional calendar in a widget on Practice area browse page, so that I can see upcoming events
    Given PL+ user is logged in
    Given a user is on the website home page
    When the user navigates to the 'Media & Telecoms' practice area browse page
    Then the user should be presented with a calendar widget for the current month
    And the user should be presented with an indicator on days on which events occur
    When the user clicks on an event indicator
    Then the user should be presented with a lightbox
    And the lightbox should contain the title and snippet of that event
