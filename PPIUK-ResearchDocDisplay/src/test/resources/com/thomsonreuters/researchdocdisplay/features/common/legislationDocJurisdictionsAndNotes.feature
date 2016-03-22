Feature: As a PL+ User I want to view one or many jurisdictions and amendment notes and links with lightbox

  Background: 
    Given PL+ user is logged in

  Scenario Outline: [777142] The legislation document contains jurisdictions
    When the user opens document with <GUID> guid
    When the user clicks on "View Document" link
    Then the document opens correctly
    When the user clicks on "<jurisdiction>" link
    Then the user is taken to the "<jurisdiction>" part of the document
    When the user clicks on "<interal>" link
    And the user clicks on "View Document" link
    Then the document opens correctly

    Examples: 
      | GUID                              | jurisdiction                                  | internal         |
      | I338C4FF0E44911DA8D70A0E70A78ED65 | Northern Ireland                              | Sch.27(1) para.1 |
      | I05DC825127A511E197D193A320D3C975 | England, Scotland, Wales and Northern Ireland | Pt 2 s.20(2)     |

  Scenario Outline: [777142] The legislation document contains notes
    When the user opens document with <GUID> guid
    When the user clicks on "View Document" link
    Then the document opens correctly
    When the user clicks on "Amendments" link
    Then the user is taken to the "Amendments" part of the document
    And the notes have numbers and description
    When the user clicks on "<link>" in "Amendments" section
    When the user clicks on "View Document" link
    Then the document opens correctly

    Examples: 
      | GUID                              | link             |
      | I338C4FF0E44911DA8D70A0E70A78ED65 | Sch.27(1) para.1 |
      | I33B7CCC0E44911DA8D70A0E70A78ED65 | Sch.27(1) para.1 |
      | I05DC825127A511E197D193A320D3C975 | Pt 2 s.20(2)     |

