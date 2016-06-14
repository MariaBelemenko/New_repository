Feature: [763726][764077][768208][763786] As a PL+ user when I begin to type a search term then I can see a list of suggested search phrases according to what I have begun to enter

  Background: Log onto to test site
    Given PL+ user is logged in

  @bug
  Scenario: [763726] When the user types 3 characters up to 10 suggested terms are displayed in know how
    #818346 - suggestions not being generated with three characters
    When the user enters 3 characters into the search box "pro"
    Then the user should be presented with the below search suggestions
      | PRO BONO ADVICE    |
      | PRO BONO AGREEMENT |
    And the suggested search terms are displayed in alphabetical order

  @bug
  Scenario: [764077] Append terms to suggested terms - add text to end of selected term in know how
    #818346 - suggestions not being generated with three characters
    When the user enters 3 characters into the search box "pro"
    And the user selects the suggested term "PRO BONO ADVICE"
    Then the user verifies that the term "PRO BONO ADVICE" appears in the search box
    When the user edits the text of the suggested search term and add additional text "group"
    And the user can submit the search request
    And the user can open the first know how search result "1"
    Then the user can verify that the full text of the know how document contains the search terms "proceedings" and "group"

  Scenario: [768208] WM suggestions do not appear on KH pages
    When the user enters 5 characters into the search box "merck"
    Then the user should not be presented with the below search suggestions
      | MERCK KGAA OFFER FOR AZ ELECTRONICS |

  @manual
  Scenario: [763786] Ability to use keyboard to scroll through suggested terms and select term  - move selected term into search box (know how)
    When the user enters 3 characters into the search box "pro"
    And the user has been presented with the suggested search terms
    And the user can navigate up and down the list of terms using the up and down keys on their keyboard
    And as the user navigates using their keys the terms should be highlighted to show the current focus of the user and the highlighted term should appear in the search box
    When the user selects an option using the return key then the selected term should be displayed in the search box and the search should be run on the selected term

  @e2e @prod
  Scenario: Verify the Auto Suggest in Search
    When the user starts typing the term "Pub"
    Then the user should see auto suggestion list
    When the user selects the suggested term "PUB CREHAN"
    Then the search results should be shown according to the search term selected
