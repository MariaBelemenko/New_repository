Feature: As a PL+ User I want to view links in Links according with classname and hrefAtribute

  Scenario Outline: The case documents contain links in Links to this case section
    Given PL+ user is logged in
    When the user opens document with <GUID> guid
    Then the user click on View Document button
    Then the document opens correctly
    And the document contain "<links>" links
    And these "<links>" displayed accoding with className and hrefAtribute
  Examples:
    | GUID                              | links      |
    | I0d6a093d6cf411e498db8b09b4f043e0 | Bailii     |
    | I0d6a093d6cf411e498db8b09b4f043e0 | Westlaw UK |
    | I984ef7396cf011e498db8b09b4f043e0 | Bailii     |
    | I984ef7396cf011e498db8b09b4f043e0 | Westlaw UK |
      
