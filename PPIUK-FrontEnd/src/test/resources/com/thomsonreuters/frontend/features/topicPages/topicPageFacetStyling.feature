Feature: As a user,
  I want to see the topic page facet styling according to the design

  Scenario: User verifies topic page pagination
    Given PL+ user is logged in
    And the user navigating to topic page "Cartels" of practice area "Competition"
    Then the user should see the page no "1"
    And the user varifies each page by navigates through each of the following pages
      | Pages |
      | 2     |
      | 3     |
      | 4     |
      | 5     |
      | 6     |

  @manual
  Scenario: User verifies topic page facet styling
    Given a user is logged in
    When user navigates to the practice area like Competition
    And user navigates to one of its topic page like Cartels
    Then the user see the topic page with facet styling according to the design document.
