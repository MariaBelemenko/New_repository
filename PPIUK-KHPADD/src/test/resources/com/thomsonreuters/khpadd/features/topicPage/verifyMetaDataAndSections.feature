@e2e
Feature: Verify Meta Data and Sections of PA documents

  # Test will be passed ONLY if user have Pre-Release content option.
  # In other cases test will fail due to "Products" section on meta-data block not available for user without PreReleaseContent FAC.
  # PreReleaseContent FAC was set to user "PLUKTestUser1" permanently.
  Scenario Outline: Verify practice areas documents metadata and sections of Practice Notes, Standard Docs, Standard Clauses, Checklists
    Given PL+ user is logged in with following details
      | userName | PLUKTestUser1 |
    When the user opens 'Resources' link
    And the user opens '<Resource Link>' link
    And the user opens '<Practice Area Link>' link
    And the user clicks on '<Section Link>' link in table of contents
    And the user clicks on '<Practice Note Link>' link in '<Section Link>' section of the document
    Then the user verifies MetaData and Sections
  Examples:
    | Resource Link                         | Practice Area Link | Section Link                                 | Practice Note Link                                                                                |
    | Practice notes                        | Corporate          | Share acquisitions: private                  | A toolkit for private share acquisitions                                                          |
    | Practice notes                        | Property           | Overage                                      | Overage payments                                                                                  |
    | Standard documents and drafting notes | Corporate          | Company administration and meetings          | Minutes of a general meeting                                                                      |
    | Standard documents and drafting notes | Employment         | Transfer of undertakings                     | Advice to an employee on TUPE                                                                     |
    | Standard clauses and drafting notes   | Environment        | Health and safety                            | Public sector boilerplate: Health and safety                                                      |
    | Standard clauses and drafting notes   | IP & IT            | Boilerplate                                  | Announcements                                                                                     |
    | Checklists                            | Commercial         | General contract and boilerplate             | Damages for breach of contract: flowchart                                                         |
    | Checklists                            | Property           | Estate management and licences               | Consent to alterations of residential premises let on a long lease (Landlord): step-by-step guide |

  Scenario Outline: Verify practice areas documents metadata and sections of Legal Updates
    Given PL+ user is logged in with following details
      | userName | PLUKTestUser1 |
    When the user opens 'Resources' link
    And the user opens 'Legal updates' link
    And the user opens '<Practice Area Link>' link
    And the user clicks on the first link in results
    Then the user verifies MetaData and Sections
  Examples:
    | Practice Area Link |
    | Corporate          |
    | Commercial         |
    | Employment         |
    | Property           |
