Feature: As a PL+ User I want to see the Legislation metadata in the right hand side of the central column
  As a PL+ User I want to see the Jurisdiction in Legislation metadata in the right hand side of the central column

  Background:
    Given PL+ user is logged in with following details
      | userName | Asset_page_one |

  Scenario Outline: The primary source documents contain metadata
    When the user opens document with <GUID> guid
    Then the user click on View Document button
    Then the document opens correctly
    Then the user see the Legislation metadata in the right hand side of the central column
    And the user see "Resource Type" resource type
    And The user sees "Maintained" status
  Examples:
    | GUID                              |
    | I6905ab2e63a911e598dc8b09b4f043e0 |
    | I6905ab3163a911e598dc8b09b4f043e0 |
    | I6905ab4863a911e598dc8b09b4f043e0 |
    | I8127783d52a011e598dc8b09b4f043e0 |

  Scenario Outline: The primary source documents contain jurisdiction
    When the user opens document with <GUID> guid
    Then the user click on View Document button
    Then the document opens correctly
    Then the user see the Legislation metadata in the right hand side of the central column
    And the user see "Jurisdiction" jurisdiction
    And the user sees the content of "Jurisdiction" jurisdiction
  Examples:
    | GUID                              |
    | I2f49c89c574211e598dc8b09b4f043e0 |

  Scenario Outline: The primary source documents contain jurisdictions
    When the user opens document with <GUID> guid
    Then the user click on View Document button
    Then the document opens correctly
    Then the user see the Legislation metadata in the right hand side of the central column
    Then the user see "Jurisdictions" jurisdictions
    And the user sees the content of "Jurisdictions" jurisdictions
    And the "Jurisdictions" Jurisdictions contain more than one jurisdiction
  Examples:
    | GUID                              |
    | I2537ebdb63f011e598dc8b09b4f043e0 |
    | I48c5fd4553d211e498db8b09b4f043e0 |
    | I2537ebed63f011e598dc8b09b4f043e0 |
