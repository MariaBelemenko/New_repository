@should
Feature: [792545][792551][792565][792547][702177][792476][792527][792536] uk Scoped Search Dropdown (Country Pages, What's market pages, What's Market deal type pages, PLC Magazine, Homepage , PA Page , Topic Page, Ask Page, Glossary Page, document page)

  Background: Log on to test site with user having routing set to view the product details
    Given PL+ user is logged in with following details
      | userName          | Search1_AutoUser       |
    And the user is on the home page

  # Bug 860453 - REGRESSION - topic information missing from know how resources
  #885342:[HS]Topics are not appearing in the related content section of a document on Firefox
  Scenario: [792536] - Scoped search on Topic Page
    When the user navigates to practice area "Employment" filtered by "Contracts of employment" topic page
    Then the user can verify that the scoped search dropdown states "Contracts of Employment"
    And the user can display the scoped search dropdown menu options
    Then the search drop down options provided on "Topic Page" are as below
      | Contracts of Employment         |
      | All Content                     |
      | Agriculture & Rural Land       |
      | Arbitration (All Jurisdictions) |
      | Arbitration (England & Wales)   |
      | Business Crime & Investigations |
      | Commercial                      |
      | Competition                     |
      | Construction                    |
      | Corporate                       |
      | Cross-border                    |
      | Data Protection                 |
      | Dispute Resolution              |
      | Employment                      |
      | Environment                     |
      | EU                              |
      | Family                          |
      | Finance                         |
      | Financial Services              |
      | IP & IT                         |
      | Life Sciences                   |
      | Local Government                |
      | Media & Telecoms                |
      | Pensions                        |
      | Planning                        |
      | Private Client                  |
      | Property                        |
      | Property Litigation             |
      | Public Law                      |
      | Restructuring & Insolvency      |
      | Share Schemes & Incentives      |
      | Tax                             |
    When the user runs a free text search for the query "employee benefits"
    Then the user can verify that the scoped search dropdown states "Contracts of Employment"
    And the user can verify that the title listed above the search results is "Contracts of Employment"
    When the user can open the first know how search result "3"
    Then the user verifies that the product detail contains the topic area "Contracts of Employment"
    When the user can display the scoped search dropdown menu options
    And user selects the dropdown option "Commercial"
    And the user runs a free text search for the query "tax"
    Then the user can verify that the scoped search dropdown states "Commercial"
    And the user can verify that the title listed above the search results is "Commercial"
    When the user can open the first know how search result "1"
    Then the user verifies that the product detail contains the practice area "Commercial"