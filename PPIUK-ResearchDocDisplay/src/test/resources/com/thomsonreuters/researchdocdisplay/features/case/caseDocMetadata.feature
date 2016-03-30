Feature: As a PL+ User I want to view the metadoc information for a case documents

  Background: 
    Given PL+ user is logged in

  Scenario Outline: [742452] case document contains metadata
    When the user opens document with <GUID> guid
    When the user clicks on "View Document" link
    Then the document opens correctly
    And the metadata is displayed in the right hand side of the central column
    And the metadata contains "Where Reported"
    And the metadata contains "Hearing Dates"
    And the metadata contains "Counsel"

    Examples: 
      | GUID                              |
      | I79273E60A8EF11E0888FEF03F0EFCF17 |
      | I65D353E0B03111E1A9C0890F1F61FF5D |


  Scenario Outline: [784754] User can view the metadoc information for a case
    When the user opens document with <GUID> guid
    When the user clicks on "View Document" link
    Then the document opens correctly
    And the left hand navigation menu is displayed
    And the content column is displayed
    And the metadata is displayed in the right hand side of the central column
    And delivery options are displayed
    And the status icon is displayed
    And the status description is displayed
    And the metadata contains "Court"
    And the metadata contains "Date"
    And the metadata contains "Where Reported"
    And the metadata contains "Hearing Dates"
    And the metadata contains "Appellate committee"

    Examples: 
      | GUID                              | 
      | I79273E60A8EF11E0888FEF03F0EFCF17 | 
      | I65D353E0B03111E1A9C0890F1F61FF5D |
      | IE8146150B21311E49FBB8F994A94F811 |
      | IA77ABBF0A43711E0BAE6C7A444C8F8F8 |
