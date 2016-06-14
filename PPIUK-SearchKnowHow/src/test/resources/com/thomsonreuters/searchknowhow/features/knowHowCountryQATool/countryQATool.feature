Feature: [814488] countryQATool.feature

#868384 :[Regression] Author name is NOT displayed as a link
  Scenario: Author Link Functionality from Country Q&A Article
    Given PL+ user is logged in
    When the user views a document in Country QA
    Then the user clicks link for "Canada" and verifies that it was selected
    And the author name is displayed as a link
    When the user selects the author link
    Then the user is able to view a photograph and biography of the author
