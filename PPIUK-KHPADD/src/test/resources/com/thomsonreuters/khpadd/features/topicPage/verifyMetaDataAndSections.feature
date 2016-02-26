@e2e
Feature: Verify Meta Data and Sections of PA documents

  Background:
    Given PL+ user is logged in

  # Test will be passed ONLY if user have Pre-Release content option.
  # In other cases test will fail due to "Products" section on meta-data block not available for user w/o Pre-Release content.
  # Question about it was sent to Sam Newman but still no answer.
  Scenario Outline: Verify practice areas documents metadata and sections of Practice Notes, Standard Docs, Standard Clauses, Checklists
    When the user opens 'Resources' link
    And the user opens '<Resource Link>' link
    And the user opens '<Practice Area Link>' link
    And the user clicks on '<Section Link>' link in table of contents
    And the user clicks on '<Practice Note Link>' link in '<Section Link>' section of the document
    Then the user verifies MetaData and Sections
  Examples:
    | Resource Link                         | Practice Area Link | Section Link                                 | Practice Note Link                                                                                |
    | Practice notes                        | Commercial         | Supply of goods and services                 | Consumer legislation: overview                                                                    |
    | Practice notes                        | Corporate          | Share acquisitions: private                  | A toolkit for private share acquisitions                                                          |
    | Practice notes                        | Employment         | Transfer of undertakings                     | Asset purchase agreements: drafting and negotiating employment indemnities and warranties         |
    | Practice notes                        | Property           | Overage                                      | Overage payments                                                                                  |
    | Standard documents and drafting notes | Commercial         | Supply of goods and services                 | Letter of advice to a customer on terms and conditions of supply of services (pro-customer)       |
    | Standard documents and drafting notes | Corporate          | Company administration and meetings          | Minutes of a general meeting                                                                      |
    | Standard documents and drafting notes | Employment         | Transfer of undertakings                     | Advice to an employee on TUPE                                                                     |
    | Standard documents and drafting notes | Property           | Other sets of pre-contract enquiries         | Construction enquiries before contract                                                            |
    | Standard clauses and drafting notes   | Corporate          | Acquisitions: Share purchase agreements      | Anti-corruption warranties: share purchase agreement                                              |
    | Standard clauses and drafting notes   | Environment        | Health and safety                            | Public sector boilerplate: Health and safety                                                      |
    | Standard clauses and drafting notes   | IP & IT            | Boilerplate                                  | Announcements                                                                                     |
    | Standard clauses and drafting notes   | Property           | Easements, covenants and thirty party rights | Easement: Overhanging eaves                                                                       |
    | Checklists                            | Commercial         | General contract and boilerplate             | Damages for breach of contract: flowchart                                                         |
    | Checklists                            | Corporate          | Company formation and constitution           | Company formation: checklist                                                                      |
    | Checklists                            | Employment         | Transfer of undertakings                     | Dealing with TUPE transfers in the tendering process: checklist                                   |
    | Checklists                            | Property           | Estate management and licences               | Consent to alterations of residential premises let on a long lease (Landlord): step-by-step guide |

  Scenario Outline: Verify practice areas documents metadata and sections of Legal Updates
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
