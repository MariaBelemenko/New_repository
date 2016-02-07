Feature: Ensure the Whats Market Page is present and displayed correctly

  Scenario: Verify that the Whats Market page is displayed correctly
    Given PL+ user is logged in
    When the user clicks on the resources tab on the home page
    And the whats market link is clicked
    Then the user verifies that the current PageTitle contains 'What's Market'
    And the whats market page is displayed correctly
