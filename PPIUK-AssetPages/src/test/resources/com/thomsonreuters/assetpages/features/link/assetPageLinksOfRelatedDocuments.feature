@e2e @prod
Feature: [818356] As a PL+ User I want to view list of Related documents grouped by document type in case asset page

  Background: 
    Given PL+ user is logged in with following details
      | userName | Asset_page_one |

  Scenario Outline: [818356] The case asset page contain list of Related documents grouped by document type
    When the user opens document with <GUID> guid
    Then the user click on View Document button
    Then the document opens correctly
    Then the user see "Content referring to this case" jump link in the left hand side navigation panel
    When the user clicks on "Content referring to this case" jump link
    Then the user sees the "<link>" link
    And this link "<link>" belong to document "<type>" type
    When the user clicks on this "<link>" link
    Then the user is taken from primary source page to internal document

    Examples: 
      | GUID                              | link                                                               | type                |
      | I984ef7396cf011e498db8b09b4f043e0 | Enforcing security: overview                                       | UK Practice Note    |
      | I984ef7396cf011e498db8b09b4f043e0 | Charge over bank account: drafting note                            | UK Drafting Notes   |
      | I8cba0f91532011e598dc8b09b4f043e0 | Charge over shares: Charge over certificated shares and securities | UK Standard Clauses |
      | I984f1fea6cf011e498db8b09b4f043e0 | Charge over bank account: drafting note                            | UK Drafting Notes   |
