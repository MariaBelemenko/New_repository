Feature: [839937] As a PL+ User when I enter 3+ charatcers into the search field on the global page, a list of suggested terms is suggested to me

  Background: 
    Given PL+ user is logged in
    When the user navigates to the Global Page
    Then the Global Page opens correctly

  Scenario Outline: The user enters 3 characters and list of suggested terms appears
    When the user enter "<character1>" on the search field
    Then the list of suggested terms does not appear
    When the user enter "<character2>" on the search field
    Then the user should be presented with the below search suggestions
      | TAG              |
      | TAG ALONG        |
      | TAG ALONG RIGHT  |
      | TAG ALONG RIGHTS |
      | TAG-ALONG        |
      | TAG-ALONG RIGHTS |
    And the suggested search terms are displayed in alphabetical order

    Examples: 
      | character1 | character2 | suggestion |
      | ta         | g          | TAG ALONG  |

  Scenario Outline: The user select term from the list of suggestions
    When the user enter "<character>" on the search field
    Then the user selects the suggested term "<term>"
    And the user verifies that the term "<term>" appears in the search box

    Examples: 
      | character | term      |
      | tag       | TAG ALONG |

  Scenario Outline: The user verifies that all search results contain the search term
    When the user searches for "<term>"
    And the user verifies that the term "<term>" appears in the search box
    When the user can select the option to show more detail
    Then the returned results contain the search "<term>"

    Examples: 
      | term |
      | tax  |
