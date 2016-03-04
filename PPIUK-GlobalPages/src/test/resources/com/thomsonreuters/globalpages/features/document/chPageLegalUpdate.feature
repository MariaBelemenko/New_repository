Feature: As a PL+ User, when I am on the global page I want to be able to view a list of the latest legal updates that have been coded to the international jurisdiction

  Background:
    Given PL+ user is logged in
      | routing          | BETA |
      | mandatoryRouting | YES  |
    And the user navigates to the main PLCUK page
    When the user selects "International" tab and clicks on "China" link in "International subscriptions" section
    Then the Category Page opens correctly

  Scenario: verify the legal update widget
    Then the user should see 5 updates on a "Legal updates" widget
    And "Legal updates" widget should display publication dates of documents
    And the "Legal updates" dates are sorted in reverse chronological order
    When the user clicks on the 'View all' link of the "Legal updates" widget
    Then the user should be taken to the "China" Topic LU results list
    Then the user should be presented with a list of LU documents
    And the dates in results list are sorted in reverse chronological order
    And the user is presented with a 'RSS' link in the result page toolbar
    When the user clicks on this link
    Then the user should be presented with the RSS information page

  Scenario: verify the RSS link
    And the user is presented with the Legal Updates widget
    And the user should be presented with an 'RSS' Link
    When the user clicks on the RSS link
    Then the user should be presented with the RSS information page

  Scenario: verify history of legal update
    Then the user should see 5 updates on a "Legal updates" widget
    And "Legal updates" widget should display publication dates of documents
    And the "Legal updates" dates are sorted in reverse chronological order
    When the user clicks on the 'View all' link of the "Legal updates" widget
    Then the user should be taken to the "China" Topic LU results list
    Then the user should be presented with a list of LU documents
    And the user should see first five updates same as on widget

  Scenario Outline: verify the documents in legal update widget
    Then the user should see 5 updates on a "Legal updates" widget
    And "Legal updates" widget should display publication dates of documents
    When the user clicks on the "<number>" link on "Legal updates" widget
    Then the document opens correctly
  Examples:
    | number |
    | 1      |
    | 2      |
    | 4      |

  Scenario Outline: verify the documents in full list of legal update documents
    When the user clicks on the 'View all' link of the "Legal updates" widget
    Then the document opens correctly
    And the user can open the first know how search result "<number>"
    Then the document opens correctly
    And the user verifies that the product detail contains the practice area "China"
  Examples:
    | number |
    | 1      |
    | 2      |
    | 3      |
