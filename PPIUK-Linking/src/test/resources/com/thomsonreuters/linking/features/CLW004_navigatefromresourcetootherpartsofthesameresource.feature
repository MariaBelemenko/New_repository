Feature: Verify links from resource to other parts of the same resource (jumplinks)

  Scenario Outline: For the sample doc verify the jump linking
    Given the "<PLC document>" of type "<PLC document TYPE>" exists on Novus platform
    And for "<PLC document>" I get all the jump links from the Fatwire xml
    And user captures the jump links in the Novus main document xml
    Then for "<PLC document>" the number of jump links should be the equal
  Examples:
    | PLC document TYPE               | PLC document |
    | Practice Note                   | 9-376-4010   |
    | Practice Note - Overview        | 7-203-1181   |
    | Ask document                    | a-008-4220   |
    | Legal Update                    | 9-606-5528   |
    | US practice note double coded   | 6-502-0189   |
    | Country QA                      | 2-521-5400   |
    | Legislation Primary Source page | 4-505-6037   |
    | Binary Content                  | 3-525-2190   |

  @manual
  Scenario: For the sample standard document verify the jump linking
    Given the standard document 6-376-3125 exists on Novus platform
    And I get all the jump links and links to other plc docs in the standard document
    And I get all the links of the corresponding GUID on Novus
    When i compare them
    Then the jumplinks should be equal

  @manual
  Scenario: For the sample standard clause verify the jump linking
    Given the standard clause 3-210-4966 exists on Novus platform
    And I get all the links in the standard document
    And I get all the links of the corresponding GUID on Novus
    When i compare them
    Then the jumplinks should be equal
