Feature:Verify email archive functionality within practice areas

  Scenario: Verify email archive functionality within practice areas
    Given PL+ user is logged in
    And the user is on the home page
    When has selected the homepage practice area link to "Agriculture & Rural Land"
    And has selected the link to Resources
    And the user has selected the resource link entitled Email archive
    Then the user is presented with a page entitled Email archive "Agriculture & Rural Land"
    And the user can verify the presence of a list of archive search results