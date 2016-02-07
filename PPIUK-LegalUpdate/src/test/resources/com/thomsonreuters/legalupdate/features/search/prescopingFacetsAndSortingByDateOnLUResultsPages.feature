Feature: LU Results Facets - Pre-scoping, Sorting By Date

  Scenario Outline: PA LU Results: Facets - Pre-scoping, Sorting By Date
    Given PL+ user is logged in with following details
      | userName | LU_AutoUser |
    Given a user is on a "<practiceArea>" PA page
    When the user clicks on the 'View all' link of the LU widget
    Then the user should be presented with a list of LU documents
    And the results should be from the relevant PA "<practiceArea>"
    And the 'Practice Area' facets should be pre-scoped to the "<practiceArea>" PA that the user had come from
    And the user should be displayed the child topics of that practice area
    And the user should be able to select the child topics of that practice area to filter the results
    And the results should be sorted by date (most recent first)
    And the user should not be presented with the sort order drop down
    And the user should not be presented with any 'Resource type' faceting
  Examples:
    | practiceArea               |
    | Arbitration                |
    | Commercial                 |
    | Competition                |
    | Construction               |
    | Corporate                  |
    | Dispute Resolution         |
    | Employment                 |
    | Environment                |
    | Family                     |
    | Finance                    |
    | Financial Services         |
    | IP & IT                    |
    | Media & Telecoms           |
    | Pensions                   |
    | Private Client             |
    | Property                   |
    | Public Law                 |
    | Restructuring & Insolvency |
    | Share Schemes & Incentives |
    | Tax                        |

  Scenario: Topic LU Results: Facets - Pre-scoping, Sorting By Date
    Given PL+ user is logged in with following details
      | userName | LU_AutoUser |
    Given a user navigate to a "Insurance" Topic page from a "Construction" Practice Area page
    When the user clicks on the 'View all' link of the LU widget
    Then the user should be taken to the "Insurance" Topic LU results list
    And the 'Practice Area' facets should be pre-scoped to the "Construction" PA that the user had come from
    And the 'Practice Area' facets should be pre-scoped to the "Insurance" Topic that the user had come from
    Then the user should be presented with a list of LU documents
    And the results should be sorted by date (most recent first)
    And the user should not be presented with the sort order drop down
    And the user should not be presented with any 'Resource type' faceting
