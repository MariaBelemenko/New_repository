Feature: [702210][713886] ukKnowHowSearchResultsPerPage
  1)ukKnowHowSearchResultsPerPageS2-28.feature -  As  a PL+ user I should be able to select from the options available to me the total number of results displayed per page
  2)ukKnowHowSearchResultTotal.feature - Verify total results on the search results page

  Background: Log on to test site
    Given PL+ user is logged in

  Scenario Outline: [702210] As  a PL+ user I should be able to select from the options available to me the total number of results displayed per page
    And the user runs a free text search for the query "<query>"
    When the user selects the option to display "<number>" of results per page
    Then the user is able to verify the presence of text confirming that results "<results>" are displayed on the page
    And the user is able to verify the presence of know how search result "<rank>"
  Examples:
    | number       | query    | results | rank |
    | 20 per page  | contract | 1 - 20  | 20   |
    | 50 per page  | contract | 1 - 50  | 50   |
    | 100 per page | contract | 1 - 100 | 100  |

  Scenario:[713886] Verify total results on the search results page
    When the user runs a free text search for the query "tax"
    When the user selects the option to display "50 per page" of results per page
    Then the user can verify that the search result total contains text confirming that the specified number "50" of results are displayed

  Scenario: Verify page numbering and navigation options on know how search results page
    And the user runs a free text search for the query "law"
    And the user verifies the presence of page number "1"
    And the user verifies that page "1" is selected
    And the user verifies the presence of a next page navigation arrow
    And the user verifies the presence of a last page navigation arrow
    And the user selects page number "9"
    And the user verifies that page "9" is selected
    And the user verifies the presence of a previous page navigation arrow
    And the user verifies the presence of a first page navigation arrow
    And the user selects the next page navigation arrow
    And the user verifies that page "10" is selected
    And the user selects the previous page navigation arrow
    And the user verifies that page "9" is selected
    And the user selects the first page navigation arrow
    And the user verifies that page "1" is selected
    And the user selects page number "9"
    And the user selects the last page navigation arrow
    And the user pauses for "8" seconds
    And the user verifies that the next page navigation arrow is no longer displayed
    And the user verifies that the last page navigation arrow is no longer displayed
    And the user selects the first page navigation arrow
    And the user pauses for "8" seconds
    And the user verifies that the previous page navigation arrow is no longer displayed
    And the user verifies that the first page navigation arrow is no longer displayed

  Scenario: Verify page numbering and navigation options on know how practice area search results page
    And has selected the link to the practice area "Construction"
    And the user runs a free text search for the query "law"
    And the user verifies the presence of page number "1"
    And the user verifies that page "1" is selected
    And the user verifies the presence of a next page navigation arrow
    And the user verifies the presence of a last page navigation arrow
    And the user selects page number "9"
    And the user verifies that page "9" is selected
    And the user verifies the presence of a previous page navigation arrow
    And the user verifies the presence of a first page navigation arrow
    And the user selects the next page navigation arrow
    And the user verifies that page "10" is selected
    And the user selects the previous page navigation arrow
    And the user verifies that page "9" is selected
    And the user selects the first page navigation arrow
    And the user verifies that page "1" is selected
    And the user selects page number "9"
    And the user selects the last page navigation arrow
    And the user pauses for "8" seconds
    And the user verifies that the next page navigation arrow is no longer displayed
    And the user verifies that the last page navigation arrow is no longer displayed
    And the user selects the first page navigation arrow
    And the user pauses for "8" seconds
    And the user verifies that the previous page navigation arrow is no longer displayed
    And the user verifies that the first page navigation arrow is no longer displayed
