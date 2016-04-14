@wip
Feature: [710510] legislationDefaultOperator.feature
  "And" operator will be the default search operator

  Background: Log on to test site
    Given PL+ user is logged in
    And user selects the combined Know How UK link

  Scenario Outline: verify that the default search operator is 'and'
    And user clicks on UK Legislation
    When the user runs a free text search for the query "<query>"
    And the user gets the legislation search result count and stores it as count "1"
    And the user runs a free text search for the query "<query2>"
    And the user gets the legislation search result count and stores it as count "2"
    And the user verifies that the legislation search result count "1" is less than "2"
  Examples:
    | query              | query2            |
    | dangerous and dogs | dangerous or dogs |
    | dangerous dogs     | dangerous or dogs |

  Scenario Outline: verify that results for an "and" search comprise all search terms (includes the scenario where no "and" is included in the query)
    And user clicks on UK CASES
    When the user runs a free text search for the query "<query>"
    Then the user can select the option to show most detail
    Then the user is able to verify that for result "<rank>" the search term "<highlightedTerm>" is highlighted within the legislation result text
    Then the user is able to verify that for result "<rank>" the search term "<highlightedTerm2>" is highlighted within the legislation result text
  Examples:
    | query              | rank | highlightedTerm | highlightedTerm2 |
    | dangerous and dogs | 4    | dangerous       | dogs             |
    | dangerous dogs     | 5    | dangerous       | dogs             |
