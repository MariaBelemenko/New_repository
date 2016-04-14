@wip
Feature: Drafted version of Automation on Delivery Cases

  Background:
    Given PL+ user is logged in
    And user selects the combined Know How UK link
    And user clicks on UK CASES

  Scenario Outline: Cases Free Search
    Given user enters "<search>" criteria
    And user clicks on Search button
    And user verifies Cases Results
    And user selects multiple documents
    And user clicks on Save To Folder icon
    And user clicks on New Folder
    And user enters New Folder name
    And user clicks on OK Button
    And user clicks on Save button
  Examples:
    | search |
    | Cancer |
