Feature: [814488] countryQATool.feature

#868384 :[Regression] Author name is NOT displayed as a link
  Scenario: Author Link Functionality from Country Q&A Article
    Given PL+ user is logged in
    When the user views a document in Country QA
    And the user clicks link for "Canada"
    And the author name is displayed as a link
    And the user selects the author link
    And the user is able to view a photograph and biography of the author
