Feature: [CLW039] Verify links to external urls for the Sample documents

  Scenario Outline: For the sample Knowhow doc, Standard document, Country doc, Case Tracker, Whats Market doc verify the forward linking
    Given the "<PLC document>" of type "<PLC document TYPE>" exists on Novus platform
    And for "<PLC document>" I get all the external links in PLC XML
    And capture all the external links in the Novus document content
    Then for "<PLC document>" the total number of external links should be the equal
  Examples:
    | PLC document TYPE        | PLC document |
    | Practice Note            | 1-580-0745   |
    | Legal Update             | 9-606-5528   |
    | External resource        | 7-516-0749   |
    | Standard Document        | 6-376-3125   |
    | Drafting Note            | 7-376-3200   |
    | Standard Clause          | 7-517-2182   |
    | Ask document             | a-008-4220   |
    | Practice Note - Overview | 1-519-0278   |
