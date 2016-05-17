Feature: Verify Firmstyle, Fastdraft, and Annotations

  Scenario: Downloading a standard document in Firmstyle
    Given PL+ user is logged in with following details
      | userName         | FStyleUser |
    And the user come back on to Home page as logged in user
    When the user runs a free text search for the query "deed"
    And the user selects the know how parent facet "Standard Documents and Clauses"
 #   And the user selects the know how option to apply filters
    And the user can open the first know how search result "1"
    And the user clicks Firm Style link
    Then Firm Style download box appiars

  @wip
  Scenario: Fastdraft 'Start drafting'
    Given PL+ user is logged in
    When the user runs a free text search for the query "sales agency agreement"
    And the user can open the first know how search result "1"
    And the user clicks Start Drafting button
    Then the user is redirected to question page for "Sales agency agreement"

  @wip
  Scenario: Document level annotation
    Given PL+ user is logged in
    When the user runs a free text search for the query "tax"
    And the user can open the first know how search result "1"
    When user click on new Annotations link
    Then annotations textbox will be displayed with tinymce editor
    And user cancels new annotation
