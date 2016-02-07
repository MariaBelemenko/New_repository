Feature: Testing FD Open Web users and Form E for IP and OpenWeb users

  Scenario:
    Given PL+ user is logged in with following details
      | routing          | FAST_DRAFT_OPEN_WEB |
      | mandatoryRouting | YES                 |
    When the user come back on to Home page
    And the user opens "Family" link
    And the user opens Form E page
    Then the user sees Sign On button with Sign On message
    When the user clicks on Sign On button on Form E page
    Then "signon" page is displayed

  @e2e
  Scenario Outline: Learn more redirects to Marketing page
    Given PL+ user is logged in with following details
      | routing          | FAST_DRAFT_OPEN_WEB |
      | mandatoryRouting | YES                 |
    Then My FastDraft link absents in the header
    When the user come back on to Home page
    And the user opens 'Resources' link
    And the user opens 'Standard documents and drafting notes' link
    And the user opens "<practiceArea>" link
    Then the user sees the FastDraft logo for "<document>" document
    When the user opens "<document>" link
    Then the user sees Learn more button
    And the draft message presents
    When the user clicks Learn more button
  Examples:
    | practiceArea   | document                                  |
    | Private Client | Master Will with drafting notes           |
    | Employment     | Employment contract for a senior employee |
