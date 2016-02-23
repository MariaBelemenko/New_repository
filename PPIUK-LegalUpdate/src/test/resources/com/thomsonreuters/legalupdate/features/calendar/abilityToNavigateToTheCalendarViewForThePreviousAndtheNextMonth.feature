@wip
Feature: The ability to navigate to the calendar view for the previous month and for the next month

  Background: 
    Given PL+ user is logged in
    And a User is viewing the full calender view for a the current month
    Then the user should be presented with a mini calendar for the current month
    And the mini calendar should have display left and right navigation arrows

  Scenario: Ability to navigate to the calendar view for the previous month
    When the user click the left facing arrow
    Then the user should be presented with the mini calendar for the previous month

  Scenario: Ability to navigate to the calendar view for the next month
    When the user click the right facing arrow
    Then the user should be presented with the mini calendar for the next month
