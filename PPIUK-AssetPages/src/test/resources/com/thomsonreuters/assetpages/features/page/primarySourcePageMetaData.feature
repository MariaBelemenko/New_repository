Feature: As a PL+ User I want to see the Legislation metadata in the right hand side of the central column
  As a PL+ User I want to see the Jurisdiction in Legislation metadata in the right hand side of the central column

  Background:
    Given PL+ user is logged in

  Scenario Outline: The primary source documents contain metadata
    When the user opens document with <GUID> guid
    Then the document opens correctly
    And the metadata is displayed in the right hand side of the central column
    And the metadata contains "Resource Type"
    And the metadata contains "Maintained"
  Examples:
    | GUID                              |
    | I6905ab2e63a911e598dc8b09b4f043e0 |
    | I6905ab3163a911e598dc8b09b4f043e0 |
    | I8127783d52a011e598dc8b09b4f043e0 |

  Scenario Outline: The primary source documents contain jurisdiction
    When the user opens document with <GUID> guid
    Then the document opens correctly
    And the metadata is displayed in the right hand side of the central column
    And the metadata contains "Jurisdiction"
  Examples:
    | GUID                              |
    | I2f49c89c574211e598dc8b09b4f043e0 |

  Scenario Outline: The primary source documents contain jurisdictions
    When the user opens document with <GUID> guid
    Then the document opens correctly
    And the metadata is displayed in the right hand side of the central column
    And the metadata contains "Jurisdiction"
    And the "Jurisdictions" Jurisdictions contain more than one jurisdiction
  Examples:
    | GUID                              |
    | I2537ebdb63f011e598dc8b09b4f043e0 |
    | I48c5fd4553d211e498db8b09b4f043e0 |
    | I2537ebed63f011e598dc8b09b4f043e0 |
