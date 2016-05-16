@sandystest5 @wip @CPET

Feature: PL+ Home Page Browse
  Verify that the Recent History box is present and either contains a max of 8 links or a message to start browsing

  Scenario: Verify the Recent History box is present and has content
    Given PL+ user is logged in with following details
      | userName   | CPETuser3 |
    Then The user can see the Recent History box
    And The user can see content in the Recent History box
