Feature:Verify email archive functionality within practice areas

  Background: Log on to test site with user having routing set to view the product details
    Given PL+ user is logged in with following details
      | userName | Search1_AutoUser |
    And the user is on the home page

  Scenario: Verify email archive functionality within practice areas
    When has selected the homepage practice area link to "Agriculture & Rural Land"
    And has selected the link to Resources
    And the user has selected the resource link entitled Email archive
    Then the user is presented with a page entitled Email archive "Agriculture & Rural Land"
    And the user can verify the presence of a list of archive search results