Feature: As a PL+ User I want to view list of other provisions

  Scenario Outline: The asset page documents contain links to other provisions
    Given PL+ user is logged in
    When the user opens document with <GUID> guid
    Then the user click on View Document button
    Then the document opens correctly
    Then the user sees "To view the other provisions relating to this primary source, see:" section
    Then the user sees "<link1>" in "To view the other provisions relating to this primary source, see:" other provisions section
    When the user clicks on this "<link1>" link
    Then the document opens correctly
  Examples:
    | GUID                              | link1                                      |
    | I8127783d52a011e598dc8b09b4f043e0 | Family Procedure Rules 2010 (SI 2010/2955) |
    | I6905ab3b63a911e598dc8b09b4f043e0 | Financial Services and Markets Act 2000    |
    | I6905aae963a911e598dc8b09b4f043e0 | Financial Services and Markets Act 2000    |
