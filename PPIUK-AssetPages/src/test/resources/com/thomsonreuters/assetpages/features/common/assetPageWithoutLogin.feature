Feature: As as the user is not logged in PL+ I want to view case asset page documents and primary source document

  Scenario Outline: The case assert documents opens without login
    When the user opens document with <GUID> guid
    Then the user click on View Document button
    Then the document opens correctly
  Examples:
    | GUID                              |
    | Ieda8cc31f27711e498db8b09b4f043e0 |
    | I984ef7606cf011e498db8b09b4f043e0 |
    | I6905aae963a911e598dc8b09b4f043e0 |
