Feature: [841507] As a PL+ User, I am able to navigates to topic page

  Background:
    Given PL+ user is logged in
    When the user navigates to the main PLCUK page
    When the user selects "International" tab and clicks on "China" link in "International subscriptions" section
    Then the Category Page opens correctly

  Scenario Outline: verify that topic page contains resource tab
    Then the user clicks on "<topicPage>" link
    Then the user verifies that the current PageTitle contains '<pageTitleAfterClickonlink>'
    And the list of resource types is displayed
    And the list of jurisdictions is not displayed
  Examples:
    | topicPage | pageTitleAfterClickonlink |
    | Finance   | Finance                   |
