Feature: [798060] TS1 View a single document

  @RemoveSRMOptionUK
  Scenario: [798060] View a single document and timeout when Super Remember Me enabled
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
    Given PL+ user is applying routing without login
      | mandatoryRouting | YES                              |
      | routing          | SPECIFIED_USER_TIMEOUT_3_MINUTES |
      | userName         | srm_user                         |
    When he is viewing a free document "/Document/I7ab265477b3d11e498db8b09b4f043e0/View/FullText.html"
    And he has a session open and timed out
    Then user gets redirected to the document page that he was visiting and is logged in