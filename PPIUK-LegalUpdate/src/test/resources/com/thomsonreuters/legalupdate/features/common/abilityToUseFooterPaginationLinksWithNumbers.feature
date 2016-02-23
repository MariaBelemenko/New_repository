Feature: The ability to use the pagination links on the Footer so that I can navigate to other pages of search results

  Scenario Outline: I want to use the pagination links on the Footer so that I can navigate to other pages of search results
    Given PL+ user is logged in
    And a user is on a legal updates results page
    And a user is on legal updates results page number "<initial page number>"
    And the pagination links display the number of results pages
    When the user clicks on page number "<destination page number>"
    Then the user should navigate to page "<destination page number>" of results
  Examples:
    | initial page number |  | destination page number |
    | 1                   |  | 2                       |
    | 1                   |  | 3                       |
    | 3                   |  | 1                       |

  Scenario Outline: I want to use the pagination links on the Footer so that I can navigate to other pages of search results
    Given PL+ user is logged in
    Given a user navigate to a "Insurance" Topic page from a "Construction" Practice Area page
    When the user clicks on the 'View all' link of the LU widget
    And a user is on legal updates results page number "<initial page number>"
    And the pagination links display the number of results pages
    When the user clicks on page number "<destination page number>"
    Then the user should navigate to page "<destination page number>" of results
  Examples:
    | initial page number |  | destination page number |
    | 1                   |  | 2                       |
    | 1                   |  | 3                       |
    | 3                   |  | 1                       |
