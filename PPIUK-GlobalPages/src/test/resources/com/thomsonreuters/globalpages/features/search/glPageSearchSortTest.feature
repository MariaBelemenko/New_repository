@wip
Feature: As a PL+ User, I want to sort my search results by relevancy, date and Title [A-Z]
  So that I can view the list of search results in my preferred order

  Scenario Outline: Verify sort results by date. Verify that the user is able to sort search results by relevancy
    Given PL+ user is logged in with following details
      | userName | GlPage_UK1 |
    When the user selects "International" tab and clicks on "<link>" link in "International subscriptions" section
    Then the Category Page opens correctly
    When the user runs a free text search for the query "tag"
    And the user verifies that the option for sorting by relevance is displayed by default
    And the user obtains the title of the first, second and third result and stores it
    And the user can select the option to sort by "Date"
    And the user can verify that the title of the first, second and third results should not be the same as the stored values
    And the user can select the option to sort by "Relevance"
    Then the user is able to verify that the title of the first,second and third results should be the same as the stored values
  Examples:
    | link   |
    | Global |
    | China  |
