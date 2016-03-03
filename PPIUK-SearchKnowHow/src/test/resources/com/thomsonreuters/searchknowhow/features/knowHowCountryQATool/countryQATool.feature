Feature: [814488] countryQATool.feature

  Scenario: Author Link Functionality from Country Q&A Article
    Given PL+ user is logged in
    When the user views a document in Country QA
    Then the author name is displayed as a link
    And the user selects the author link
    Then the user is able to view a photograph and biography of the author
