Feature: As a PL+ User I want to see primary source document
  As a PL+ User I want to see the primary source title

  Background:
    Given PL+ user is logged in

  Scenario Outline: Document opens correctly
    When the user opens document with <GUID> guid
    Then the document opens correctly
  Examples:
    | GUID                              |
    | I6905aafa63a911e598dc8b09b4f043e0 |
    | I6905ab0663a911e598dc8b09b4f043e0 |
    | I6905ab1063a911e598dc8b09b4f043e0 |
    | I8127783d52a011e598dc8b09b4f043e0 |
    | I2f49c89c574211e598dc8b09b4f043e0 |

  Scenario Outline: The title displayed in primary source document
    When the user opens document with <GUID> guid
    Then the document opens correctly
    Then the primary source title is displayed
  Examples:
    | GUID                              |
    | I6905ab1563a911e598dc8b09b4f043e0 |
    | I6905ab1763a911e598dc8b09b4f043e0 |
    | I6905ab2063a911e598dc8b09b4f043e0 |
    | I8127783d52a011e598dc8b09b4f043e0 |
