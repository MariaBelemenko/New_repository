Feature: [780907] FD3 Testing FD PA Users
  [774399] FD16 Testing Link to FastDraft from PL+:  My FastDraft Dashboard
  [774396] FD7 Testing Link to FastDraft from PL+- Start Drafting

  Scenario:
    Given PL+ user is logged in with following details
      | routing          | FAST_DRAFT |
      | mandatoryRouting | YES        |
    When the user goes My FastDraft
    Then the user is redirected to Fast Draft dashboard
    When the user deletes all Fast Draft projects
    Then there are no Fast Draft projects
    And user relogs in

  Scenario:
    Given PL+ user is logged in with following details
      | routing          | FAST_DRAFT |
      | mandatoryRouting | YES        |
    When the user goes My FastDraft
    Then the user is redirected to Fast Draft dashboard
    And current Fast Draft URL is correct
    And user relogs in

  Scenario Outline:
    Given PL+ user is logged in with following details
      | routing          | FAST_DRAFT |
      | mandatoryRouting | YES        |
    When the user come back on to Home page
    And the user opens "Family" link
    And the user opens Form E page
    Then the user sees Start here button with Start here message
    And the user sees Upload button with Upload message
    And the user clicks link Form E user guide "<userGuide>"
    Then "<userGuide>" page is displayed
  Examples:
    | userGuide   |
    | /4-539-9785 |

  Scenario Outline:
    Given PL+ user is logged in with following details
      | routing          | FAST_DRAFT |
      | mandatoryRouting | YES        |
    When the user come back on to Home page
    And the user opens 'Resources' link
    And the user opens 'Standard documents and drafting notes' link
    And the user opens "<practiceArea>" link
    And the user opens "<document>" link
    Then the user sees Start Drafting button
    And the draft message for PA presents
    When the user clicks Start Drafting button
    Then the user is redirected to question page for "<document>"
    When the user clicks save new document with project name "<projectName>" and document name "<documentName>"
    And the user goes My projects
    Then the project "<projectName>" presents
    When the user opens project "<projectName>"
    Then the document "<documentName>" presents
    When the user goes My projects
    And the user deletes the project "<projectName>"
    Then the project "<projectName>" is absent
    And user relogs in
  Examples:
    | practiceArea   | document                                  | projectName     | documentName |
    | Employment     | Employment contract for a senior employee | Project Empl    | Employment   |
    | Private Client | Master Will with drafting notes           | Project Private | Private      |
