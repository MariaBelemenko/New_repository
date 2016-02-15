@bug
Feature: [763079] Folders/History - Save to folder and Previously viewed signs

  Scenario Outline: Foldering Signs from WLN to PL+
    Given PL+ user is logged in with following details
      | userName | FFHTestUser1_Firm3 |
    When API cleans all folders and history
    Given WLN user is logged in with following details
      | userName | FFHTestUser1_Firm3 |
    When API cleans all folders and history and user relogs in
    And the user clicks on 'Folders' link on the header
    And the user creates new folder "<folder1>" in "<parentFolder>" folder
    Then the folder "<folder1>" appears in the "<parentFolder>" folder
    When the user come back on to WLN Home page
    And the user runs a free text search for the query "<query>"
    And the user opens '1' link in the search result and store its title and guid
    And the user adds current document to new "<folder2>" folder with parent folder "<parentFolder>"
    And the user come back on to WLN Home page
    And the user runs a free text search for the query "<query>"
    Then the user finds the same document and checks it has got foldered sign
    And the user finds the same document and checks it has got previously viewed sign
    Given PL+ user is logged in with following details
      | userName | FFHTestUser1_Firm3 |
    When the user come back on to Home page
    And the user runs a free text search for the query "<query>"
    Then the user finds the same document and checks it has not got previously viewed sign
    And the user finds the same document and checks it has not got foldered sign
  Examples:
    | query                    | folder1 | folder2 | parentFolder |
    | "Investing in Australia" | wln1    | wln2    | root         |

  Scenario Outline: Foldering Signs from PL+ to WLN
    Given WLN user is logged in with following details
      | userName | FFHTestUser1_Firm3 |
    When API cleans all folders and history
    Given PL+ user is logged in with following details
      | userName | FFHTestUser1_Firm3 |
    When API cleans all folders and history and user relogs in
    And the user clicks on 'Folders' link on the header
    And the user creates new folder "<folder1>" in "<parentFolder>" folder
    Then the folder "<folder1>" appears in the "<parentFolder>" folder
    When the user come back on to Home page
    And the user runs a free text search for the query "<query>"
    And the user opens '1' link in the search result and store its title and guid
    And the user adds current document to new "<folder2>" folder with parent folder "<parentFolder>"
    And the user come back on to Home page
    And the user runs a free text search for the query "<query>"
    Then the user finds the same document and checks it has got foldered sign
    And the user finds the same document and checks it has got previously viewed sign
    Given WLN user is logged in with following details
      | userName | FFHTestUser1_Firm3 |
    And the user come back on to WLN Home page
    And the user runs a free text search for the query "<query>"
    Then the user finds the same document and checks it has not got previously viewed sign
    And the user finds the same document and checks it has not got foldered sign
  Examples:
    | query                    | folder1 | folder2 | parentFolder |
    | "Investing in Australia" | plcuk1  | plcuk2  | root         |
