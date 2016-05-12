@sandystest1 @wip

Feature: PL+ Home Page Browse
  In Order to view Practice areas, Resources and International links
  As a User I want to select the relevant resources on the homepage via the Browse Menu

  Scenario: Verify default link is 'Practice areas' in menu 'Browse Menu' on the Home Page
    Given PL+ user is logged in
    When the user clicks button 'Browse Menu' on the Home Page
    Then user can view three links: Practice Areas, Resources and International
    And the user verifies that default Link is 'Practice areas'


  Scenario: Verify that 'Practice Area' links are displayed in pop up window 'Browse Menu' on the Home Page
    Given the user clicks through the "Practice areas" links that are displayed in the 'Browse Menu' on the Home Page
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
      | For in-house lawyers            |
      | For company secretaries         |
      | For charity lawyers             |
      | For advising smaller businesses |


  Scenario: Verify that 'International' links are displayed in pop up window 'Browse Menu' on the Home Page
    Given the user clicks through the "International" links that are displayed in the 'Browse Menu' on the Home Page
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
    Then The user clicks the Browse button tab link "International"
    Then The user clicks the Browse link "View all"
    And The user verifies the PL page title is "All countries"
    Then The user clicks the Browse button tab link "International"
    Then The user clicks the Browse link "International subscriptions ~ Canada"
    And The user verifies the PL page title is "Practical Law"
    Then The user clicks the Browse button tab link "International"
    Then The user clicks the Browse link "US"
    And The user verifies the PL page title is "Practical Law"


  Scenario: Verify that 'Resources' links are displayed in pop up window 'Browse Menu' on the Home Page
    Given the user clicks through the "Resources" links that are displayed in the 'Browse Menu' on the Home Page
      | Global guides                            |
      | Practice notes                           |
      | Standard documents and drafting notes    |
      | Standard clauses and drafting notes      |
      | Checklists                               |
      | Ask                                      |
      | Legal updates                            |
      | What's Market                            |
      | PLC Magazine                             |
    Then The user clicks the Browse button tab link "Resources"
    Then The user clicks the Browse link "Bloomsbury books online"
    And The user verifies the PL page title is "Books"
    Then The user clicks the Browse button tab link "Resources"
    Then The user clicks the Browse link "Glossary"
    And The user verifies the glossary page title is "Glossary"




