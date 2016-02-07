Feature: Enhance all PL content with w target attribute

  Scenario Outline: Verify the Cite query attribute for the W-target-preference value in the Novus XML version
    Given the "<PLC document>" of type "<PLC document TYPE>" exists on Novus platform
    Then I verify the cite.query attribute for the w-target-preference for "<PLC document>"
  Examples:
    | PLC document TYPE        | PLC document |
    | Practice Note            | 9-376-4010   |
    | Practice Note            | 3-596-5405   |
    | Practice Note - Overview | 7-203-1181   |
    | Ask document             | a-008-4220   |
    | Legal Update             | 9-606-5528   |
    | Standard Document        | 6-376-3125   |
    | Standard Clause          | 3-210-4966   |
    | Case Tracker             | 8-102-3365   |
    | Country QA               | 2-521-5400   |
    | External resource        | 7-516-0749   |
    | Cross border             | 6-502-0189   |
