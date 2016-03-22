Feature: Verify folders, favourites and history

  Scenario Outline: Adding a document to a new folder
    Given PL+ user is logged in
    And the user come back on to Home page as logged in user
    And the user clicks on 'Folders' link on the header
    And the user deletes the folder "<folderName>" if it exists
    When the user runs a free text search for the query "income tax data"
    And the user opens '1' link in the search result and store its title and guid
    And the user adds current document to new "<folderName>" folder with parent folder "root"
    And the user clicks on 'Folders' link on the header
    Then 'Folders' page opens
    And the folder "<folderName>" appears in the "root" folder
    And all documents present in the "<folderName>" folder
  Examples:
    | folderName |
    | test1      |

  Scenario: Adding a practice area/topic to favourites
    Given PL+ user is logged in
    And the user come back on to Home page as logged in user
    When user clicks on the "Commercial" Practice Area Link
    And the user adds page to favourites group 'My Favorites'
    And the user clicks on "Consumer" link
    And the user adds page to favourites group 'newGroup'
    When the user clicks on 'Favourites' link on the header
    Then the user checks that 'Commercial' link presents in favourites group 'My Favorites' on Favourites page
    And the user checks that 'Consumer' link presents in favourites group 'newGroup' on Favourites page
    And the user deletes the favourites group 'newGroup'
 #   And the user deletes the favourites page 'Commercial'
    And the user deletes the favourites page 'Commercial | Practice'

  Scenario: Verify a search and viewing document is recorded in history
    Given PL+ user is logged in
    And the user come back on to Home page as logged in user
    When the user runs a free text search for the query "article 101"
    And the user opens '1' link in the search result and store its title and guid
    And the user clicks on the View Related Content link on right hand panel
    And the user clicks on 'History' link on the header
    Then the '1' link contains the document title and guid
    And the '1' link contains event type 'Document View'
    And the '1' link contains ClientId and date
    Then the '2' link contains text "article 101" and url '/Search/Results.html?query=article%20101'
    And the '2' link contains event type 'Search'
    And the '2' link contains ClientId and date
