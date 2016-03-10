Feature: [789826] (Testing Task Only) - Create contact and attach contact to a FastDraft document

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

  Scenario Outline: Create contact in Address book
    Given PL+ user is logged in with following details
      | userName         | FDTestUser2 |
      | routing          | FAST_DRAFT  |
      | mandatoryRouting | YES         |
    When the user goes My FastDraft
    Then the user is redirected to Fast Draft dashboard
    When the user goes Address book
    And creates new person contact with details title "Mr", first name "<name>", second name "Tester" and email "tom123@gmail.com"
    Then the contact "<testContact>" presents in Address book
    When the user closes Address book
    Then the user is redirected to Fast Draft dashboard
    #Update field with contact from Address book
    When creates new project "<projectType>" and "<documentType>" with project name "<projectName>" and document name "<documentName>"
    And the user goes to "<page>" on Fast Draft
    And the user updates contact "<contact>" with "<testContact>"
    Then the contact "<contact>" has "<testContact>" value
    And there is remove "<testContact>" button in "<contact>"
    When the user goes View Draft
    Then the user checks draft text contains value "<fullName>" in field "<field>"
    When the user goes My projects
    And the user deletes the project "<projectName>"
    Then the project "<projectName>" is absent
    #Remove contact from Address book
    When the user goes Address book
    And the user removes contact "<testContact>" from Address book
    Then the contact "<testContact>" absents in Address book
    And user relogs in
  Examples:
    | projectType                   | documentType          | projectName   | documentName  | page                 | contact    | testContact | field               | fullName      | name |
    | Employment standard documents | Consultancy agreement | Consultancy 1 | Consultancy 1 | Consultant's details | consultant | Tom Tester  | employment.contract | Mr Tom Tester | Tom  |
