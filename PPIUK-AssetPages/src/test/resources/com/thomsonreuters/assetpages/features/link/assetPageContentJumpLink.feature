Feature: [788452] [805752] [818597] As a PL+ User I want to select Content referring to this case link and jump to that part of the document
  As a PL+ User I do not want to see  Content referring to this case link and Content referring to this case link section

  Background:
    Given PL+ user is logged in

  @usmanh 
  Scenario Outline: [788452] [825918] The case documents contain jump links in the left hand side navigation panel
    When the user opens document with <GUID> guid
    Then the document opens correctly
    Then text added to the document
    Then the user see "Content referring to this case" jump link in the left hand side navigation panel
    When the user clicks on "Content referring to this case" jump link
    Then the user is taken to the "Content referring to this case" part of the document
  Examples:
    | GUID                              |
    | I984ef7606cf011e498db8b09b4f043e0 |
    | I984ef7626cf011e498db8b09b4f043e0 |

  Scenario Outline: [788452] The case documents does not contain Content referring to this case link and does not contaion Content referring to this case section
    When the user opens document with <GUID> guid
    Then the document opens correctly
    Then the user does not see "Content referring to this case" jump link
    When the user does not see "Content referring to this case" section
  Examples:
    | GUID                              |
    | I984f1fc96cf011e498db8b09b4f043e0 |
    | Ib9aa3e441c9a11e38578f7ccc38dcbee |
