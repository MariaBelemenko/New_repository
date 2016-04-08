@bug
Feature: As a PL+ User I want to select a menu item and jump to that part of the document

  # 825936: RDDBUG: "Links to this primary source" jump link doesn't work correctly
  Scenario Outline: [790161] The case documents contain Links to this case jump link in the left hand side navigation panel
    Given PL+ user is logged in
    When the user opens document with <GUID> guid
    Then the user click on View Document button
    Then the document opens correctly
    Then text added to the document
    Then the user see "Links to this primary source" jump link in the left hand side navigation panel
    When the user clicks on "Links to this primary source" jump link
    Then the user is taken to selected part of the document
  Examples:
    | GUID                              |
    | I67915bc263a911e598dc8b09b4f043e0 |
    | I6905aad063a911e598dc8b09b4f043e0 |
    | I6905aae363a911e598dc8b09b4f043e0 |
    | I8127783d52a011e598dc8b09b4f043e0 |