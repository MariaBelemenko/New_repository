@prod
Feature: Ability to sort documents by title and date

  # There is necessary that the user have static immutable data to check sorting documents by date column
  @e2e
  Scenario: Verify Sort by title in Folders
    Given PL+ user 'FFHTestUser1_Sorting' opens 'SubFolder_0' folder
    When the user clicks on the 'Title' column
    Then the rows sorted by 'Title' column in ascending
    When the user clicks on the 'Title' column again
    Then the rows sorted by 'Title' column in descending

  @e2e
  Scenario: Verify Sort by added date in Folders
    Given PL+ user 'FFHTestUser1_Sorting' opens 'SubFolder_0' folder
    When the user clicks on the 'Date Added' column
    Then the rows sorted by 'Date Added' column in ascending
    When the user clicks on the 'Date Added' column again
    Then the rows sorted by 'Date Added' column in descending
