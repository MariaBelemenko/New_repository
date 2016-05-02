Feature: [774402] FS1 As a PL+ User I want to view the download in FirmStyle option So that I know I can�download the standard document in my Companies Firm Style

  Background:
    Given PL+ user is logged in with following details
      | userName         | FSTestUser2 |
      | routing          | FIRM_STYLE  |
      | mandatoryRouting | YES         |

  Scenario Outline: Able to see the Firm Style Link from a Document
    When the user come back on to Home page
    And the user opens 'Resources' link
    And the user opens 'Standard documents and drafting notes' link
    And the user opens "<practiceArea>" link
    And the user opens "<document>" link
    Then the user sees the Firm Style link
  Examples:
    | practiceArea               | document                                                                           | ref        |
    | Private Client             | Master Will with drafting notes                                                    | 5-381-4187 |
    | Share Schemes & Incentives | Legal due diligence information request: long form: share purchases: 13. Employees | 7-200-3932 |
    | Employment                 | Employment contract for a senior employee                                          | 5-200-2047 |
    | Property                   | Lease of whole with prescribed clauses                                             | 8-201-5543 |
    | Corporate                  | Asset purchase agreement                                                           | 2-107-3546 |

  Scenario Outline: Able to see the Firm Style Link from a Clause
    When the user come back on to Home page
    And the user opens 'Resources' link
    And the user opens 'Standard clauses and drafting notes' link
    And the user opens "<practiceArea>" link
    And the user opens "<clause>" link
    Then the user sees the Firm Style link
  Examples:
    | practiceArea | clause                                                                   | ref        |
    | Family       | Specimen questions: Income: tax returns                                  | 0-533-2706 |
    | Public Law   | Public sector boilerplate: Audit                                         | 0-501-5058 |
    | Environment  | Environmental indemnity: seller-friendly draft: asset purchase agreement | 4-201-0726 |
