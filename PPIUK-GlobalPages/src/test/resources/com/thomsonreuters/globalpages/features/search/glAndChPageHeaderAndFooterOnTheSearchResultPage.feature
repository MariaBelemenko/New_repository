Feature: [838717][839947] As a User, I want to see header and footer on the Global and China search results page

  Scenario Outline: As a user, I want to see a header and footer on the Global and China search results page
    Given PL+ user is logged in
    When the user navigates to the main PLCUK page
    When the user selects "International" tab and clicks on "<link>" link in "International subscriptions" section
    Then the Category Page opens correctly
    When the user runs a free text search for the query "tax"
    Then the user should be able to see a header on the page
    Then the user should be able to see a footer on the page
  Examples:
    | link   |
    | Global |
    | China  |