@wip
Feature: [710510] casesDefaultOperator.feature
  As a PL+ User with a WLUK Subscription I want the default search operator to be an "And" when I type in two or more values (e.g. school holiday = school & holiday)
  So that I can ensure the results returned are relevant to my search criteria("And" operator will be the default search operator)

  Background: Log on to test site
    Given PL+ user is logged in
    And user selects the combined Know How UK link

  Scenario Outline: verify that the default search operator is 'and'
    And user clicks on UK CASES
    When the user runs a free text search for the query "<query>"
    And the user gets the search result count and stores it as count "1"
    And the user runs a free text search for the query "<query2>"
    And the user gets the search result count and stores it as count "2"
    And the user verifies that the search result count "1" is less than "2"
  Examples:
    | query                 | query2               |
    | rihanna and copyright | rihanna or copyright |
    | rihanna copyright     | rihanna or copyright |

  Scenario Outline: verify that results for an "and" search comprise all search terms (includes the scenario where no "and" is included in the query)
    And user clicks on UK CASES
    When the user runs a free text search for the query "<query>"
    Then the user can select the option to show most detail
    Then the user is able to verify that for result "<rank>" the search term "<highlightedTerm>" is highlighted within the case result text
    Then the user is able to verify that for result "<rank>" the search term "<highlightedTerm2>" is highlighted within the case result text
  Examples:
    | query                   | rank | highlightedTerm | highlightedTerm2 |
    | contract and acceptance | 1    | contract        | acceptance       |
    | contract acceptance     | 1    | contract        | acceptance       |
