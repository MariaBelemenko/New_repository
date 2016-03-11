Feature: [838717][839947] As a PL+ User, I want to to view the page number for my search result
  So that I can identify which page of search results I am viewing

  Scenario Outline: [838717][839947] User checks the Rer page appearance for Global page and China search results
    Given PL+ user is not logged in
    And the user navigates to the main PLCUK page
    When the user selects "International" tab and clicks on "<link>" link in "International subscriptions" section
    Then the Category Page opens correctly
    When the user runs a free text search for the query "tax"
    And the user selects the "<results>" from per page dropdown
    Then the user should be seeing "<results>" per page
    Then the user sees '<interval>' search result count
  Examples:
    | results | interval | link   |
    | 20      | 1-20     | Global |
    | 50      | 1-50     | Global |
    | 100     | 1-100    | Global |
    | 20      | 1-20     | China  |
    | 50      | 1-50     | China  |
    | 100     | 1-100    | China  |
