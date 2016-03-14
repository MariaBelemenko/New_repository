Feature: [788387] As a PL+ User I want to view links to view and link to Practice notes

  Scenario Outline: [788387] The case documents contain Practice Notes
    Given PL+ user is logged in
    When the user opens document with <GUID> guid
    Then the document opens correctly
    Then the user sees "Practice Notes" UK Practice Notes section
    When the user clicks on "<link>" link
    Then the document opens correctly

    Examples: 
      | GUID                              | link                                            |
      | I984ef7626cf011e498db8b09b4f043e0 | Duty to give reasons                            |
      | I8cba0f91532011e598dc8b09b4f043e0 | Taking security over shares and debt securities |
