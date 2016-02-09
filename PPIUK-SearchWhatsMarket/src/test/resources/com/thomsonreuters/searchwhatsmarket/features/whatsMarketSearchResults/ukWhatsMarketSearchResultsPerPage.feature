Feature: [no story] ukWhatsMarketSearchResultsPerPage.feature

  Background: Log on to test site
    Given PL+ user is logged in with following details
        | userName          | Search2_AutoUser       |
        | newSession        | TRUE                   |
    And the user selects the link entitled Whats Market UK Home

  Scenario Outline: As a PL+ user I should be able to select from the options available to me the total number of results displayed per page
    And the user runs a free text search for the query "<query>"
    When the user selects the option to display "<number>" of results per page
    Then the user is able to verify the presence of text confirming that results "<results>" are displayed on the page
    And the user is able to verify the presence of whats market search result "<rank>"
    Examples:
      | number       | query    | results | rank |
      | 20 per page  | contract | 1 - 20  | 20   |
      | 50 per page  | contract | 1 - 50  | 50   |
      | 100 per page | contract | 1 - 100 | 100  |

  Scenario: Verify total results on the search results page for whats market
    When the user runs a free text search for the query "tax"
    When the user selects the option to display "50 per page" of results per page
    Then the user can verify that the search result total contains text confirming that the specified number "50" of results are displayed

  Scenario: Verify page numbering and navigation options on whats market search results page
    And the user runs a free text search for the query "law or order or civil or criminal"
    And the user verifies the presence of page number "1"
    And the user verifies that page "1" is selected
    And the user verifies the presence of a next page navigation arrow
    And the user verifies the presence of a last page navigation arrow
    And the user selects page number "8"
    And the user verifies that page "8" is selected
    And the user selects the next page navigation arrow
    And the user verifies that page "9" is selected
    And the user selects the previous page navigation arrow
    And the user verifies that page "8" is selected
    And the user selects the first page navigation arrow
    And the user verifies that page "1" is selected
    And the user selects page number "5"
    And the user selects the last page navigation arrow
    And the user verifies the presence of a previous page navigation arrow
    And the user verifies the presence of a first page navigation arrow
    And the user verifies that the next page navigation arrow is no longer displayed
    And the user verifies that the last page navigation arrow is no longer displayed
    And the user selects the first page navigation arrow
    And the user verifies that the previous page navigation arrow is no longer displayed
    And the user verifies that the first page navigation arrow is no longer displayed

  Scenario: Verify page numbering and navigation options on whats market topic area search results page
    And has selected the link to "AGMs: FTSE 350"
    And the user runs a free text search for the query "law or order or civil or criminal"
    And the user verifies the presence of page number "1"
    And the user verifies that page "1" is selected
    And the user verifies the presence of a next page navigation arrow
    And the user verifies the presence of a last page navigation arrow
    And the user selects page number "7"
    And the user verifies that page "7" is selected
    And the user verifies the presence of a previous page navigation arrow
    And the user verifies the presence of a first page navigation arrow
    And the user selects the next page navigation arrow
    And the user verifies that page "8" is selected
    And the user selects the previous page navigation arrow
    And the user verifies that page "7" is selected
    And the user selects the first page navigation arrow
    And the user verifies that page "1" is selected
    And the user selects page number "9"
    And the user selects the last page navigation arrow
    And the user verifies that the next page navigation arrow is no longer displayed
    And the user verifies that the last page navigation arrow is no longer displayed
    And the user selects the first page navigation arrow
    And the user verifies that the previous page navigation arrow is no longer displayed
    And the user verifies that the first page navigation arrow is no longer displayed
