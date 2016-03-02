Feature: PL+ WLUK user want to view the party names and aliases of the case participants

  Background:
    Given PL+ user is logged in with following details
      | routing          | ASK |
      | mandatoryRouting | YES |

  Scenario Outline: The case documents contain party names
    When the user opens document with <GUID> guid
    Then the document opens correctly
    And the party names are displayed
  Examples:
    | GUID                              |
    | IBE054C30399911DCB27FFE1C1BCE7676 |
    | IC27756E01A8D11E58F5C98C910793DB8 |

  Scenario Outline: The case documents contain party names
    When the user opens document with <aliasesGuid> guid
    Then the user click on View Document button
    Then the document opens correctly
    And the party names are displayed
    Then the alias party names are displayed
  Examples:
    | aliasesGuid                       |
    | I4C068AF0F0E011DCA6E2BE3BAAB09C4B |
    | I33E1D220101411DCADF9829FC0255391 |
    | IB4853D008C2D11DCA378AF31B759E020 |
