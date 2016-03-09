Feature: [818351] As a PL+ User I want to view list of Related documents grouped by document type

  Background: 
    Given PL+ user is logged in

  Scenario Outline: [818351] The primary source document contain list of Related documents grouped by document type
    When the user opens document with <GUID> guid
    Then the document opens correctly
    Then the user see "Content referring to this primary source" jump link in the left hand side navigation panel
    When the user clicks on "Content referring to this primary source" jump link
    Then the user sees the "<link>" link
    And this link "<link>" belong to document "<type>" type
    When the user clicks on this "<link>" link
    Then the document opens correctly

    Examples: 
      | GUID                              | link                                       | type                  |
      | I405a58d853d111e498db8b09b4f043e0 | Comfort letter: binding                    | UK Standard Documents |
      | I67915bfd63a911e598dc8b09b4f043e0 | Electronic communications: checklist       | UK Checklists         |
