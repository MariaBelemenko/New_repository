@wip
Feature: [799682] As a PL+ User I want to see that the primary source documents saves in the history

  Scenario Outline: [799682] As a PL+ User I want to see that the primary source documents saves in the history
    Given PL+ user is logged in
    When API cleans all folders and history and user relogs in
    And the user opens document with <GUID> guid
    Then the document opens correctly
    Then the user store title and URL of primary source document
    Then the user sees the "<link>" link
    When the user clicks on this "<link>" link
    Then the user is taken from primary source page to internal document
    Then the user store title and URL of now how document
    When the user clicks on 'History' link on the header
    When the user clicks on 'Documents' tab on the History page
    Then the '1' link contains the document title and href of know how document
    Then the '2' link contains the document title and href of primary source document
  Examples:
    | GUID                              | link                                   |
    | I67915bae63a911e598dc8b09b4f043e0 | Company accounts and reports: overview |
