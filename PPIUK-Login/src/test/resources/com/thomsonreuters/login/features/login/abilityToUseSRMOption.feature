Feature: Enable option for Super Remember Me in PL+.

  Background: 
    Given PL+ user is not logged in
    When the user navigates to the main PLCUK page

  #do not remove this tag! this is to delete SRM option after test
  @RemoveSRMOptionUK @e2e
  Scenario: Checking Remember me function is working
    Given a username/password user in the login screen
      | userName | srm_user               |
      | routing  | NONE                   |
      | role     | SUPER_REMEMBER_ME_USER |
    When he selects the option to be remembered on this computer
    Then he activates the super remember me cookie
    And when the user logs out
    And he clicks the sign in button on the log out page
    Then he will be automatically authenticated
    And he will not see the Log in page

  #do not remove this tag! this is to delete SRM option after test
  @RemoveSRMOptionUK 
  Scenario: Checking Remember me function is working when selecting, on this computer
    Given a username/password user in the login screen
      | userName | srm_user               |
      | routing  | NONE                   |
      | role     | SUPER_REMEMBER_ME_USER |
    When he selects the option to be remembered on this computer
    Then he activates the super remember me cookie
    And when the user logs out
    And he tries to access PL+
    Then he will be automatically authenticated
    And he will not see the Log in page
