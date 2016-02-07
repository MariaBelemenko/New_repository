@e2e @prod
Feature: User completely logged out when clicked on log out

  Scenario: As a PPI user I want to be completely logged out from that product when I clicked log out so I can log in as a different user.
    Given PL+ user is logged in with following details
      | userName | srm_user               |
      | role     | SUPER_REMEMBER_ME_USER |
      | routing  | NONE                   |
    When this logged in user clicks on Sign off
    And he is redirected to a log out confirmation page
    Then user selects the option to forget the remember me cookie
    And the next time that he tries to connect to PL+
    Then he should be logged out from system
