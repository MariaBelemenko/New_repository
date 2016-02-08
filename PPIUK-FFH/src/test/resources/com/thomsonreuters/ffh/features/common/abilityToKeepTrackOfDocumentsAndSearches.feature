Feature: As a PPI User I want to keep track of the documents and searches that I visited so I can go back to a previous search or document.

  Scenario Outline:
    Given PL+ user is logged in with following details
      | userName | FFHTestUser |
    When API cleans all folders and history and user relogs in
    And the user runs a free text search for the query "<query>"
    And the user waits search result to load
    And the user opens '2' link in the search result and store its title and guid
    When the user clicks on 'History' link on the header
    When the user clicks on 'Documents' tab on the History page
    Then the '1' link contains the document title and guid
    When the user clicks on 'Searches' tab on the History page
    Then the '1' link contains text "<query>" and url '/Search/Results.html?query=Tax'
    When the user clicks on 'All_History' tab on the History page
    Then the '1' link contains the document title and guid
    Then the '2' link contains text "<query>" and url '/Search/Results.html?query=Tax'
    Then the '1' link contains event type 'Document View'
    Then the '2' link contains event type 'Search'
  Examples:
    | query |
    | Tax   |
