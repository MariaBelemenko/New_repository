Feature: [838026] Open web user is able to view the abstract for each document

  Scenario Outline: [838026] open the document by open web user
    Given PL+ user is not logged in
    And the user navigates to the main PLCUK page
    When the user selects "International" tab and clicks on "Global" link in "International subscriptions" section
    Then the Category Page opens correctly
    And the user runs a free text search for the query "<Document title>"
    When the user clicks link '<Document title>' on 'search' page
    Then the document opens correctly
    And the delivery widget is not displayed
    And there will be text informing the user to login to view full text document
    And "Sign in" button is present in document body
    And "Request a free trial" button is present in document body
  Examples:
    | Document title                                |
    | Execution of deeds and documents              |
    | Execution of deeds and documents by charities |
