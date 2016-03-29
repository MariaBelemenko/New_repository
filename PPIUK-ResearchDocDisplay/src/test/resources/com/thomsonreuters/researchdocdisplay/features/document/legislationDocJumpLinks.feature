Feature: As a PL+ User I want to select a jump link and go to that part of the document

  Scenario Outline: [777146] The provision contains one or many jump links
    Given PL+ user is logged in
    When the user opens document with <GUID> guid
    When the user clicks on "View Document" link
    Then the document opens correctly
    And the table of contents is displayed
    When the user clicks on "Amendments" link
    Then the user is taken to the "Amendments" part of the document
    When the user clicks on "Annotated Statutes" link
    Then the user is taken to the "Annotated Statutes" part of the document

  Examples:
    | GUID                              |
    | I338C4FF0E44911DA8D70A0E70A78ED65 |
    | IC6FAC450491811DFA52897A37C152D8C |
    | I05DC825127A511E197D193A320D3C975 |
