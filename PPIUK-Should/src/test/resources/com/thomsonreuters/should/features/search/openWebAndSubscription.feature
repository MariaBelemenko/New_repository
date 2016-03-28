Feature: Testing Open Web And Subscriptions

  Scenario: Verify Also Found in section available to open web users
    #860453 - topic information missing from know how resources
    Given PL+ user is logged in with following details
      | routing       | OPEN_WEB_SEARCH |
      | loginRequired | NO              |
    And the user runs a free text search for the query "asset purchase"
    And the user pauses for "3" seconds
    Then the user is able to verify that a page of search results is displayed
    And the user can open the first know how search result "1"
    And the user can verify that the document contains the header Also Found In
