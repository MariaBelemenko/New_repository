@wip
Feature: Create an Orphan page to house the Legal Updates browse/result page

  Scenario: Type the Orphan page URL into their browser he should be presented with the correct Orphan page
    Given PL+ user is logged in with following details
      | userName | LU_AutoUser |
    Given a User types the Orphan page URL into their browser
    Then they should be presented with the correct Orphan page