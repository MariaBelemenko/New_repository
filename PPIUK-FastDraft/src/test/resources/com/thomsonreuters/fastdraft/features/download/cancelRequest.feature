@wip @robot
Feature: Redirecting to FastDraft popup

# This test uses JAVA Robot, therefore it could be run locally only
  Scenario:
    Given PL+ user is logged in with following details
      | userName         | FDTestUser2          |
      | routing          | FAST_DRAFT_INCORRECT |
      | mandatoryRouting | YES                  |
    When the user goes My FastDraft
    Then the user sees Redirecting to FastDraft popup
    And the user sees Cancel Request button
    When the user clicks Cancel Request button
    Then there is no Redirecting to FastDraft popup

  Scenario: 
    Given PL+ user is logged in with following details
      | userName         | FDTestUser2          |
      | routing          | FAST_DRAFT_INCORRECT |
      | mandatoryRouting | YES                  |
    When the user come back on to Home page
    And the user opens "Family" link
    And the user opens Form E page
    And the user starts here Form E
    Then the user sees Redirecting to FastDraft popup
    And the user sees Cancel Request button
    When the user clicks Cancel Request button
    Then there is no Redirecting to FastDraft popup

  Scenario: 
    Given PL+ user is logged in with following details
      | userName         | FDTestUser2          |
      | routing          | FAST_DRAFT_INCORRECT |
      | mandatoryRouting | YES                  |
    When the user come back on to Home page
    And the user opens 'Resources' link
    And the user opens 'Standard documents and drafting notes' link
    And the user opens "Private Client" link
    And the user opens "Master Will with drafting notes" link
    And the user clicks Start Drafting button
    Then the user sees Redirecting to FastDraft popup
    And the user sees Cancel Request button
    When the user closes Redirecting to FastDraft
    Then there is no Redirecting to FastDraft popup

  Scenario: 
    Given PL+ user is logged in with following details
      | userName         | FDTestUser2          |
      | routing          | FAST_DRAFT_INCORRECT |
      | mandatoryRouting | YES                  |
    When the user come back on to Home page
    And the user opens "Family" link
    And the user opens Form E page
    And the user clicks Upload Form E
    Then the user sees Redirecting to FastDraft popup
    And the user sees Cancel Request button
    When the user closes Redirecting to FastDraft
    Then there is no Redirecting to FastDraft popup
