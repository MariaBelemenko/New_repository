@wip
Feature: [712240]Create LegalUpdate alert

  Background:
    Given PL+ user is logged in with following details
      | clientId | B |
    When user go to alerts center page
    When user selects the alert type of 'LegalUpdate' to create

  Scenario:
    Given that a user is on the Legal Update creation page 'basics' bellow,
    Then the user should be presented with the ability to enter 'TestLegalUpdate' name for their alert,
    And the user should be presented with their client ID,
    And the user should have the ability to enter 'Alert Description' Description for their alert

  Scenario:
    Given that a user is on the Legal Update creation page 'content' bellow,
    Then the user should be given the ability to select 'United Kingdom' PLC Practice areas
    And the user should be given the ability to select 'All United Kingdom Cases' PLC Topics
    When the user selects content:
      | Administrative Court Digest |
      | British Company Cases       |
      | Business Law Reports        |
    Then the user should see their selected content alongside the content table

  Scenario:
    Given that a user is on the Legal Update creation page 'schedule alert' bellow,
    Then the user should user should be given the ability to select 'Weekly' frequency of delivery
    And the user should be able to opt to receive an alert even if there is no new content
    And the user should have the ability to save their alert