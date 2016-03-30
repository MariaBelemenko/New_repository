Feature: The document contains modifications

  Background: 
    Given PL+ user is logged in

  Scenario Outline: [777144] Document contains modifications
    When the user opens document with <GUID> guid
    When the user clicks on "View Document" link
    Then the document opens correctly
    And the table of contents is displayed
    When the user clicks on "Modifications" link
    Then the user is taken to the "Modifications" part of the document
    And the internal links are displayed in "Modifications" section
    When the user selects "<link>" 
    When the user clicks on "View Document" link
    Then the document opens correctly
    Examples: 
      | GUID                              | link                                                            |
      | I338C4FF0E44911DA8D70A0E70A78ED65 | Disability Discrimination Act 1995 c. 50, Sch. 2 para. 2        |
      | I1A1950919E8111DEB1C4C7C568C3E0B1 | Companies (Authorised Minimum) Regulations 2009/2425, reg. 9(1) |
      | I84AF3150FFCF11DDA8D5C24AB9A3F5FB | Sch.1 para.1                                                    |
