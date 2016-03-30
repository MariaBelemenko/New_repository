@wip
Feature: View Images in Full Text content

  Scenario Outline: View Images in documents
    Given PL+ user is logged in
    When the user opens document with <GUID> guid
    Then the document opens correctly
    Then the user see title of opened document
    Then the document contains images
    Then the user see <number> images on document
  Examples:
    | GUID                              | number |
    | I34E2F2309C0711E4ABBBADAAA4F7D653 | 4      |