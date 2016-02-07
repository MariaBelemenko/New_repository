@manual
Feature As a user I want to see the topic page pagination according to the Design document

  Scenario: User verifies pagination styling
    Given a user is logged in
    When user navigates to the practice area like Competition
    And user navigates to one of its topic page like Cartels
    Then the user scrolls down and should see the pagination according to the design document
