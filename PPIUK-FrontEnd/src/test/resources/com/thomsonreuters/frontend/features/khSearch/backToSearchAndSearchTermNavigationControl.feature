@manual
Feature: As a  user,
  I want to see the Back to Search Result and Search Term navigation control on the document display page.

  Scenario: User verifies the "Back to Search Result" link on the Doc Display page
    Given a user is logged in
    And user searches for term "tax"
    When user clicks on the first search result document link
    Then the user should see the "Back to search Results" according to the design document.
    And user clicks on the "Back to Search Results" link
    And user should be taken back to the search results page

  Scenario: User verifies the Search term navigation control  on the Doc Display page
    Given a user is logged in
    And user searches for term "tax"
    When user clicks on the first search result document link
    Then the user should see the Search term naviagtion conrotl  according to the design document.
    And user clicks on the next button on search term navigation control
    And user should be taken to the next highlighted