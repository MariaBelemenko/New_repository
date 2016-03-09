Feature: Date corresponds to the correct format

  Background:
    Given PL+ user is logged in

  Scenario Outline: Document has correct date
    When the user opens document with <GUID> guid
    Then the user click on View Document button
    Then the document opens correctly
    And the document contains date in "dd MMMM yyyy" format
    
  Examples:
    | GUID                              |
    | I79273E60A8EF11E0888FEF03F0EFCF17 |
    | I65D353E0B03111E1A9C0890F1F61FF5D |
    | IE8146150B21311E49FBB8F994A94F811 |
    | IA77ABBF0A43711E0BAE6C7A444C8F8F8 |

  Scenario Outline: Document consist alias party names
    When the user opens document with <GUID> guid
    Then the user click on View Document button
    Then the document opens correctly
    Then the party names is displayed on document
    Then the user see alias party names
  Examples:
    | GUID                              |
    | I35E25AC0F92311DB9045877B5F5EF663 |

  Scenario Outline: Document consist party names
    When the user opens document with <GUID> guid
    Then the user click on View Document button
    Then the document opens correctly
    Then the party names is displayed on document
  Examples:
    | GUID                              |
    | I79273E60A8EF11E0888FEF03F0EFCF17 |
    | I65D353E0B03111E1A9C0890F1F61FF5D |
    | IE8146150B21311E49FBB8F994A94F811 |
    | IA77ABBF0A43711E0BAE6C7A444C8F8F8 |

  Scenario Outline: The case documents contain judgement navigation menu is disabled
    When the user opens document with <GUID> guid
    Then the user click on View Document button
    Then the document opens correctly
    Then the user see the "Judgment" judgment menu
    And the "Judgment" judgement navigation menu is disabled
  Examples:
    | GUID                              |
    | I79273E60A8EF11E0888FEF03F0EFCF17 |
    | I65D353E0B03111E1A9C0890F1F61FF5D |
    | IE8146150B21311E49FBB8F994A94F811 |
    | IA77ABBF0A43711E0BAE6C7A444C8F8F8 |

  @wip 
  Scenario Outline: case document contains metadata
    When the user opens document with <GUID> guid
    Then the user click on View Document button
    Then the document opens correctly
    And the metadata is displayed in the right hand side of the central column
    And the metadata contains "Where Reported" 
    And the metadata contains "Hearing Dates"
    And the metadata contains "Counsel"
    #And the user see pdf images
    #And the user see a column for the left hand navigation
    #And the user see the meta content on the document
    #And the user see the delivery options
    #And the judgement doucument consist that document in PDF
    #When the user selects the Judgement PDF
    #Then a PDF copy of the Judgement is downloaded
    #When the user opens document with <footNoteGuid> guid
    #Then the user see "Footnotes" footnotes
  Examples:
    | GUID                              |
    | I79273E60A8EF11E0888FEF03F0EFCF17 |
    | I65D353E0B03111E1A9C0890F1F61FF5D |
    | IA77ABBF0A43711E0BAE6C7A444C8F8F8 |
    | IE8146150B21311E49FBB8F994A94F811 |
