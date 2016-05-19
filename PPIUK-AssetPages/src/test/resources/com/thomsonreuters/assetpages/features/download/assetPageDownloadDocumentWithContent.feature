Feature: As a PL+ User I want to download pdf document
  and view Content referring to this case in downloaded document

  Scenario Outline: [798569] [818357] The user download pdf document and view Content referring to this case in downloaded document
    Given PL+ user is logged in
    When the user opens document with <GUID> guid
    Then the user click on View Document button
    Then the document opens correctly
    Then the user see Download icon in delivery options in right hand side
    When the user click on Download icon
    And the user click on the "Content to Append" tab
    Then the user see the "Related AssetPage References" check box
    When the user click on "Related AssetPage References" check box
    And the user click on the "Basic" tab
    Then document download with content references
    And the downloaded document contain "Content referring to this case" section
  Examples:
    | GUID                              |
    | I984ef7606cf011e498db8b09b4f043e0 |
    | I984ef7626cf011e498db8b09b4f043e0 |
    | I984f1d556cf011e498db8b09b4f043e0 |
