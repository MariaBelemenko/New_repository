@bug
Feature: [789816] As a PL+ User I want to view celex links on the case asset page

  Background:
    Given PL+ user is logged in

  #809166 [REGRESSION]-RDDBUG: celex links looks like hard coded links
  Scenario Outline: [789816] The case assert documents contains celex links
    When the user opens document with <GUID> guid
    Then the user click on View Document button
    Then the document opens correctly
    Then the user see celex links "EUR-Lex"
    When the user click on celex link "EUR-Lex"
  Examples:
    | GUID                              |
    | I949641a853c711e598dc8b09b4f043e0 |
    | Ib96f286b6cf311e498db8b09b4f043e0 |
    | Ia8def2ff533611e598dc8b09b4f043e0 |
