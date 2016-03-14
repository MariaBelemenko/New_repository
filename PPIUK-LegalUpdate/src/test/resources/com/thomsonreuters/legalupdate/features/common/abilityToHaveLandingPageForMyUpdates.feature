@wip
Feature: [719729] The ability to filter my legal updates results page by the resource type

  Scenario: I want to have a landing page for MyUpdates
    Given PL+ user is logged in
    And a user has navigated to the MyUpdates page
    Then the user should be presented with a landing page
