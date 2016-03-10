Feature: [788462] As a PL+ User I want to view the meta data relating to a case asset page
  [813548] As a PL+ User I want does not want to see Division in case asset page
  [813548] As a PL+ User I want does not want to see Court in case asset page

  Background: 
    Given PL+ user is logged in

  Scenario Outline: [788462] The case documents contain the case metadata in the right hand side of the central column
    When the user opens document with <GUID> guid
    Then the document opens correctly
    And the metadata is displayed in the right hand side of the central column
    And the metadata contains "Resource Type"
    And the metadata contains "Court"
    And the metadata contains "Date"
    And the metadata contains "Where Reported"
    And the metadata contains "Division"
    And the metadata contains "Jurisdiction of court"

    Examples: 
      | GUID                              |
      | I984ef7626cf011e498db8b09b4f043e0 |
      | I984ef77b6cf011e498db8b09b4f043e0 |

  Scenario Outline: [813548] The case documents does not contain Division
    When the user opens document with <GUID> guid
    Then the document opens correctly
    And the metadata is displayed in the right hand side of the central column
    And the metadata does not contain "Division"

    Examples: 
      | GUID                              |
      | Ieda8cc31f27711e498db8b09b4f043e0 |
      | I984f1d486cf011e498db8b09b4f043e0 |

  Scenario Outline: [813548] The case documents does not contain Court
    When the user opens document with <GUID> guid
    Then the document opens correctly
    And the metadata is displayed in the right hand side of the central column
    And the metadata does not contain "Court"

    Examples: 
      | GUID                              |
      | I984f1d8d6cf011e498db8b09b4f043e0 |
      | Ib96f28826cf311e498db8b09b4f043e0 |

  Scenario Outline: [816071] The case documents does not contain Court
    When the user opens document with <GUID> guid
    Then the document opens correctly
    And the metadata is displayed in the right hand side of the central column
    And the metadata contains "Court"
    And the metadata contains "Specialist court"
    And the user see Specialist court value

    Examples: 
      | GUID                              |
      | I984f1e8a6cf011e498db8b09b4f043e0 |
      | I984f1f176cf011e498db8b09b4f043e0 |
