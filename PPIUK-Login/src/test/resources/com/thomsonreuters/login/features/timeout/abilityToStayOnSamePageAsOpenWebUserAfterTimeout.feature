Feature: [758805] Skip Open web authentication if a user is not Open web (Username/Password users).

  Scenario: [758805] Modify timeout re-direct to skip Open web authentication if a user is not Open web
    Given PL+ user is logged in with routing details
      | mandatoryRouting | YES                              |
      | routing          | SPECIFIED_USER_TIMEOUT_3_MINUTES |
      | userName         | LoginUser7                          |
    When he is viewing a free document "/Document/I7ab265477b3d11e498db8b09b4f043e0/View/FullText.html"
    And he has a session open and timed out
    Then he should stay on same document page as OpenWeb user
    And the user clicks Log in button
    When a PPI user enter its username and password
      | userName | LoginUser7  |
    And clicks on Sign in
    Then user gets redirected to the document page that he was visiting and is logged in
