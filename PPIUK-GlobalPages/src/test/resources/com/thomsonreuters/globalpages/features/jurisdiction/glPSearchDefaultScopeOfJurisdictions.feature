Feature: [839960] As a PL+ User I can run search and the list of Jurisdictions is displayed in the left hand side

  Scenario: The user can run a search and results include list of Jurisdictions in the left hand side
    Given PL+ user is logged in
    When the user navigates to the Global Page
    Then the Global Page opens correctly
    When the user runs a free text search for the query "tax"
    Then the user is able to verify that the jurisdiction facets by default 5 facets are displayed
    And the following list of jurisdictions is displayed
      | International  |
      | United Kingdom |
      | United States  |
      | China          |
      | Canada         |
