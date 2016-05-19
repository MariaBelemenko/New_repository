@e2e
Feature: [780806] FS3 Testing PL+ "PA" users can download a document in FirmStyle

  Scenario Outline: Documents and FS
    Given PL+ user is logged in with following details
      | userName         | FSTestUser2 |
      | routing          | FIRM_STYLE  |
      | mandatoryRouting | YES         |
    When the user come back on to Home page
    And the user opens 'Resources' link
    And the user opens 'Standard documents and drafting notes' link
    And the user opens "<practiceArea>" link
    And the user opens "<document>" link
    And the user clicks Firm Style link and download a document
    Then the file "<documentName>" should be downloaded to the users machine
  Examples:
    | practiceArea   | document                                  | documentName      |
    | Employment     | Employment contract for a senior employee | 5-200-2047.fs.doc |
    | Private Client | Master Will with drafting notes           | 5-381-4187.fs.doc |

  Scenario Outline: Clause and FS
    Given PL+ user is logged in with following details
      | userName         | FSTestUser2 |
      | routing          | FIRM_STYLE  |
      | mandatoryRouting | YES         |
    And the user come back on to Home page
    And the user opens 'Resources' link
    And the user opens 'Standard clauses and drafting notes' link
    And the user opens "<practiceArea>" link
    And the user opens "<clause>" link
    And the user clicks Firm Style link and download a document
    Then the file "<clauseName>" should be downloaded to the users machine
  Examples:
    | practiceArea | clause                                  | clauseName        |
    | Family       | Specimen questions: Income: tax returns | 0-533-2706.fs.doc |
    | Public Law   | Public sector boilerplate: Audit        | 0-501-5058.fs.doc |

  Scenario Outline: Documents and House Style
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
  Examples:
    | practiceArea   | document                                  | documentName      |
    | Employment     | Employment contract for a senior employee | 5-200-2047.fs.doc |
    | Private Client | Master Will with drafting notes           | 5-381-4187.fs.doc |

  Scenario Outline: Clause and House Style
    Given PL+ user is logged in with following details
      | userName         | FDTestUser2 |
      | routing          | FIRM_STYLE  |
      | mandatoryRouting | YES         |
    And the user come back on to Home page
    And the user opens 'Resources' link
    And the user opens 'Standard clauses and drafting notes' link
    And the user opens "<practiceArea>" link
    And the user opens "<clause>" link
    And the user clicks Firm Style link and download a document
    Then the file "<clauseName>" should be downloaded to the users machine
  Examples:
    | practiceArea | clause                                  | clauseName        |
    | Family       | Specimen questions: Income: tax returns | 0-533-2706.fs.doc |
    | Public Law   | Public sector boilerplate: Audit        | 0-501-5058.fs.doc |
