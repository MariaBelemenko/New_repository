@manual @e2e
Feature: [780806] FS3 Testing PL+ "PA" users can download a document in FirmStyle
  [770524] FD10 Download Fast Draft Project (Document)
  [803549] Testing Firm Style direct link

# This test uses JAVA Robot, therefore it could be run locally only
  Scenario Outline: Check FS and House Style
    Given PL+ user is logged in with following details
      | userName         | FSTestUser2 |
      | routing          | FIRM_STYLE  |
      | mandatoryRouting | YES         |
    When the user come back on to Home page
    And the user deletes all files with name ".fs" and extension ".doc" from Downloads
    And the user opens 'Resources' link
    And the user opens 'Standard documents and drafting notes' link
    And the user opens "<practiceArea>" link
    And the user opens "<document>" link
    And the user clicks Firm Style link and download a document
    Then the file "<documentName>" should be downloaded to the users machine
    Given PL+ user is logged in with following details
      | userName         | FDTestUser2 |
      | routing          | FIRM_STYLE  |
      | mandatoryRouting | YES         |
    When the user come back on to Home page
    And the user opens 'Resources' link
    And the user opens 'Standard documents and drafting notes' link
    And the user opens "<practiceArea>" link
    And the user opens "<document>" link
    And the user clicks Firm Style link and download a document
    Then the file "<documentName>" should be downloaded to the users machine
  #Only the steps below are not automated
  #Then the fist document has FS logo
  #And the second document has no FS logo
  Examples:
    | practiceArea | document                                  | documentName      | documentNameURL    |
    | Employment   | Employment contract for a senior employee | 5-200-2047.fs.doc | /5-200-2047.fs.doc |

  Scenario Outline: Check FS and House Style for fastdrafted documents
    Given PL+ user is logged in with following details
      | userName         | FDTestUser2 |
      | routing          | FAST_DRAFT  |
      | mandatoryRouting | YES         |
    When the user come back on to Home page
    And the user opens 'Resources' link
    And the user opens 'Standard documents and drafting notes' link
    And the user opens "<practiceArea>" link
    And the user opens "<document>" link
    And the user clicks Start Drafting button
    Then the user is redirected to question page for "<document>"
    When the user goes View Draft
    And the user clicks Word document and saves .doc file
    Then draft file with extension "<extension>" should download to the users machine
    Given PL+ user is logged in with following details
      | userName         | FSTestUser2           |
      | routing          | FAST_DRAFT_FIRM_STYLE |
      | mandatoryRouting | YES                   |
    When the user come back on to Home page
    And the user opens 'Resources' link
    And the user opens 'Standard documents and drafting notes' link
    And the user opens "<practiceArea>" link
    And the user opens "<document>" link
    And the user clicks Start Drafting button
    Then the user is redirected to question page for "<document>"
    When the user goes View Draft
    And the user clicks Word document and saves .doc file
    Then draft file with extension "<extension>" should download to the users machine
    #Only the steps below are not automated
    #Then the fist document has no FS logo
    #Then the second document has FS logo
  Examples:
    | practiceArea | document                                     | ref        | extension |
    | Employment   | Settlement agreement: employment (long form) | 3-200-3665 | .doc      |
