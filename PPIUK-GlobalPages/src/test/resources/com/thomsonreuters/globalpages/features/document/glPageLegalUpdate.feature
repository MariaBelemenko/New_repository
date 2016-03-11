Feature: [840384] As a PL+ User, when I am on the global page I want to be able to view a list of the latest legal updates that have been coded to the international jurisdiction

  Background:
    Given PL+ user is logged in
    When the user navigates to the main PLCUK page
    When the user selects "International" tab and clicks on "Global" link in "International subscriptions" section
    Then the Category Page opens correctly

  Scenario: verify the legal update widget
    Then the user should see 5 updates on a "Legal updates" widget
    And "Legal updates" widget should display publication dates of documents
    And the "Legal updates" dates are sorted in reverse chronological order
    When the user clicks on the 'View all' link of the "Legal updates" widget
    Then the user should be taken to the "Global" Topic LU results list
    Then the user should be presented with a list of LU documents
    And the user should see first five updates same as on widget
    And the results is refined to only include that "International" jurisdiction
    And the user can open the first know how search result "1"
    Then the document opens correctly

  Scenario Outline: verify the legal update widget
    Then the user should see 5 updates on a "Legal updates" widget
    And "Legal updates" widget should display publication dates of documents
    When the user clicks on the "<number>" link on "Legal updates" widget
    Then the document opens correctly
  Examples:
    | number |
    | 1      |
    | 2      |
    | 4      |
