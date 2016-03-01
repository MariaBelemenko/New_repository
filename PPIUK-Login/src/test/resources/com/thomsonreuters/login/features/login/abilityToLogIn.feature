Feature: Not logged in user can log in as username and password

  @e2e @prod
  Scenario: As a not logged in user I want to use Sign On link on the header to login.
    Given PL+ user is not logged in
    When the user navigates to the main PLCUK page
    And the user clicks on Sign On link on the header
    Then the user is able to sign in with OnePass
      | userName | LoginUser3 |
    And Sign On link is not shown to user
    And Sign In link is not shown to user

  Scenario: As a not logged in user I want to use Sign In link on the footer to login.
    Given PL+ user is not logged in
    When the user navigates to the main PLCUK page
    And the user clicks on Sign In link on the footer
    Then the user is able to sign in with OnePass
      | userName | LoginUser3 |
    And Sign In link is not shown to user
    And Sign On link is not shown to user

  Scenario: As a not logged in user I want to use Sign On button on the document to login.
    Given PL+ user is not logged in
    When he is viewing a free document "/Document/Ib9a9f49f1c9a11e38578f7ccc38dcbee/View/FullText.html"
    And the user clicks on Sign in button on the document
    Then the user is able to sign in with OnePass
      | userName | LoginUser3 |
    And the user should be redirected to a page with the document
    And Sign On link is not shown to user
    And Sign In link is not shown to user
    And Sign In button is not shown to user
