Feature: As a PL+ User I want to see Top button

  Scenario Outline: The case documents contain Top button
    Given PL+ user is logged in
    When the user opens document with <GUID> guid
    Then the user click on View Document button
    Then the document opens correctly
    Then apply document settings
    When the user scrolled to the bottom of the document
    Then the user see Top button
    When the user click on Top button
    Then the user scrolled to the top of the document
  Examples:
    | GUID                              |
    | Ieda8cc31f27711e498db8b09b4f043e0 |
    | I984ef7626cf011e498db8b09b4f043e0 |