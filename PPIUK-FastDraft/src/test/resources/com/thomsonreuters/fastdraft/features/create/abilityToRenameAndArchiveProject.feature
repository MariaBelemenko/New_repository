Feature: View, Rename and Archive FastDraft Project and FastDraft document

  Scenario:
    Given PL+ user is logged in with following details
      | userName         | FDTestUser2 |
      | routing          | FAST_DRAFT  |
      | mandatoryRouting | YES         |
    When the user goes My FastDraft
    Then the user is redirected to Fast Draft dashboard
    When the user deletes all Fast Draft projects
    Then there are no Fast Draft projects
    And user relogs in

  Scenario Outline:
    Given PL+ user is logged in with following details
      | userName         | FDTestUser2 |
      | routing          | FAST_DRAFT  |
      | mandatoryRouting | YES         |
    When the user goes My FastDraft
    Then the user is redirected to Fast Draft dashboard
    When creates new project "<projectType>" and "<documentType>" with project name "<projectName>" and document name "<documentName>"
    And the user goes My projects
    And creates new document with "<documentType2>" with document name "<documentName2>" in project with name "<projectName>"
    #Rename
    When the user goes My projects
    And the user renames the project "<projectName>" with "<projectNewName>"
    Then the project "<projectNewName>" presents
    When the user renames the project "<projectNewName>" with "<projectName>" and clicks cancel
    Then the project "<projectNewName>" presents
    And the project "<projectName>" is absent
    When the user opens project "<projectNewName>"
    And the user renames the document "<documentName>" with "<documentNewName>"
    Then the document "<documentNewName>" presents
    When the user renames the document "<documentNewName>" with "<documentName>" and clicks cancel
    Then the document "<documentNewName>" presents
    And the document "<documentName>" is absent
    #Archive
    When the user goes My projects
    And the user archives the project "<projectNewName>" and clicks cancel
    Then the project "<projectNewName>" presents
    And the user archives the project "<projectNewName>"
    Then the project "<projectNewName>" is absent
    When the user goes Archive
    Then the project "<projectNewName>" presents
    #Unarchive
    When the user unarchives the project "<projectNewName>" and clicks cancel
    Then the project "<projectNewName>" presents
    When the user unarchives the project "<projectNewName>"
    Then the project "<projectNewName>" is absent
    #Delete project
    When the user switches to current projects
    And the user deletes the project "<projectNewName>"
    Then the project "<projectNewName>" is absent
    Given PL+ user is logged in with following details
      | userName         | FDTestUser2 |
      | routing          | FAST_DRAFT  |
      | mandatoryRouting | YES         |
    And user relogs in
  Examples:
    | projectType                         | documentType    | documentType2           | projectName | projectNewName | documentName | documentNewName | documentName2 |
    | Finance contracts                   | Deed of release | Guarantee and indemnity | Finance 1   | Finance 22     | Deed 1       | Deed 2          | Guarantee 1   |
    | Family, Financial statement: Form E | Finance Form E  | Finance Form E          | Form E 1    | Form E 0       | Form E 1     | Form E 2        | Form E x      |
