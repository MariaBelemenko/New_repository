Feature: [CLW004a] Verify the related content info

  Scenario Outline: For the sample docs verify the related content
    Given for "<PLC document>" I get the related content from Fatwire XML
    When for "<PLC document>" I get the NORM relations
    Then the related Content number should be equal
  Examples:
    | PLC document TYPE             | PLC document |
    | Standard Clause               | 7-517-2182   |
    | Country QA                    | 3-502-1557   |
    | Practice Note - Overview      | 7-203-1181   |
    | Ask document                  | a-008-4220   |
    | Legal Update                  | 9-606-5528   |
    | Standard Clause               | 3-210-4966   |
    | Country QA                    | 2-521-5400   |
    | External resource             | 7-516-0749   |
    | Binary Content                | 3-525-2190   |
    | US practice note double coded | 6-502-0189   |
