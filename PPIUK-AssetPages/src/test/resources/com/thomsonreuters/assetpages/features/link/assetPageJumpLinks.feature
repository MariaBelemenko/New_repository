Feature: As a PL+ User I want to select a Links to this case and jump to that part of the document
  As a PL+ User I do not want to see a Links to this case and Links to this case section

  Background:
    Given PL+ user is logged in with following details
      | userName | Asset_page_one |

  Scenario Outline: The case documents contain Links to this case jump link in the left hand side navigation panel
    When the user opens document with <GUID> guid
    Then the user click on View Document button
    Then the document opens correctly
    Then the user see "Legal updates on this case" jump link in the left hand side navigation panel
    When the user clicks on "Legal updates on this case" jump link
    Then the user is taken to selected part of the document
  Examples:
    | GUID                              |
    | I984f1d3b6cf011e498db8b09b4f043e0 |
    | I984f1d8d6cf011e498db8b09b4f043e0 |
    | I984f1dad6cf011e498db8b09b4f043e0 |

  Scenario Outline: The case documents does not contain Links to this case and does not contaion Links to this case section
    When the user opens document with <GUID> guid
    Then the user click on View Document button
    Then the document opens correctly
    Then the user does not see "Legal updates on this case" jump link
    When the user does not see "Legal updates on this case" section
  Examples:
    | GUID                              |
    | I949641a853c711e598dc8b09b4f043e0 |
