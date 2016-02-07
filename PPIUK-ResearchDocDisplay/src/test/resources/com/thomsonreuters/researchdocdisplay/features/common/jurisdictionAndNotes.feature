Feature: As a PL+ User I want to view one or many jurisdictions and amendment notes and links with lightbox

  Scenario Outline: The provision contains two or more jurisdictions
    Given PL+ user is logged in
    When the user opens document with <GUID> guid
    Then the user click on View Document button
    Then the document opens correctly
    And the user the user will see the jurisdictions listed in the left hand navigation column
    When the user selects a jurisdiction
    Then the user is taken to that part of the document
    And the document contain internal links to other documents
    When the user clicks on one of interlan links
    Then the user will be taken to the internal document
  Examples:
    | GUID                              |
    | I338C4FF0E44911DA8D70A0E70A78ED65 |
    | I05DC825127A511E197D193A320D3C975 |

  Scenario Outline: The provision contains notes
    Given PL+ user is logged in
    When the user opens document with <GUID> guid
    Then the user click on View Document button
    Then the document opens correctly
    And the user see the "Amendments" amendments on document
    When the user views the "Amendments" amendments
    Then the user see notes in the amendments section
    And each note have a number and description
    And the note description contains links to internal documents
    When the user clicks on one of interlan links
    Then the user will be taken to the internal document
  Examples:
    | GUID                              |
    | I338C4FF0E44911DA8D70A0E70A78ED65 |
    | I33B7CCC0E44911DA8D70A0E70A78ED65 |
    | I05DC825127A511E197D193A320D3C975 |

  Scenario Outline: The provision contains links with lightbox
    Given PL+ user is logged in
    When the user opens document with <GUID> guid
    Then the user click on View Document button
    Then the document opens correctly
    When the mouse move on footnote reference
    Then a lightbox will appear
    And the text "Footnote 1" will be displayed to the users
    And the light box contains links to internal documents
    When the user click on the link
    Then the user will be taken to the internal document
  Examples:
    | GUID                              |
    | I338C4FF0E44911DA8D70A0E70A78ED65 |
