Feature: [782598] FD11a FD12b Create and Save a FastDraft Project (Document)
  [770562] FD11d Delete FastDraft Project (Document)

  Scenario: Delete all the fast draft projects
    Given PL+ user is logged in with following details
      | routing          | FAST_DRAFT |
      | mandatoryRouting | YES        |
    When the user goes My FastDraft
    Then the user is redirected to Fast Draft dashboard
    When the user deletes all Fast Draft projects
    Then there are no Fast Draft projects
    And user relogs in

  Scenario Outline: Form E
    Given PL+ user is logged in with following details
      | routing          | FAST_DRAFT |
      | mandatoryRouting | YES        |
    When the user goes My FastDraft
    Then the user is redirected to Fast Draft dashboard
    And current Fast Draft URL is correct
    When creates new project "<projectType>" and "<documentType>" with project name "<projectName>" and document name "<documentName>"
    And the user goes to "<page>" on Fast Draft
    And the user update text field "<field>" with value "<value>"
    And the user goes My projects
    And the user opens project "<projectName>" and document "<documentName>"
    And the user goes to "<page>" on Fast Draft
    Then the user checks text field "<field>" has value "<value>"
    When the user goes My projects
    And creates new document with "<documentType>" with document name "<documentName2>" in project with name "<projectName>"
    #Delete document
    When the user goes My projects
    And the user opens project "<projectName>"
    And the user deletes the document "<documentName2>" and click cancel
    And the user goes My projects
    And the user opens project "<projectName>"
    Then the document "<documentName2>" presents
    When the user deletes the document "<documentName2>"
    And the user goes My projects
    And the user opens project "<projectName>"
    Then the document "<documentName2>" is absent
    #Delete project
    When the user goes My projects
    And the user deletes the project "<projectName>" and click cancel
    Then the project "<projectName>" presents
    And the user deletes the project "<projectName>"
    Then the project "<projectName>" is absent
    Given PL+ user is logged in with following details
      | routing          | FAST_DRAFT |
      | mandatoryRouting | YES        |
    And user relogs in
  Examples:
    | projectType                         | documentType   | projectName      | documentName | documentName2 | page       | field    | value     |
    | Family, Financial statement: Form E | Finance Form E | Project Form E 1 | Form E 1     | Form E 2      | Coversheet | ans_name | Test user |

  Scenario Outline: Word Documents
    Given PL+ user is logged in with following details
      | routing          | FAST_DRAFT |
      | mandatoryRouting | YES        |
    When the user goes My FastDraft
    Then the user is redirected to Fast Draft dashboard
    When creates new project "<projectType>" and "<documentType>" with project name "<projectName>" and document name "<documentName>"
    And the user goes to "<page>" on Fast Draft
    And the user update text field "<field>" with value "<value>"
    And the user goes My projects
    And the user opens project "<projectName>" and document "<documentName>"
    And the user goes View questions
    And the user goes to "<page>" on Fast Draft
    Then the user checks text field "<field>" has value "<value>"
    When the user goes View Draft
    Then the user checks draft text contains value "<value>" in field "<field>"
    When the user goes My projects
    And creates new document with "<documentType2>" with document name "<documentName2>" in project with name "<projectName>"
    #Delete document
    When the user goes My projects
    And the user opens project "<projectName>"
    And the user deletes the document "<documentName2>" and click cancel
    And the user goes My projects
    And the user opens project "<projectName>"
    Then the document "<documentName2>" presents
    When the user deletes the document "<documentName2>"
    And the user goes My projects
    And the user opens project "<projectName>"
    Then the document "<documentName2>" is absent
    #Delete project
    When the user goes My projects
    And the user deletes the project "<projectName>" and click cancel
    Then the project "<projectName>" presents
    And the user deletes the project "<projectName>"
    Then the project "<projectName>" is absent
    Given PL+ user is logged in with following details
      | routing          | FAST_DRAFT |
      | mandatoryRouting | YES        |
    And user relogs in
  Examples:
    | projectType                | documentType              | documentType2             | projectName | documentName | documentName2 | page                | field                      | value    |
    | Asset purchase transaction | Asset purchases agreement | Assignment of trade marks | Asset 1     | Purchases 1  | Assignment 2  | Business and assets | ans_businessLF.description | Business |
