@e2e
Feature: As a PPI User I want to be able to edit the name of a folder so I can identified different folders.

  Scenario Outline: Able to edit the name of a folder
    Given PL+ user is logged in
    When API cleans all folders and history and user relogs in
    And the user clicks on 'Folders' link on the header
    And the user creates new folder "<folder1>" in "<parentFolder1>" folder
    Then the folder "<folder1>" appears in the "<parentFolder1>" folder
    When the user renames folder "<folder1>" to "<folder2>" by double click
    Then the folder "<folder2>" appears in the "<parentFolder1>" folder
    When the user renames folder "<folder2>" to "<folder3>"
    Then the folder "<folder3>" appears in the "<parentFolder1>" folder
    When the user deletes the folder "<folder3>"
    Then the folder "<folder3>" disappear from "<parentFolder1>" folder
  Examples:
    | folder1 | parentFolder1 | folder2 | folder3 |
    | new123  | root          | pl1245  | pl1     |
