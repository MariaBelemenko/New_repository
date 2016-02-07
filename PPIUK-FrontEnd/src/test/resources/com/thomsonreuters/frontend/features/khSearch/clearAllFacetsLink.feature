Feature: As a PL+ user,
  I should be able to deselect multiple facets simultaneously CLEAR ALL FACETS (Across Facet Types)-  Know How

  Scenario: Verify search without modification of query discards all selected facets
    Given PL+ user is logged in
    When the user runs a free text search for the query "taxation"
    And the user selects the know how following parent facets
      | Practice Notes |
      | Employment     |
      | England        |
    And the user selects the know how option to apply filters
    And the user verifies that the know how following facet is selected
      | Practice Notes |
      | Employment     |
      | England        |
    When the user clicks on clear all link
    Then the user verifies that the following parent facets are not selected
      | Practice Notes |
      | Employment     |
      | England        |