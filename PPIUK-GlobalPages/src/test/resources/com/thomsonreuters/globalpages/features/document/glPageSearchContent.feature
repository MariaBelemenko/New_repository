Feature: [834018] As a PL+ User I can run a search from the header search bar and rearch result will unclude PLUK PLUS PLCA PLCh PLAUS content

  Scenario Outline: The user can run a search and results returned include PLUK PLUS PLCA PLCh PLAUS content
    Given PL+ user is logged in with following details
      | routing          | BETA |
      | mandatoryRouting | YES  |
    When the user navigates to the Global Page
    Then the Global Page opens correctly
    And the user runs a free text search for the query "<Document title>"
    When the user clicks link '<Document title>' on 'search' page
    Then the document opens correctly
    And the document coded to "<Practice Area>" Practice Area
  Examples:
    | Document title                                                                      | Practice Area |
    | China updates tax regime for sale of offshore holding companies                     | China         |
    | Managing an ill or injured employee: challenging a medical certificate: quick guide | PL Australia  |
    | Finance Act 2015: diverted profits tax                                              | PLC UK        |
    | Auction Timeline                                                                    | PL Canada     |
    | Reform of the 2001 Brussels Regulation: tracker                                     | PLC US        |
