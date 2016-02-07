@wip
Feature: Create an Orphan page to house the Legal Updates widget

  Scenario: User is on a Orphan Practice Area browse page he should be presented with a legal Updates widget
    Given PL+ user is logged in with following details
      | userName | LU_AutoUser |
    When a User is on a Orphan Practice Area browse page
    Then they should be presented with a legal Updates widget on a Orphan Practice Area browse page
    When User is on a Orphan Topic browse page
    Then they should be presented with a legal Updates widget on a Orphan Topic browse page
