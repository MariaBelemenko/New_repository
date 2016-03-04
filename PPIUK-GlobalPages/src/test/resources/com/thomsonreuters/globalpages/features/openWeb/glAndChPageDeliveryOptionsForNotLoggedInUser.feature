Feature: Not logged in user cannot use delivery options in China and Global page

  Background:
    Given PL+ user is not logged in

  Scenario Outline: As a Not logged in user I want to not be able to to use delivery options on document page
    When the user navigates to the main PLCUK page
    When the user selects "International" tab and clicks on "<link>" link in "International subscriptions" section
    Then the Category Page opens correctly
    When the user runs a free text search for the query "tax"
    Then he does not see in the document page any link related to delivery options (email, download, print)
    And he is not able to use these features on document page
  Examples:
    | link   |
    | Global |
    | China  |

  Scenario Outline: As a Not logged in user I want to not be able to to use delivery options on China and Global legal updates results page
    When the user navigates to the main PLCUK page
    When the user selects "International" tab and clicks on "<link>" link in "International subscriptions" section
    Then the Category Page opens correctly
    When the user clicks on the 'View all' link of the "Legal updates" widget
    Then the user should be taken to the "<link>" Topic LU results list
    Then he does not see on a legal updates results page any link related to delivery options (email, download, print)
    And he is not able to use these features on legal updates results page
  Examples:
    | link   |
    | Global |
    | China  |
