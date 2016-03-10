Feature: [795432] Testing feature toggle

  Scenario: Ensure FastDraft URL is correct and redirection works
    Given PL+ user is logged in with following details
      | userName         | FFHTestUser1_Firm2 |
      | routing          | FAST_DRAFT         |
      | mandatoryRouting | YES                |
    When the user goes My FastDraft
    Then the user is redirected to Fast Draft dashboard
    And current Fast Draft URL is correct

  Scenario Outline: Start Drafting
    Given PL+ user is logged in with following details
      | userName         | FFHTestUser1_Firm2 |
      | routing          | FAST_DRAFT         |
      | mandatoryRouting | YES                |
    When the user come back on to Home page
    And the user opens 'Resources' link
    And the user opens 'Standard documents and drafting notes' link
    And the user opens "<practiceArea>" link
    And the user opens "<document>" link
    And the user clicks Start Drafting button
    Then the user is redirected to question page for "<document>"
  Examples:
    | practiceArea | document                                     | ref        |
    | Employment   | Settlement agreement: employment (long form) | 3-200-3665 |

  Scenario: Form E
    Given PL+ user is logged in with following details
      | userName         | FFHTestUser1_Firm2 |
      | routing          | FAST_DRAFT         |
      | mandatoryRouting | YES                |
    When the user come back on to Home page
    And the user opens "Family" link
    And the user opens Form E page
    And the user starts here Form E
    Then the user is redirected to question page for "Finance Form E"
