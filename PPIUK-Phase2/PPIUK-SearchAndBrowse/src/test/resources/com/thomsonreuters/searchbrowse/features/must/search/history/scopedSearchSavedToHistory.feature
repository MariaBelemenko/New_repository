Feature: (894454) Verify scoped search is preserved within history

  Scenario Outline: Scope search - know how
    Given PL+ user is logged in with following details
      | userName | Search_Browse_User1 |
    When the user navigates to practice area "<practiceArea>"
    Then the user can verify that the scoped search dropdown states "<practiceArea>"
    When the user runs a free text search for the query "<searchTerm>"
    Then the user can verify that the scoped search dropdown states "<practiceArea>"
    And the user can verify that the title listed above the search results is "<practiceArea>"
  Examples:
    | practiceArea | searchTerm        |
    | Employment   | employee benefits |

  Scenario Outline:Verify know how scoped search is preserved within history
    When the user selects the link to history
    And the user selects the link "<searchTerm>" to re-run the scoped search
    Then the user is able to confirm that the scoped search dropdown is set to the scoped value "<practiceArea>"
    And the user is able to verify that the pre-scoped "<practiceArea>" value is correctly highlighted as a facet
    And the user is able to verify that the number of search results matches with previous results
    #And the user is able to verify that the facet count for practice area with previous results facet count
  Examples:
    | practiceArea | searchTerm        |
    | Employment   | employee benefits |

  Scenario Outline: Scope search - what's market
    Given PL+ user is logged in with following details
      | userName | Search_Browse_User1 |
    And has selected the link to the What's Market homepage
    And the user selects the deal type "<dealName>"
    Then the user can verify that the scoped search dropdown states "<dealName>"
    When the user runs a free text search for the query "<searchTerm>"
    Then the user can verify that the scoped search dropdown states "<dealName>"
    And the user can verify that the title listed above the search results is "<dealName>"
  Examples:
    | dealName     | searchTerm       |
    | Public M & A | mining companies |

  Scenario Outline:Verify what's market scoped search is preserved within history
    When the user selects the link to history
    And the user selects the link "<searchTerm>" to re-run the scoped search
    Then the user is able to confirm that the scoped search dropdown is set to the scoped value "<dealName>"
    And the user is able to verify that the pre-scoped "<dealName>" value is correctly highlighted as a facet
    And the user is able to verify that the number of search results matches with previous results
    #And the user is able to verify that the facet count for deal type with previous results facet count
  Examples:
  | dealName     | searchTerm       |
  | Public M & A | mining companies |
