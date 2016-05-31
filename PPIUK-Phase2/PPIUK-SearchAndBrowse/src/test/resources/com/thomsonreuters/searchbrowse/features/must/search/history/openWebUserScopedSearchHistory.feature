Feature: (894454) Verify scoped search is preserved within history

  Background:
    Given PL+ user is logged in with following details
      | routing       | OPEN_WEB_SEARCH |
      | loginRequired | NO              |

  Scenario: Verify scoped search is preserved after open web user logs in
    When PL+ user is logged in with following details
      | username |  |
    And the user navigates to WLUK practice area "Employment"
    When the user runs a free text search for the query "employee benefits"
    And PL+ user is logged in with following details
      | username |  |
    Then the user is able to confirm that the scoped search dropdown is set to the scoped value "Employment"
    And the user is able to verify that the pre-scoped search value is correctly highlighted as a facet
    And the user is able to verify that the facet count for practice area with previous results facet count

  Scenario: Verify scoped search is preserved within history for open web user after logging in
    When PL+ user is logged in with following details
      | username |  |
    And the user navigates to WLUK practice area "Employment"
    When the user runs a free text search for the query "employee benefits"
    And PL+ user is logged in with following details
      | username |  |
    Then the user is able to confirm that the scoped search dropdown is set to the scoped value "Employment"
    And the user is able to verify that the pre-scoped search value is correctly highlighted as a facet
    And the user is able to verify that the number of search results matches with previous results
    And the user is able to verify that the facet count for practice area with previous results facet count
    When the user selects the link to history
    And the user selects the link to re-run the scoped search
    Then the user is able to confirm that the scoped search dropdown is set to the scoped value "Employment"
    And the user is able to verify that the pre-scoped search value is correctly highlighted as a facet
    And the user is able to verify that the number of search results matches with previous results
    And the user is able to verify that the facet count for practice area with previous results facet count

  Scenario: Verify scoped search is preserved within history between user sessions
    Given PL+ user is logged in with following details
      | username |  |
    And user navigated to WestLaw UK  home page through compartment
    And the user navigates to WLUK practice area "Employment"
    Then the user can verify that the scoped search dropdown states "Employment"
    When the user runs a free text search for the query "employee benefits"
    When user logs out
    Given PL+ user is logged in with routing details
      | username |  |
    When the user selects the link to history
    And the user selects the link to re-run the scoped search
    Then the user is able to confirm that the scoped search dropdown is set to the scoped value "Employment"
    And the user is able to verify that the pre-scoped search value is correctly highlighted as a facet
    And the user is able to verify that the number of search results matches with previous results
    And the user is able to verify that the facet count for practice area with previous results facet count