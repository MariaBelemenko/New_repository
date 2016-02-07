@e2e @prod
Feature: Persistent Browse

  Background:
    Given PL+ user is logged in

  Scenario: To verify All Practice Areas Under BROWSE All Content
    When user clicks on "Browse Menu" dropdown
    And user selects sub-menu 'Practice areas'
    Then the following links should be present on the section
      | Arbitration        | Commercial | Competition                | Construction               | Corporate      |
      | Dispute Resolution | Employment | Environment                | Family                     | Finance        |
      | Financial Services | IP & IT    | Media & Telecoms           | Pensions                   | Private Client |
      | Property           | Public Law | Restructuring & Insolvency | Share Schemes & Incentives | Tax            |

  Scenario: To verify All Resources Under BROWSE All Content
    When user clicks on "Browse Menu" dropdown
    And user selects sub-menu 'Resources'
    Then the following links should be present on the section and every link opens page with selected resource
      | Practice notes | Standard documents and drafting notes | Standard clauses and drafting notes |
      | Checklists     | Glossary                              | What's Market                       |
      | Ask            | Bloomsbury books online               | PLC Magazine                        |

  Scenario: To verify All Countries Under BROWSE All Content
    When user clicks on "Browse Menu" dropdown
    And user selects sub-menu 'International'
    Then the following links should be present on the section and every link opens page with selected resource
      | Argentina | Australia    | Austria     | Brazil | Canada | China       | France | Germany            |
      | Hong Kong | India        | Indonesia   | Italy  | Japan  | Mexico      | Norway | Russian Federation |
      | Singapore | South Africa | South Korea | Spain  | Sweden | Switzerland | Turkey | United States      |

  Scenario: To verify All Practice Areas Under BROWSE All Content when document is opened
    When user navigates directly to document with guid "Ib5551f64e83211e398db8b09b4f043e0"
    And user clicks on "Browse Menu" dropdown
    And user selects sub-menu 'Practice areas'
    Then the following links should be present on the section
      | Arbitration        | Commercial | Competition                | Construction               | Corporate      |
      | Dispute Resolution | Employment | Environment                | Family                     | Finance        |
      | Financial Services | IP & IT    | Media & Telecoms           | Pensions                   | Private Client |
      | Property           | Public Law | Restructuring & Insolvency | Share Schemes & Incentives | Tax            |

  Scenario: To verify All Resources Under BROWSE All Content when document is opened
    When user navigates directly to document with guid "Icf316a29e89111e398db8b09b4f043e0"
    And user clicks on "Browse Menu" dropdown
    And user selects sub-menu 'Resources'
    Then the following links should be present on the section and every link opens page with selected resource
      | Practice notes | Standard documents and drafting notes | Standard clauses and drafting notes |
      | Checklists     | Glossary                              | What's Market                       |
      | Ask            | Bloomsbury books online               | PLC Magazine                        |

  Scenario: To verify Countries Under BROWSE All Content when document is opened
    When user navigates directly to document with guid "Ife559e5d062411e598db8b09b4f043e0"
    And user clicks on "Browse Menu" dropdown
    And user selects sub-menu 'International'
    Then the following links should be present on the section and every link opens page with selected resource
      | Argentina | Australia    | Austria     | Brazil | Canada | China       | France | Germany            |
      | Hong Kong | India        | Indonesia   | Italy  | Japan  | Mexico      | Norway | Russian Federation |
      | Singapore | South Africa | South Korea | Spain  | Sweden | Switzerland | Turkey | United States      |

  Scenario: To verify All Practice Areas Under BROWSE All Content when Search results are displayed
    When the user searches for "Tax"
    And user clicks on "Browse Menu" dropdown
    And user selects sub-menu 'Practice areas'
    Then the following links should be present on the section
      | Arbitration        | Commercial | Competition                | Construction               | Corporate      |
      | Dispute Resolution | Employment | Environment                | Family                     | Finance        |
      | Financial Services | IP & IT    | Media & Telecoms           | Pensions                   | Private Client |
      | Property           | Public Law | Restructuring & Insolvency | Share Schemes & Incentives | Tax            |

  Scenario: To verify All resources Under BROWSE All Content Search results are displayed
    When the user searches for "Commercial"
    And user clicks on "Browse Menu" dropdown
    And user selects sub-menu 'Resources'
    Then the following links should be present on the section and every link opens page with selected resource
      | Practice notes | Standard documents and drafting notes | Standard clauses and drafting notes |
      | Checklists     | Glossary                              | What's Market                       |
      | Ask            | Bloomsbury books online               | PLC Magazine                        |

  Scenario: To verify All Countries Under BROWSE All Content when  Search results are displayed
    When the user searches for "Pub"
    And user clicks on "Browse Menu" dropdown
    And user selects sub-menu 'International'
    Then the following links should be present on the section and every link opens page with selected resource
      | Argentina | Australia    | Austria     | Brazil | Canada | China       | France | Germany            |
      | Hong Kong | India        | Indonesia   | Italy  | Japan  | Mexico      | Norway | Russian Federation |
      | Singapore | South Africa | South Korea | Spain  | Sweden | Switzerland | Turkey | United States      |