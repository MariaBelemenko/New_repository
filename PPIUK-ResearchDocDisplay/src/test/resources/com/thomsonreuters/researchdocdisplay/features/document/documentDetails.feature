Feature: As a PL+ User I want to see annotated statutes
  As a PL+ User I do not want to see annotated statutes
  As a PL+ User I want to view the metadoc information for a case

  Background: 
    Given PL+ user is logged in

  Scenario Outline: Document contains annotated statutes
    When the user opens document with <GUID> guid
    When the user clicks on "View Document" link
    Then the document opens correctly
    And the "Annotated Statutes" menu link is present
    When the user click on "Annotated Statutes" menu link
    Then the usee see the "Annotated Statutes" text
    And the user see the "Section" and paragraphs

    Examples: 
      | GUID                              |
      | I338C4FF0E44911DA8D70A0E70A78ED65 |
      | I1AEE75F069FB11E3A64C9C652D1D8F6C |
      | I634790A0D9A211E2A7399744A15A9ECB |
      | IBEA9A630693111E38326ED868108EF62 |
      | I05DC825127A511E197D193A320D3C975 |
      | IC6F7B713491811DFA52897A37C152D8C |
      | I1AEE75F069FB11E3A64C9C652D1D8F6C |

  Scenario Outline: AnnotatedStatutes doesn't displayed on document
    When the user opens document with <GUID> guid
    Then the user click on View Document button
    Then the document opens correctly
    And the "Annotated Statutes" menu link is not present
    And the "Annotated Statutes" section is not displayed

    Examples: 
      | GUID                              |
      | I8E7400C0E44E11DA8D70A0E70A78ED65 |
      | I8D8B9C90E44E11DA8D70A0E70A78ED65 |
      | I4CF16720EDC711E29802DDCEC5A68FAA |
      | IE78F9172880411E48128AD5CC901B033 |
      | I0D637770E45011DA8D70A0E70A78ED65 |

  Scenario Outline: [784754] User can view the metadoc information for a case
    When the user opens document with <GUID> guid
    Then the user click on View Document button
    Then the document opens correctly
    And the user see a column for the left hand navigation
    And the user see the content column
    And the user see the delivery options
    When the user see the meta content on the document
    Then the user see Status Icon
    And the user see Status Description
    And the user see "Court" Court
    And the user see "Date" Date
    And the user see "Where Reported" Where Reported
    And the user see "Hearing Dates" hearing dates
    And the user see "Appellate committee" Appellate committee

    Examples: 
      | GUID                              |
      | I79273E60A8EF11E0888FEF03F0EFCF17 |
      | I65D353E0B03111E1A9C0890F1F61FF5D |
      | IE8146150B21311E49FBB8F994A94F811 |
      | IA77ABBF0A43711E0BAE6C7A444C8F8F8 |
