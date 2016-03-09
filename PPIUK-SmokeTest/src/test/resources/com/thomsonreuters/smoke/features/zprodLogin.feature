Feature: Verify logging in and subscriptions

  Scenario: Logged in user can access resources
    Given PL+ user is logged in
    And the user is navigated to the logged in view of the PL+ homepage
    When the user runs a free text search for the query "sales agency agreement"
    And the user can open the first know how search result "1"
    Then the user is navigated to the logged in view of the document

  Scenario: Non-logged in user(OpenWeb) can't access subscription resources
    Given PL+ user is not logged in
    And PL+ user navigates to home page
    When the user runs a free text search for the query "sales agency agreement"
    And the user can open the first know how search result "1"
    Then the user is provided with an option to sign-in or register for free trial

  Scenario: Save my username and password
    Given PL+ user is not logged in
    And PL+ user navigates to login page
    When a PPI user enter its username and password
      | userName | danholland |
    And user selects Save my Username and Password checkbox
    And clicks on Sign in
    Then the user is navigated to the logged in view of the PL+ homepage
    When user logs out
    And user tries to log in again
    Then he will see the username box in the log in page populated with his username
    And his password will be populated in the password box
    And his password will not be readable in the screen and only asterisks will be visible

  @RemoveSRMOptionUK
  Scenario: Super remember me
    Given PL+ user is not logged in
    And PL+ user navigates to login page
    When a PPI user enter its username and password
      | userName | danholland |
    When he selects the option to be remembered on this computer
    And he activates the super remember me cookie
    Then the user is navigated to the logged in view of the PL+ homepage
    And when the user logs out
    And he tries to access PL+
    Then he will be automatically authenticated
    And he will not see the Log in page
