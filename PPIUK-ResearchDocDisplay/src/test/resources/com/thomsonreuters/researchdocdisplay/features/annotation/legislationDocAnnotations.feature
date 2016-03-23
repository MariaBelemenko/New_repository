Feature: As a PL+ User I want to view and hide annotations

  Background: 
    Given PL+ user is logged in

  Scenario Outline: [742433] The document contain hide annotations
    When the user opens document with <GUID> guid
    When the user clicks on "View Document" link
    Then the document opens correctly
    When the user clicks on "Annotated Statutes" link
    Then the user is taken to the "Annotated Statutes" part of the document
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
