@sandystest @wip

Feature: PL+ Home Page Browse
  In Order to view Practice areas, Resources and International links
  As a User I want to select the relevant resources on the homepage via the Browse Menu

  Scenario: Verify default link is 'Practice areas' in menu 'Browse Menu' on the Home Page
    Given PL+ user is logged in
    When the user clicks button 'Browse Menu' on the Home Page
    Then user can view three links: Practice Areas, Resources and International
    And the user verifies that default Link is 'Practice areas'

  #@e2e @prod
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

  #@e2e @prod
  Scenario: Verify that 'Resources' links are displayed in pop up window 'Browse Menu' on the Home Page
    Given the user clicks through the "Resources" links that are displayed in the 'Browse Menu' on the Home Page
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
  Scenario: Verify that 'International' links are displayed in pop up window 'Browse Menu' on the Home Page
    Given the user clicks through the "International" links that are displayed in the 'Browse Menu' on the Home Page
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

