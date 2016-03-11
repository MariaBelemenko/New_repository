Feature: [838717][839947] As a PL+ User, I want to to view the pagination of my search result
  So that I can identify which page of search results I am viewing

  Background:
    Given PL+ user is logged in

  Scenario Outline: [838717][839947] User checks the Pagination of GP and China search results.
    When the user selects "International" tab and clicks on "<link>" link in "International subscriptions" section
    Then the Category Page opens correctly
    When the user runs a free text search for the query "tax"
    And the user selects the "20" from per page dropdown
    Then the user verifies that page "1" is selected
    And the user is able to verify the presence of page number "2"
    And the user is able to select the link to the next page
    And the user is able to verify the presence of page number "1"
    And the user is able to select the link to page "1"
    And the user is able to verify the presence of page number "2"
  Examples:
    | link   |
    | Global |
    | China  |

  Scenario: [838717] User checks the first and last page in Pagination of GP search results.
    When the user selects "International" tab and clicks on "Global" link in "International subscriptions" section
    Then the Category Page opens correctly
    When the user runs a free text search for the query "tax"
    And the user selects the "20" from per page dropdown
    Then the user verifies that page "1" is selected
    And the user verifies the search results count "10,000"
    And the user is able to verify the presence of below page numbers
      | 2 |
      | 3 |
      | 4 |
      | 5 |
      | 6 |
      | 7 |
      | 8 |
      | 9 |
    And user verifies the "Last Page" present
    And user verifies the navigation to "First Page" not present
    When user clicks on "7" link
    And user verifies the "First Page" present
    And user verifies the "Last Page" present
    When clicks on the "Last Page" pagination link
    Then user verifies the navigation to "Last Page" not present
    And user verifies the "First Page" present
