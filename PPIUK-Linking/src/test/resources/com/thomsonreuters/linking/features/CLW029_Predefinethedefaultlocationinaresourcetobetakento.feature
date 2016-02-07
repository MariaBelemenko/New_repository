Feature: Verify navigate from resource to other resource or specific section of other resource

  Scenario Outline: For the sample doc verify the linking to other resource or specific section of other resource
    Given the "<PLC document>" of type "<PLC document TYPE>" exists on Novus platform
    And for "<PLC document>" I get all the links to other resource or specific section of other resource
    And for "<PLC document>" I get all the Primary Source links
    When for "<PLC document>" captures all the links to other resource or specific section of other resource
    Then for "<PLC document>" the number of links should be the equal
  Examples:
    | PLC document TYPE        | PLC document |
    | Practice Note            | 1-580-0745   |
    | Practice Note - Overview | 1-519-0278   |
    | Legal Update             | 9-606-5528   |
    | Standard Clause          | 7-517-2182   |
    | Case Tracker             | 8-102-3365   |
    | External resource        | 7-516-0749   |
    | Ask document             | a-008-4220   |

  Scenario Outline: For the Sample Practice Note verify the What's Market Links
    Given the "<WhatsMarketPLCref>" of type "PracticeNote" exists on Novus platform
    When the user gets all the Whats Market links for "<WhatsMarketPLCref>"
    Then for "<GUID>" the Whats Market links should have w-target-preference wmref
    And the WhatsMarket Links should be equal
  Examples:
    | WhatsMarketPLCref | GUID                              |
    | 8-525-5855        | Ib5556cd7e83211e398db8b09b4f043e0 |
    | 0-615-8065        | Iff36e07109f211e598db8b09b4f043e0 |
    | 7-502-0730        | I21063f73ef0811e28578f7ccc38dcbee |