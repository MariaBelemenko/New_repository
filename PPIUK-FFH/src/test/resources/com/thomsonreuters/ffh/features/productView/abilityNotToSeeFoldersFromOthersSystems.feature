Feature: As a PPI User I do not want to see Folders from other products in my Folders so I avoid seeing undesireable Folders.

# It is needded to add story with 'Save to folder' pop
# It is needded to add story with Recent folders
  Scenario Outline:
    Given WLN user is logged in with following details
      | routing          | FOLDERS |
      | mandatoryRouting | YES     |
    When API cleans all folders and history
    And user relogs in
    Given PL+ user is logged in with following details
      | userName | FFHUser4 |
    When API cleans all folders and history and user relogs in
    And the user come back on to Home page
    And the user runs a free text search for the query "<query>"
    And the user waits search result to load
    And the user selects '2' documents, stores its titles and guids and saves to new "<plFolder>" folder with parent folder "<parentFolder>"
    When the user clicks on 'Folders' link on the header
    And all documents present in the "<plFolder>" folder
    Given WLN user is logged in with following details
      | routing          | FOLDERS |
      | mandatoryRouting | YES     |
    When the user clicks on 'Folders' link on the header
    Then the folder "<plFolder>" with parent folder "<parentFolder>" is absent
    And the user checks Faceting is absent
    # the ckeck below was added due to bug 763742
    When the user come back on to WLN Home page
    And the user runs a free text search for the query "<query>"
    And the user waits search result to load
    Then the user selects '2' documents and checks "<plFolder>" folder is absent in root folder
    # the ckeck below was added due to bug 764039
    When the user come back on to WLN Home page
    Then there is no the "<plFolder>" folder in recent folders drop down
    And there is no root folder duplication in recent folders drop down
  Examples:
    | query | plFolder | parentFolder |
    | Crime | pl1      | root         |

  Scenario Outline:
    Given PL+ user is logged in
    When API cleans all folders and history
    And user relogs in
    Given WLN user is logged in with following details
      | userName         | FFHUser4 |
      | routing          | FOLDERS  |
      | mandatoryRouting | YES      |
    When API cleans all folders and history and user relogs in
    And the user come back on to WLN Home page
    And the user runs a free text search for the query "<query>"
    And the user waits search result to load
    And the user selects '2' documents, stores its titles and guids and saves to new "<wlnFolder>" folder with parent folder "<parentFolder>"
    When the user clicks on 'Folders' link on the header
    And all documents present in the "<wlnFolder>" folder
    Given PL+ user is logged in with following details
      | userName | FFHUser4 |
    When the user clicks on 'Folders' link on the header
    Then the folder "<wlnFolder>" with parent folder "<parentFolder>" is absent
    And the user checks Faceting is absent
    # the ckeck below was added due to bug 763742
    When the user come back on to Home page
    And the user runs a free text search for the query "<query>"
    And the user waits search result to load
    Then the user selects '2' documents and checks "<wlnFolder>" folder is absent in root folder
  Examples:
    | query | wlnFolder | parentFolder |
    | Crime | wln1      | root         |