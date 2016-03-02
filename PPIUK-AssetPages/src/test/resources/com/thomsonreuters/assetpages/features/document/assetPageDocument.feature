Feature: As a PL+ User I want to see the party names
  As a PL+ User I want to see the case page

  Background:
    Given PL+ user is logged in

  Scenario Outline: The case documents contain party names
    When the user opens document with <GUID> guid
    Then the user click on View Document button
    Then the document opens correctly
    Then the party names is displayed in assert page
  Examples:
    | GUID                              |
    | I984f1d406cf011e498db8b09b4f043e0 |
    | I984f1d556cf011e498db8b09b4f043e0 |
    | I984ef7626cf011e498db8b09b4f043e0 |

  Scenario Outline: The case documents contain case page
    When the user opens document with <GUID> guid
    Then the user click on View Document button
    Then the document opens correctly
    Then the Case page "Case page" is displayed in assert page
  Examples:
    | GUID                              |
    | I984f1d566cf011e498db8b09b4f043e0 |
    | I984f1dad6cf011e498db8b09b4f043e0 |
    | I984ef7626cf011e498db8b09b4f043e0 |

  Scenario Outline: The asset pages have correct title
    When the user opens document with <GUID> guid
    Then the user click on View Document button
    Then the document opens correctly
    Then the party names is displayed in assert page
    And the asset page has title
    And the title include party names
  Examples:
    | GUID                              |
    | I984f1d566cf011e498db8b09b4f043e0 |
    | I984f1d8d6cf011e498db8b09b4f043e0 |
    | I8ca3a4eb65a211e598dc8b09b4f043e0 |
