Feature: I want the Search Connectors in the search box to display correctly within the header
  So that the logo of the product can be correctly identified by the viewer

  Scenario: Check the access guide on the landing page search text-box and "*" as a universal character
    Given PL+ user is logged in
    When user clicks on the "i"
    Then user should see the search guide popup
    And user should see "*" character with "Universal character" explanation
