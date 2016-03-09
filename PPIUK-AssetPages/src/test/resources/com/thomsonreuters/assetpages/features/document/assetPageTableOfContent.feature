Feature: As a PL+ User I want to view and hide the Table of content

  Scenario Outline: The case documents contain Table of content
    Given PL+ user is logged in
    When the user opens document with <GUID> guid
    Then the document opens correctly
    Then the user see Table of content
    When the user click on "Table of Contents" Table of content
    Then the Table of content will hide
    When the user click on "Table of Contents" Table of content
    Then the user see Table of content
  Examples:
    | GUID                              |
    | Ieda8cc31f27711e498db8b09b4f043e0 |
    | I984ef7606cf011e498db8b09b4f043e0 |
    | I984ef7626cf011e498db8b09b4f043e0 |