Feature: I want the company logo to display correctly within the header
  So that the logo of the product can be correctly identified by the viewer

  Scenario: I want the company log to display and function correctly.
    Given PL+ user is logged in
    Then user should see company logo
    And  user clicks on company logo
    And user should see "Home" page
