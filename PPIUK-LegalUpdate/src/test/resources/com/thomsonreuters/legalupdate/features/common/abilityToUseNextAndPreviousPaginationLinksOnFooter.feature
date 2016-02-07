Feature: The ability to use the Next and previous pagination links on the Footer so that I can navigate to other pages of search results.

  Scenario Outline: Use the Next and previous pagination links on the Footer so that I can navigate to other pages of search results.
    Given PL+ user is logged in with following details
      | userName | LU_AutoUser |
    And a user is on a legal updates results page "/LegalUpdates/Practice/1-379-8575"
    And a user is on legal updates results page number "<initial page number>"
    And the page navigation links are displayed either side of the page numbers
    When the user clicks on "<page arrow>"
    Then the user should navigate to the page "<destination page>" of results
  Examples:
    | initial page number | page arrow | destination page |
    | 1                   | >          | 2                |
    | 1                   | >>         | >>               |
    | 9                   | <          | 8                |
    | 9                   | <<         | <<               |
