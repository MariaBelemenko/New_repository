Feature: As a User
  I am able to run search and filter by China topic

  Background:
    Given PL+ user is logged in with following details
      | userName | GlPage_UK1 |
    And the user navigates to the main PLCUK page
    When the user selects "International" tab and clicks on "China" link in "International subscriptions" section
    Then the Category Page opens correctly

  Scenario Outline: verify filter by china topic
    And the user runs a free text search for the query "<query>"
    Then the "Practice Area" section includes only "China" topics
      | Anti-bribery and anti-corruption     |
      | Arbitration and dispute resolution   |
      | Commercial contracts and boilerplate |
      | Corporate, FDI and M&A               |
      | Corporate governance                 |
      | Foreign direct investment (FDI)      |
      | Free trade zones (FTZs)              |
      | Mergers & acquisitions (M&A)         |
      | Employment and benefits              |
      | Finance                              |
      | Intellectual property (IP)           |
      | Real estate                          |
    And the user selects the know how following parent facets with single selection
      | <facet> |
    Then the user verifies that the know how following facet is selected and their count is equal to total count
      | <facet> |
    And the user can open the first know how search result "<number>" and get document guid
    Then the document opens correctly
    And the document belongs to "<topic>" topic
  Examples:
    | query | facet                                | number | topic                                      |
    | tag   | Commercial contracts and boilerplate | 1      | China\Commercial contracts and boilerplate |
    | tax   | Employment and benefits              | 2      | China\Employment and benefits              |
