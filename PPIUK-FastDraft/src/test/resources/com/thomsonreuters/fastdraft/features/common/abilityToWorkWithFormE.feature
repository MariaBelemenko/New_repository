@wip @robot
Feature: As a PL+ "PA" user I want to upload a Form E document using a Form E template So that I can upload my changes to FastDraft

# This test uses JAVA Robot, therefore it could be run locally only
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

  Scenario Outline: Form E editable PDF
    Given PL+ user is logged in with following details
      | userName         | FDTestUser2 |
      | routing          | FAST_DRAFT  |
      | mandatoryRouting | YES         |
    When the user come back on to Home page
    And the user deletes all files with name "draft" and extension ".pdf" from Downloads
    #Upload form FD document page from FD page
    And the user opens "Family" link
    And the user opens Form E page
    And the user starts here Form E
    Then the user is redirected to question page for "Finance Form E"
    When the user goes to "Coversheet" on Fast Draft
    And the user update text field "<nameField>" with value "<name>"
    And the user goes to "General information: Personal" on Fast Draft
    And the user update dropdown field "<dayField>" with value "1"
    And the user update dropdown field "<monthField>" with value "February"
    And the user update dropdown field "<yearField>" with value "1998"
    And the user clicks save new document with project name "<projectName>" and document name "<documentName>"
    And the user goes View Draft
    And the user exports Form E as editable PDF with changes
    Then draft file with extension ".pdf" should download to the users machine
    When the user updates PFD with new name "<newName>", new date "02", new month "04" and new year "1960" in Date of birth
    And the user goes My projects
    And the user opens project "<projectName>"
    And the user uploads edited PDF to the document name "<documentName>"
    Then the user is redirected to Changes in the uploaded PDF page
    And there is a section "Full name" with original "<name>" and reviced "<newName>"
    And there is a section "Date of birth" with original "1 February 1998" and reviced "2 April 1960"
    When the user deselects "Full name" section
    And the users clicks accept changes on Changes in the uploaded PDF page
    Then the user is redirected to question page for "<documentName>"
    When the user goes to "Coversheet" on Fast Draft
    Then the user checks text field "<nameField>" has value "<name>"
    When the user goes to "General information: Personal" on Fast Draft
    Then the user checks dropdown field "<dayField>" has value "2"
    And the user checks dropdown field "<monthField>" has value "April"
    And the user checks dropdown field "<yearField>" has value "1960"
    #Upload form Form E page from Form E page
    When user relogs in
    And the user come back on to Home page
    And the user opens "Family" link
    And the user opens Form E page
    And the user Uploads Form E for Form E page
    Then the user is redirected to Changes in the uploaded PDF page
    And there is a section "Full name" with original "<name>" and reviced "<newName>"
    And there is a section "Date of birth" with original "1 February 1998" and reviced "2 April 1960"
    When the user deselects "Date of birth" section
    And the users clicks accept changes on Changes in the uploaded PDF page
    Then the user is redirected to question page for "<documentName>"
    When the user goes to "Coversheet" on Fast Draft
    Then the user checks text field "<nameField>" has value "<newName>"
    When the user goes to "General information: Personal" on Fast Draft
    Then the user checks dropdown field "<dayField>" has value "1"
    And the user checks dropdown field "<monthField>" has value "February"
    And the user checks dropdown field "<yearField>" has value "1998"
    When the user goes My projects
    #Upload edited pdf to another project and get the error
    And creates new project "Family, Financial statement: Form E" and "Finance Form E" with project name "<projectName2>" and document name "<documentName2>"
    And the user goes My projects
    And the user opens project "<projectName2>"
    And the user uploads edited PDF to the document name "<documentName2>"
    Then the user is redirected to document page with upload error
    #Upload .txt file and get the error
    When the user goes My projects
    And the user opens project "<projectName>"
    And the user uploads new file with name "new" end extension ".txt" to the document name "<documentName>"
    Then the user is redirected to document page with upload not the correct type error
    #Delete projects
    When the user goes My projects
    And the user deletes the project "<projectName>"
    Then the project "<projectName>" is absent
    When the user deletes the project "<projectName2>"
    Then the project "<projectName2>" is absent
    #Delete document
    And the file should be removed
    Given PL+ user is logged in with following details
      | userName         | FDTestUser2 |
      | routing          | FAST_DRAFT  |
      | mandatoryRouting | YES         |
    And user relogs in
  Examples:
    | projectName  | documentName | projectName2 | documentName2 | nameField | name | newName | dayField                  | monthField                  | yearField                  |
    | Proj FormE 2 | Form E 2     | Proj FormE3  | Form E 3      | ans_name  | Test | Jon     | day_ans_general-dateBirth | month_ans_general-dateBirth | year_ans_general-dateBirth |
