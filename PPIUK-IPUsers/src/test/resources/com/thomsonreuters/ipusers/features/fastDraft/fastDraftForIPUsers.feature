@wip@ip
@e2e
Feature: [780906] FD5 Testing FD IP users
  [792122] FD17 Testing Form E for IP and OpenWeb users

# To be run on QED ONLY
# This test could be run only on IP mashine which has an access to FS QED d100-infra.dev.practicallaw.com
# At the moment the issue with accessebility d100 from Iryna Smolina VDI is in progress
# Court, Jonathan P. (Legal) <Jonathan.Court@thomsonreuters.com> could help to test this manually

  Scenario: 
    Given PL+ user is logged in with following details
      | routing          | FAST_DRAFT_IP_USERS |
      | mandatoryRouting | YES                 |
    When the user come back on to Home page
    And the user opens "Family" link
    And the user opens Form E page
    Then the user sees Log in as single user button with Sign On message
    When the user clicks on Log in as single user button on Form E page
    Then "signon" page is displayed
    Given PL+ user is logged in with following details after IP login
      | userName | FDTestUser2 |
    Then "/Home/About/FormE" page is displayed
    And the user sees Start here button with Start here message
    And the user sees Upload button with Upload message
    And the user starts here Form E
    Then the user is redirected to question page for "<document>"
    And the user goes View Draft
    And the user exports Form E as editable PDF with changes
    Then draft file with extension ".pdf" should download to the users machine
    And the file should be removed
    When the user clicks save new document with project name "Form Exx" and document name "Form Exx"
    And the user goes My projects
    Then the project "<projectName>" presents
    When the user opens project "<projectName>"
    Then the document "<documentName>" presents
    When the user goes My projects
    And the user deletes the project "<projectName>"
    Then the project "<projectName>" is absent
    And user relogs in

  Scenario Outline: 
    Given PL+ user is logged in with following details
      | routing          | FAST_DRAFT_IP_USERS |
      | mandatoryRouting | YES                 |
    Then My FastDraft link absents in the header
    When the user come back on to Home page
    And the user opens 'Resources' link
    And the user opens 'Standard documents and drafting notes' link
    And the user opens "<practiceArea>" link
    Then the user sees the FastDraft logo for "<document>" document
    When the user opens "<document>" link
    Then the user sees Login as single user button
    And the draft message for IP users presents
    When the user clicks Login as single user button
    Then "signon" page is displayed
    Given PL+ user is logged in with following details after IP login
      | userName | FDTestUser2 |
    Then "<ref>" page is displayed
    And the user sees Start Drafting button
    And the draft message for PA presents
    When the user clicks Start Drafting button
    Then the user is redirected to question page for "<document>"
    When the user goes View Draft
    And the user clicks Word document and saves .doc file
    Then draft file with extension ".doc" should download to the users machine
    And the file should be removed
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
      | practiceArea | document                                                | ref        | projectName | documentName |
      | Property     | Lease of whole with prescribed clauses                  | 8-201-5543 | Lease vv    | Lease pp     |
      | Property     | Contract for the sale of freehold land subject to lease | 5-107-4907 | Contract z  | Contract z   |
