Feature: As a PPI user I want to change the Client ID after log in

  @bug
  Scenario: As a PPI user I want to change the Client ID after log in
    Given PL+ user is logged in with following details
      | userName | Login_AutoUser |
    And user is able to see default client id "PRACTICAL LAW" in the header
    When user clicks on client id "PRACTICAL LAW"
    Then user is able to change client id "TESTACCOUNTID"
    And user can see new client id "TESTACCOUNTID" in the header
