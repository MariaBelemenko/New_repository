@bug @should
Feature: Should [780805] FS4 Testing Restrict on basis FAC

  # 830028 [REGRESSION] Wrong path to Firm Style maketing page
  Scenario Outline: Deny document
    Given PL+ user is logged in with following details
      | routing          | FIRM_STYLE_IP_USERS_NO_FAC |
      | mandatoryRouting | YES                        |
    When the user come back on to Home page
    And the user opens 'Resources' link
    And the user opens 'Standard documents and drafting notes' link
    And the user opens "<practiceArea>" link
    And the user opens "<document>" link
    And the user clicks Firm Style link
    Then Firm Style Tools page is displayed
    When the user opens <documentNameURL> url on plcuk website
    Then Firm Style Tools page is displayed
  Examples:
    | practiceArea   | document                               | documentName      | documentNameURL    |
    | Private Client | Master Will with drafting notes        | 5-381-4187.fs.doc | /5-381-4187.fs.doc |
    | Property       | Lease of whole with prescribed clauses | 8-201-5543.fs.doc | /8-201-5543.fs.doc |

  Scenario Outline: Deny clause
    Given PL+ user is logged in with following details
      | routing          | FIRM_STYLE_IP_USERS_NO_FAC |
      | mandatoryRouting | YES                        |
    When the user come back on to Home page
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
