Feature: The document contains modifications

  Background:
    Given PL+ user is logged in

  Scenario Outline: Document contains modifications
    When the user opens document with <GUID> guid
    Then the user click on View Document button
    Then the document opens correctly
    Then the user see modifications on document
    Then modifications contain internal links to other documents
    When the user clicks on one of those links
    Then the user will be taken to the selected document
  Examples:
    | GUID                              |
    | I338C4FF0E44911DA8D70A0E70A78ED65 |
    | I81A5A5917A0711DE82FFE2E60A4C5A45 |
    | I05DC825127A511E197D193A320D3C975 |

  Scenario Outline: Document contains annotated statutes
    When the user opens document with <GUID> guid
    Then the user click on View Document button
    Then the document opens correctly
    And the "Annotated Statutes" menu link is present
    When the user click on "Annotated Statutes" menu link
    Then the usee see the "Annotated Statutes" text
  Examples:
    | GUID                              |
    | I338C4FF0E44911DA8D70A0E70A78ED65 |
    | I1AEE75F069FB11E3A64C9C652D1D8F6C |
    | I634790A0D9A211E2A7399744A15A9ECB |
    | IBEA9A630693111E38326ED868108EF62 |
    | I05DC825127A511E197D193A320D3C975 |
    | IC6F7B713491811DFA52897A37C152D8C |
    | I1AEE75F069FB11E3A64C9C652D1D8F6C |
