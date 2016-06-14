Feature: [638469][637926] searchFromSpecificRegion.feature
  This feature covers tests for the following stories:
  [638469], [637926]

  Scenario Outline: Search from <region> site retrieves <region> resources
    Given PL+ user is logged in
    When has selected the Know How - <region> link
    And the user runs a free text search for the query "<query>"
    And the user can open the first know how search result "1"
    Then it is clear to the user that results are restricted to Global content because the product details contain at least one of the following categories
  Examples:
    | region | query                          |
    | UK     | cloud computing                |
    | US     | hostile takeovers and defences |