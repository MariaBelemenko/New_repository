@robot @e2e
Feature: [780805] FS4 Testing Restrict on basis FAC
  [803549] Testing Firm Style direct link

  # This test uses JAVA Robot, therefore it could be run locally only
  # 833984 [REGRESSION] Download FS document starting from Open Web user is broken
  @bug
  Scenario Outline: Open Web Drect link House Style
    Given PL+ user is logged in with following details
      | routing          | OPEN_WEB |
      | mandatoryRouting | YES      |
    When the user deletes all files with name ".fs" and extension ".doc" from Downloads
    And the user opens <documentNameURL> url on plcuk website
    Then "signon" page is displayed
    Given PL+ user is logged in with following details after IP login
      | userName | FDTestUser2 |
    Then the file "<documentName>" should be downloaded to the users machine
    And the file "<documentName>" should be removed
    And "showDownloadPage" page is displayed
    When the user clicks on FS download link "<documentName>"
    Then the file "<documentName>" should be downloaded to the users machine
    And the file "<documentName>" should be removed
    When the user clicks on Home page
    Then "/Home.html" page is displayed
  Examples:
    | practiceArea   | document                                | documentName      | documentNameURL    |
    | Family         | Specimen questions: Income: tax returns | 0-533-2706.fs.doc | /0-533-2706.fs.doc |
    | Private Client | Master Will with drafting notes         | 5-381-4187.fs.doc | /5-381-4187.fs.doc |

  @bug
  Scenario Outline: Open Web Drect link Firm Style
    Given PL+ user is logged in with following details
      | routing          | OPEN_WEB |
      | mandatoryRouting | YES      |
    When the user deletes all files with name ".fs" and extension ".doc" from Downloads
    And the user opens <documentNameURL> url on plcuk website
    Then "signon" page is displayed
    Given PL+ user is logged in with following details after IP login
      | userName | FSTestUser2 |
    Then the file "<documentName>" should be downloaded to the users machine
    And the file "<documentName>" should be removed
    And "showDownloadPage" page is displayed
    When the user clicks on FS download link "<documentName>"
    Then the file "<documentName>" should be downloaded to the users machine
    And the file "<documentName>" should be removed
    When the user clicks on Home page
    Then "/Home.html" page is displayed
  Examples:
    | practiceArea   | document                                | documentName      | documentNameURL    |
    | Family         | Specimen questions: Income: tax returns | 0-533-2706.fs.doc | /0-533-2706.fs.doc |
    | Private Client | Master Will with drafting notes         | 5-381-4187.fs.doc | /5-381-4187.fs.doc |

  # 830028 [REGRESSION] Wrong path to Firm Style maketing page
  @bug
  Scenario Outline: Deny document
    Given PL+ user is logged in with following details
      | userName         | FSTestUser2       |
      | routing          | FIRM_STYLE_NO_FAC |
      | mandatoryRouting | YES               |
    And the user come back on to Home page
    And the user opens 'Resources' link
    And the user opens 'Standard documents and drafting notes' link
    And the user opens "<practiceArea>" link
    And the user opens "<document>" link
    And the user clicks Firm Style link
    Then Firm Style Tools page is displayed
    When the user opens <documentNameURL> url on plcuk website
    Then Firm Style Tools page is displayed
  Examples:
    | practiceArea   | document                                  | documentName      | documentNameURL    |
    | Private Client | Master Will with drafting notes           | 5-381-4187.fs.doc | /5-381-4187.fs.doc |
    | Employment     | Employment contract for a senior employee | 5-200-2047.fs.doc | /5-200-2047.fs.doc |

  @bug
  Scenario Outline: Deny clause
    Given PL+ user is logged in with following details
      | userName         | FSTestUser2       |
      | routing          | FIRM_STYLE_NO_FAC |
      | mandatoryRouting | YES               |
    And the user come back on to Home page
    And the user opens 'Resources' link
    And the user opens 'Standard clauses and drafting notes' link
    And the user opens "<practiceArea>" link
    And the user opens "<clause>" link
    And the user clicks Firm Style link
    Then Firm Style Tools page is displayed
    When the user opens <clauseNameURL> url on plcuk website
    Then Firm Style Tools page is displayed
  Examples:
    | practiceArea | clause                                  | clauseName        | clauseNameURL      |
    | Family       | Specimen questions: Income: tax returns | 0-533-2706.fs.doc | /0-533-2706.fs.doc |
    | Public Law   | Public sector boilerplate: Audit        | 0-501-5058.fs.doc | /0-501-5058.fs.doc |
