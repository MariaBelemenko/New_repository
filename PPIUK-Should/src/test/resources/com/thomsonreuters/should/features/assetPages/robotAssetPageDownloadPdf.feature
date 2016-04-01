Feature: [805839] As a PL+ User I want to view links to Westlaw UK and Bailii on downloaded from PL+ pdf document
  [798569] As a PL+ User I want to download pdf document and view Content referring to this case in downloaded document

  Background: 
    Given PL+ user is logged in

  # 876559:[REGRESSION] Bailii / Westlaw UK links are broken in the delivered document
  @bug
  Scenario Outline: [805839] The user download pdf document
    When the user opens document with <GUID> guid
    Then the document opens correctly
    Then the user see links to "Bailii" Bailii
    Then the user see link to "Westlaw UK" Westlaw UK
    Then the user see Download icon in delivery options in right hand side
    When the user click on Download icon
    Then download document in "pdf" extension
    And the downloaded PDF document contain hyperlink to "Bailii" Bailii
    And the downloaded PDF document contain hyperlink to "Westlaw UK" Westlaw UK

    Examples: 
      | GUID                              |
      | I984f1fea6cf011e498db8b09b4f043e0 |
      | I984ef7626cf011e498db8b09b4f043e0 |
