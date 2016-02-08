@ip @robot
Feature: [780804] FS4 Testing IP users download FS document
  [780805] FS4 Testing Restrict on basis FAC
  [803549] Testing Firm Style direct link

  # This test uses JAVA Robot, therefore it could be run locally only
  
  # This test could be run only on IP mashine
  # Kavtur, Tatsiana <Tatsiana.Kavtur@thomsonreuters.com> could help to test this manually
  
  Scenario Outline: 
    Given PL+ user is logged in with following details
      | routing          | FIRM_STYLE_IP_USERS |
      | mandatoryRouting | YES                 |
    When the user come back on to Home page
    And the user deletes all files with name ".fs" and extension ".doc" from Downloads
    And the user opens 'Resources' link
    And the user opens 'Standard documents and drafting notes' link
    And the user opens "<practiceArea>" link
    And the user opens "<document>" link
    And the user clicks Firm Style link and download a document
    Then the file "<documentName>" should be downloaded to the users machine
    And the file "<documentName>" should be removed
    When the user opens <documentNameURL> url on plcuk website
    Then the file "<documentName>" should be downloaded to the users machine
    And the file "<documentName>" should be removed

    Examples: 
      | practiceArea | document                               | documentName      | documentNameURL    |
      | Property     | Lease of whole with prescribed clauses | 8-201-5543.fs.doc | /8-201-5543.fs.doc |
      | Corporate    | Asset purchase agreement               | 2-107-3546.fs.doc | /2-107-3546.fs.doc |

  Scenario Outline: 
    Given PL+ user is logged in with following details
      | routing          | FIRM_STYLE_IP_USERS |
      | mandatoryRouting | YES                 |
    When the user come back on to Home page
    And the user deletes all files with name ".fs" and extension ".doc" from Downloads
    And the user opens 'Resources' link
    And the user opens 'Standard clauses and drafting notes' link
    And the user opens "<practiceArea>" link
    And the user opens "<clause>" link
    And the user clicks Firm Style link and download a document
    Then the file "<clauseName>" should be downloaded to the users machine
    And the file "<clauseName>" should be removed
    When the user opens <clauseNameURL> url on plcuk website
    Then the file "<clauseName>" should be downloaded to the users machine
    And the file "<clauseName>" should be removed

    Examples: 
      | practiceArea | clause                                  | clauseName        | clauseNameURL      |
      | Family       | Specimen questions: Income: tax returns | 0-533-2706.fs.doc | /0-533-2706.fs.doc |
      | Public Law   | Public sector boilerplate: Audit        | 0-501-5058.fs.doc | /0-501-5058.fs.doc |
