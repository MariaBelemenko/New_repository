Feature: As a User I want to view the download in FirmStyle option So that I know I can download the standard document in my Companies Firm Style

  Background:
    Given PL+ user is logged in with following details
      | userName         | FSTestUser1 |
      | routing          | FIRM_STYLE  |
      | mandatoryRouting | YES         |

  Scenario Outline: User cannot see the firm style link from a document link
    And the user opens 'Resources' link
    And the user opens 'Standard documents and drafting notes' link
    And the user opens "<practiceArea>" link
    And the user opens "<document>" link
    Then the user does not see the Firm Style link
  Examples:
    | practiceArea | document                                          | ref        |
    | IP&IT        | Single licensee escrow agreement (NCC Group form) | 0-100-9636 |
    | Finance      | Irrevocable documentary credit application form   | 0-100-9622 |
    | Construction | Adjudication Agreement, 2011 Edition (Adj 2011)   | 0-572-8397 |

  Scenario Outline: User cannot see the firm style link from a clause link
    And the user opens 'Resources' link
    And the user opens 'Standard clauses and drafting notes' link
    And the user opens "<practiceArea>" link
    And the user opens "<clause>" link
    Then the user does not see the Firm Style link
  Examples:
    | practiceArea | clause                                                                 | ref        |
    | Construction | NEC3 ECC Z clause: quality management and audit                        | 0-500-4451 |
    | Property     | Consultation draft CRC clauses for insertion into standard form leases | 9-500-6766 |

  Scenario Outline: User cannot see the firm style link from a checklist link
    And the user opens 'Resources' link
    And the user opens 'Checklists' link
    And the user opens "<practiceArea>" link
    And the user opens "<checklist>" link
    Then the user does not see the Firm Style link
  Examples:
    | practiceArea | checklist                                 | ref        |
    | Corporate    | After closing: international acquisitions | 3-107-3937 |
