Feature: [838717] [839960] As a PL+ User, I want to view the right number of Jurisdictions and open More Jurisdictions

  Scenario: [838717] [839960] User checks the right number of Jurisdictions
    Given PL+ user is logged in
    When the user navigates to the Global Page
    Then the Global Page opens correctly
    When the user runs a free text search for the query "tax"
    Then the jurisdiction section contains the following countries
      | International  |
      | United Kingdom |
      | United States  |
      | China          |
      | Canada         |
    Then the user is able to verify that the jurisdiction facets by default 5 facets are displayed
    When the user selects the following facets in more jurisdictions in popup box in global search result page
      | Australia |
      | China     |
      | Canada    |
    Then the jurisdiction section contains the following countries
      | Canada    |
      | China     |
      | Australia |
    And the user verifies that the following facet is selected
      | Canada    |
      | China     |
      | Australia |