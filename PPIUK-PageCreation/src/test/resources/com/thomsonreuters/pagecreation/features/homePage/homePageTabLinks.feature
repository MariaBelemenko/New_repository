@sandystest2

Feature: PL+ Home Page Browse
  In Order to view Practice areas, Resources and International links
  As a User I want to select the relevant resources on the homepage via the tabs

  Scenario: Verify default link is 'Practice areas' on the Home Page
    Given PL+ user is logged in
    Then user can view three tabs: Practice Areas, Resources and International
    And the user verifies that default Tab is 'Practice areas'

  #@e2e @prod
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
      #| EU referendum in the UK         |


  #@e2e @prod
  Scenario: Verify that 'Resources' link is displayed in central box on the home page
    Given the user clicks through the "Resources" links that are displayed on the Home Page
      | Practice notes                           |
      | Standard documents and drafting notes    |
      | Standard clauses and drafting notes      |
      | Checklists                               |
      #| Glossary                                 |
      | Ask                                      |
      | Legal updates                            |
      | What's Market                            |
      | PLC Magazine                             |
      #| Bloomsbury books online                  |
      | Global guides                            |

      #@e2e @prod
  Scenario: Verify that 'International' link is displayed in central box on the home page
    Given the user clicks through the "International" links that are displayed on the Home Page
      | Argentina                         |
      | Australia                         |
      | Austria                           |
      | Brazil                            |
      | Canada                            |
      | China                             |
      | France                            |
      | Germany                           |
      | Hong Kong                         |
      | India                             |
      | Indonesia                         |
      | Italy                             |
      | Japan                             |
      | Mexico                            |
      | Norway                            |
      | Russian Federation                |
      | Singapore                         |
      | South Africa                      |
      | South Korea                       |
      | Spain                             |
      | Sweden                            |
      | Switzerland                       |
      | Turkey                            |
      | United States                     |
      #| View all                          |
      #| Canada                            |
      | China                             |
      | Global                            |
      #| US                                |
      | International transaction guides  |
      #| Global guides                     |
      #| Arbitration                       |
      #| EU Law                            |
      #| Competition                       |