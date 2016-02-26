Feature: As a PL+ User I want to view more that 300 links in Content reffering section grouped by document type in Primary source page

  Scenario Outline: The primary source document contain more than 300 links in Content reffering section grouped by document type
    Given PL+ user is logged in
    When the user opens document with <GUID> guid
    Then the user click on View Document button
    Then the document opens correctly
    Then the user see "Content referring to this primary source" jump link in the left hand side navigation panel
    When the user clicks on "Content referring to this primary source" jump link
    And the user sees the number of links found
    And this number more than "300"
    When the user scrolled to the bottom of the document
    Then the user sees Show more "Show more..." link
    When the user clicks on Show more "Show more..." link
    Then the number of displayed links equals to the number of results found
  Examples:
    | GUID                              |
    | I35a6e3dd53d011e498db8b09b4f043e0 |
