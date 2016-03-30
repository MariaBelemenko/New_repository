Feature: [777141] As a PL+ User I want to view title, status, effective date and version in legislation document

  Background: 
    Given PL+ user is logged in

  Scenario Outline: Legislation document contains title, status, effective date, version
    When the user opens document with <GUID> guid
    When the user clicks on "View Document" link
    Then the document opens correctly
    And the title is displayed on the document
    And the metadata is displayed in the right hand side of the central column
    And the metadata contains "<status>"
    And the metadata contains "Version"
    And the metadata contains "<effective date>"

    Examples: 
      | GUID                              | status             | effective date            |
      | I338C4FF0E44911DA8D70A0E70A78ED65 | Partially Repealed | April 5, 2011             |
      | I33B7CCC0E44911DA8D70A0E70A78ED65 | Law In Force       | October 1, 2010 - present |
