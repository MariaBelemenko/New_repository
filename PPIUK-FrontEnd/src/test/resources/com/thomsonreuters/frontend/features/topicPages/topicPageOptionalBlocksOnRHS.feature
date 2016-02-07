Feature: As a user,
  I want to style the optional blocks on the right hand side of a topic page
  So that the it looks like the attached designs if and when we have the blocks ready to slot into that space

  @manual
  Scenario: User verifies the optional blocks (e.g. International resources, Key forms etc) on topic page
    Given a user is logged in
    When user navigates to the PA page like "Commercial"
    And user navigates to the topic page like "Advertising and Marketing"
    Then user should see the optional blocks on the right hand side like "International Resources" or "Key forms" according to design document