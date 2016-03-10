Feature: [780794] FD19 Parallel Running Testing

# PLEASE note for CI/DEMO/QED the link to Legacy FD is
# When the user goes to View all FastDraft items = http://d" + System.getProperty("base.legacy.url") + "-infra.dev.practicallaw.com:8080/da/
  Scenario:
    Given PL+ user is logged in with following details
      | routing          | FAST_DRAFT  |
      | mandatoryRouting | YES         |
    When the user goes My FastDraft
    Then the user is redirected to Fast Draft dashboard
    When the user deletes all Fast Draft projects
    Then there are no Fast Draft projects
    And user relogs in

  Scenario:
    Given PLC user is logged in with following details
      | userName | FDTestUser2 |
    When the user goes to View all FastDraft items
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
    And current Fast Draft URL is correct
    #Create contact
    When the user goes Address book
    And creates new person contact with details title "Mr", first name "<name>", second name "Tester" and email "test123@gmail.com"
    Then the contact "<testTestator>" presents in Address book
    When the user closes Address book
    Then the user is redirected to Fast Draft dashboard
    #Update contact from Address book
    When creates new project "<projectType>" and "<documentType>" with project name "<projectName>" and document name "<documentName>"
    And the user goes to "<page>" on Fast Draft
    And the user updates contact "<testator>" with "<testTestator>"
    #Check contact from Address book presents
    Then the contact "<testator>" has "<testTestator>" value
    And there is remove "<testTestator>" button in "<testator>"
    When the user goes View Draft
    Then the user checks draft text contains value "<fullName>" in field "<field>"
    And user relogs in
    Given PLC user is logged in with following details
      | userName | FDTestUser2 |
    When the user goes to View all FastDraft items
    Then the user is redirected to Fast Draft dashboard
    And current Fast Draft URL is correct
    #Check project present
    And the project "<projectName>" presents
    #Check project has contact from Address book
    When the user opens project "<projectName>" and document "<documentName>"
    Then the user checks draft text contains value "<fullName>" in field "<field>"
    #Delete project
    When the user goes My projects
    And the user deletes the project "<projectName>"
    Then the project "<projectName>" is absent
    #Remove contact from Address book
    When the user goes Address book
    And the user removes contact "<testTestator>" from Address book
    Then the contact "<testTestator>" absents in Address book
    And user relogs in
    Given PL+ user is logged in with following details
      | userName         | FDTestUser2 |
      | routing          | FAST_DRAFT  |
      | mandatoryRouting | YES         |
    When the user goes My FastDraft
    #Check project is absent
    Then the project "<projectName>" is absent
    #Check contact from Address book is absent
    When the user goes Address book
    Then the contact "<testTestator>" absents in Address book
    And user relogs in
  Examples:
    | projectType                       | documentType                                    | projectName | documentName | page              | testator | testTestator | field          | fullName   | name |
    | Private client standard documents | Will with optional commentary and briefing note | Will 5      | Will 5       | Testator: details | testator | Jon Tester   | private.client | Jon Tester | Jon  |

  Scenario Outline:
    Given PLC user is logged in with following details
      | userName | FDTestUser2 |
    When the user goes to View all FastDraft items
    Then the user is redirected to Fast Draft dashboard
    And current Fast Draft URL is correct
    When creates new project "<projectType>" and "<documentType>" with project name "<projectName>" and document name "<documentName>"
    And the user goes to "<page>" on Fast Draft
    And the user update text field "<field>" with value "<value>"
    And the user goes My projects
    And the user opens project "<projectName>" and document "<documentName>"
    And the user goes to "<page>" on Fast Draft
    Then the user checks text field "<field>" has value "<value>"
    And user relogs in
    Given PL+ user is logged in with following details
      | userName         | FDTestUser2 |
      | routing          | FAST_DRAFT  |
      | mandatoryRouting | YES         |
    When the user goes My FastDraft
    Then the user is redirected to Fast Draft dashboard
    And current Fast Draft URL is correct
    #Check project present
    And the project "<projectName>" presents
    #Check project has updated text field
    When the user opens project "<projectName>" and document "<documentName>"
    When the user goes to "<page>" on Fast Draft
    Then the user checks text field "<field>" has value "<value>"
    #Delete project
    When the user goes My projects
    And the user deletes the project "<projectName>"
    Then the project "<projectName>" is absent
    And user relogs in
    Given PLC user is logged in with following details
      | userName | FDTestUser2 |
    When the user goes to View all FastDraft items
    #Check project is absent
    Then the project "<projectName>" is absent
    And user relogs in
  Examples:
    | projectType                         | documentType   | projectName      | documentName | page       | field    | value     |
    | Family, Financial statement: Form E | Finance Form E | Project Form E 5 | Form E 5     | Coversheet | ans_name | Test user |
