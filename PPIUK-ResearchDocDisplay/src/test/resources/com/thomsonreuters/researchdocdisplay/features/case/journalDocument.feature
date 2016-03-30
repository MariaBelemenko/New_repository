@wip
Feature: I want to view notes in Full Text content

  Background:
    Given PL+ user is logged in with following details
      | routing          | ASK |
      | mandatoryRouting | YES |

  Scenario Outline: Journal document contain Footnotes
    When the user opens document with <document1> guid
    Then the user click on View Document button
    Then the document opens correctly
    And the user see "Footnotes" footnotes
    Then the user see footnote number within the footnotes section
    When the user clicks on a footnote number within the footnotes section
    Then the user taken to that part of the document
    Then the user see footnote within the document
    When the user clicks on a footnote within the document
    Then the light box appears
    And the note text "Footnote 55" appears
  Examples:
    | document1                         |
    | I34E2F2309C0711E4ABBBADAAA4F7D653 |
    | I36564230FDB811E4ABD6CBDDF2736E09 |
    | I89CC49B0FA9711E49CDBA95B00781B0C |

  Scenario Outline: Journal document contain internal links in Footnotes
    When the user opens document with <document2> guid
    Then the user click on View Document button
    Then the document opens correctly
    And footnote contains links to other internal documents
    When the user selects a link
    Then the user will be taken to the internal document
    When the user returns to the previous page
    Then the user see footnote number within the footnotes section
    When the user clicks on a footnote number within the footnotes section
    Then the user taken to that part of the document
    Then the user see footnote within the document
    When the user clicks on a footnote within the document
    Then the light box appears
    And the light box note contains internal links to other documents
    When the user selects a link in light box
    Then the user will be taken to the internal document
  Examples:
    | document2                         |
    | I34E2F2309C0711E4ABBBADAAA4F7D653 |
