Feature: Practice Area Search
  This feature covers tests for the following stories:
  [638471]

  @e2e
  Scenario Outline: Search for KH Content for PLC UK <productArea> and verify search results
    Given PL+ user is logged in with following details
      | userName          | Search1_AutoUser       |
    And has selected the link to the practice area "<practicearea>"
    And the user runs a free text search for the query "<query>"
    And the user can open the first know how search result "<resultPosition>"
    And the user verifies that the product detail contains the practice area "<productArea>"
  Examples:
    | practicearea       | query     | resultPosition | productArea               |
    | Corporate          | children  | 4              | PLC UK Corporate          |
    | Financial Services | fund      | 2              | PLC UK Financial Services |
    | Pensions           | fund      | 1              | PLC UK Pensions           |
