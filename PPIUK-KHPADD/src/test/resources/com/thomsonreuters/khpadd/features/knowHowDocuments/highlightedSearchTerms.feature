@manual
Feature: [730960, 730961]  As a: website user
  I want: to be able to hide highlighting of the terms I searched for
  So that: it does not distract from the document

  Scenario: Should be able to stop highlighting of the search terms in document
    Given PL+ user is logged in
    And user searches for term "Tax"
    And user should see the results
    When the user clicks on the first search result
    Then document is displayed with search terms highlighted
    When user un-checks the checkbox to remove highlighting
    Then search term highlighting is removed

  # There will be a new story to change this functionality
  Scenario: Existing WLN functionality: Clicking on next and previous buttons
    Given PL+ user is logged in
    And user searches for term "Tax"
    And user should see the results
    When the user clicks on the first search result
    Then document is displayed with search terms highlighted
    When user click on next to navigate to next highlighted search term
    Then the focus moves to the next highlighted search term which is not in the current window view
    And clicking on the next button when reached last search term opens the next document (from original search results)

  Scenario: When you have not arrived at the page via search, the search terms feature will not appear
    Given PL+ user is logged in
    And user navigates directly to document with guid "anything"
    Then none of the terms are highlighted


