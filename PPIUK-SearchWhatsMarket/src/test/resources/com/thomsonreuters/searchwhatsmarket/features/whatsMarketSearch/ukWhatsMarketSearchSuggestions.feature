@stepg
Feature: [767388][767411][764084][767407] ukWhatsMarketSearchSuggestions.feature
  As a PL+ user when I begin to type a search term then I can see a list of suggested search phrases according to what I have begun to enter

  Background: Log onto to test site
    Given PL+ user is logged in

  @bug
  Scenario: [767388] When the user types 3 characters up to 10 suggested terms are displayed in whats market
    #bug is 818346 - suggestions not being generated with three characters
    And has selected the link to the What's Market homepage
    When the user enters 3 characters into the search box "ipo"
    Then the user should be presented with the below search suggestions
      | IPOS: AIM                  |
      | IPOS: MAIN MARKET          |
      | IPOS: MAIN MARKET DIVIDEND |
    And the suggested search terms are displayed in alphabetical order

  Scenario: [767411] Append terms to suggested terms - add text to end of selected term in whats market
    And has selected the link to the What's Market homepage
    When the user enters 3 characters into the search box "ars"
    And the user selects the suggested term "ARSENAL"
    And the user verifies that the term "ARSENAL" appears in the search box
    Then the user edits the text of the suggested search term and add additional text "group"
    And the user can submit the search request
    And the user can open the first whats market search result "1"
    And the user can verify that the full text of the know how document contains the search terms "Arsenal" and "group"

  Scenario: [764084] WM suggestions only appear on WM pages - all other pages return KH suggestions
    And has selected the link to the What's Market homepage
    When the user enters 5 characters into the search box "merck"
    Then the user should be presented with the below search suggestions
      | MERCK KGAA OFFER FOR AZ ELECTRONICS |

  @manual
  Scenario: [767407] Ability to use keyboard to scroll through suggested terms and select term - move selected term into search box (whats market)
    When the user enters 3 characters into the search box "pub"
    And the user has been presented with the suggested search terms
    And the user can navigate up and down the list of terms using the up and down keys on their keyboard
    And as the user navigates using their keys the terms should be highlighted to show the current focus of the user and the highlighted term should appear in the search box
    When the user selects an option using the return key then the selected term should be displayed in the search box and the search should be run on the selected term
