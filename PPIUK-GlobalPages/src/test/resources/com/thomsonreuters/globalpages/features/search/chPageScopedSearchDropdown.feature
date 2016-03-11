Feature: [839944] [843637] As a PL+ User, I am able to over-ride the default scoping in China page

  Scenario Outline: verify the scop search drop down
    Given PL+ user is logged in with following details
      | routing          | BETA |
      | mandatoryRouting | YES  |
    When the user navigates to the main PLCUK page
    When the user selects "International" tab and clicks on "China" link in "International subscriptions" section
    Then the Category Page opens correctly
    Then the user can verify that the scoped search dropdown states "China"
    Then the scoped search drop down contains the practice areas as below
      | China                           |
      | All Content                     |
      | Agriculture & Rural Land        |
      | Arbitration (All Jurisdictions) |
      | Arbitration (England & Wales)   |
      | Business Crime & Investigations |
      | Commercial                      |
      | Competition                     |
      | Construction                    |
      | Corporate                       |
      | Data Protection                 |
      | Dispute Resolution              |
      | Employment                      |
      | Environment                     |
      | EU                              |
      | Family                          |
      | Finance                         |
      | Financial Services              |
      | IP & IT                         |
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
    When user selects the dropdown option "<practiceArea>"
    And the user runs a free text search for the query "tax"
    Then the user can verify that the scoped search dropdown states "<practiceArea>"
    Then the scoped search drop down contains the practice areas as below
      | <practiceArea>                  |
      | All Content                     |
      | Agriculture & Rural Land        |
      | Arbitration (All Jurisdictions) |
      | Arbitration (England & Wales)   |
      | Business Crime & Investigations |
      | Commercial                      |
      | Competition                     |
      | Construction                    |
      | Corporate                       |
      | Data Protection                 |
      | Dispute Resolution              |
      | Employment                      |
      | Environment                     |
      | EU                              |
      | Family                          |
      | Finance                         |
      | Financial Services              |
      | IP & IT                         |
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
    And the user can verify that the title listed above the search results is "<practiceArea>"
    And the user can open the first know how search result "1"
    Then the document opens correctly
    And the user verifies that the product detail contains the practice area "<product>"
  Examples:
    | practiceArea | product           |
    | Employment   | PLC UK Employment |
    | Corporate    | PLC UK Corporate  |
    | China        | China             |

  Scenario: verify back to china button
    Given PL+ user is logged in
    When the user navigates to the main PLCUK page
    When the user selects "International" tab and clicks on "China" link in "International subscriptions" section
    Then the Category Page opens correctly
    When the user runs a free text search for the query "tax"
    Then the user can verify that the title listed above the search results is "China"
    When the user clicks link 'Back to China' on 'search' page
    Then the user is presented with a page with header "China"
