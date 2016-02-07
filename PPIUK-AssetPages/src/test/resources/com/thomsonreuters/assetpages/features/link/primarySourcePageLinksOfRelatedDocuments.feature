@e2e @prod
Feature: As a PL+ User I want to view list of Related documents grouped by document type

  Scenario Outline: The primary source document contain list of Related documents grouped by document type
    Given PL+ user is logged in with following details
      | userName | Asset_page_one |
    When the user opens document with <GUID> guid
    Then the user click on View Document button
    Then the document opens correctly
    Then the user see "Content referring to this primary source" jump link in the left hand side navigation panel
    When the user clicks on "Content referring to this primary source" jump link
    Then the user sees the "<link>" link
    And this link "<link>" belong to document "<type>" type
    When the user clicks on this "<link>" link
    Then the user is taken from primary source page to internal document
  Examples:
    | GUID                              | link                                       | type                       |
    | I6905aae963a911e598dc8b09b4f043e0 | Corporate restructuring: debt equity swaps | UK Practice Note Overviews |
    | I405a58d853d111e498db8b09b4f043e0 | Comfort letter: binding                    | UK Standard Documents      |
    | I67915bfd63a911e598dc8b09b4f043e0 | Electronic communications: checklist       | UK Checklists              |
