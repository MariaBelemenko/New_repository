@wip
Feature: [693638] Create an Orphan page to house the Legal Updates widget

  Scenario: User is on a Orphan Practice Area browse page he should be presented with a legal Updates widget
    Given PL+ user is logged in
    When a User is on a Orphan Practice Area browse page
    Then they should be presented with a legal Updates widget on a Orphan Practice Area browse page
    When User is on a Orphan Topic browse page
    Then they should be presented with a legal Updates widget on a Orphan Topic browse page
