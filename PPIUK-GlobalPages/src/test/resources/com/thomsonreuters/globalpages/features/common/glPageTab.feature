Feature: As a User
  I can navigate to the global page and browse by resource types

  Background:
    Given PL+ user is logged in
    When the user navigates to the main PLCUK page
    When the user selects "International" tab and clicks on "Global" link in "International subscriptions" section
    Then the Category Page opens correctly

  Scenario Outline: verify international transaction guides in transactions tab
    When the user selects "Transactions" tab
    And the user clicks on "<internationalTransactionGuide>" link
    Then the user verifies that the current PageTitle contains '<internationalTransactionGuide>'
    And international guide opens correctly
  Examples:
    | internationalTransactionGuide                                |
    | Joint Ventures International Transaction Guide               |
    | Private Company Acquisitions International Transaction Guide |
    | Sales and Marketing International Transaction Guide          |

  Scenario: verify content of transactions tab
    When the user selects "Transactions" tab
    And the list of links is present below the "Popular international resources" header
    And all "Popular international resources" links opens correctly
    And the list of links is present below the "International collections" header
    And all "International collections" links opens correctly

  Scenario: verify View all PL standard documents and clauses link
    When the user clicks on "View all PL standard documents and clauses" link
    Then the document opens correctly
    Then document title is displayed as "Standard documents, clauses and drafting notes"

  Scenario: verify content of countries tab
    When the user selects "Countries" tab
    Then the "Country essentials" header is displayed
    And the list of countries includes the following countries
      | Argentina          |
      | Australia          |
      | Austria            |
      | Brazil             |
      | Canada             |
      | China              |
      | France             |
      | Germany            |
      | Hong Kong          |
      | India              |
      | Indonesia          |
      | Italy              |
      | Japan              |
      | Mexico             |
      | Norway             |
      | Russian Federation |
      | Singapore          |
      | South Africa       |
      | South Korea        |
      | Spain              |
      | Sweden             |
      | Switzerland        |
      | Turkey             |
      | United States      |
    When the user clicks on "View all" link
    Then the user verifies that the current PageTitle contains 'All countries'

  Scenario Outline: verify content of countries in the countries tab
    When the user selects "Countries" tab
    When the user clicks on "<country>" link
    Then the user verifies that the current PageTitle contains '<country>'
  Examples:
    | country   |
    | Germany   |
    | Indonesia |
    | Brazil    |
    | Argentina |

  Scenario Outline: verify links in International subscriptions section in the countries tab
    When the user selects "Countries" tab and clicks on "<link>" link in "International subscriptions" section
    And the user clicks on Continue button
    Then the user is taken to the "<webSite>" web site in the same window and tab
  Examples:
    | link   | webSite                                     |
    | Canada | ca.practicallaw.com                         |
    | China  | thomsonreuters.com/Browse/Home/Global/China |
    | UK     | thomsonreuters.com/Browse/Home/Home         |
    | US     | westlaw.com                                 |

  Scenario Outline: verify links in International practice areas section in the countries tab
    When the user selects "Countries" tab and clicks on "<link>" link in "International practice areas" section
    Then the user verifies that the current PageTitle contains '<link>'
  Examples:
    | link        |
    | Arbitration |
    | EU Law      |
    | Competition |

  Scenario Outline: verify content of global guides tab
    When the user selects "Global guides" tab
    Then the list of global guides is present as below
      | Agricultural Law                                                 |
      | Arbitration                                                      |
      | Capital Markets                                                  |
      | Cartel Leniency                                                  |
      | Competition: Merger Control                                      |
      | Competition: Restraints of Trade and Dominance                   |
      | Construction and Projects                                        |
      | Corporate Governance and Directors' Duties                       |
      | Corporate Real Estate                                            |
      | Data Protection                                                  |
      | Digital Business                                                 |
      | Dispute Resolution                                               |
      | Distribution and Marketing of Drugs                              |
      | Doing Business in...                                             |
      | Employee Share Plans                                             |
      | Employment and Employee Benefits                                 |
      | Energy and Natural Resources                                     |
      | Enforcement of Arbitral Awards                                   |
      | Enforcement of Judgments                                         |
      | Environment                                                      |
      | Establishing a Business in...                                    |
      | Family Law                                                       |
      | Finance                                                          |
      | Financial and Business Crime                                     |
      | Insurance and Reinsurance                                        |
      | International Insolvency: Group Insolvency and Directors' Duties |
      | International Trade and Commercial Transactions                  |
      | Investing in...                                                  |
      | Investment Funds                                                 |
      | IP in Business Transactions                                      |
      | Joint Ventures                                                   |
      | Life Sciences                                                    |
      | Outsourcing                                                      |
      | Pensions                                                         |
      | Private Client                                                   |
      | Private Equity and Venture Capital                               |
      | Private Mergers and Acquisitions                                 |
      | Public Mergers and Acquisitions                                  |
      | Public Procurement                                               |
      | Restructuring and Insolvency                                     |
      | Shareholders' Rights in Private and Public Companies             |
      | Structured Finance and Securitisation                            |
      | Tax on Transactions                                              |
    And the user clicks on "<link>" link
    Then the user verifies that the current PageTitle contains '<internationalTransactionGuide>'
  Examples:
    | link             | internationalTransactionGuide |
    | Agricultural Law | Agricultural Law Global Guide |
    | Arbitration      | Arbitration Global Guide      |
