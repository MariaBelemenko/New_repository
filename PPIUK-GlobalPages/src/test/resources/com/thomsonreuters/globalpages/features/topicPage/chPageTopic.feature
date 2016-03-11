Feature: [839952] As a PL+ User, I am able to browse to the China page and see a list of links to China Topics

  Background:
    Given PL+ user is logged in
    And the user navigates to the main PLCUK page
    When the user selects "International" tab and clicks on "China" link in "International subscriptions" section
    Then the Category Page opens correctly

  Scenario Outline: verify topic pages
    Then the "Corporate, FDI and M&A" header is displayed
    And the user clicks on "<topic>" link
    Then the user verifies that the current PageTitle contains '<title>'
    Then the resources sections are displayed on the topic page
    Then the following icons are disabled
      | Email          |
      | Print          |
      | Download       |
      | Save to Folder |
    And the user clicks on "<link>" link
    Then the document opens correctly
  Examples:
    | topic                                | title                                | link                                                       |
    | Anti-bribery and anti-corruption     | Anti-bribery and anti-corruption     | Quick guide: Bribery and corruption toolkit                |
    | Arbitration and dispute resolution   | Arbitration and dispute resolution   | Training and competence: requirements for authorised firms |
    | Commercial contracts and boilerplate | Commercial contracts and boilerplate | Advertising country questions: China                       |
    | Employment and benefits              | Employment and benefits              | Quick guide: Employment toolkit                            |
    | Finance                              | Finance                              | Performance guarantee                                      |
    | Intellectual property                | Intellectual property (IP)           | Chinese company names                                      |
    | Real estate                          | Real estate                          | Obtaining land use rights in China: overview               |
    | Corporate governance                 | Corporate governance                 | Chinese company names                                      |
    | Foreign direct investment            | Foreign direct investment (FDI)      | Choosing a lawyer for your China deal                      |
    | Free trade zones                     | Free trade zones (FTZs)              | China (Shanghai) Pilot Free Trade Zone: overview           |
    | Mergers & acquisitions               | Mergers & acquisitions (M&A)         | Choosing a lawyer for your China deal                      |

  Scenario Outline: verify legal updates widget in the china topic pages
    And the user clicks on "<topic>" link
    Then the user should see 5 updates on a "Legal Updates" widget
    And "Legal Updates" widget should display publication dates of documents
    And the "Legal Updates" dates are sorted in reverse chronological order
    When the user clicks on the 'View all' link of the "Legal Updates" widget
    Then the user should be taken to the "<topic>" Topic LU results list
    Then the user should be presented with a list of LU documents
    And the user should see first five updates same as on widget
  Examples:
    | topic                            |
    | Anti-bribery and anti-corruption |
    | Real estate                      |
    | Corporate governance             |

  Scenario Outline: verify the search by topic
    And the user clicks on "<link>" link
    And the user runs a free text search for the query "document"
    And the user can open the first know how search result "<number>" and get document guid
    Then the document opens correctly
    And the document belongs to "<topic>" topic
  Examples:
    | link                               | number | topic                                    |
    | Anti-bribery and anti-corruption   | 1      | China\Anti-bribery and anti-corruption   |
    | Arbitration and dispute resolution | 2      | China\Arbitration and dispute resolution |
    | Employment and benefits            | 3      | China\Employment and benefits            |
    | Finance                            | 4      | China\Finance                            |
