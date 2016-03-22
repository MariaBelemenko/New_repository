Feature: As a PL+ User I want to view one or many jurisdictions and amendment notes and links with lightbox

  Background: 
    Given PL+ user is logged in

  Scenario Outline: [777142] The provision contains links with lightbox
    When the user opens document with <GUID> guid
    When the user clicks on "View Document" link
    Then the document opens correctly
    When the mouse moves on "<number>" footnote reference
    And the "<text>" is displayed in the lightbox
    When the user selects "<link in footnote>"
    Then the document opens correctly

    Examples: 
      | GUID                              | text              | link in footnote | number |
      | I338C4FF0E44911DA8D70A0E70A78ED65 | Footnote <number> | Sch.27(1) para.1 | 1      |
