Feature: academicUsers.feature

  Scenario: Verify that academic user with access to PL + Research content is presented with "For Educational Use Only" on all documents
    Given a user has logged into PL with the subscription
      | Academic |
    And the user has run a free text search for the term X
    Then the user is able to verify that a page of know how search results is displayed by default to the user
    And the user is able to verify the presence of a tab entitled "Selected Westlaw UK documents"
    And the user is able to select the tab
    And the user is able to view the research content search results page
    And the user is able to open the first search result
    And the user is able to verify the presence of the message "For educational use only"


  Scenario: Verify that academic user with access to PL only is not able to access research results tab
    Given a user has logged into PL with the subscription
      | Academic |
    And the user has run a free text search for the term X
    Then the user is able to verify that a page of know how search results is displayed by default to the user
    And the user is able to verify the presence of a tab entitled Selected Westlaw UK documents
    And the user is not able to select the tab