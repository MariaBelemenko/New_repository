@wip
Feature: As a User,
  I want the ability to select how much information I see about an event

  Scenario: Ability to select how much information I see about an event
    Given PL+ user is logged in
    Given user is on full calendar view page
    And the user is presented with the info details button
      | Less Detail |
      | More Detail |
      | Most Detail |
