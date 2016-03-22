Feature: Verify legal updates/current awareness

  Scenario: Legal update navigation
    Given PL+ user is logged in
    And the user come back on to Home page as logged in user
    When user clicks on the "Corporate" Practice Area Link
    And the user clicks on the 'View all' link of the LU widget
    Then the user should be presented with a list of LU documents
    And the results should be sorted by date (most recent first)
    And the results should be from the relevant PA "Corporate"
    When the user can open the first know how search result "1"
    Then User is not able to see previous link in left hand side as carosal
    And the user stores title of next legal update on carousal
    When User clicks on next link in right hand side as carosal
    Then the user verifies he is on correct legal update on carousal
    And User is able to see previous link in left hand side as carosal
    And the user stores title of previous legal update on carousal
    When User clicks on previous link in left hand side as carosal
    Then the user verifies he is on correct legal update on carousal
    And User is not able to see previous link in left hand side as carosal

  Scenario: Search within legal updates
    Given PL+ user is logged in
    And the user come back on to Home page as logged in user
    When a user navigate to a "Share acquisitions: private" Topic page from a "Corporate" Practice Area page
    And the user clicks on the 'View all' link of the LU widget
    Then the user should be presented with a list of LU documents
    And the specific Subject Area "Share Acquisitions: Private" and its parent Practice Area "Corporate" are displayed
    When the user runs a free text search for the query "appeal"
    Then the specific Subject Area "Share Acquisitions: Private" and its parent Practice Area "Corporate" are displayed
    Then the user is able to verify that the search result in position "1" within the result list has the resource type "Legal update"

  Scenario: Search results filter for legal updates
    Given PL+ user is logged in
    And the user come back on to Home page as logged in user
    When a user is on the Legal Updates Home page
    And the user clicks on the 'View all' link of the LU widget
    Then the user verifies that the current PageTitle contains 'Legal updates | All'
    And the user should be presented with a list of LU documents
    When the user selects the know how parent facet "Northern Ireland"
  #  And the user selects the know how option to apply filters
    Then the user is able to verify that the search result in position "1" within the result list has the jurisdiction "Northern Ireland"
