Feature: (894454) Verify scoped search is preserved within history

  Scenario Outline: Verify scoped search is preserved after open web user logs in
    Given PL+ user is logged in with following details
      | routing       | OPEN_WEB_SEARCH |
      | loginRequired | NO              |
    When the user navigates to practice area "<practiceArea>"
    And the user runs a free text search for the query "<searchTerm>"
    Then the user is able to confirm that the scoped search dropdown is set to the scoped value "<practiceArea>"
    When PL+ user is logged in with details by selecting signin button
      | userName | Search_Browse_User1 |
    Then the user is able to confirm that the scoped search dropdown is set to the scoped value "<practiceArea>"
    And the user is able to verify that the pre-scoped "<practiceArea>" value is correctly highlighted as a facet
    And the user is able to verify that the number of search results matches with previous results
  Examples:
    | practiceArea | searchTerm        |
    | Employment   | employee benefits |

  Scenario Outline: Verify scoped search is preserved within history for open web user after logging in
    When the user selects the link to history
    And the user selects the link "<searchTerm>" to re-run the scoped search
    Then the user is able to confirm that the scoped search dropdown is set to the scoped value "<practiceArea>"
    And the user is able to verify that the pre-scoped "<practiceArea>" value is correctly highlighted as a facet
    And the user is able to verify that the number of search results matches with previous results
  Examples:
    | practiceArea | searchTerm        |
    | Employment   | employee benefits |

  Scenario Outline: Verify scoped search is preserved within history between user sessions
    When PL+ user is logged in with following details
      | userName | Search_Browse_User1 |
    When the user navigates to practice area "<practiceArea>"
    Then the user can verify that the scoped search dropdown states "<practiceArea>"
    When the user runs a free text search for the query "<searchTerm>"
    When user logs out
    When PL+ user is logged in with following details
      | userName         | Search_Browse_User1 |
      | mandatoryRouting | false               |
    When the user selects the link to history
    And the user selects the link "<searchTerm>" to re-run the scoped search
    Then the user is able to confirm that the scoped search dropdown is set to the scoped value "<practiceArea>"
    And the user is able to verify that the pre-scoped "<practiceArea>" value is correctly highlighted as a facet
    And the user is able to verify that the number of search results matches with previous results
  Examples:
    | practiceArea | searchTerm        |
    | Employment   | employee benefits |