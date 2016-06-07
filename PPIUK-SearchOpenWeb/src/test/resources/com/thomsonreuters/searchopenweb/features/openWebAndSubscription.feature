Feature: Testing Open Web And Subscriptions

  Scenario: Verify open web user has no access to whats market content
    Given PL+ user is logged in with following details
      | routing       | OPEN_WEB_SEARCH |
      | loginRequired | NO              |
      | newSession    | TRUE            |
    When the user selects the link to the Resource tab
    Then the user can verify that no link entitled "What's Market" is present

#Bug 902097:What's Market link is visible for Open Web user in Featured section 
@bug @wip
  Scenario: [891777]  Verify open web user has no access to whats market content in Featured section 
    Given PL+ user is not logged in
    When PL+ user navigates to home page
    Then the user does not see any link related to "What's Market" in featured section
 #remove after QED deploy 15 June
 @wip
  Scenario: [891777] As a not logged in user I do not want to see any related links to What's Market so I do not get confused when I am not able to use them.
    Given PL+ user is not logged in
    When PL+ user navigates to home page
    And the user clicks button 'Browse Menu' on the Home Page
    And the user selects Resource tab
    Then the user does not see any link related to "What's Market" in Browse Menu
    And the user does not see any section with title "Market analysis" in Browse Menu
    

  Scenario: Verify logged in standard user does have access to what's market
    Given PL+ user is logged in with following details
     | routing          | BETA |
     | mandatoryRouting | YES  |
    When the user selects the link to the Resource tab
    Then the user can verify that a link entitled "What's Market" is present

  Scenario: Verify open web user is able to search know how
    Given PL+ user is logged in with following details
      | routing       | OPEN_WEB_SEARCH |
      | loginRequired | NO              |
    And the user runs a free text search for the query "contract"
    And the user pauses for "3" seconds
    Then the user is able to verify that a page of search results is displayed
    And the user can open the first know how search result "1"
    And the user is presented with a message offering a free trial in order to access the full resource

  Scenario: User with a PL+ subscription but no access to what's market is presented with appropriate message on whats market search results page
    Given PL+ user is logged in with following details
      | routing          | NOWHATSMARKETACCESS |
      | mandatoryRouting | YES                 |
    And has selected the link to the What's Market homepage
    When the user runs a free text search for the query "deal"
    And the user pauses for "3" seconds
    Then the user is presented with a message confirming that the user needs a whats market subscription to view the results

  Scenario: Verify Also Found in section available to open web users
    #860453 - topic information missing from know how resources
    Given PL+ user is logged in with following details
      | routing       | OPEN_WEB_SEARCH |
      | loginRequired | NO              |
    And the user runs a free text search for the query "asset purchase"
    And the user pauses for "3" seconds
    Then the user is able to verify that a page of search results is displayed
    And the user can open the first know how search result "1"
    And the user verifies the presence of the Topics heading in Related Content section