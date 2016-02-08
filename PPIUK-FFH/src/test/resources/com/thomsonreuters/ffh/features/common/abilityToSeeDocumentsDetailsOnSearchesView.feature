Feature: As a PPI User I want to see Description, Date/Time that I did the search and Client ID for every search in the Searches view in the History page so I can go back to a search done before.

  Scenario:
    Given PL+ user is logged in with following details
      | userName | FFHTestUser |
    When API cleans all folders and history and user relogs in
    And the user runs a free text search for the query "School"
    And the user waits search result to load
    When the user clicks on 'History' link on the header
    When the user clicks on 'Searches' tab on the History page
    Then the '1' link contains text "School" and url '/Search/Results.html?query=School'
    Then the '1' link contains ClientId and date
