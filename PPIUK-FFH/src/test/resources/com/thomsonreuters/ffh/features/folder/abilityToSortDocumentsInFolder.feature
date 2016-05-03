@prod
Feature: Ability to sort documents by title and date

  # There is necessary that the user have static immutable data to check sorting documents by date column
  Background:
    Given PL+ user is logged in with following details
      | userName | FFHTestUser1_Sorting |
    And the user goes to folder 'SubFolder_0'

  @e2e
  Scenario: Verify Sort by title in Folders
    When the user clicks on the 'Title' column
    Then the rows sorted by 'Title' column in ascending
    When the user clicks on the 'Title' column again
    Then the rows sorted by 'Title' column in descending

  @e2e
  Scenario: Verify Sort by added date in Folders
    When the user clicks on the 'Date Added' column
    Then the rows sorted by 'Date Added' column in ascending
    When the user clicks on the 'Date Added' column again
    Then the rows sorted by 'Date Added' column in descending
