Feature: (894454) Verify scoped search is preserved within history

  Scenario: Scope search - know how
    Given PL+ user is logged in with routing details
      |Compartment selection routing options to be entered here|
    And the user navigates to WLUK practice area "Employment"
    Then the user can verify that the scoped search dropdown states "Employment"
    When the user runs a free text search for the query "employee benefits"
    Then the user can verify that the scoped search dropdown states "Employment"
    And the user can verify that the title listed above the search results is "Employment"

  Scenario:Verify know how scoped search is preserved within history
    When the user selects the link to history
    And the user selects the link to re-run the scoped search
    Then the user is able to confirm that the scoped search dropdown is set to the scoped value "Employment"
    And the user is able to verify that the pre-scoped search value is correctly highlighted as a facet
    And the user is able to verify that the number of search results matches with previous results
    And the user is able to verify that the facet count for practice area with previous results facet count

  Scenario: Scope search - what's market
    Given PL+ user is logged in
    And the user navigates to the what's market page
    And the user selects the deal type "Public M & A"
    Then the user can verify that the scoped search dropdown states "Public M & A"
    When the user runs a free text search for the query "mining companies"
    Then the user can verify that the scoped search dropdown states "Publuc M & A"
    And the user can verify that the title listed above the search results is "Public M & A"

  Scenario:Verify what's market scoped search is preserved within history
    When the user selects the link to history
    And the user selects the link to re-run the scoped search
    Then the user is able to confirm that the scoped search dropdown is set to the scoped value "Public M & A"
    And the user is able to verify that the pre-scoped search value is correctly highlighted as a facet
    And the user is able to verify that the number of search results matches with previous results
    And the user is able to verify that the facet count for the deal type matches the previous results facet count
