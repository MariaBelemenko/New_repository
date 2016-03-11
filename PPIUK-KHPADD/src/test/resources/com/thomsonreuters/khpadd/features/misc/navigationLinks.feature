@manual
Feature: [730586] Verify resource history and related content link
  I want: to see navigation links on the right hand column
  So that: I can navigate to the resource history and related content

  Scenario: Verification of Jump link in the document for view resource history and view related content
    Given PL+ user is logged in
    When user navigates directly to document with guid "I020627b21cb611e38578f7ccc38dcbee"
    When the user clicks on the View Resource History link on right hand panel
    Then the user is taken to the "Resource History" box at the bottom of the resource page

  Scenario: Verification of Jump link in the document for view related content
    Given PL+ user is logged in
    When user navigates directly to document with guid "I020627b21cb611e38578f7ccc38dcbee"
    When the user clicks on the View Related Content link on right hand panel
    Then the user is taken to the "Related Content" box at the bottom of the resource page

  Scenario: [781797] Verification of linking to the right section in a document
    Given PL+ user is logged in
    When user navigates directly to document with guid "I33f1056de8cd11e398db8b09b4f043e0"
    And the user clicks on the first drafting note in this document
    When user clicks on the link "Practice note, Pre-action protocols: an overview: Consequences of non-compliance with pre-action protocols."
    Then the user is navigated to the right section in the above practice note document
