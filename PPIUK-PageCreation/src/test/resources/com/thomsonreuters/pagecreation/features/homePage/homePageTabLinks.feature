@sandystest2 @wip @CPET

Feature: PL+ Home Page Browse
  In Order to view Practice areas, Resources and International links
  As a User I want to select the relevant resources on the homepage via the tabs

  Scenario: Verify default link is 'Practice areas' on the Home Page
    Given PL+ user is logged in
    Then user can view three tabs: Practice Areas, Resources and International
    And the user verifies that default Tab is 'Practice areas'

  Scenario: Verify that 'Practice Area' link is displayed in central box on the home page
    Given the user clicks through the "Practice areas" links that are displayed on the Home Page
      | Agriculture & Rural Land        |
      | Arbitration                     |
      | Business Crime & Investigations |
      | Commercial                      |
      | Competition                     |
      | Construction                    |
      | Corporate                       |
      | Data Protection                 |
      | Dispute Resolution              |
      | Employment                      |
      | Environment                     |
      | EU Law                          |
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
      | For advising smaller businesses |
      | For charity lawyers             |
      | For company secretaries         |
      | For in-house lawyers            |
    Then The user clicks link to "EU referendum in the UK"
    And The user verifies the resource page title is "EU Referendum"

  Scenario: Verify that 'Resources' link is displayed in central box on the home page
    Given the user clicks through the "Resources" links that are displayed on the Home Page
      | Practice notes                           |
      | Standard documents and drafting notes    |
      | Standard clauses and drafting notes      |
      | Checklists                               |
      | Ask                                      |
      | Legal updates                            |
      | What's Market                            |
      | PLC Magazine                             |
      | Global guides                            |
    Then The user clicks the Home page tab link "Resources"
    Then The user clicks link to "Glossary"
    And The user verifies the glossary page title is "Glossary"
    Then The user clicks the Home page tab link "Resources"
    Then The user clicks link to "Bloomsbury books online"
    And The user verifies the PL page title is "Books"

  Scenario: Verify that 'International' link is displayed in central box on the home page
    Given the user clicks through the "International" links that are displayed on the Home Page
      | Argentina                               |
      | Australia                               |
      | Austria                                 |
      | Brazil                                  |
      | Canada                                  |
      | China                                   |
      | France                                  |
      | Germany                                 |
      | Hong Kong                               |
      | India                                   |
      | Indonesia                               |
      | Italy                                   |
      | Japan                                   |
      | Mexico                                  |
      | Norway                                  |
      | Russian Federation                      |
      | Singapore                               |
      | South Africa                            |
      | South Korea                             |
      | Spain                                   |
      | Sweden                                  |
      | Switzerland                             |
      | Turkey                                  |
      | United States                           |
      | International subscriptions ~ China     |
      | Global                                  |
      | International transaction guides        |
      | Global guides                           |
      | Arbitration                             |
      | EU Law                                  |
      | Competition                             |
    Then The user clicks the Home page tab link "International"
    Then The user clicks link to "View all"
    And The user verifies the PL page title is "All countries"
    Then The user clicks the Home page tab link "International"
    Then The user clicks link to "International subscriptions ~ Canada"
    And The user verifies the PL page title is "Practical Law"
    Then The user clicks the Home page tab link "International"
    Then The user clicks link to "US"
    And The user verifies the PL page title is "Practical Law"


  Scenario: Verify that the 'Recent History' box is present on the Home Page and that either the
  'browse more' message is there or there is at least one article link
    Given PL+ user is logged in
