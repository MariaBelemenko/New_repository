Feature: As a PL+ User, I am able to browse the content by resource type

  Background:
    Given PL+ user is logged in with following details
      | userName | GlPage_UK1 |
    And the user navigates to the main PLCUK page
    When the user selects "International" tab and clicks on "China" link in "International subscriptions" section
    Then the Category Page opens correctly

  Scenario Outline: verify that list of links under section headings is present
    When the user selects "Resources" tab
    Then the user sees "<header1>" and the list of links
      | Practice notes                              |
      | Standard documents and drafting notes       |
      | Standard clauses and drafting notes         |
      | Checklists                                  |
      | China glossary                              |
      | China government and business organisations |
      | China legislation                           |
    Then the user sees "<header2>" and the list of links
      | About this practice area        |
      | Meet the team                   |
      | Consultation board              |
      | Provisional publishing schedule |
      | New content                     |
    Then the user sees "<header3>" and the list of links
      | Legal updates          |
      | Monthly e-mail archive |
  Examples:
    | header1              | header2                  | header3           |
    | Maintained resources | About this practice area | Current awareness |

  Scenario Outline: verify that documents opens correctly
    When the user selects "Resources" tab
    Then the user clicks on "<link>" link
    Then the document opens correctly
    And document title is displayed as "<title>"
  Examples:
    | link                                        | title                                        |
    | Practice notes                              | Practice notes: China                        |
    | Standard documents and drafting notes       | Standard documents and drafting notes: China |
    | Standard clauses and drafting notes         | Standard Clauses and drafting notes: China   |
    | Checklists                                  | Checklists: China                            |
    | China glossary                              | China glossary                               |
    | China government and business organisations | Government and business organisations: China |
    | China legislation                           | China legislation                            |
    | About this practice area                    | About Practical Law China                    |
    | Provisional publishing schedule             | Provisional publishing schedule: China       |
    | New content                                 | New content: China                           |
    | Monthly e-mail archive                      | China monthly e-mail archive                 |

  Scenario Outline: verify that links opens correctly
    When the user selects "Resources" tab
    Then the user clicks on "<link>" link
    Then the user verifies that the current PageTitle contains '<pageTitleAfterClickonlink>'
  Examples:
    | link               | pageTitleAfterClickonlink |
    | Meet the team      | Our team                  |
    | Consultation board | Consultation board        |
    | Legal updates      | Legal Updates             |
