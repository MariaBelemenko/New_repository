Feature: As a PL+ User I want to view sorted links by document types in primary source pages

  Scenario Outline: The primary source document contain sorted links by document types
    Given PL+ user is logged in
    When the user opens document with <GUID> guid
    Then the user click on View Document button
    Then the document opens correctly
    Then the user see "Content referring to this primary source" jump link in the left hand side navigation panel
    When the user clicks on "Content referring to this primary source" jump link
    Then the user sees "<docType1>" type of document
    And links of "<docType1>" type of document are sorted alphabetically
    Then the user sees "<docType2>" type of document below "<docType1>"
    And links of "<docType2>" type of document are sorted alphabetically
    Then the user sees "<docType3>" type of document below "<docType2>"
    And links of "<docType3>" type of document are sorted alphabetically
    Then the user sees "<docType4>" type of document below "<docType3>"
    And links of "<docType4>" type of document are sorted alphabetically

    Examples: 
      | GUID                              | docType1              | docType2            | docType3          | docType4                   |
      | I405a58d853d111e498db8b09b4f043e0 | UK Standard Documents | UK Standard Clauses | UK Drafting Notes | Legal Update (Case Report) |
      | I96ee510f7a3a11e498db8b09b4f043e0 | UK Standard Clauses   | UK Drafting Notes   | UK Checklists     | Legal Update (Archive)     |
