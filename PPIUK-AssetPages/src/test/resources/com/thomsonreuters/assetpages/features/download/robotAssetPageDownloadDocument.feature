@wip
Feature: As a PL+ User I want to download asset page document in different formats
  As a PL+ User I want to download asset page document with table of content
  As a PL+ User I want to download the asset page document and see right number of bullets

  Background:
    Given PL+ user is logged in

  Scenario Outline: The user download document in different formats
    When the user opens document with <GUID> guid
    Then the user click on View Document button
    Then the document opens correctly
    Then the user see Download icon in delivery options in right hand side
    When the user click on Download icon
    Then download document in "<extension>" extension
  Examples:
    | GUID                              | extension |
    | I984ef7626cf011e498db8b09b4f043e0 | pdf       |
    | I6905aae963a911e598dc8b09b4f043e0 | doc       |
    | I67915bfe63a911e598dc8b09b4f043e0 | rtf       |

  Scenario Outline: The user download document include table of content
    When the user opens document with <GUID> guid
    Then the user click on View Document button
    Then the document opens correctly
    Then the user see "<linkInTableOfContent>" jump link in the left hand side navigation panel
    Then the user see Download icon in delivery options in right hand side
    When the user click on Download icon
    Then download document in "pdf" extension
    And downloaded document contain "<linkInTableOfContent>" link
  Examples:
    | GUID                              | linkInTableOfContent         |
    | I3890f315651511e598dc8b09b4f043e0 | Links to this primary source |
    | I79546a1cc1c911e498db8b09b4f043e0 | Links to this primary source |
    | I023b5f2853d211e498db8b09b4f043e0 | Links to this primary source |

  Scenario Outline: The user downloaded document contain right number of bullets
    When the user opens document with <GUID> guid
    Then the user click on View Document button
    Then the document opens correctly
    Then the user see Download icon in delivery options in right hand side
    When the user click on Download icon
    Then download document in "rtf" extension
    And downloaded document contains the right number of bullets
  Examples:
    | GUID                              |
    | I984f1d556cf011e498db8b09b4f043e0 |
