Feature: As a PPI User I do not want to see any previous History from other products so I do not get confused.

# It is needded to add story with Recent history
  Scenario Outline:
    Given WLN user is logged in with following details
      | routing          | FOLDERS |
      | mandatoryRouting | YES     |
    When API cleans all folders and history
    Given PL+ user is logged in with following details
      | userName | FFHUser4 |
    When API cleans all folders and history and user relogs in
    And the user come back on to Home page
    And the user runs a free text search for the query "<query>"
    And the user waits search result to load
    And the user opens '3' link in the search result and store its title and guid
    And the user clicks on 'History' link on the header
    And the user clicks on 'Documents' tab on the History page
    Then the '1' link contains the document title and guid
    When the user clicks on 'All_History' tab on the History page
    Then the '1' link contains the document title and guid
    And the '1' link contains event type 'Document View'
    And the '2' link contains text "<query>" and url '/Search/Results.html?query=Tax'
    And the '2' link contains event type 'Search'
    Given WLN user is logged in with following details
      | userName         | FFHUser4 |
      | routing          | FOLDERS  |
      | mandatoryRouting | YES      |
    When the user come back on to WLN Home page
    And the user clicks on 'History' link on the header
    And the user clicks on 'All_History' tab on the History page
    Then the user checks history is empty
    And the user checks Faceting is absent
    And the user clicks on 'Documents' tab on the History page
    Then the user checks history is empty
    And the user checks Faceting is absent
    And the user clicks on 'Searches' tab on the History page
    Then the user checks history is empty
    And the user checks Faceting is absent
    When the user come back on to WLN Home page
    Then there is no the '/Search/Results.html?query=Tax' in recently used searches drop down
    And there is no the document title and guid in recently used documents drop down
  Examples:
    | query |
    | Tax   |

  # "User opens 6 link..." - 6 - is the link of document which have the same title on the document view page and
  # on the History page. In some cases, document title can be so long that on History page it contains short forms of words
  # and assert is fail.
  Scenario Outline:
    Given PL+ user is logged in
    When API cleans all folders and history
    Given WLN user is logged in with following details
      | userName         | FFHUser4 |
      | routing          | FOLDERS  |
      | mandatoryRouting | YES      |
    When API cleans all folders and history and user relogs in
    And the user come back on to WLN Home page
    And the user runs a free text search for the query "<query>"
    And the user waits search result to load
    And the user opens '6' link in the search result and store its title and guid
    And the user clicks on 'History' link on the header
    And the user clicks on 'Documents' tab on the History page
    Then the '1' link contains the document title and guid
    When the user clicks on 'All_History' tab on the History page
    Then the '1' link contains the document title and guid
    And the '1' link contains event type 'Document View'
    And the '2' link contains text "<query>" and url '/Search/Results.html?query=Tax'
    And the '2' link contains event type 'Search'
    Given PL+ user is logged in with following details
      | userName | FFHUser4 |
    When the user clicks on 'History' link on the header
    And the user clicks on 'All_History' tab on the History page
    Then the user checks history is empty
    And the user checks Faceting is absent
    And the user clicks on 'Documents' tab on the History page
    Then the user checks history is empty
    And the user checks Faceting is absent
    And the user clicks on 'Searches' tab on the History page
    Then the user checks history is empty
    And the user checks Faceting is absent
  Examples:
    | query |
    | Tax   |
    