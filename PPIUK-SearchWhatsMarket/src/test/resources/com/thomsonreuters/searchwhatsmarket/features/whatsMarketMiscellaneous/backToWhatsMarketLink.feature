Feature: Verify Back to What's Market homepage link from search results page

  Background: Log on to test site with user having routing set to view the product details
    Given PL+ user is logged in
    And the user is on the home page

  Scenario: Verify back to whats market link is displayed on whats market search results page
    And has selected the link to the What's Market homepage
    And the user runs a free text cobalt search with query "law"
    And the user verifies the presence of the link entitled "Back to What's Market"

  @bug
  Scenario: Verify back to whats market link is displayed on whats market search results page
  #824356
    And has selected the link to the What's Market homepage
    And has selected the link to "Joint ventures"
    And the user runs a free text cobalt search with query "law"
    And the user verifies the presence of the link entitled "Back to Joint ventures"