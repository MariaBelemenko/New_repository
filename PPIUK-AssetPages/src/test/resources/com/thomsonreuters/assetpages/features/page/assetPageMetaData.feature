Feature: As a PL+ User I want to view the meta data relating to a case asset page
  As a PL+ User I want does not want to see Division in case asset page
  As a PL+ User I want does not want to see Court in case asset page

  Background:
    Given PL+ user is logged in

  Scenario Outline: The case documents contain the case metadata in the right hand side of the central column
    When the user opens document with <GUID> guid
    Then the user click on View Document button
    Then the document opens correctly
    And the user see the case metadata in the right hand side of the central column
    And the user see the "Resource Type " Resource type
    And the user see the "Court" Court name
    And the user see the "Date" Date
    And the user see citations it has been reported "Where Reported"
    And the user see the "Division" Division
    And the user see the "Jurisdiction of court" Jurisdiction
  Examples:
    | GUID                              |
    | I984ef7626cf011e498db8b09b4f043e0 |
    | I984ef77b6cf011e498db8b09b4f043e0 |

  Scenario Outline: The case documents does not contain Division
    When the user opens document with <GUID> guid
    Then the user click on View Document button
    Then the document opens correctly
    And the user see the case metadata in the right hand side of the central column
    And the user doesn not see the "Division" Division
  Examples:
    | GUID                              |
    | Ieda8cc31f27711e498db8b09b4f043e0 |
    | I984f1d486cf011e498db8b09b4f043e0 |

  Scenario Outline: The case documents does not contain Court
    When the user opens document with <GUID> guid
    Then the user click on View Document button
    Then the document opens correctly
    And the user see the case metadata in the right hand side of the central column
    And the user does not see the "Court" Court
  Examples:
    | GUID                              |
    | I984f1d8d6cf011e498db8b09b4f043e0 |
    | Ib96f28826cf311e498db8b09b4f043e0 |

  Scenario Outline: The case documents does not contain Court
    When the user opens document with <GUID> guid
    Then the user click on View Document button
    Then the document opens correctly
    And the user see the case metadata in the right hand side of the central column
    And the user see "Specialist court" Specialist court
    And the user see Specialist court value
  Examples:
    | GUID                              |
    | I984f1e8a6cf011e498db8b09b4f043e0 |
    | I984f1f176cf011e498db8b09b4f043e0 |
