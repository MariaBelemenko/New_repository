Feature: [792545][792551][792565][792547][702177][792476][792527][792536] uk Scoped Search Dropdown
  (Country Pages, What's market pages, What's Market deal type pages, PLC Magazine, Homepage , PA Page , Topic Page, Ask Page, Glossary Page, document page)

  Background: Log on to test site with user having routing set to view the product details
    Given PL+ user is logged in with following details
      | userName | SearchKnowHowUser6 |
    And the user is on the home page 

  Scenario: [792545] - Scoped search on country pages
    ##And the user runs a free text search for the query "tax"
    ##theUserGetsTheKnowHowSearchResultCountAndStoresItAsCount "1"
    And has selected the link entitled International
    And has selected the link to the country page "Italy"
    Then the user can verify that the scoped search dropdown states "Italy"
    ##And the user runs a free text search for the query "tax"
    ##theUserGetsTheKnowHowSearchResultCountAndStoresItAsCount "2"
    ##And the user verifies that the know how search result count "2" is less than "1"
    And the user can display the scoped search dropdown menu options
    And the user can verify that the dropdown options include "All Content"
    When the user runs a free text search for the query "contract for sale of land subject to leases"
    Then the user can verify that the scoped search dropdown states "Italy"
    And the user can verify that the title listed above the search results is the country name "Italy"
    And the user can verify that the search result in position "1" contains the jurisdiction "Italy"

  Scenario: [792547] - Scoped search on PLC Magazine page
    And has selected the link to Resources
    And has selected the link to PLC Magazine
    Then the user can verify that the scoped search dropdown states "PLC Magazine"
    And the user can display the scoped search dropdown menu options
    And the user can verify that the dropdown options include "All Content"
    When the user runs a free text search for the query "contract"
    Then the user can verify that the scoped search dropdown states "PLC Magazine"
    And the user can verify that the title listed above the search results is "PLC Magazine"
    And the user can open the first know how search result "1"
    And the user verifies that the product detail contains PLC Magazine "PLC Magazine (UK)"

  @e2e @prod
  Scenario: [792476] - Scoped search on HomePage
    Then the user can verify that the scoped search dropdown states "All Content"
    When the user can display the scoped search dropdown menu options
    Then the search drop down options provided on "Homepage" are as below
      | All Content                     |
      | Agriculture & Rural Land        |
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
    And the user runs a free text search for the query "Bribery Act 2010"
    Then the user can verify that the scoped search dropdown states "All Content"
    And the user can verify that the title listed above the search results is "All Content"
    Then the user can display the scoped search dropdown menu options
    When user selects the dropdown option "Commercial"
    And the user runs a free text search for the query "tax"
    Then the user can verify that the scoped search dropdown states "Commercial"
    Then the user can display the scoped search dropdown menu options
    Then the search drop down options provided on "Practice Area Page" are as below
      | Commercial                      |
      | All Content                     |
      | Agriculture & Rural Land        |
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
    Then the user can close the scoped search dropdown menu options
    And the user can verify that the title listed above the search results is "Commercial"
    And the user can open the first know how search result "1"
    And the user verifies that the product detail contains the practice area "PLC UK Commercial"

  @e2e @prod
  Scenario: [702177][792527] - Scoped search on PA Page
    When has selected the homepage practice area link to "Corporate"
    Then the user can verify that the scoped search dropdown states "Corporate"
    Then the user can display the scoped search dropdown menu options
    Then the search drop down options provided on "Practice Area Page" are as below
      | Corporate                       |
      | All Content                     |
      | Agriculture & Rural Land        |
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
    And the user runs a free text search for the query "acquisitions 2014"
    Then the user can verify that the scoped search dropdown states "Corporate"
    And the user can verify that the title listed above the search results is "Corporate"
    And the user can open the first know how search result "4"
    And the user verifies that the product detail contains the practice area "Corporate"
    When the user can display the scoped search dropdown menu options
    And user selects the dropdown option "Finance"
    And the user runs a free text search for the query "tax"
    Then the user can verify that the scoped search dropdown states "Finance"
    And the user can verify that the title listed above the search results is "Finance"
    And the user can open the first know how search result "3"
    And the user verifies that the product detail contains the practice area "Finance"

  @e2e @prod
  Scenario: [792536] - Scoped search on Topic Page
    When the user navigates to practice area "Employment" filtered by "Contracts of employment" topic page
    Then the user can verify that the scoped search dropdown states "Contracts of Employment"
    Then the user can display the scoped search dropdown menu options
    Then the search drop down options provided on "Topic Page" are as below
      | Contracts of Employment         |
      | All Content                     |
      | Agriculture & Rural Land        |
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
    And the user runs a free text search for the query "employee benefits"
    Then the user can verify that the scoped search dropdown states "Contracts of Employment"
    And the user can verify that the title listed above the search results is "Contracts of Employment"
    And the user can open the first know how search result "3"

  Scenario: Scoped search on Ask landing Page and Ask Practice Area page
    When the user is in page 'Browse Menu>Resources>Ask' with page Title 'Ask'
    Then the user can verify that the scoped search dropdown states "Ask"
    Then the user can display the scoped search dropdown menu options
    Then the search drop down options provided on "Ask landing page" are as below
      | Ask         |
      | All Content |
    And the user runs a free text search for the query "GMP"
    Then the user can verify that the scoped search dropdown states "Ask"
    And the user can verify that the title listed above the search results is "Ask"
    Then the user can display the scoped search dropdown menu options
    Then the search drop down options provided on "Ask landing page" are as below
      | Ask         |
      | All Content |
    When the user is in page 'Browse Menu>Resources>Ask' with page Title 'Ask'
    And the user clicks link 'Construction' on 'the Ask Landing' page
    And the user verifies that the current PageTitle contains 'Ask: Construction'
    Then the user can verify that the scoped search dropdown states "Ask: Construction"
    Then the user can display the scoped search dropdown menu options
    Then the search drop down options provided on "Ask Practice area page" are as below
      | Ask: Construction |
      | Ask               |
      | All Content       |
    And the user runs a free text search for the query "BUILD AGREEMENT"
    Then the user can verify that the scoped search dropdown states "Ask: Construction"
    Then the user can display the scoped search dropdown menu options
    Then the search drop down options provided on "Ask Practice area page" are as below
      | Ask: Construction |
      | All Content       |

  Scenario: Scoped search on Glossary landing Page
    When user navigates to a glossary page
    Then the user can verify that the scoped search dropdown states "All Content"
    When the user can display the scoped search dropdown menu options
    Then the search drop down options provided on "Glossary page" are as below
      | All Content                     |
      | Agriculture & Rural Land        |
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
    And the user runs a free text search for the query "Bribery Act 2010"
    Then the user can verify that the scoped search dropdown states "All Content"
    And the user can verify that the title listed above the search results is "All Content"
    Then the user can display the scoped search dropdown menu options
    When user selects the dropdown option "Pensions"
    And the user runs a free text search for the query "tax"
    Then the user can verify that the scoped search dropdown states "Pensions"
    Then the user can display the scoped search dropdown menu options
    Then the search drop down options provided on "Practice Area Page" are as below
      | Pensions                        |
      | All Content                     |
      | Agriculture & Rural Land        |
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
    And the user can verify that the title listed above the search results is "Pensions"
    And the user can open the first know how search result "4"
    And the user verifies that the product detail contains the practice area "Pensions"

  Scenario: Scoped search on Document Page
    When user navigates directly to document with guid "I95c5ea1ae67a11e398db8b09b4f043e0"
    Then the user can verify that the scoped search dropdown states "All Content"
    When the user can display the scoped search dropdown menu options
    Then the search drop down options provided on "Glossary page" are as below
      | All Content                     |
      | Agriculture & Rural Land        |
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
    And the user runs a free text search for the query "Bribery Act 2010"
    Then the user can verify that the scoped search dropdown states "All Content"
    And the user can verify that the title listed above the search results is "All Content"
    Then the user can display the scoped search dropdown menu options
    When user selects the dropdown option "Family"
    And the user runs a free text search for the query "tax"
    Then the user can verify that the scoped search dropdown states "Family"
    Then the user can display the scoped search dropdown menu options
    Then the search drop down options provided on "Document Page" are as below
      | Family                          |
      | All Content                     |
      | Agriculture & Rural Land        |
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
    And the user can verify that the title listed above the search results is "Family"
    And the user can open the first know how search result "7"
    And the user verifies that the product detail contains the practice area "Family"
