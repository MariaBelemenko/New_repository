@e2e @should
Feature: [803549] Testing Firm Style direct link

  # This test uses JAVA Robot, therefore it could be run locally only
  # 833984 [REGRESSION] Download FS document starting from Open Web user is broken
  @bug
  Scenario Outline: Open Web Direct link House Style
    Given PL+ user is logged in with following details
      | routing          | OPEN_WEB |
      | mandatoryRouting | YES      |
    When the user opens <documentNameURL> url on plcuk website
    And the user deletes all files with name ".fs" and extension ".doc" from Downloads
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
  Scenario Outline: Open Web Direct link Firm Style
    Given PL+ user is logged in with following details
      | routing          | OPEN_WEB |
      | mandatoryRouting | YES      |
    When the user opens <documentNameURL> url on plcuk website
    And the user deletes all files with name ".fs" and extension ".doc" from Downloads
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
