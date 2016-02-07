Feature: As a PL+ User I want to select a provision jump link and go to that part of the document

  Scenario Outline: The provision contains one or many jump links
    Given PL+ user is logged in
    When the user opens document with <GUID> guid
    Then the user click on View Document button
    Then the document opens correctly
    And the user see "Amendments" jump link
    When the user clicks on "Amendments" jump links
    Then the user redirected to that part of the document.
  Examples:
    | GUID                              |
    | I338C4FF0E44911DA8D70A0E70A78ED65 |
    | I33B7CCC0E44911DA8D70A0E70A78ED65 |
    | IC6FAC450491811DFA52897A37C152D8C |
    | I05DC825127A511E197D193A320D3C975 |
