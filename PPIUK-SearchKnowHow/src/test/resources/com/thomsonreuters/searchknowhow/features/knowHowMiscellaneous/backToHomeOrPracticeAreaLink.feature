Feature: [no story] Verify Back to Home or Practice Area Link from know how search results page

  Background: Log on to test site with user having routing set to view the product details
    Given PL+ user is logged in
    And the user is on the home page

  @e2e @prod
  Scenario: Verify back to home link is displayed on know how search results page
    And the user runs a free text cobalt search with query "law"
    And the user verifies the presence of the link entitled "Back to Home"

  Scenario: Verify Back to practice area link is displayed on practice area search results page
    And has selected the link to the practice area "Arbitration"
    And the user runs a free text cobalt search with query "law"
    And the user verifies the presence of the link entitled "Back to Arbitration"
