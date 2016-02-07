@wip
Feature: As a PL+ User I want to navigate to document and verifying the document layout is displaying in three columns or not

  Scenario: User verifies the case document layout as it is displaying in three columns
    Given PL+ user is logged in
    And user clicks on UK New Content Link
    Given user clicks on UK CASES
    When user enters search with "caseDocument2"
    And user clicks on Search button
    When user clicks on Sort By Relevancy
    And User selects "caseDocument2>"
    Then User is viewing a Case "caseDocument2"
    And Document displayed in three column layout

  Scenario: User verifies the Provision document layout as it is displaying in three columns
    Given PL+ user is logged in
    And user clicks on UK New Content Link
    Given user clicks on UK Legislation
    When user enters search with "provisionDocument1"
    And user clicks on Search button
    When user clicks on Sort By Relevancy
    And User selects "provisionDocument1"
    Then User is viewing Provision "provisionDocument1"
    And Document displayed in three column layout
