@e2e
Feature: AS a PPI User I want to be able to create a new folder so I can have different folders to organize my documents.
  As a PPI User I want to be able to create subfolders and add documents there so I can organize my Folders.
  As a PPI User I want to be able to delete a folder so I don't have to see it if I don't need it anymore.

  Scenario Outline:
    Given PL+ user is logged in
    When API cleans all folders and history and user relogs in
    And the user clicks on 'Folders' link on the header
    And the user creates new folder "<folder1>" in "<parentFolder1>" folder
    Then the folder "<folder1>" appears in the "<parentFolder1>" folder
    When the user creates new folder "<folder2>" in "<folder1>" folder
    Then the folder "<folder2>" appears in the "<folder1>" folder
    When the user creates new folder "<folder3>" in "<folder2>" folder
    Then the folder "<folder3>" appears in the "<folder2>" folder
    When the user creates new folder "<folder2>" in "<folder1>" folder and gets cannot create duplicates error
    When the user creates new folder "<folder1>" in "<folder3>" folder
    Then the folder "<folder1>" appears in the "<folder3>" folder
    When the user deletes the folder "<folder1>"
    Then the folder "<folder1>" disappear from "<parentFolder1>" folder
    And the folder "<folder2>" disappear from "<folder1>" folder
    And the folder "<folder3>" disappear from "<folder2>" folder
    And the folder "<folder1>" disappear from "<folder3>" folder
  Examples:
    | folder1 | parentFolder1 | folder2 | folder3 |
    | new123  | root          | new456  | new789  |
