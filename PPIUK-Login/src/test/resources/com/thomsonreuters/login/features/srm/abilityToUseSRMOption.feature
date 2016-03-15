Feature: [752718] Enable option for Super Remember Me in PL+.

  #do not remove this tag! this is to delete SRM option after test
  @RemoveSRMOptionUK @e2e
  Scenario: [752718] SRM user can login back from logout page
    Given PL+ user is not logged in
    When the user navigates to the main PLCUK page
    And the user clicks on Sign On link on the header
    When the user enters his username and password on the login page
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
  Scenario: [752718] SRM user can automatically login after he logged out
    Given PL+ user is not logged in
    When the user navigates to the main PLCUK page
    And the user clicks on Sign On link on the header
    When the user enters his username and password on the login page
      | userName | srm_user               |
      | routing  | NONE                   |
      | role     | SUPER_REMEMBER_ME_USER |
    When he selects the option to be remembered on this computer
    Then he activates the super remember me cookie
    And when the user logs out
    And he tries to access PL+
    Then he will be automatically authenticated
    And he will not see the Log in page
