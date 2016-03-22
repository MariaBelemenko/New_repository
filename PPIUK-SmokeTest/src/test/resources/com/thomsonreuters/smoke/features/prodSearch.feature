Feature: Verify search

  Scenario: Selecting multiple search filters
    Given PL+ user is logged in
    And the user come back on to Home page as logged in user
    When the user runs a free text search for the query "tax"
    And the user selects the know how parent facet "Glossary"
    And the user selects the know how parent facet "Scotland"
  #  And the user selects the know how option to apply filters
    Then the user verifies that the know how facet is selected "Glossary"
    Then the user verifies that the know how facet is selected "Scotland"
    Then the user is able to verify that the search result in position "1" within the result list has the resource type "Glossary"
    Then the user is able to verify that the search result in position "1" within the result list has the jurisdiction "Scotland"

  Scenario: Auto suggest
    Given PL+ user is logged in
    And the user come back on to Home page as logged in user
    When the user enters 3 characters into the search box "tax"
    Then the user should see auto suggestion list
    When the user selects the suggested term "TAX"
    Then the search results should be shown according to the search term selected
