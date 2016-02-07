Feature: As a PL+ User, I want to link back to the global page I performed a search from

  Background:
    Given PL+ user is not logged in
    And the user navigates to the main PLCUK page

  Scenario Outline: Verify link back to category page
    When the user selects "International" tab and clicks on "<link>" link in "International subscriptions" section
    Then the Category Page opens correctly
    When the user runs a free text search for the query "document"
    When the user clicks link '<backLink>' on 'search' page
    Then the user is presented with a page with header "<header>"
  Examples:
    | link   | backLink       | header |
    | Global | Back to Global | Global |
    | China  | Back to China  | China  |

  Scenario Outline: Verify Back to country link is displayed on country search results page
    When the user selects "International" tab and clicks on "Global" link in "International subscriptions" section
    Then the Category Page opens correctly
    When the user selects "<tab>" tab and clicks on "<country>" link
    And the user runs a free text search for the query "<query>"
    And the user clicks link 'Back to <country>' on 'search' page
    Then the user is presented with a page with header "<country>"
  Examples:
    | tab       | country | query    |
    | Countries | Canada  | document |
