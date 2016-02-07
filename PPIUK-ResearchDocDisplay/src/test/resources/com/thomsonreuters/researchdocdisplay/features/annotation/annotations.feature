Feature: As a PL+ User I want to view and hide annotations

  Scenario Outline: The document contain hide annotations
    Given PL+ user is logged in
    When the user opens document with <GUID> guid
    Then the user click on View Document button
    Then the document opens correctly
    And the provision has "Annotated Statutes" annotations
    When the user navigates to annotations section
    Then "Annotated Statutes" annotations will be displayed by default
    Then show and hide link is displayed as part of annotations header
    When the user selects option to annotation
    Then annotations will be hidden
    When the user selects option to annotation
    Then annotations will be displayed
  Examples:
    | GUID                              |
    | I8D8B2760E44E11DA8D70A0E70A78ED65 |
    | I338C4FF0E44911DA8D70A0E70A78ED65 |
    | I1AEE75F069FB11E3A64C9C652D1D8F6C |
