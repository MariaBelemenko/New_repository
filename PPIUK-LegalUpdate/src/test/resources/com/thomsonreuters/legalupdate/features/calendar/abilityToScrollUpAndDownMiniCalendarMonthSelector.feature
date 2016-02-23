@wip
Feature: The ability to scroll up and down the mini calendar month selector

  Scenario: Ability to scroll up and down the mini calendar month selector
    Given PL+ user is logged in
    Given a user is viewing the month selector on the mini calendar
    And the user is presented with an Up arrow on the month selector
    And the user is presented with an Down arrow on the month selector
    When the User clicks on the Up arrow
    Then the month selector should scroll to months in the past
    When the User clicks on the Down arrow
    Then the month selector should scroll to months in the future
