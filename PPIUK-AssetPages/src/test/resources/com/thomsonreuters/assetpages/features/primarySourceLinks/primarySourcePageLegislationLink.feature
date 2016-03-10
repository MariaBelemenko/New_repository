Feature: [789994] As a PL+ User I want to view links to�Legislation.gov.uk on the primary source page

  Scenario Outline: [789994] The primary source documents contains links to�Legislation
    Given PL+ user is logged in
    When the user opens document with <GUID> guid
    Then the document opens correctly
    Then the user see links to "Legislation.gov.uk" Legislation
    When the user click on "Legislation.gov.uk" Legislation link
    Then the user is taken to "legislation.gov.uk" resource
  Examples:
    | GUID                              |
    | I8127783d52a011e598dc8b09b4f043e0 |