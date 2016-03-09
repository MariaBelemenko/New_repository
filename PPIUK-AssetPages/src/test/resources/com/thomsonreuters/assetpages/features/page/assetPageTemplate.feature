Feature: As a PL+ User I want to see Where Reported and Where Reported list in right hand side menu
  As a PL+ User I do not want to see End of Document
  As a PL+ User I want to see Resource Type and Count

  Background:
    Given PL+ user is logged in

  Scenario Outline: The case documents contain Where Reported list
    When the user opens document with <GUID> guid
    Then the user click on View Document button
    Then the document opens correctly
    And the metadata is displayed in the right hand side of the central column
    And the metadata contains "Where Reported"
    And the user see Where Reported list
  Examples:
    | GUID                              |
    | I984f1e2b6cf011e498db8b09b4f043e0 |
    | I984ef7626cf011e498db8b09b4f043e0 |

  Scenario Outline: The case documents does not contain End of Document
    When the user opens document with <GUID> guid
    Then the user click on View Document button
    Then the document opens correctly
    Then the document contain class with case-asset-doc
    Then the document contain content body
    And the content body contain end of document
    And the end of document does not contain text
  Examples:
    | GUID                              |
    | I984ef7766cf011e498db8b09b4f043e0 |
    | I984f1d556cf011e498db8b09b4f043e0 |

  Scenario Outline: The case documents contain Resource Type and Count
    When the user opens document with <GUID> guid
    Then the user click on View Document button
    Then the document opens correctly
    And the metadata is displayed in the right hand side of the central column
    And the metadata contains "Resource Type"
    And the metadata contains "Court"
  Examples:
    | GUID                              |
    | I984f1de46cf011e498db8b09b4f043e0 |
    | I984f1d556cf011e498db8b09b4f043e0 |
